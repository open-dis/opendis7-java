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
  /** Character sentinel indicating remainder of line is a comment */
  public static final String COMMENT_MARKER = "#";
  
  static String outputDirectoryPath   = "./pduLog";
  static String DEFAULT_FILE_PREFIX   = "PduCaptureLog";
  static String DISLOG_FILE_EXTENSION = ".dislog";
  
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

  private Writer logFileWriter;
  private File   logFile;
  private DisThreadedNetworkInterface                disThreadedNetIF;
  private DisThreadedNetworkInterface.RawPduListener disRawPduListener;
  
  private Long      startNanoTime = null;
  private final  StringBuilder sb = new StringBuilder();
  private final  Base64.Encoder base64Encoder = Base64.getEncoder();
  private static int     port     = DisThreadedNetworkInterface.DEFAULT_DIS_PORT; // self-test via port 1 when main() invoked
  private final  int     pduCount = 0;    // debug
  private boolean headerWritten   = false;
  private boolean running         = true; // starts recording by default
  
  /**
   * Default constructor that uses default values for output directory, multicast address and port.
   * 
   * @throws IOException if something goes wrong during instantiation
   */
  public PduRecorder() throws IOException
  {
      this(outputDirectoryPath, DisThreadedNetworkInterface.DEFAULT_MULTICAST_ADDRESS, port);
  }
  
  /**
   * Constructor to let the use specify an output directory. Uses default values 
   * for multicast address and port.
   * 
   * @param directoryPath the directory to write log files to
   * @throws IOException if something goes wrong during instantiation
   */
  public PduRecorder(String directoryPath) throws IOException
  {
    this(directoryPath, DisThreadedNetworkInterface.DEFAULT_MULTICAST_ADDRESS, DisThreadedNetworkInterface.DEFAULT_DIS_PORT);
  }
  
  /** Constructor to let the user specify all required parameters
   * 
   * @param outputPath local path to the directory to write log files to
   * @param multicastAddress the multicast group address to receive data from (TODO allow unicast UDP)
   * @param port the port to receive data through
   * @throws IOException if something goes wrong during instantiation
   */
  @SuppressWarnings("Convert2Lambda")
  public PduRecorder(String outputPath, String multicastAddress, int port) throws IOException
  {
    outputDirectoryPath = outputPath;
    logFile       = createUniquePduLogFile(new File(outputPath).toPath(), DEFAULT_FILE_PREFIX + DISLOG_FILE_EXTENSION );
    logFileWriter = new PrintWriter(new BufferedWriter(new FileWriter(logFile)));
    
    disThreadedNetIF = new DisThreadedNetworkInterface(multicastAddress, port);
    
    disRawPduListener = new DisThreadedNetworkInterface.RawPduListener() {
        @Override
        public void incomingPdu(DisThreadedNetworkInterface.ByteArrayBufferAndLength bAndL) {
            receivePdu(bAndL.bufferByteArray, bAndL.length);
        }
    };
    
    disThreadedNetIF.addRawListener(disRawPduListener);
    System.out.println(getClass() + " listening to IP address " + multicastAddress + " on port " + port);
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

  /** Start or resume this instance */
  public void startResume()
  {
    running = true;
  }
  /** Stop or pause this instance */
  public void stopPause()
  {
    running = false;
  }
  /** End operation of this instance
     * @return recorder logFile */
  public File end()
  {
    running = false;
    disThreadedNetIF.removeRawListener(disRawPduListener);
    disThreadedNetIF.kill();

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
    public DisThreadedNetworkInterface getDisThreadedNetIF() {
        return disThreadedNetIF;
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
    System.out.println("dis7.utilities.stream.PduRecorder main() performs self-test by sending full set of PDUs via port " + port);
    port = 1; // avoid listening to other PDU streams during self test
    
    PduFactory factory = new PduFactory(); //default appid, country, etc.

    PduRecorder pduRecorder;
    try {
        pduRecorder = new PduRecorder(); // default address, port, output directory path
    } 
    catch(IOException ex) {
      System.err.println("Exception creating recorder: " + ex.getLocalizedMessage());
      return;
    }
    System.out.println("dis7.utilities.stream.PduRecorder pduRecorder created... isRunning()=" + pduRecorder.isRunning());
     
    DisPduType allPDUTypesArray[] = DisPduType.values();
    System.out.println("dis7.utilities.stream.PduRecorder allPDUTypesArray created, length=" + allPDUTypesArray.length + " ...");
    Arrays.stream(allPDUTypesArray).forEach(pduTypeValue-> {
      if(pduTypeValue != DisPduType.OTHER) 
      {
        try {
            pduRecorder.getDisThreadedNetIF().send(factory.createPdu(pduTypeValue));
        }
        catch(Exception ex) {
          System.err.println("Exception sending Pdu: "+ex.getLocalizedMessage());
        }
      }
    });
    System.err.flush(); // ensure all output sent
    pduRecorder.end();
    System.out.println("dis7.utilities.stream.PduRecorder pduRecorder complete... isRunning()=" + pduRecorder.isRunning());
  }
}
