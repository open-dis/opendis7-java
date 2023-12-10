/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD-style open-source license, see project
 * <a href="https://savage.nps.edu/opendis7-java/license.html" target="_blank">license.html</a> and <a href="https://savage.nps.edu/opendis7-java/license.txt" target="_blank">license.txt</a>
 */
package edu.nps.moves.dis7.utilities;

import edu.nps.moves.dis7.enumerations.DisPduType;
import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.Pdu;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a thread-safe, multicast DIS network interface class which greatly simplifies reading and writing of PDUs for applications.
 * This simplifies and consolidates all reading, writing and threading of DIS over the network.
 *
 * Example <code>main()</code> self-test response shown in log file.
 * @see <a href="https://github.com/open-dis/open-dis7-java/blob/master/src/edu/nps/moves/dis7/utilities/DisThreadedNetworkInterfaceSelfTestLog.txt">https://github.com/open-dis/open-dis7-java/blob/master/src/edu/nps/moves/dis7/utilities/DisThreadedNetworkInterfaceSelfTestLog.txt</a>
 *
 * @author Don Brutzman, brutzman@nps.edu
 * @author Mike Bailey, jmbailey@nps.edu
 * @since Jul 29, 2019
 */
public class DisThreadedNetworkInterface
{
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

    /** Default socket port  <code>3000</code>, matches Wireshark DIS capture default
     * @see <a href="https://en.wikipedia.org/wiki/Port_(computer_networking)">https://en.wikipedia.org/wiki/Port_(computer_networking)</a> 
     */
    public static final int DEFAULT_DIS_PORT = 3000;

    /** *  Default multicast group address <code>239.1.2.3</code> for sendPDU and receive connections.
     * @see <a href="https://en.wikipedia.org/wiki/Multicast_address">https://en.wikipedia.org/wiki/Multicast_address</a>  
     */
    public static final String DEFAULT_DIS_ADDRESS = "239.1.2.3";

    private static String  descriptor;
    private static boolean verbose         = true;
    private static boolean verboseReceipt  = true;
    private static boolean verboseSending  = true;
    private static boolean verboseIncludesTimestamp = false;

    // independently available parameters for each DisThreadedNetworkInterface object
    private String  disAddress;
    private String  TRACE_PREFIX;
    private int     disPort;
    private boolean killed; // thread loop sentinel

    private InetAddress       inetAddress;
    private InetSocketAddress inetSocket;
    private NetworkInterface  networkInterface;
    private DatagramSocket    datagramSocket;

    /* *********** queues and lists and public methods ************** */
    private final List<PduListener>                  everyTypeListeners = new ArrayList<>();
    private final Map<DisPduType, List<PduListener>> typeListeners      = new HashMap<>();
    private final List<RawPduListener>               rawListeners       = new ArrayList<>();
    
    // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/LinkedBlockingQueue.html
    private final LinkedBlockingQueue<Pdu>           pdus2send = new LinkedBlockingQueue<>(); // FIFO
    
    private DisThreadedNetworkInterface.PduListener pduListenerSelfTest;

    DatagramPacket packet;

    /**
     * Pdu listener interface is an internal class.
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
     * Raw pdu listener interface is an internal class.
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

    /** Default constructor using default multicast address and port, no descriptor */
    public DisThreadedNetworkInterface()
    {
        this(DEFAULT_DIS_ADDRESS, DEFAULT_DIS_PORT, "", verbose);
    }

    /**
     * Object constructor with descriptor, using default multicast address and port
     * @param newDescriptor simple descriptor name for this interface
     */
    public DisThreadedNetworkInterface(String newDescriptor)
    {
        this(DEFAULT_DIS_ADDRESS, DEFAULT_DIS_PORT, newDescriptor, verbose);
    }

