/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.utilities.stream;

import com.google.common.primitives.Longs;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Base64;

import static edu.nps.moves.dis7.utilities.stream.PduRecorder.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.regex.Pattern;
//Test Tobi
public class PduPlayer
{
  public interface RawListener {
    void receiveBytes(byte[] ba);
  }
  private Path disLogDirectory;
  private String ip;
  private int port;
  private Thread thrd;
  
  public PduPlayer(String ip, int port, Path disLogDirectory) throws IOException
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
  private DatagramSocket datagramSocket;
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
      
      FilenameFilter filter = (dir, name) -> name.endsWith(PduRecorder.DISLOG_FILE_EXTENSION) && !name.startsWith(".");
      
      File[] fs = disLogDirectory.toFile().listFiles(filter);
      if (fs == null)
        fs = new File[0];
      
      Arrays.sort(fs, (f1, f2) -> {
        return f1.getName().compareTo(f2.getName());
      });
      //Arrays.sort(fs, Comparator.comparing(File::getName));

      if(netSend)
        datagramSocket = new DatagramSocket();
      Base64.Decoder base64Decoder = Base64.getDecoder();
      
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
            
            //---Code Tobi for Plain Text---
            if (line.contains("#")) line = line.substring(0,line.indexOf("#")-1); //Delete appended Comments
            //String[] sa = line.split(",");
            //Pattern splitting needed for playback of unencoded streams
                        String REGEX = "\\],\\[";
                        Pattern pattern = Pattern.compile(REGEX);
                        String[] sa;
                        sa = pattern.split(line);
                        //Add the "]" to the end of sa[0]. It was taken off by the split
                        sa[0] = sa[0].concat("]");
                        //Add the "]" to the end of sa[0]. It was taken off by the split
                        sa[1] = "[".concat(sa[1]);
            //------------------------------
            if (sa.length != 2) {
              System.err.println("Error: parsing error.  Line follows.");
              System.err.println(line);
              byebye();
            }
            
            if (startNanoTime == null)
              startNanoTime = System.nanoTime();
            
            //byte[] pduTimeBytes = decdr.decode(sa[0]);
            
            //---Code Tobi for Plain Text---
            byte[] pduTimeBytes = null;
            String[] splitString;

                        //Split first String into multiple Strings cotaining integers
                        REGEX = ",";
                        pattern = Pattern.compile(REGEX);

                        sa[0] = sa[0].substring(1, sa[0].length() - 1);

                        splitString = pattern.split(sa[0]);

                        //Define an array to store the in values from the string and initalize it to a value drifferent from NULL
                        int[] arr = new int[splitString.length];

                        String tempString = "";

                        //Test
                        for (int x = 0; x < splitString.length; x++) {

                            tempString = splitString[x].trim();

                            int tempInt = Integer.parseInt(tempString);
                            arr[x] = tempInt;
                        }
                        // Credit:  https://stackoverflow.com/questions/1086054/how-to-convert-int-to-byte
                        ByteBuffer byteBuffer1 = ByteBuffer.allocate(arr.length * 4);
                        IntBuffer intBuffer = byteBuffer1.asIntBuffer();
                        intBuffer.put(arr);

                        pduTimeBytes = byteBuffer1.array();
            
            //------------------------------
            long pduTimeInterval = Longs.fromByteArray(pduTimeBytes);
            // This is a relative number in nanoseconds of the time of packet reception minus first packet reception for scenario.

            long targetSimTime = startNanoTime + pduTimeInterval;  // when we should send the packet
            long now = System.nanoTime();
            long sleepTime = targetSimTime - now; //System.nanoTime(); // the difference between then and now

            if (sleepTime > 20000000) { // 20 ms //
              //System.out.println("sim interval = " + pduTimeInterval + ", sleeping for " + sleepTime/1000000l + " ms");
              sleep(sleepTime / 1000000L, (int) (sleepTime % 1000000L));
            }
            
            //byte[] buffer = decdr.decode(sa[1]);
            //---Code Tobi for Plain Text---
            //Handle the second String
                        // Split second String into multiple Strings cotaining integers
                        REGEX = ",";
                        pattern = Pattern.compile(REGEX);

                        sa[1] = sa[1].substring(1, sa[1].length() - 1);

                        splitString = pattern.split(sa[1]);

                        //Define an array to store the in values from the string and initalize it to a value drifferent from NULL
                        arr = new int[splitString.length];

                        //trim spaces, if any
                        tempString = "";

                        //Test
                        for (int x = 0; x < splitString.length; x++) {

                            tempString = splitString[x].trim();

                            int tempInt = Integer.parseInt(tempString);
                            arr[x] = tempInt;

                            //System.out.println(tempInt);
                        }

                        // Credit:  https://stackoverflow.com/questions/1086054/how-to-convert-int-to-byte
                        ByteBuffer byteBuffer2 = ByteBuffer.allocate(arr.length * 4);
                        intBuffer = byteBuffer2.asIntBuffer();
                        intBuffer.put(arr);

                        byte[] buffer = byteBuffer2.array();
                        
                        //When the byteBuffer stores the arry of Integers into the byte array it store a 7 as 0 0 0 7.
                        //Therefore a shortBuffer is created where only every forth value is stored.
                        //it must be done with modulo instead of testing for "0" because a "0" could be there as value and not as padding
                        byte[] bufferShort = new byte[byteBuffer2.array().length / 4];

                        int bufferShortCounter = 0;

                        for (int i = 1; i < byteBuffer2.array().length; i++) {

                            if (((i + 1) % 4) == 0) {

                                bufferShort[bufferShortCounter] = buffer[i];
                                bufferShortCounter++;
                            }
                        }
            //------------------------------
            
            if(netSend) {
              DatagramPacket datagramPacket = new DatagramPacket(bufferShort, bufferShort.length, addr, port);
              datagramSocket.send(datagramPacket);
              System.out.println("Sent PDU ");
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
    catch (IOException ex) {
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
      if (datagramSocket != null) {
        datagramSocket.close();
        datagramSocket = null;
      }
      if (brdr != null) {
        brdr.close();
        brdr = null;
      }
    }
    catch (IOException ioex) {
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
    else if (s.startsWith(FINISH_COMMENT_MARKER)) {
      System.out.print("Total PDUs: ");
      showCounts();
      System.out.println();
      System.out.println("End of replay from " + f.getName());
      System.out.println(s.substring(FINISH_COMMENT_MARKER.length()));
      
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
  
  /** Invocation
    * @param args none supported
   */
  public static void main(String[] args)
  {
    try {
      //new Player("230.0.0.0", 3000, new File("./pdulog").toPath()).startResume();
      new PduPlayer("230.0.0.0", 3000, new File("./pdulog").toPath());
    }
    catch (IOException ex) {
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
