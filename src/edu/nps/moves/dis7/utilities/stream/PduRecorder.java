package edu.nps.moves.dis7.utilities.stream;

import com.google.common.primitives.Longs;

import edu.nps.moves.dis7.enumerations.DisPduType;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.PduFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FilenameUtils;

/** Utility to save PDUs received over the network to disk
 * 
 * @author Mike Bailey, jmbailey@nps.edu
 */
public class PduRecorder implements PduReceiver
{
    /** Default multicast group address <code>239.1.2.3</code> for send and receive connections.
     * @see <a href="https://en.wikipedia.org/wiki/Multicast_address">https://en.wikipedia.org/wiki/Multicast_address</a>  */
    public static String DEFAULT_DIS_ADDRESS = DisThreadedNetworkInterface.DEFAULT_DIS_ADDRESS;

    /** Default socket port  <code>3000</code>, matches Wireshark DIS capture default
     * @see <a href="https://en.wikipedia.org/wiki/Port_(computer_networking)">https://en.wikipedia.org/wiki/Port_(computer_networking)</a> */
    public static int DEFAULT_DIS_PORT = DisThreadedNetworkInterface.DEFAULT_DIS_PORT;
    
  private String disAddress = DEFAULT_DIS_ADDRESS;
  private int    disPort    = DEFAULT_DIS_PORT;
    
  /** Character sentinel indicating remainder of line is a comment */
  public static final String COMMENT_MARKER = "#";
  
  static final String OUTPUT_DIRECTORY_DEFAULT = "./pduLog";
               String outputDirectory          = OUTPUT_DIRECTORY_DEFAULT;
               Path   outputDirectoryPath;
  static String DEFAULT_FILE_PREFIX      = "PduCaptureLog";
  static String DISLOG_FILE_EXTENSION    = ".dislog";
  
  static final String START_COMMENT_MARKER           = COMMENT_MARKER + " Start, ";
  static final String FINISH_COMMENT_MARKER          = COMMENT_MARKER + " Finish, ";
  static final String ENCODING_BASE64                = "ENCODING_BASE64";
  static final String ENCODING_PLAINTEXT             = "ENCODING_PLAINTEXT";
  static final String ENCODING_BINARY                = "ENCODING_BINARY";  // TODO likely requires different code path
  static final String ENCODING_XML                   = "ENCODING_XML";     // TODO, repeat Open-DIS version 4 effort
  static final String ENCODING_EXI                   = "ENCODING_EXI";     // TODO, use Exificient or Nagasena libraries
  static final String ENCODING_JSON                  = "ENCODING_JSON";    // TODO, repeat Open-DIS version 4 effort
  static final String ENCODING_MAK_DATA_LOGGER       = "ENCODING_MAK_DATA_LOGGER";       // verbose pretty-print. perhaps output only (MAK format itself is binary)
  static final String ENCODING_WIRESHARK_DATA_LOGGER = "ENCODING_WIRESHARK_DATA_LOGGER"; // 
  static final String ENCODING_CDIS                  = "ENCODING_CDIS";    // future work based on new SISO standard
  
  private static String pduLogEncoding = ENCODING_PLAINTEXT; // TODO use Java enumerations, generalize/share across library
  
  private String TRACE_PREFIX = ("[pduRecorder " + getDescriptor()).trim() + "] ";
  private String  descriptor      = new String();

  private Writer logFileWriter;
  private File   logFile;
  private DisThreadedNetworkInterface                disThreadedNetworkInterface;
  private DisThreadedNetworkInterface.RawPduListener disRawPduListener;
  
  private Long      startNanoTime = null;
  private final  StringBuilder sb = new StringBuilder();
  private final  Base64.Encoder base64Encoder = Base64.getEncoder();
  private static int     port     = DisThreadedNetworkInterface.DEFAULT_DIS_PORT; // self-test via port 1 when main() invoked
  private final  int     pduCount = 0;    // debug
  private boolean headerWritten   = false;
  private boolean running         = true; // starts recording by default
  
  /**
   * Default constructor that uses default values for output directory, DIS address and port.
   * Each instance must invoke start() to begin operations, pause() to suspend operations, 
   * resume() to continue operations, and stop() to terminate operations.
   * @throws IOException if something goes wrong during instantiation
   */
  public PduRecorder() throws IOException
  {
        this (OUTPUT_DIRECTORY_DEFAULT, DEFAULT_DIS_ADDRESS, DEFAULT_DIS_PORT);
  }
  
