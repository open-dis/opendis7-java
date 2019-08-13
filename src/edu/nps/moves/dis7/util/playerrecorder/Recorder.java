package edu.nps.moves.dis7.util.playerrecorder;

import com.google.common.primitives.Longs;
import edu.nps.moves.dis7.Pdu;
import edu.nps.moves.dis7.enumerations.DISPDUType;
import edu.nps.moves.dis7.util.DisNetworking;
import edu.nps.moves.dis7.util.DisNetworking.BuffAndLength;
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
  static String DISLOG_FILE_TAIL = ".dislog";

  public static String COMMENT_MARKER = "!";
  static String START_COMMENT_MARKER = COMMENT_MARKER + "Begin" + COMMENT_MARKER;
  static String STOP_COMMENT_MARKER = COMMENT_MARKER + "End" + COMMENT_MARKER;

  private BufferedWriter bwr;

  private File logFile;

  public Recorder(Path outputDir, String filename) throws IOException
  {
    logFile = makeFile(outputDir, filename + DISLOG_FILE_TAIL);
    bwr = new BufferedWriter(new FileWriter(logFile));
  }

  Long startNanoTime = null;
  StringBuilder sb = new StringBuilder();
  Base64.Encoder encdr = Base64.getEncoder();
  int pduCount = 0;
  boolean headerWritten = false;

  @Override
  public void receivePdu(byte[] buff, int len)
  {
    //Pdu pdu = makePdu(type,buff,len);
    long packetRcvNanoTime = System.nanoTime();
    if (startNanoTime == null)
      startNanoTime = packetRcvNanoTime;

    byte[] timeAr = Longs.toByteArray(packetRcvNanoTime - startNanoTime);
    System.out.println("wrote time "+(packetRcvNanoTime - startNanoTime));

    sb.setLength(0);
    sb.append(encdr.encodeToString(timeAr));
    sb.append(',');
    byte[] buffsized = Arrays.copyOf(buff, len);
    sb.append(encdr.encodeToString(buffsized));
    try {
      if (!headerWritten) {
        writeHeader();
        headerWritten = true;
      }
      bwr.write(sb.toString());
      bwr.newLine();
    }
    catch (IOException ex) {
      System.err.println("Fatal exception writing DIS log file in Recorder.start()");
      throw new RuntimeException(ex);
    }
    System.out.print(++pduCount + "\r");

    //bwr.flush();
    sb.setLength(0);
  }

  public void stopAndClose()
  {
    try {
      writeFooter();
      bwr.flush();
      bwr.close();
      System.out.println("Recorder log file closed");
    }
    catch (IOException ex) {
      System.out.println("IOException closing file: " + ex.getMessage());
    }
  }

  private void writeHeader() throws IOException
  {
    String template = "Beginning of DIS capture file, %s.";
    String startComment = String.format(template, logFile.getName());
    bwr.write(START_COMMENT_MARKER + startComment);
    bwr.newLine();
  }

  private void writeFooter() throws IOException
  {
    String template = "End of DIS capture file, %s.";
    String endComment = String.format(template, logFile.getName());
    bwr.write(STOP_COMMENT_MARKER + endComment);
    bwr.newLine();
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
  
  /* Example usage */
  public static void main(String[] args)
  {
    PduFactory factory = new PduFactory(); //default appid, country, etc.
    DisNetworking disnet = new DisNetworking(); // default ip and port
    
    Path path = new File("./pdulog").toPath();
    String filename = "Pdusave";
    
    Recorder recorder;
    try{recorder = new Recorder(path, filename);} catch(IOException ex) {
      System.err.println("Exception creating recorder: "+ex.getLocalizedMessage());
      return;
    }
    
    // Start a thread to receive and record pdus

    Thread receiverThrd = new Thread(()->{
      int count = 1;
      while(true){
      try {
        BuffAndLength blen = disnet.receiveRawPdu();
        System.out.println(""+ count++ +" Got pdu from DisNetworking");
        recorder.receivePdu(blen.buff,blen.length);
      }
      catch(IOException ex) {
        System.err.println("Exception receiving Pdu: "+ex.getLocalizedMessage());
      }
      }
    });
    receiverThrd.setPriority(Thread.NORM_PRIORITY);
    receiverThrd.setDaemon(true);
    receiverThrd.start();
    
    
    DISPDUType all[] = DISPDUType.values();
    Arrays.stream(all).forEach(typ-> {
      if(typ != DISPDUType.OTHER) {
        try {
          Pdu pdu = factory.createPdu(typ);
          disnet.sendPdu(pdu);
          sleep(100);
        }
        catch(IOException ex) {
          System.err.println("Exception sending Pdu: "+ex.getLocalizedMessage());
        }
      }
      });
    sleep(2000);
    
    receiverThrd.interrupt();
    recorder.stopAndClose();
  }
  
  private static void sleep(long ms)
  {
    try{Thread.sleep(ms);}catch(InterruptedException ex) {}
  }
}
