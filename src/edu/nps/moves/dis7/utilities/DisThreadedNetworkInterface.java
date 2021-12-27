/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.utilities;

import edu.nps.moves.dis7.enumerations.DisPduType;
import edu.nps.moves.dis7.pdus.DisTime;
import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.Pdu;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a thread-safe, multicast DIS network interface class.
 * 
 * @author Mike Bailey, jmbailey@nps.edu
 * @since Jul 29, 2019
 */
public class DisThreadedNetworkInterface
{

    /** ********** Begin class ************** */
    /**
     * MTU 8192: TODO this has actually been superseded by a larger buffer size,
     * but good enough for now
     */
    public static final int MAX_DIS_PDU_SIZE = 8192;

    /**
     * MTU 1500: size of an Ethernet frame, common value to avoid packet
     * segmentation
     */
    public static final int MAX_TRANSMISSION_UNIT_SIZE = 1500;

    // independently available parameters for each DisThreadedNetworkInterface object
    private String  disAddress; 
    private int     disPort;
    private boolean killed = false; // thread loop sentinel

    private InetAddress       inetAddress;
    private InetSocketAddress inetSocket;
    private NetworkInterface  networkInterface;
    private DatagramSocket    datagramSocket;
    
    /** Default multicast group address <code>239.1.2.3</code> for send and receive connections.
     * @see <a href="https://en.wikipedia.org/wiki/Multicast_address">https://en.wikipedia.org/wiki/Multicast_address</a>  */
    public static String DEFAULT_DIS_ADDRESS = "239.1.2.3";

    /** Default socket port  <code>3000</code>, matches Wireshark DIS capture default
     * @see <a href="https://en.wikipedia.org/wiki/Port_(computer_networking)">https://en.wikipedia.org/wiki/Port_(computer_networking)</a> */
    public static int DEFAULT_DIS_PORT = 3000;

    private String  descriptor      = new String();
    private String  TRACE_PREFIX = "[" + (this.getClass().getSimpleName() + " " + getDescriptor()).trim() + "] ";
    private boolean verbose         = true;
    private boolean verboseReceipt  = true;
    private boolean verboseSending  = true;
    private boolean verboseIncludesTimestamp = false;

    /* *********** queues and lists  and public methods ************** */
    private final List<PduListener> everyTypeListeners = new ArrayList<>();
    private final Map<DisPduType, List<PduListener>> typeListeners = new HashMap<>();
    private final List<RawPduListener> rawListeners = new ArrayList<>();
    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/LinkedBlockingQueue.html
    private final LinkedBlockingQueue<Pdu> pdus2send = new LinkedBlockingQueue<>(); // FIFO

    ByteArrayOutputStream baos;
    DataOutputStream      dos;
    DatagramPacket        packet;

    /**
     * Pdu listener class and interface
     */
    public interface PduListener
    {
        /**
         * Callback method
         * @param pdu received pdu
         */
        void incomingPdu(Pdu pdu);
    }

    /**
     * Raw pdu listener class and interface
     */
    public interface RawPduListener
    {
        /**
         * Callback method
         * @param bAndL exposed buffer to receive incoming pdu
         */
        void incomingPdu(ByteArrayBufferAndLength bAndL);
    }

    /**
     * Stores data for further processing
     */
    public class ByteArrayBufferAndLength
    {
        /**
         * Active ByteArray buffer
         */
        public byte[] bufferByteArray;
        /**
         * Active ByteArray buffer length
         */
        public int length;

        /**
         * Default constructor for data storage
         *
         * @param bufferByteArray the data buffer to store
         * @param length the length of the data buffer
         */
        public ByteArrayBufferAndLength(byte[] bufferByteArray, int length)
        {
            this.bufferByteArray = bufferByteArray;
            this.length = length;
        }
    }