  /**
   * Constructor to let the use specify an output directory.
   * Uses default values for multicast address and port.
   * Each instance must invoke start() to begin operations, pause() to suspend operations, 
   * resume() to continue operations, and stop() to terminate operations.
   * 
   * @param initialOutputDirectory the directory to write log files to
   * @throws IOException if something goes wrong during instantiation
   */
  public PduRecorder(String initialOutputDirectory) throws IOException
  {
        this(initialOutputDirectory, DEFAULT_DIS_ADDRESS, DEFAULT_DIS_PORT);
  }
  
  /** Constructor to let the user specify all required parameters.
   * Each instance must invoke start() to begin operations, pause() to suspend operations, 
   * resume() to continue operations, and stop() to terminate operations..
   * 
   * @param initialOutputDirectory local path for directory where the log files are written
   * @param initialAddress multicast group address to receive data from (TODO allow unicast UDP)
   * @param initialPort UDP port to listen for data
   */
  @SuppressWarnings("Convert2Lambda")
  public PduRecorder(String initialOutputDirectory, String initialAddress, int initialPort)
  {
    try {
        outputDirectoryPath = new File(initialOutputDirectory).toPath();
        this.descriptor = "PduRecorder"; // default
        this.disAddress = initialAddress;
        this.disPort    = initialPort;
        logFile         = createUniquePduLogFile(outputDirectoryPath, DEFAULT_FILE_PREFIX + DISLOG_FILE_EXTENSION );
        logFileWriter   = new PrintWriter(new BufferedWriter(new FileWriter(logFile)));
    }
    catch (IOException ex)
    {
      System.err.println("Exception when creating log file in directory=" + initialOutputDirectory + "\n" +
                          "   " + ex.getClass().getSimpleName() + ": " + ex.getLocalizedMessage());
    }
  }
  
    /**
     * TODO change this to enumeration type for strictness
     *
     * @return the pduLogEncoding
     */
    public static String getPduLogEncoding()
    {
        return pduLogEncoding;
    }

    /**
     * @param newPduLogEncoding the pduLogEncoding to set
     */
    public static void setPduLogEncoding(String newPduLogEncoding) {
        pduLogEncoding = newPduLogEncoding;
    }

  /** Resume instance operation
   * @see start()
   * @see stop()
   * @see pause() */
  public void resume()
  {
    if  (disThreadedNetworkInterface == null)
    {
         System.out.println("** Warning, PduRecorder resume() failed to find running disThreadedNetworkInterface, repeating start()");
         start(); // start me up
    }
    else running = true;
  }

  /** Start instance operation
   * @see stop()
   * @see pause()
   * @see resume()
   */
  public void start()
  {
    if (disThreadedNetworkInterface == null)
    {
        disThreadedNetworkInterface = new DisThreadedNetworkInterface(getAddress(), getPort());
        disThreadedNetworkInterface.setDescriptor (getDescriptor()); // pass it along
        
        disRawPduListener = new DisThreadedNetworkInterface.RawPduListener() {
            @Override
            public void incomingPdu(DisThreadedNetworkInterface.ByteArrayBufferAndLength bAndL) {
                receivePdu(bAndL.bufferByteArray, bAndL.length);
            }
        };
        disThreadedNetworkInterface.addRawListener(disRawPduListener);
        System.out.println("[" + (getClass().getSimpleName() + " " + getDescriptor()).trim() + "] listening to IP address " + getAddress() + " on port " + getPort());
    }
    running = true;
  }
  /** Pause operation of this instance
   * @see start()
   * @see stop()
   * @see resume()
   */
  public void pause()
  {
    running = false;
  }
  /** End operation of this instance, removing interfaces
    * @return recorder logFile
   * @see start()
   * @see pause()
   * @see resume() */
  public File stop()
  {
    running = false;
    if (disThreadedNetworkInterface != null)
    {
        disThreadedNetworkInterface.removeRawListener(disRawPduListener);
        disThreadedNetworkInterface.finishOperations();
    }

    writeFooter();
    try {
        System.out.println();
        System.out.println("Closing recorder log file: " + logFile.getCanonicalPath());
        logFileWriter.close(); // a flush occurs first during a close
    } 
    catch (IOException ex) {
        Logger.getLogger(PduRecorder.class.getName()).log(Level.SEVERE, null, ex);
    }
    return logFile;
  }
  
  byte[] oldBuffer;
  
