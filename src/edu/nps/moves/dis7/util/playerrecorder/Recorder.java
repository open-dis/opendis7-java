package edu.nps.moves.dis7.util.playerrecorder;

import com.google.common.primitives.Longs;
import edu.nps.moves.dis7.Pdu;
import edu.nps.moves.dis7.enumerations.DISPDUType;
import edu.nps.moves.dis7.util.DisNetworking;
import edu.nps.moves.dis7.util.DisThreadedNetIF;
import edu.nps.moves.dis7.util.PduFactory;
import org.apache.commons.io.FilenameUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Base64;

public class Recorder implements PduReceiver
{
  static String DEFAULT_OUTDIR = "./pdulog";
  static String DEFAULT_FILEPREFIX = "Pdusave";
  static String DEFAULT_MCAST = "230.0.0.0";
  static int    DEFAULT_PORT = 3000;
  
  static String DISLOG_FILE_TAIL = ".dislog";

  public static String COMMENT_MARKER = "!";
  static String START_COMMENT_MARKER = COMMENT_MARKER + "Begin" + COMMENT_MARKER;
  static String STOP_COMMENT_MARKER  = COMMENT_MARKER + "End"   + COMMENT_MARKER;

  private BufferedWriter bufferedWriter;
  private File           logFile;
  
  private DisThreadedNetIF disnetworking;
  
  public Recorder() throws IOException
  {
    this(DEFAULT_OUTDIR,DEFAULT_MCAST,DEFAULT_PORT);
  }
  
  public Recorder(String outputDir, String mcastaddr, int port) throws IOException
  {
    logFile = makeFile(new File(outputDir).toPath(), DEFAULT_FILEPREFIX+DISLOG_FILE_TAIL );
    bufferedWriter = new BufferedWriter(new FileWriter(logFile));
    
    disnetworking = new DisThreadedNetIF(port, mcastaddr);
    disnetworking.addRawListener(bAndL->receivePdu(bAndL.buff,bAndL.length));
  }
  
  public void startResume()
  {
    doSave = true;
  }
  
  public void stopPause()
  {
    doSave = false;
  }
  
  public String getOutputFile()
  {
    if(logFile != null)
      return logFile.getAbsolutePath();
    return null;
  }
  
  public File end() throws IOException
  {
    disnetworking.kill();

    writeFooter();
    bufferedWriter.flush();
    bufferedWriter.close();
    System.out.println();
    System.out.println("Recorder log file closed");
    return logFile;
  }
 
  Long startNanoTime = null;
  StringBuilder sb = new StringBuilder();
  Base64.Encoder base64Encoder = Base64.getEncoder();
  int pduCount = 0;
  boolean headerWritten = false;
  boolean doSave = true;
  
  @Override
  public void receivePdu(byte[] buff, int len)
  {
    if(!doSave)
      return;
    
    long packetRcvNanoTime = System.nanoTime();
    if (startNanoTime == null)
        startNanoTime = packetRcvNanoTime;

    byte[] timeByteArray = Longs.toByteArray(packetRcvNanoTime - startNanoTime);
    //System.out.println("wrote time "+(packetRcvNanoTime - startNanoTime));

    sb.setLength(0);
    sb.append(base64Encoder.encodeToString(timeByteArray));
    sb.append(',');
    byte[] buffsized = Arrays.copyOf(buff, len);
    sb.append(base64Encoder.encodeToString(buffsized));
    try {
      if (!headerWritten) {
        writeHeader();
        headerWritten = true;
      }
      bufferedWriter.write(sb.toString());
      bufferedWriter.newLine();
    }
    catch (IOException ex) {
      System.err.println("Fatal exception writing DIS log file in Recorder.start()");
      throw new RuntimeException(ex);
    }
    //System.out.println("Recorder: "+ ++pduCount);

    sb.setLength(0);
  }
  
  public String getLogFile()
  {
    return logFile.getAbsolutePath();
  }
  
  private void writeHeader() throws IOException
  {
    String template = "Beginning of DIS capture file, %s.";
    String startComment = String.format(template, logFile.getName() + " (show transient progressing PDU count, then final total)");
    bufferedWriter.write(START_COMMENT_MARKER + startComment);
    bufferedWriter.newLine();
  }

  private void writeFooter() throws IOException
  {
    String template = "End of DIS capture file, %s.";
    String endComment = String.format(template, logFile.getName());
    bufferedWriter.write(STOP_COMMENT_MARKER + endComment);
    bufferedWriter.newLine();
  }

  private File makeFile(Path outputDir, String filename) throws IOException
  {
    String bname = FilenameUtils.getBaseName(filename);
    String ext = FilenameUtils.getExtension(filename);

    Integer count = null;
    File f;
    boolean fileExists;
    outputDir.toFile().mkdirs();
    do {
      String fn = bname + (count == null ? "" : count) + "." + ext;
      f = new File(outputDir.toFile(), fn);
      fileExists = f.exists();
      if (count == null)
        count = 1;
      else
        count++;
    } while (fileExists);
    if (!f.createNewFile()) {
      System.out.println("Cannot create dis log file at " + f.getAbsolutePath());
      throw new RuntimeException("File creation error");
    }
    return f;
  }
  
  /* Example test usage */
  public static void main(String[] args)
  {
    PduFactory factory = new PduFactory(); //default appid, country, etc.
    DisNetworking disnet = new DisNetworking(); // default ip and port
    
    Path path = new File("./pdulog").toPath();
    String filename = "Pdusave";
    
    Recorder recorder;
    try{recorder = new Recorder();} catch(IOException ex) {
      System.err.println("Exception creating recorder: "+ex.getLocalizedMessage());
      return;
    }
     
    DISPDUType all[] = DISPDUType.values();
    Arrays.stream(all).forEach(typ-> {
      if(typ != DISPDUType.OTHER) {
        try {
          Pdu pdu = factory.createPdu(typ);
          disnet.sendPdu(pdu);
          sleep(100);
        }
        catch(Exception ex) {
          System.err.println("Exception sending Pdu: "+ex.getLocalizedMessage());
        }
      }
      });
    sleep(2000);
    
    try {
      recorder.end();
    }
    catch(Exception ex) {
      System.err.println("Exception closing recorder: "+ex.getClass().getSimpleName()+": "+ex.getLocalizedMessage());
    }
  }
  
  private static void sleep(long ms)
  {
    try{Thread.sleep(ms);}catch(InterruptedException ex) {}
  }
}