    /**
     * Object constructor with verboseness initialization, using default multicast address and port
     * @param defaultVerbose whether or not DisThreadedNetworkInterface is verbose
     */
    public DisThreadedNetworkInterface(boolean defaultVerbose)
    {
        this(DEFAULT_DIS_ADDRESS, DEFAULT_DIS_PORT, "", defaultVerbose);
    }

    /**
     * Object constructor using specified multicast address, port, descriptor, and verboseness
     * @param address the multicast group or unicast address to utilize
     * @param port the multicast port to utilize
     */
    public DisThreadedNetworkInterface(String address, int port)
    {
        this(address, port, "", verbose);
    }

    /**
     * Object constructor using specified multicast address and port, plus descriptor.
     * @param address the multicast group or unicast address to utilize
     * @param port the multicast port to utilize
     * @param newDescriptor simple descriptor name for this interface
     */
    public DisThreadedNetworkInterface(String address, int port, String newDescriptor)
    {
        this(address, port, newDescriptor, verbose); // no change in verbose
    }

    /**
     * Primary object constructor using specified multicast address and port, plus descriptor and verboseness.
     * @param address the multicast group or unicast address to utilize
     * @param port the multicast port to utilize
     * @param newDescriptor simple descriptor name for this interface
     * @param defaultVerbose whether or not DisThreadedNetworkInterface is verbose
     */
    public DisThreadedNetworkInterface(String address, int port, String newDescriptor, boolean defaultVerbose)
    {
        disAddress = address;
        disPort    = port;
        try
        {
            inetAddress = InetAddress.getByName(disAddress);
        }
        catch (UnknownHostException ex)
        {
            Logger.getLogger(DisThreadedNetworkInterface.class.getSimpleName()).log(Level.SEVERE, null, ex);
        }
        inetSocket = new InetSocketAddress(inetAddress, disPort); // tests that accessor methods are working as set
        networkInterface = findIpv4Interface();

        if (newDescriptor == null)
             descriptor = "";
        else descriptor = newDescriptor;
        verbose        = defaultVerbose;
        verboseReceipt = defaultVerbose;
        verboseSending = defaultVerbose;
        
        initializeListeners();
        killed = false;
        TRACE_PREFIX = "[" + (DisThreadedNetworkInterface.class.getSimpleName() + " " + descriptor).trim() + "] ";

        begin();
    }
    private void initializeListeners()
    {
        everyTypeListeners.clear();
             typeListeners.clear();
             rawListeners.clear();
    }

    /**
     * Add a listener to accept only pdus of a given type
     * @param newListener listener instance implementing the RawPduListener interface
     * @param disPduType Pdu type
     */
    public synchronized void addListener(PduListener newListener, DisPduType disPduType)
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
    public synchronized void addListener(PduListener newListener)
    {
        everyTypeListeners.add(newListener);
    }

