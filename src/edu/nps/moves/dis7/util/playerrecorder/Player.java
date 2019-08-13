/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.nps.moves.dis7.util.playerrecorder;


import com.google.common.primitives.Longs;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Base64;

import static edu.nps.moves.dis7.util.playerrecorder.Recorder.*;

public class Player
{
  private Path disLogDirectory;
  private String ip;
  private int port;

  public Player(String ip, int port, Path disLogDirectory)
  {
    this.disLogDirectory = disLogDirectory;
    this.ip = ip;
    this.port = port;
  }

  private Integer scenarioPduCount = null;
  private boolean showPduCountsOneTime = false;
  private int pduCount = 0;
  private DatagramSocket dsock;
  private BufferedReader brdr;
  private Long startNanoTime=null;

  @SuppressWarnings("StatementWithEmptyBody")
  public void startResume() throws IOException
  {
    System.out.println("Replaying DIS logs.");
    InetAddress addr = InetAddress.getByName(ip);

    FilenameFilter filter = (dir, name) -> name.endsWith(Recorder.DISLOG_FILE_TAIL) && !name.startsWith(".");

    File[] fs = disLogDirectory.toFile().listFiles(filter);
    if(fs == null)
      fs = new File[0];

    Arrays.sort(fs,(f1,f2)->{return f1.getName().compareTo(f2.getName());});
    //Arrays.sort(fs, Comparator.comparing(File::getName));

    dsock = new DatagramSocket();
    Base64.Decoder decdr = Base64.getDecoder();

    for(File f : fs) {
      System.out.println("Replaying "+f.getAbsolutePath());
      brdr = new BufferedReader(new FileReader(f), 1024 * 200); // 200kb buffer

      String line = brdr.readLine();
      while(line != null) {
        if(line.length()<=0)
          ; // blank lines ok
        else if (line.startsWith(COMMENT_MARKER)) {
          if(handleComment(line,f)) {
            // here if we got an end comment
            break;  // out of read loop
          }
        }
        else {

          String[] sa = line.split(",");
          if (sa.length != 2) {
            System.err.println("Error: parsing error.  Line follows.");
            System.err.println(line);
            byebye();
          }

          if (startNanoTime == null)
            startNanoTime = System.nanoTime();

          byte[] pduTimeBytes = decdr.decode(sa[0]);
          long pduTimeInterval = Longs.fromByteArray(pduTimeBytes);
          // This is a relative number in nanoseconds of the time of packet reception minus first packet reception for scenario.

          long targetSimTime = startNanoTime + pduTimeInterval;  // when we should send the packet
          long now = System.nanoTime();
          long sleepTime = targetSimTime - now; //System.nanoTime(); // the difference between then and now

          if (sleepTime > 20000000) { // 20 ms //
            //System.out.println("sim interval = " + pduTimeInterval + ", sleeping for " + sleepTime/1000000l + " ms");
            sleep(sleepTime/1000000L, (int)(sleepTime % 1000000L));
          }

          byte[] buffer = decdr.decode(sa[1]);
          //Pdu pdu = pduFactory.createPdu(buffer);
          DatagramPacket packet = new DatagramPacket(buffer, buffer.length, addr, port);
          dsock.send(packet);

          pduCount++;
          if(scenarioPduCount != null)
            scenarioPduCount++;

          if(showPduCountsOneTime || pduCount % 5 == 0)
            showCounts();
        }

        line = brdr.readLine();
      }
      brdr.close();
    }
  }
  private void showCounts()
  {
    if(scenarioPduCount != null)
      System.out.print(pduCount + " " + ++scenarioPduCount+"\r");
    else
      System.out.print(pduCount+"\r");
    showPduCountsOneTime = false;
  }

  private void byebye() throws IOException
  {
    System.out.println("Replay stopped.");

    // @formatter:off
    try { dsock.close();brdr.close(); } catch (Exception ioex) {System.err.println("IOException closing reader in Player"); }
    // @formatter:on

    throw new IOException("Dis Replayer parsing error");
  }

  private boolean handleComment(String s, File f)  //true if we're done
  {
    boolean ret=false;
    if(s.startsWith(START_COMMENT_MARKER)) {
      //System.out.println();
      s = s.substring(START_COMMENT_MARKER.length());
      System.out.println(s+"  ");
      showPduCountsOneTime = true;  // get the first one in there
    }
    else if (s.startsWith(STOP_COMMENT_MARKER)) {
      showCounts();
      System.out.println();
      System.out.println("End of replay from "+f.getName());
      System.out.println(s.substring(STOP_COMMENT_MARKER.length()));

      scenarioPduCount = 0;
      startNanoTime=null;
      ret = true;
    }
    return ret;
  }

  @SuppressWarnings("unused")
  public void stopPause()
  {

  }
  
  public static void main(String[] args)
  {
    try {
      //new Player("230.0.0.0", 3000, new File("./pdulog").toPath()).startResume();
      new Player("230.0.0.0", 3000, new File("/Users/mike/NetbeansProjects/open-dis7-java/examples/pdulog").toPath()).startResume();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  private static void sleep(long ms, int ns)
  {
    // @formatter:off
    try { Thread.sleep(ms,ns); } catch (InterruptedException ex) { System.out.println("InterruptedException"); }
    // @formatter:on
  }
}