  /** receivePdu from DIS data stream
   * @param newBuffer byte array for receiving data
   * @param newLength length of byte array
   */
  @Override
  public void receivePdu(byte[] newBuffer, int newLength)
  {
    if (java.util.Arrays.equals(newBuffer, oldBuffer))
        System.err.println ("PduRecorder warning: PDU newBuffer equals PDU oldBuffer"); // debug
    
    if(!isRunning())
      return;
    
    long packetRcvNanoTime = System.nanoTime();
    if (startNanoTime == null)
        startNanoTime = packetRcvNanoTime;

    byte[] timeByteArray = Longs.toByteArray(packetRcvNanoTime - startNanoTime);
    //System.out.println("wrote time "+(packetRcvNanoTime - startNanoTime));

    byte[] buffsized = Arrays.copyOf(newBuffer, newLength);
    DisPduType pduType;
    
    switch (pduLogEncoding)
    {
        case ENCODING_BASE64:
            sb.append(base64Encoder.encodeToString(timeByteArray));
            sb.append(',');
            sb.append(base64Encoder.encodeToString(buffsized)); 
            break;
            
        case ENCODING_PLAINTEXT:
            // by Tobias Brennenstuhl SPring 2020
            sb.append(Arrays.toString(timeByteArray).replace(" ", ""));
            sb.append(',');
            sb.append(Arrays.toString(buffsized).replace(" ", ""));
            sb.append(" # ");
            pduType = DisPduType.getEnumForValue(Byte.toUnsignedInt(buffsized[2])); // 3rd byte
            sb.append(pduType);
            break;
        
        default:
            System.err.println ("Encoding " + pduLogEncoding + " not recognized or supported");
    }
    if (!headerWritten) {
      writeHeader();
      headerWritten = true;
    }
    try {
      logFileWriter.write(sb.toString());
      ((PrintWriter)logFileWriter).println();
    }
    catch (IOException ex) {
      throw new RuntimeException("Fatal exception writing DIS log file in PduRecorder thread: " + ex);
    }
    //System.out.println("Recorder: "+ ++pduCount);

    sb.setLength(0);
  }
  
  /** Retrieve the path to the log file
   * 
   * @return the path to the log file
   */
  public String getLogFilePath()
  {
    return logFile.getAbsolutePath();
  }
  
    /**
     * @return an instance of this DisThreadedNetworkInterface
     */
    public DisThreadedNetworkInterface getDisThreadedNetworkInterface() {
        return disThreadedNetworkInterface;
    }
  