    /**
     * Remove previously added listener
     *
     * @param priorListener listener instance implementing the RawPduListener interface
     */
    public synchronized void removeListener(PduListener priorListener)
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
        try {
            // additional sleep, hopefully allowing teardown to proceed to completion
            wait(100l); // TODO needed?
        } catch (InterruptedException ex) {
            Logger.getLogger(DisThreadedNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Add a listener to accept pdus of all types in the form of a byte array
     *
     * @param rawPduListener listener instance implementing the RawPduListener interface
     */
    public synchronized void addRawListener(RawPduListener rawPduListener)
    {
        rawListeners.add(rawPduListener);
    }

    /**
     * Remove previously added raw listener
     *
     * @param rawPduListener listener instance implementing the RawPduListener interface
     */
    public synchronized void removeRawListener(RawPduListener rawPduListener)
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
     * Get current multicast (or unicast) network address for sendPDU and receive connections.
     * @see <a href="https://en.wikipedia.org/wiki/Multicast_address">https://en.wikipedia.org/wiki/Multicast_address</a>
     * @return current multicast address value
     */
    public String getAddress()
    {
        return this.disAddress;
    }
    /**
     * Network address for sendPDU and receive connections.
     * @see <a href="https://en.wikipedia.org/wiki/Multicast_address">https://en.wikipedia.org/wiki/Multicast_address</a>
     * @param newAddress the new network address to set
     */
    public synchronized void setAddress(String newAddress) {
        this.disAddress = newAddress;
    }

    /**
     * Send the given pdu to the network using the IP address and port given to the constructor
     * @param pdu the pdu to sendPDU
     */
    public synchronized void sendPDU(Pdu pdu)
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
        if (sendingThread == null)
        {
//          System.out.println(TRACE_PREFIX + "createThreads() start sendingThread...");
            sendingThread = new Thread(sendingThreadRunnable, "sendingThread");
            // https://stackoverflow.com/questions/2213340/what-is-a-daemon-thread-in-java
            sendingThread.setDaemon(false); // user thread, not system thread
            sendingThread.setPriority(Thread.NORM_PRIORITY);
            sendingThread.start();
        }
        if (hasVerboseSending())
            System.out.println(TRACE_PREFIX + "createThreads() sendingThread.isAlive()=" + sendingThread.isAlive());

        if (receiveThread == null)
        {
//          System.out.println(TRACE_PREFIX + "createThreads() start receiveThread...");
            receiveThread = new Thread(receiveThreadRunnable, "receiveThread");
            // https://stackoverflow.com/questions/2213340/what-is-a-daemon-thread-in-java
            receiveThread.setDaemon(false); // user thread, not system thread
            receiveThread.setPriority(Thread.NORM_PRIORITY);
            receiveThread.start();
        }
        if (hasVerboseReceipt())
            System.out.println(TRACE_PREFIX + "createThreads() receiveThread.isAlive()=" + receiveThread.isAlive());
    }
    /**
     * Can be used to restart DisThreadedNetworkInterface if closed.
     * Create datagram socket if not already available; can also be invoked by
     * either sender or receiver thread to ensure datagram socket is open.
     * Method was originally named start().
     */
    public synchronized final void begin()
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

                datagramSocket.joinGroup(inetSocket, networkInterface);

                // https://stackoverflow.com/questions/10663920/calling-thread-sleep-from-synchronized-context-in-java
                // https://stackoverflow.com/questions/1036754/difference-between-wait-vs-sleep-in-java
                wait (100L); // allow threads, streams to catch up // TODO consider wait() instead of sleep()
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
        if (hasVerboseSending())
        {
//                    if (hasVerboseOutputIncludesTimestamp())
//                        message += " (timestamp " + getTimestamp()); // TODO
            message += "datagramSocket.joinGroup  address=" + inetSocket.getHostString() + " port=" + inetSocket.getPort() +
                       " isConnected()=" + datagramSocket.isConnected() + " createDatagramSocket() complete.";
            if (verbose)
            {
                System.out.println(message);
                System.out.flush();
            }
        }
    }