    /**
     * Object constructor using default multicast address and port, no descriptor
     */
    public DisThreadedNetworkInterface()
    {
        this(DEFAULT_DIS_ADDRESS, DEFAULT_DIS_PORT, "");
    }
    /**
     * Object constructor with descriptor, using default multicast address and port
     * @param newDescriptor simple descriptor name for this interface
     */
    public DisThreadedNetworkInterface(String newDescriptor)
    {
        this(DEFAULT_DIS_ADDRESS, DEFAULT_DIS_PORT, newDescriptor);
    }
    /**
     * Object constructor using specified multicast address and port 
     * @param address the multicast group or unicast address to utilize
     * @param port the multicast port to utilize
     */
    public DisThreadedNetworkInterface(String address, int port)
    {
        
        this(address, port, "");
    }
    /**
     * Object constructor using specified multicast address and port, plus descriptor.
     * @param address the multicast group or unicast address to utilize
     * @param port the multicast port to utilize
     * @param newDescriptor simple descriptor name for this interface
     */
    public DisThreadedNetworkInterface(String address, int port, String newDescriptor)
    {
        if (newDescriptor == null)
             descriptor = "";
        else descriptor = newDescriptor;
        TRACE_PREFIX = "[" + (DisThreadedNetworkInterface.class.getSimpleName() + " " + descriptor).trim() + "] ";
        
        disAddress = address;
        disPort    = port;
        try
        {
            inetAddress = InetAddress.getByName(disAddress);
        }
        catch (UnknownHostException ex)
        {
            Logger.getLogger(DisThreadedNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        inetSocket = new InetSocketAddress(inetAddress, disPort); // tests that accessor methods are working as set
        networkInterface = findIpv4Interface();
        
        begin();
    }

    /**
     * Add a listener to accept only pdus of a given type
     * @param newListener listener instance implementing the RawPduListener interface
     * @param disPduType Pdu type
     */
    public void addListener(PduListener newListener, DisPduType disPduType)
    {
        if (disPduType == null)
        {
            addListener(newListener);
        }
        else
        {
            List<PduListener> arLis = typeListeners.get(disPduType);
            if (arLis == null)
            {
                arLis = new ArrayList<>();
                typeListeners.put(disPduType, arLis);
            }
            arLis.add(newListener);
        }
    }

    /**
     * Add a listener to accept all pdu types
     * @param newListener listener instance implementing the RawPduListener interface
     */
    public void addListener(PduListener newListener)
    {
        everyTypeListeners.add(newListener);
    }

    /**
     * Remove previously added listener
     *
     * @param priorListener listener instance implementing the RawPduListener interface
     */
    public void removeListener(PduListener priorListener)
    {
        everyTypeListeners.remove(priorListener);

        typeListeners.entrySet().forEach(entry ->
        {
            List<PduListener> arLis = entry.getValue();
            if (arLis.contains(priorListener))
            {
                arLis.remove(priorListener);
            }
        });
        // additional sleep, hopefully allowing teardown to proceed to completion
        sleep(100l); // TODO needed?
    }

    /**
     * Add a listener to accept pdus of all types in the form of a byte array
     *
     * @param rawPduListener listener instance implementing the RawPduListener interface
     */
    public void addRawListener(RawPduListener rawPduListener)
    {
        rawListeners.add(rawPduListener);
    }

    /**
     * Remove previously added raw listener
     *
     * @param rawPduListener listener instance implementing the RawPduListener interface
     */
    public void removeRawListener(RawPduListener rawPduListener)
    {
        rawListeners.remove(rawPduListener);
        // additional sleep, hopefully allowing teardown to proceed to completion
        sleep(100l); // TODO needed?
    }

    /**
     * Method renamed as <code>getAddress()</code> so use that method instead.
     * @return current multicast address value
     */
    @Deprecated
    public String getMulticastGroup()
    {
        return getAddress();
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
    }

    /**
     * Send the given pdu to the network using the IP address and port given to the constructor
     * @param pdu the pdu to send
     */
    public void send(Pdu pdu)
    {
        pdus2send.add(pdu);
    }

    /* *************** networking i/o ************* */
    private PduFactory pduFactory = new PduFactory();

    private Thread sendingThread;
    private Thread receiveThread;

    /** Initialization of threads, otherwise no action that while they remain running */
    private synchronized void createThreads()
    {
        if (receiveThread == null)
        {
//          System.out.println("DisThreadedNetworkInterface createThreads() start receiveThread...");
            receiveThread = new Thread(receiveThreadRunnable, "receiveThread");
            // https://stackoverflow.com/questions/2213340/what-is-a-daemon-thread-in-java
            receiveThread.setDaemon(false); // user thread, not system thread
            receiveThread.setPriority(Thread.NORM_PRIORITY);
            receiveThread.start();
        }
        System.out.println("DisThreadedNetworkInterface createThreads() receiveThread.isAlive()=" + receiveThread.isAlive());

        if (sendingThread == null)
        {
//          System.out.println("DisThreadedNetworkInterface createThreads() start sendingThread...");
            sendingThread = new Thread(sendingThreadRunnable, "sendingThread");
            // https://stackoverflow.com/questions/2213340/what-is-a-daemon-thread-in-java
            sendingThread.setDaemon(false); // user thread, not system thread
            sendingThread.setPriority(Thread.NORM_PRIORITY);
            sendingThread.start();
        }
        System.out.println("DisThreadedNetworkInterface createThreads() sendingThread.isAlive()=" + receiveThread.isAlive());
    }
    /**
     * Can be used to restart DisThreadedNetworkInterface if closed.
     * Create datagram socket if not already available; can also be invoked by
     * either sender or receiver thread to ensure datagram socket is open.
     * Method was originally named start().
     */
    public void begin()
    {
        createDatagramSocket(); // common asset, synchronized to prevent interleaved reentry
        
        createThreads();
    }
    /**
     * Create datagram socket if not already available; can also be invoked by
     * either sender or receiver thread to ensure datagram socket is open.
     * Synchronized method to prevent interleaved reentry.
     * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html">Java Tutorials: Synchronized Methods</a>
     */
//    @SuppressWarnings("SleepWhileHoldingLock") // intentional
    private synchronized void createDatagramSocket()
    {
        // The capacity could go up to MAX_DIS_PDU_SIZE, but this should be good for now
        baos   = new ByteArrayOutputStream(MAX_TRANSMISSION_UNIT_SIZE);
        dos    = new DataOutputStream(baos);
        packet = new DatagramPacket(baos.toByteArray(), baos.size(), inetSocket);
        
        String message = TRACE_PREFIX;
        
        if ((datagramSocket != null))
        {
            if (datagramSocket.isConnected())
            {
                System.out.println(message + "datagramSocket is already connected...");
            }
            else if (datagramSocket.isClosed())
            {
                datagramSocket = null;
                System.err.println(" *** " + TRACE_PREFIX + "datagramSocket was previously used but closed, resetting...");
            }
        }
        if (datagramSocket == null) // may have just been reset
        {
            try
            {
//              System.out.println(message + "datagramSocket is getting connected...");
                // The initial value of the SO_BROADCAST socket option is FALSE
                datagramSocket = new MulticastSocket(getPort());
                datagramSocket.setSoTimeout(1000); // msec timeout on reading and then continue looping in order to avoid blocking
                
                ((MulticastSocket) datagramSocket).joinGroup(inetSocket, networkInterface);
                
                Thread.sleep (100L); // allow threads, streams to catch up
            } 
            catch (InterruptedException ex)
            {
                System.err.println(" *** " + TRACE_PREFIX + "InterruptedException in DisThreadedNetworkInterface createDatagramSocket(): " + ex.getLocalizedMessage());
            } 
            catch (IOException ex)
            {
                System.err.println(" *** " + TRACE_PREFIX + "IOException in DisThreadedNetworkInterface createDatagramSocket(): " + ex.getLocalizedMessage());
            }
        }
        if (hasVerboseOutput())
        {
//                    if (hasVerboseOutputIncludesTimestamp())
//                        message += " (timestamp " + getTimestamp()); // TODO
            message += "datagramSocket.joinGroup  address=" + inetSocket.getHostString() + " port=" + inetSocket.getPort() +
                       " isConnected()=" + datagramSocket.isConnected() + " createDatagramSocket() complete.";
            System.out.println(message);
            System.out.flush();
        }
    }
  
    @SuppressWarnings("SleepWhileInLoop") // intentional
    private Runnable receiveThreadRunnable = () -> {

        int pduReceiptCounter = 0;

        // The capacity could go up to MAX_DIS_PDU_SIZE, but this should be good for now
        // The raw listeners will strip off any extra padding and process what is required
        ByteBuffer byteBuffer = ByteBuffer.allocate(MAX_TRANSMISSION_UNIT_SIZE);
        DatagramPacket receivedPacket = new DatagramPacket(byteBuffer.array(), byteBuffer.capacity());

        while (!killed && !Thread.currentThread().isInterrupted()) // loop until terminated
        {
            try
            {
                datagramSocket.receive(receivedPacket); // blocks here waiting for next DIS pdu to be received on multicast IP and specified port
                toRawListeners(receivedPacket.getData(), receivedPacket.getLength());

                Pdu nextPdu = pduFactory.createPdu(byteBuffer);

                if (nextPdu != null)
                {
                    pduReceiptCounter++; // TODO experimental, add to generator as a commented-out diagnostic; consider adding diagnostic mode
                    if (hasVerboseOutput() && hasVerboseReceipt())
                    {
                        String pad = "";
                        if (pduReceiptCounter < 10)
                               pad = " ";
                        String message = TRACE_PREFIX + "[receipt " + pad + pduReceiptCounter + "] " + nextPdu.getPduType().toString();
                        if (hasVerboseOutputIncludesTimestamp())
                            message += " (timestamp " + DisTime.timeStampToString(nextPdu.getTimestamp());
                        if (nextPdu.getPduType() == DisPduType.ENTITY_STATE)
                            message += " " + String.format("%11s", ((EntityStatePdu)nextPdu).getMarkingString());
                        message += ", size " + nextPdu.getMarshalledSize() + " bytes)";
                        System.err.flush();
                        System.out.println(message);
                        System.out.flush();
                    }
                    toListeners(nextPdu);
                }
                byteBuffer.clear();
            }
            catch (IOException ex)
            {
                // read commonly times out while waiting for PDUs to arrive, and so this trace statement is for debugging
//              System.err.println(TRACE_PREFIX + "Exception in DisThreadedNetworkInterface receiveThread: " + ex.getLocalizedMessage());
            } 
        }
        // returning kills thread, do not put any other steps here
    };

    private final Runnable sendingThreadRunnable = () -> {

        int pduSentCounter = 0;

        // The capacity could go up to MAX_DIS_PDU_SIZE, but this should be good for now
        baos   = new ByteArrayOutputStream(MAX_TRANSMISSION_UNIT_SIZE);
        dos    = new DataOutputStream(baos);
        packet = new DatagramPacket(baos.toByteArray(), baos.size(), inetSocket);

        while (!killed && !Thread.currentThread().isInterrupted()) // loop until terminated
        {
            try
            {
                Pdu nextPdu = pdus2send.take();

                nextPdu.marshal(dos);
                packet.setData(baos.toByteArray());
                datagramSocket.send(packet);
                pduSentCounter++;

                if (hasVerboseOutput() && hasVerboseSending())
                {
                    String pad = "";
                    if (pduSentCounter < 10)
                           pad = " ";
                    String message = TRACE_PREFIX + "[sending " + pad + pduSentCounter + "] " + nextPdu.getPduType().toString();
                    if (hasVerboseOutputIncludesTimestamp())
                        message += " (timestamp " + DisTime.timeStampToString(nextPdu.getTimestamp());
                    if (nextPdu.getPduType() == DisPduType.ENTITY_STATE)
                        message += " " + String.format("%11s", ((EntityStatePdu)nextPdu).getMarkingString());
                    message += ", size " + nextPdu.getMarshalledSize() + " bytes)";
                    System.err.flush();
                    System.out.println(message);
                    System.out.flush();
                }
                dos.flush();  // immediately force pdu write
                baos.reset(); // prepare for next send
            }
            catch (InterruptedException ex)
            {
                // no response, expected termination
            }
            catch (Exception ex)
            {
                System.err.println(TRACE_PREFIX + "Exception in DisThreadedNetworkInterface sendingThread: " + ex.getLocalizedMessage());
                ex.printStackTrace();
            }
        }
        // returning kills thread, do not put any other steps here
    };

    private void toListeners(Pdu pdu) 
    {
        if (everyTypeListeners.isEmpty()) {
            return;
        }

        if (pdu != null) {
            everyTypeListeners.forEach(lis -> lis.incomingPdu(pdu));

            if (typeListeners.isEmpty()) {
                return;
            }

            List<PduListener> arLis = typeListeners.get(pdu.getPduType());
            if (arLis != null) {
                arLis.forEach(lis -> lis.incomingPdu(pdu));
            }
        }
    }
  
    private void toRawListeners(byte[] data, int len)
    {
      if(rawListeners.isEmpty())
        return;

      ByteArrayBufferAndLength bl = new ByteArrayBufferAndLength(data, len);
      rawListeners.forEach(lis->lis.incomingPdu(bl));
    }

    /** Method renamed as <code>close()</code> so use that method instead.
     */
    @Deprecated
    public void kill()
    {
      setKillSentinelAndInterrupts(); 
    }

    /** Tell sendingThread and receiveThread to stop. */
    public void setKillSentinelAndInterrupts() // TODO rename AndInterrupts
    {
      killed = true; // set loop sentinel for threads to finish
      
      // https://stackoverflow.com/questions/26647840/how-do-i-interrupt-kill-a-hung-thread-in-java
      sendingThread.interrupt();
      receiveThread.interrupt();
      System.out.println ("*** setKillSentinelAndInterrupts() killed=" + killed + 
                    " sendingThread.isInterrupted()=" + sendingThread.isInterrupted() + 
                    " receiveThread.isInterrupted()=" + receiveThread.isInterrupted());
    }

    /** Terminate the instance after completion of pending send/receive activity.
     * Synchronized to prevent interleaved invocation. */
    public synchronized void close()
    {
        try 
        {
            if (!killed)
            {
                setKillSentinelAndInterrupts(); // killed = true;
                Thread.sleep(100l); // let sendingThread and receiveThread stop
            }
            pdus2send.clear(); // all stop
             dos.flush();      // immediately force pdu write, if any remain
            baos.close();
             dos.close();
            System.out.println ("*** DisThreadedNetworkInterface close():" + 
                    " pdus2send.size()=" + pdus2send.size() +
                    " baos.size()=" + baos.size() + " dos.size()=" + dos.size());
             
            // now close socket (after killing threads so that hopefully the socket doesn't lock them)
            if (datagramSocket != null && !datagramSocket.isClosed())
            {
                try {
                    ((MulticastSocket)datagramSocket).leaveGroup(inetSocket, networkInterface);
                } catch (IOException ex) {
                    Logger.getLogger(DisThreadedNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                datagramSocket.close();
                sleep(100l); // TODO needed?

                if (hasVerboseOutput())
                {
                    String message = TRACE_PREFIX;
        //                    if (hasVerboseOutputIncludesTimestamp())
        //                        message += " (timestamp " + getTimestamp()); // TODO
                    message += "datagramSocket.leaveGroup address=" + getAddress() + " port=" + getPort() + 
                               " isClosed()=" + datagramSocket.isClosed() + " close() complete.";
                    System.out.println(message);
                    System.out.flush();
                }
            }
            killThread (sendingThread); // making sure
            killThread (receiveThread); // making sure
            Thread.sleep(500l);
            reportThreadStatus();
        }
        catch (Exception e)
        {
            System.err.println ("*** DisThreadedNetworkInterface close()() unexpected exception!");
        }
    }
    public void killThread(Thread threadToKill)
    {
            try { // join and kill threadToKill
                if (threadToKill != null)
                {
                    threadToKill.interrupt();
                    threadToKill.join(4000); // wait for thread to die, msec max duration
                    Thread.sleep(100l);
                }
            }
            catch (InterruptedException ie)
            {
                System.err.println ("*** DisThreadedNetworkInterface threadToKill join() failed to wait for threadToKill to die");
                System.err.flush();
                ie.printStackTrace(System.err);
            }
            
        String   threadAlive = "null";
        if (threadToKill != null)
            threadAlive =   String.valueOf(threadToKill.isAlive());
        System.out.println ("*** killThread() status: " + threadToKill.getName() + ".isAlive()=" + threadAlive +
                                " " + threadToKill.getName() + ".isInterrupted()=" + threadToKill.isInterrupted());
        System.err.flush(); // ensure all output sent
        System.out.flush(); // ensure all output sent
    }
    
    /** Report whether sendingThread and receiveThread are alive */
    public void reportThreadStatus()
    {
        // report if successful
        String sendingThreadAlive = "null";
        String receiveThreadAlive = "null";
        if (sendingThread != null)
            sendingThreadAlive =   String.valueOf(  sendingThread.isAlive());
        if (receiveThread != null)
            receiveThreadAlive = String.valueOf(receiveThread.isAlive());
        System.out.println ("*** Thread close status: sendingThread.isAlive()=" + sendingThreadAlive +
                                                    " receiveThread.isAlive()=" + receiveThreadAlive);
        System.err.flush(); // ensure all output sent
        System.out.flush(); // ensure all output sent
    }

  /** Thread sleep for indicated interval
   * @param duration milliseconds */
  private void sleep(long duration)
  {
    try {
      Thread.sleep(duration);
    }
    catch (InterruptedException ie) 
    {
        System.err.println ("*** " + getClass().getName() + ".sleep(" + duration + ") failed to sleep");
        System.err.flush();
        ie.printStackTrace(System.err);
    }
  }

    /**
     * Find proper IPV4 interface on this computer for use with the djs address
     *
     * @return a network interface to use to join a multicast group
     */
    public static NetworkInterface findIpv4Interface() 
    {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces != null && networkInterfaces.hasMoreElements())
            {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                if (networkInterface.isUp())
                {
                    // now check available addresses available on this running interface
                    Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                    while (addresses.hasMoreElements())
                    {
                        InetAddress nextAddress = addresses.nextElement();
                        if (nextAddress instanceof Inet4Address && !nextAddress.isLoopbackAddress() && !nextAddress.isLinkLocalAddress()) 
                        {
                            // can't use object descriptor in static context
                            System.out.println("[" + DisThreadedNetworkInterface.class.getSimpleName() + "] " + "using network interface " + networkInterface.getDisplayName());
                            return networkInterface;
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(DisThreadedNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Set whether or not trace statements are provided when packets are sent or received.
     * @param newValue the verbose status to set.  Also resets verboseReceipt and verboseSending to match.
     * @see verboseReceipt
     * @see verboseSending
     */
    public void setVerbose(boolean newValue)
    {
        this.verbose        = newValue;
        this.verboseReceipt = newValue;
        this.verboseSending = newValue;
    }
    /**
     * Whether or not trace statements are provided when packets are sent or received.
     * @return the verbose status
     * @see verboseReceipt
     * @see verboseSending
     */
    public boolean hasVerboseOutput()
    {
        return verbose;
    }
    /**
     * Set whether or not trace statements are provided when packets are received.
     * @param newValue the verboseReceipt status to set
     * @see verbose
     * @see verboseSending
     */
    public void setVerboseReceipt(boolean newValue)
    {
        this.verboseReceipt = newValue;
        verbose = (verboseReceipt || verboseSending);
    }
    /**
     * Whether or not trace statements are provided when packets are received.
     * @return the verboseReceipt status
     */
    public boolean hasVerboseReceipt()
    {
        return verboseReceipt;
    }

    /**
     * Set whether or not trace statements are provided when packets are sent.
     * @param newValue the verboseSending status to set
     * @see verbose
     * @see verboseReceipt
     */
    public void setVerboseSending(boolean newValue)
    {
        this.verboseSending = newValue;
        verbose = (verboseReceipt || verboseSending);
    }
    /**
     * Whether or not trace statements are provided when packets are sent.
     * @return the verboseSending status
     */
    public boolean hasVerboseSending()
    {
        return verboseSending;
    }

    /**
     * Whether or not trace statements include timestamp values.
     * @return the verboseIncludesTimestamp value
     */
    public boolean hasVerboseOutputIncludesTimestamp()
    {
        return verboseIncludesTimestamp;
    }

    /**
     * Set whether or not trace statements include timestamp values.
     * @param verboseIncludesTimestamp the value to set
     */
    public void setVerboseIncludesTimestamp(boolean verboseIncludesTimestamp)
    {
        this.verboseIncludesTimestamp = verboseIncludesTimestamp;
    }

    /** Method renamed as <code>getPort()</code> so use that method instead.
     * @return current port value
     */
    @Deprecated
    public int getDisPort()
    {
        return getPort();
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
    }
    /**
     * Get simple descriptor (such as parent class name) for this network interface, used in trace statements
     * @return simple descriptor name
     */
    public String getDescriptor() 
    {
        return descriptor;
    }

    /**
     * Set new simple descriptor (such as parent class name) for this network interface, used in trace statements
     * @param newDescriptor simple descriptor name for this interface
     */
    public void setDescriptor(String newDescriptor) 
    {
        this.descriptor = newDescriptor;
        TRACE_PREFIX = "[" + (DisThreadedNetworkInterface.class.getSimpleName() + " " + descriptor).trim() + "] ";
    }
    
    /**
     * Main method for testing.
     * @see <a href="https://docs.oracle.com/javase/tutorial/getStarted/application/index.html">Java Tutorials: A Closer Look at the "Hello World!" Application</a>
     * @param args [address, port, descriptor] command-line arguments are an array of optional String parameters that are passed from execution environment during invocation
     */
    public static void main(String[] args)
    {
        DisThreadedNetworkInterface disThreadedNetworkInterface;
          
        System.out.println("*** DisThreadedNetworkInterface main() self test started...");
        
        String selfTestDescriptor = "main() self test";
        if ((args != null) && args.length == 3)
             selfTestDescriptor = args[2];
        if ((args == null) || (args.length == 0))
             disThreadedNetworkInterface = new DisThreadedNetworkInterface( /* default address, port */ selfTestDescriptor);
        else disThreadedNetworkInterface = new DisThreadedNetworkInterface(args[0], Integer.parseInt(args[1]), selfTestDescriptor);
        
        System.out.println("*** DisThreadedNetworkInterface main() self test initialized...");
        
        try
        {
            EntityStatePdu espdu = new EntityStatePdu();
            espdu.setMarking("self test");
            disThreadedNetworkInterface.setVerbose(true);
            DisThreadedNetworkInterface.PduListener pduListener;
            pduListener = new DisThreadedNetworkInterface.PduListener()
            {
                /** Callback handler for listener */
                @Override
                public void incomingPdu(Pdu newPdu)
                {
                    System.out.println( "received newPdu " + newPdu.getPduType().toString());
                    System.out.flush();
                }
            };
            disThreadedNetworkInterface.addListener(pduListener);

            System.out.println("*** DisThreadedNetworkInterface main() self test sending espdu...");
            disThreadedNetworkInterface.send(espdu);
            // briefly wait get response from threaded receiver
            Thread.sleep(500L);
            System.out.flush();
            System.err.flush();
            // all done, close() in finally block
        }
        catch(InterruptedException ex)
        {
            System.out.println("*** DisThreadedNetworkInterface main() self test InterruptedException " + ex.getMessage());
        }
        finally // clean up following regular completion and any interruptions
            
        {
            if (disThreadedNetworkInterface != null)
                disThreadedNetworkInterface.close();

            System.out.flush();
            System.err.flush();
            System.out.println("*** DisThreadedNetworkInterface main() self test complete.");
        }
    }
}
