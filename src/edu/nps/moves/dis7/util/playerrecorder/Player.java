/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
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
  public interface RawListener {
    void receiveBytes(byte[] ba);
  }
  private Path disLogDirectory;
  private String ip;
  private int port;
  private Thread thrd;
  
  public Player(String ip, int port, Path disLogDirectory) throws IOException
  {
    this.disLogDirectory = disLogDirectory;
    this.ip = ip;
    this.port = port;
    
    thrd = new Thread(() -> begin());
    thrd.setPriority(Thread.NORM_PRIORITY);
    thrd.setName("PlayerThread");
    thrd.setDaemon(true);
    thrd.start();
  }
  
  private Integer scenarioPduCount = null;
  private boolean showPduCountsOneTime = false;
  private int pduCount = 0;
  private DatagramSocket dsock;
  private BufferedReader brdr;
  private Long startNanoTime = null;
  private boolean paused = false;
  private boolean netSend = true;
  private RawListener rawListener = null;
  
  public void sendToNet(boolean tf)
  {
    netSend = tf;
  }
  public void addRawListener(RawListener lis)
  {
    rawListener = lis;
  }
  @SuppressWarnings("StatementWithEmptyBody")
  public void begin()
  {
    try {
      System.out.println("Replaying DIS logs.");
      InetAddress addr = InetAddress.getByName(ip);
      
      FilenameFilter filter = (dir, name) -> name.endsWith(Recorder.DISLOG_FILE_TAIL) && !name.startsWith(".");
      
      File[] fs = disLogDirectory.toFile().listFiles(filter);
      if (fs == null)
        fs = new File[0];
      
      Arrays.sort(fs, (f1, f2) -> {
        return f1.getName().compareTo(f2.getName());
      });
      //Arrays.sort(fs, Comparator.comparing(File::getName));

      if(netSend)
        dsock = new DatagramSocket();
      Base64.Decoder decdr = Base64.getDecoder();
      
      for (File f : fs) {
        System.out.println("Replaying " + f.getAbsolutePath());
        brdr = new BufferedReader(new FileReader(f), 1024 * 200); // 200kb buffer

        String line = brdr.readLine();
        while (line != null && !Thread.interrupted()) {
          while (paused) {
            sleep(1000l); // TODO confirm: full second, was half second
          }
          if (line.length() <= 0)
          ; // blank lines ok
          else if (line.startsWith(COMMENT_MARKER)) {
            if (handleComment(line, f)) {
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
              sleep(sleepTime / 1000000L, (int) (sleepTime % 1000000L));
            }
            
            byte[] buffer = decdr.decode(sa[1]);
            
            if(netSend) {
              DatagramPacket packet = new DatagramPacket(buffer, buffer.length, addr, port);
              dsock.send(packet);
            }
            if(rawListener != null) {
              rawListener.receiveBytes(buffer);
            }
            pduCount++;
            if (scenarioPduCount != null)
              scenarioPduCount++;
            
            if (showPduCountsOneTime || pduCount % 5 == 0)
              showCounts();
          }
          
          line = brdr.readLine();
        }
        brdr.close();
      }
      if(rawListener != null)
        rawListener.receiveBytes(null); // indicate the end
    }
    catch (Exception ex) {
      System.err.println("Exception reading/writing pdus: "+ex.getClass().getSimpleName()+": "+ex.getLocalizedMessage());
      thrd = null;
      closer();
    }
  }

  private void sleep(long ms)
  {
    try {
      Thread.sleep(ms);
    }
    catch (InterruptedException ex) {
    }
  }
  
  private void showCounts()
  {
    // use carriage return \r for transient display output as a run-time developer diagnostic
    // (possibly as part of earlier diagnosis of threading-related problems with dropped packets)
    if (scenarioPduCount != null)
      System.out.print(pduCount + " " + ++scenarioPduCount + "..." + "\r"); // TODO where are the ... ? not appearing in output
    else
      System.out.print(pduCount + "\r");
    showPduCountsOneTime = false;
  }
  
  private void byebye() throws IOException
  {
    System.out.println("Replay stopped.");
    closer();
    throw new IOException("Dis Replayer parsing error");
  }
  
  private void closer()
  {
    try {
      if (dsock != null) {
        dsock.close();
        dsock = null;
      }
      if (brdr != null) {
        brdr.close();
        brdr = null;
      }
    }
    catch (Exception ioex) {
      System.err.println("IOException closing reader in Player");
    }
  }
  
  private boolean handleComment(String s, File f)  //true if we're done
  {
    boolean ret = false;
    if (s.startsWith(START_COMMENT_MARKER)) {
      //System.out.println();
      s = s.substring(START_COMMENT_MARKER.length());
      System.out.println(s + "  ");
      showPduCountsOneTime = true;  // get the first one in there
    }
    else if (s.startsWith(STOP_COMMENT_MARKER)) {
      System.out.print("Total PDUs: ");
      showCounts();
      System.out.println();
      System.out.println("End of replay from " + f.getName());
      System.out.println(s.substring(STOP_COMMENT_MARKER.length()));
      
      scenarioPduCount = 0;
      startNanoTime = null;
      ret = true;
    }
    return ret;
  }

  public void startResume()
  {
    paused = false;
  }
  
  public void stopPause()
  {
    paused = false;
  }

  public void end()
  {
    thrd.interrupt();
    closer();
  }
  
  public static void main(String[] args)
  {
    try {
      //new Player("230.0.0.0", 3000, new File("./pdulog").toPath()).startResume();
      new Player("230.0.0.0", 3000, new File("/Users/mike/NetbeansProjects/open-dis7-java/examples/pdulog").toPath());
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static void sleep(long ms, int ns)
  {
    // @formatter:off
    try {
      Thread.sleep(ms, ns);
    }
    catch (InterruptedException ex) {
      System.out.println("InterruptedException");
    }
    // @formatter:on
  }
}