    @SuppressWarnings("SleepWhileInLoop") // intentional
    private Runnable receiveThreadRunnable = () -> {

        int pduReceiptCounter = 0;

        // The capacity could go up to MAX_DIS_PDU_SIZE, but this should be good for now
        ByteBuffer bBuffer = ByteBuffer.allocate(MAX_TRANSMISSION_UNIT_SIZE);
        DatagramPacket receivedPacket = new DatagramPacket(bBuffer.array(), bBuffer.capacity());
        Pdu nextPdu;
        String pad, message;

        // https://stackoverflow.com/questions/26647840/how-do-i-interrupt-kill-a-hung-thread-in-java
        while (!killed && !Thread.currentThread().isInterrupted()) // loop until terminated
        {
            try
            {
                datagramSocket.receive(receivedPacket); // blocks here waiting for next DIS pdu to be received on multicast IP and specified port
                nextPdu = pduFactory.createPdu(bBuffer);
                toRawListeners(bBuffer.array(), nextPdu.getMarshalledSize()); // pass only the actual length of pdu data

                pduReceiptCounter++; // TODO experimental, add to generator as a commented-out diagnostic; consider adding diagnostic mode
                if (hasVerboseOutput() && hasVerboseReceipt())
                {
                    pad = "";
                    if (pduReceiptCounter < 10)
                        pad = " ";
                    message = TRACE_PREFIX + "[receipt " + pad + pduReceiptCounter + "] " + nextPdu.getPduType().toString();
                    if (hasVerboseOutputIncludesTimestamp())
                        message += " (timestamp " + DisTime.convertToString(nextPdu.getTimestamp());
                    if (nextPdu.getPduType() == DisPduType.ENTITY_STATE)
                        message += " " + String.format("%11s", ((EntityStatePdu)nextPdu).getMarkingString());
                    message += ", size " + nextPdu.getMarshalledSize() + " bytes)";
                    if (hasVerboseOutput())
                    {
                        System.err.flush();
                        System.out.println(message);
                        System.out.flush();
                    }
                }
                toListeners(nextPdu);
                bBuffer.clear();
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
        Pdu nextPdu;
        String pad, message;
        ByteBuffer bBuffer = ByteBuffer.allocate(MAX_TRANSMISSION_UNIT_SIZE);

        // Just get a packet instantiated here. Set the acutal length and data when we know the PDU size
        packet = new DatagramPacket(bBuffer.array(), bBuffer.capacity(), inetSocket);

        // https://stackoverflow.com/questions/26647840/how-do-i-interrupt-kill-a-hung-thread-in-java
        while (!killed && !Thread.currentThread().isInterrupted()) // loop until terminated
        {
            try
            {
                nextPdu = pdus2send.take();
                nextPdu.marshal(bBuffer);
                packet.setData(bBuffer.array());
                packet.setLength(nextPdu.getMarshalledSize()); // sendPDU only the pdu's data length
                datagramSocket.send(packet);
                pduSentCounter++;

                if (hasVerboseOutput() && hasVerboseSending())
                {
                    pad = "";
                    if (pduSentCounter < 10)
                           pad = " ";
                    message = TRACE_PREFIX + "[sending " + pad + pduSentCounter + "] " + nextPdu.getPduType().toString();
                    if (hasVerboseOutputIncludesTimestamp())
                        message += " (timestamp " + DisTime.convertToString(nextPdu.getTimestamp());
                    if (nextPdu.getPduType() == DisPduType.ENTITY_STATE)
                        message += " " + String.format("%11s", ((EntityStatePdu)nextPdu).getMarkingString());
                    message += ", size " + nextPdu.getMarshalledSize() + " bytes)";
                    if (hasVerboseOutput())
                    {
                        System.err.flush();
                        System.out.println(message);
                        System.out.flush();
                    }
                }
                bBuffer.clear();
            }
            catch (InterruptedException ex)
            {
                // no response, expected termination
            }
            catch (Exception ex)
            {
                System.err.println(TRACE_PREFIX + "Exception in DisThreadedNetworkInterface sendingThread: " + ex.getLocalizedMessage());
                ex.printStackTrace(System.err);
            }
        }
        // returning kills thread, do not put any other steps here
    };

    private synchronized void toListeners(Pdu pdu) {
        if (pdu != null) {
            everyTypeListeners.forEach(lis -> lis.incomingPdu(pdu));

            if (!typeListeners.isEmpty()) {

                List<PduListener> arLis = typeListeners.get(pdu.getPduType());
                if (arLis != null)
                    arLis.forEach(lis -> lis.incomingPdu(pdu));

            }
        }
    }

    private synchronized void toRawListeners(byte[] data, int len) {
        
        if (rawListeners.isEmpty())
            return;

        ByteArrayBufferAndLength bl = new ByteArrayBufferAndLength(data, len);
        rawListeners.forEach(lis -> lis.incomingPdu(bl));
    }

    /** Method renamed as <code>close()</code> so use that method instead.
     */
    @Deprecated
    public synchronized void kill()
    {
      setKillSentinelAndInterrupts();
    }

    /** Tell sendingThread and receiveThread to stop. */
    public synchronized void setKillSentinelAndInterrupts()
    {
        sleep(1000l); // finish sending, receiving
        System.out.flush();
        System.err.flush();
        killed = true; // set loop sentinel for threads to finish

        // https://stackoverflow.com/questions/26647840/how-do-i-interrupt-kill-a-hung-thread-in-java
        String sendingThreadInterruptStatus, receiveThreadInterruptStatus;
        if (sendingThread != null)
        {
            sendingThread.interrupt();
            sendingThreadInterruptStatus = String.valueOf(sendingThread.isInterrupted());
        }
        else sendingThreadInterruptStatus ="null";
        
        if (receiveThread != null)
        {
            receiveThread.interrupt();
            receiveThreadInterruptStatus = String.valueOf(receiveThread.isInterrupted());
        }
        else receiveThreadInterruptStatus ="null";

        if (hasVerboseOutput())
        {
            System.out.println ("*** setKillSentinelAndInterrupts() sentinel killed=" + killed +
                      " sendingThread.isInterrupted()=" + sendingThreadInterruptStatus +
                      " receiveThread.isInterrupted()=" + receiveThreadInterruptStatus);
            System.out.flush();
            System.err.flush();
        }
    }

    /** Terminate the instance after completion of pending send/receive activity.
     * Synchronized to prevent interleaved invocation. */
    public synchronized void close()
    {
        try
        {
            if (!killed) // avoid repeats
            {
                setKillSentinelAndInterrupts(); // killed = true;
                // https://stackoverflow.com/questions/10663920/calling-thread-sleep-from-synchronized-context-in-java
                // https://stackoverflow.com/questions/1036754/difference-between-wait-vs-sleep-in-java
                // let sendingThread and receiveThread stop
                wait(100l); // // allow extra time for shutdowns to occur before continuing
            }
            if (hasVerboseOutput())
            {
//                System.out.println (TRACE_PREFIX + "close():" +
//                    " pdus2send.size()=" + pdus2send.size() + " PDUs not being sent");
//                System.out.println (TRACE_PREFIX + "close():" +
//                    " everyTypeListeners.size()=" + everyTypeListeners.size());
//                System.out.println (TRACE_PREFIX + "close():" +
//                    "      typeListeners.size()=" + typeListeners.size());
//                System.out.println (TRACE_PREFIX + "close():" +
//                    "       rawListeners.size()=" + rawListeners.size());
            }
            pdus2send.clear(); // all stop

            // now close socket (after killing threads so that hopefully the socket doesn't lock them)
            if (datagramSocket != null && !datagramSocket.isClosed())
            {
                try {
                    datagramSocket.leaveGroup(inetSocket, networkInterface);
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
            // https://stackoverflow.com/questions/10663920/calling-thread-sleep-from-synchronized-context-in-java
            // https://stackoverflow.com/questions/1036754/difference-between-wait-vs-sleep-in-java
            wait(500l); // allow extra time for shutdowns to occur before continuing
            reportThreadStatus();
        }
        catch (InterruptedException e)
        {
            System.err.println (TRACE_PREFIX + "close()() unexpected exception! " + e.getMessage());
        }
    }
    /** Tell thread to stop.
     * @param threadToKill of interest */
    public synchronized void killThread(Thread threadToKill)
    {
        try { // join and kill threadToKill
            if (threadToKill != null)
            {
                threadToKill.interrupt();
                threadToKill.join(4000); // wait for thread to die, msec max duration
                // https://stackoverflow.com/questions/10663920/calling-thread-sleep-from-synchronized-context-in-java
                // https://stackoverflow.com/questions/1036754/difference-between-wait-vs-sleep-in-java
                wait(100l); // TODO consider wait() instead of sleep()
            }
        }
        catch (InterruptedException ie)
        {
            System.err.println (TRACE_PREFIX + "threadToKill join() failed to wait for threadToKill to die");
            System.err.flush();
            ie.printStackTrace(System.err);
        }

        String   threadAlive;
        if (threadToKill != null)
        {
            threadAlive =   String.valueOf(threadToKill.isAlive());
            if (hasVerboseOutput())
                System.out.println ("*** killThread() status: " + threadToKill.getName() + ".isAlive()=" + threadAlive +
                                    " " + threadToKill.getName() + ".isInterrupted()=" + threadToKill.isInterrupted());
        }
        System.err.flush(); // ensure all output sent
        System.out.flush(); // ensure all output sent
    }

    /** Report whether sendingThread and receiveThread are alive */
    public synchronized void reportThreadStatus()
    {
        // report if successful
        String sendingThreadAlive = "null";
        String receiveThreadAlive = "null";
        if (sendingThread != null)
            sendingThreadAlive =   String.valueOf(  sendingThread.isAlive());
        if (receiveThread != null)
            receiveThreadAlive = String.valueOf(receiveThread.isAlive());
       if (hasVerboseOutput())
       {
            System.out.println ("*** Thread close status: sendingThread.isAlive()=" + sendingThreadAlive +
                                                        " receiveThread.isAlive()=" + receiveThreadAlive);
       }
        System.err.flush(); // ensure all output sent
        System.out.flush(); // ensure all output sent
    }

  /** Thread sleep for indicated interval
   * @param duration milliseconds */
  private synchronized void sleep(long duration)
  {
    try {
        // https://stackoverflow.com/questions/10663920/calling-thread-sleep-from-synchronized-context-in-java
        // https://stackoverflow.com/questions/1036754/difference-between-wait-vs-sleep-in-java
        wait(duration); // TODO consider wait() instead of sleep()
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
            NetworkInterface networkInterface;
            Enumeration<InetAddress> addresses;
            InetAddress nextAddress;

            while (networkInterfaces != null && networkInterfaces.hasMoreElements())
            {
                networkInterface = networkInterfaces.nextElement();
                if (networkInterface.isUp())
                {
                    // now check available addresses available on this running interface
                    addresses = networkInterface.getInetAddresses();
                    while (addresses.hasMoreElements())
                    {
                        nextAddress = addresses.nextElement();
                        if (nextAddress instanceof Inet4Address && !nextAddress.isLoopbackAddress() && !nextAddress.isLinkLocalAddress())
                        {
                            // can't use object descriptor in static context
                            if (verboseSending)
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
     * Set whether or not trace statements are provided when packets are sent or received, including verboseReceipt and verboseSending.
     * @param newValue the verbose status to set.  Also resets verboseReceipt and verboseSending to match.
     * @see verboseReceipt
     * @see verboseSending
     */
    public synchronized void setVerbose(boolean newValue)
    {
        DisThreadedNetworkInterface.verbose        = newValue;
        DisThreadedNetworkInterface.verboseReceipt = newValue;
        DisThreadedNetworkInterface.verboseSending = newValue;
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
    public synchronized void setVerboseReceipt(boolean newValue)
    {
        DisThreadedNetworkInterface.verboseReceipt = newValue;
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
    public synchronized void setVerboseSending(boolean newValue)
    {
        DisThreadedNetworkInterface.verboseSending = newValue;
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
     * @param newVerboseIncludesTimestamp the value to set
     */
    public synchronized void setVerboseIncludesTimestamp(boolean newVerboseIncludesTimestamp)
    {
        DisThreadedNetworkInterface.verboseIncludesTimestamp = newVerboseIncludesTimestamp;
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
    public synchronized void setPort(int newPortValue)
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
    public synchronized void setDescriptor(String newDescriptor)
    {
        if (newDescriptor != null)
            DisThreadedNetworkInterface.descriptor = newDescriptor.trim();
        TRACE_PREFIX = "[" + DisThreadedNetworkInterface.class.getSimpleName() + " " + descriptor + "] ";
    }
            
    /** Self test to check basic operation, invoked by main().
     *  Warning, VPN can block receipt of PDUs!
     *  Also be careful when debugging since debug mode can interrupt otherwise-optimized threading operations.
     */
    @SuppressWarnings("Convert2Lambda")
    private synchronized void selfTest()
    {
        System.out.println(TRACE_PREFIX + "main() self test initialized... ");
        try
        {
            EntityStatePdu espdu = pduFactory.makeEntityStatePdu();
            setVerbose(true);
            System.out.println(TRACE_PREFIX + "hasVerboseSending()=" + hasVerboseSending() + ", " +
                                              "hasVerboseReceipt()=" + hasVerboseReceipt());
            pduListenerSelfTest = new DisThreadedNetworkInterface.PduListener() // avoid Convert2Lambda editor warning
            {
                /** Callback handler for listener */
                @Override
                public synchronized void incomingPdu(Pdu newPdu)
                {
                    System.out.println(TRACE_PREFIX + "main() pduListener.incomingPdu() received newPdu " + newPdu.getPduType().toString());
                    System.out.flush();
                }
            };
            addListener(pduListenerSelfTest);

            // TODO reported send/received marking results not synchronized in DisThreadedNetworkInterfaceSelfTestLog.txt ??
            espdu.setMarking("self test 1");
            System.out.println(TRACE_PREFIX + "self test sending espdu with marking '" + espdu.getMarkingString()+ "' ...");
            sendPDU(espdu);
            espdu.setMarking("self test 2");
            System.out.println(TRACE_PREFIX + "self test sending espdu with marking '" + espdu.getMarkingString() + "' ...");
            sendPDU(espdu);
            espdu.setMarking("self test 3");
            System.out.println(TRACE_PREFIX + "self test sending espdu with marking '" + espdu.getMarkingString() + "' ...");
            sendPDU(espdu);

            // https://stackoverflow.com/questions/10663920/calling-thread-sleep-from-synchronized-context-in-java
            // https://stackoverflow.com/questions/1036754/difference-between-wait-vs-sleep-in-java
            // this test is short, must briefly wait to get synchronized with threaded sender and receiver
            wait(500L); // consider wait() instead of sleep()
            System.out.flush();
            System.err.flush();
            // all done, close() in finally block
        }
        catch(InterruptedException ex)
        {
            System.out.println("[DisThreadedNetworkInterface] main() self test InterruptedException " + ex.getMessage());
        }
        finally // carefully clean up following regular completion and any interruptions
        {
            close();

            System.out.flush();
            System.err.flush();
            System.out.println("[DisThreadedNetworkInterface] main() self test complete.");
        }
    }

    /**
     * Main method provides support for testing.
     * @see <a href="https://docs.oracle.com/javase/tutorial/getStarted/application/index.html">Java Tutorials: A Closer Look at the "Hello World!" Application</a>
     * @param args [address, port, descriptor] command-line arguments are an array of optional String parameters that are passed from execution environment during invocation
     */
    public static void main(String[] args)
    {
        System.out.println("[DisThreadedNetworkInterface] main() started...");

        DisThreadedNetworkInterface disThreadedNetworkInterface;

        String selfTestDescriptor = "main() self test";
        if ((args != null) && args.length == 3)
             selfTestDescriptor = args[2];
        if ((args == null) || (args.length == 0))
             disThreadedNetworkInterface = new DisThreadedNetworkInterface( /* default address, port */ selfTestDescriptor);
        else disThreadedNetworkInterface = new DisThreadedNetworkInterface(args[0], Integer.parseInt(args[1]), selfTestDescriptor);

        disThreadedNetworkInterface.selfTest();
    }
}