  private void writeHeader()
  {
      String timeStamp = getTimeStamp();

      try
      {
          logFileWriter.write(START_COMMENT_MARKER + pduLogEncoding + ", " + timeStamp + ", DIS capture file, " + logFile.getPath());
          ((PrintWriter) logFileWriter).println();
      } 
      catch (IOException ex)
      {
          Logger.getLogger(PduRecorder.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  private void writeFooter()
  {   
      String timeStamp = getTimeStamp();

      try
      {
          logFileWriter.write(FINISH_COMMENT_MARKER + pduLogEncoding + ", " + timeStamp + ", DIS capture file, " + logFile.getPath());
          ((PrintWriter) logFileWriter).println();
      } 
      catch (IOException ex)
      {
          Logger.getLogger(PduRecorder.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  private String getTimeStamp() {
      // https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java
      return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
  }

  /**
   * Rotates through file names so that no present file get overwritten.
   * 
   * @param outputDir the directory to place the log file
   * @param filename the name of the file w/ extension
   * @return a File reference to the log file
   * @throws IOException if something goes awry
   */
  private File createUniquePduLogFile(Path outputDir, String filename) throws IOException
  {
    String baseName  = FilenameUtils.getBaseName(filename);
    String extension = FilenameUtils.getExtension(filename);

    Integer fileCounter = null;
    File    newFile;
    boolean fileExists;
    outputDir.toFile().mkdirs();
    do {
      String nextFileName = baseName + (fileCounter == null ? "" : fileCounter) + "." + extension;
      newFile = new File(outputDir.toFile(), nextFileName);
      fileExists = newFile.exists();
      if (fileCounter == null)
        fileCounter = 1;
      else
        fileCounter++;
    } while (fileExists);
    
    if (newFile.createNewFile()) 
    {
        System.out.println("Recorder log file open: " + newFile.getCanonicalPath());
    }
    else
    {
      System.out.println("Cannot create dis log file at " + newFile.getAbsolutePath());
      throw new RuntimeException("File creation error");
    }
    return newFile;
  }

    /**
     * @return the pduRecorderRunning
     */
    public boolean isRunning()
    {
        return running;
    }
  
  /** Entry point invocation. Saves a PDU output log to ./pduLog. Invoking the
   *  edu.nps.moves.dis7.examples.PduReaderPlayer will playback all logs written
   *  to the log directory
   * 
   * @param args none supported, TODO offer path/filename
   */
  public static void main(String[] args)
  {
    System.out.println("dis7.utilities.stream.PduRecorder main() performs self-test by sending full set of PDUs");
    
    PduFactory factory = new PduFactory(); //default appid, country, etc.

    PduRecorder pduRecorder;
    try {
        pduRecorder = new PduRecorder(); // default address, port, output directory path
        pduRecorder.setDescriptor("PduRecorder main() self test");
//      pduRecorder.setPort(1); // option to avoid listening to other PDU streams during self test
        pduRecorder.start();
    } 
    catch(IOException ex) {
      System.err.println("Exception creating recorder: " + ex.getLocalizedMessage());
      System.err.println(ex.getStackTrace());
      return;
    }
    System.out.println("dis7.utilities.stream.PduRecorder pduRecorder started... isRunning()=" + pduRecorder.isRunning());
     
    DisPduType allPDUTypesArray[] = DisPduType.values();
    System.out.println("dis7.utilities.stream.PduRecorder allPDUTypesArray created, length=" + allPDUTypesArray.length + " ...");
    System.out.flush(); // ensure all output sent
    Arrays.stream(allPDUTypesArray).forEach((DisPduType pduTypeValue)-> 
    {
      if (pduTypeValue != DisPduType.OTHER) 
      {
        try {
            pduRecorder.getDisThreadedNetworkInterface().send(factory.createPdu(pduTypeValue));
            Thread.sleep (50L); // let send/receive threads and streams catch up
        }
        catch (InterruptedException ex) {
          System.err.println("Exception sending Pdu: "+ex.getLocalizedMessage());
        }
      }
      else 
      {
          System.err.println("Found pduTypeValue=DisPduType.OTHER=" + pduTypeValue);
      }
    });
    System.out.flush();
    System.err.flush(); // ensure all output sent
    pduRecorder.stop();
    System.out.println("dis7.utilities.stream.PduRecorder pduRecorder complete... isRunning()=" + pduRecorder.isRunning());
  }
    /**
     * Get current multicast (or unicast) network address for send and receive connections.
     * @see <a href="https://en.wikipedia.org/wiki/Multicast_address">https://en.wikipedia.org/wiki/Multicast_address</a> 
     * @return current multicast address value
     */
    public String getAddress()
    {
        return this.disAddress;
    }
    /**
     * Network address for send and receive connections.
     * @see <a href="https://en.wikipedia.org/wiki/Multicast_address">https://en.wikipedia.org/wiki/Multicast_address</a> 
     * @param newAddress the new network address to set
     */
    public void setAddress(String newAddress) {
        this.disAddress = newAddress;
        if (isRunning())
            System.out.println(TRACE_PREFIX + "*** warning, attempting to change network address while running...");
        // TODO warn if netIF already created
    }
    /** Get network port used, multicast or unicast.
     * @see <a href="https://en.wikipedia.org/wiki/Port_(computer_networking)">https://en.wikipedia.org/wiki/Port_(computer_networking)</a> 
     * @return current port value
     */
    public int getPort()
    {
        return this.disPort;
    }
    /**
    /** Set network port used, multicast or unicast.
     * @see <a href="https://en.wikipedia.org/wiki/Port_(computer_networking)">https://en.wikipedia.org/wiki/Port_(computer_networking)</a> 
     * @param newPortValue the disPort value to set
     */
    public void setPort(int newPortValue)
    {
        this.disPort = newPortValue;
        if (isRunning())
            System.out.println(TRACE_PREFIX + "*** warning, attempting to change network port while running...");
        // TODO warn if netIF already created
    }
    /**
     * Get simple descriptor (such as parent class name) for this network interface, used in trace statements
     * @return simple descriptor name
     */
    public String getDescriptor() {
        return descriptor;
    }

    /**
     * Set new simple descriptor (such as parent class name) for this network interface, used in trace statements
     * @param newDescriptor simple descriptor name
     */
    public void setDescriptor(String newDescriptor) 
    {
        this.descriptor = newDescriptor;
        TRACE_PREFIX = "[" + (DisThreadedNetworkInterface.class.getSimpleName() + " " + descriptor).trim() + "] ";
    }
}
