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
        
        start();
    }

    /* *********** queues and lists  and public methods ************** */
    private final List<PduListener> everyTypeListeners = new ArrayList<>();
    private final Map<DisPduType, List<PduListener>> typeListeners = new HashMap<>();
    private final List<RawPduListener> rawListeners = new ArrayList<>();
    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/LinkedBlockingQueue.html
    private final LinkedBlockingQueue<Pdu> pdus2sendLinkedBlockingQueue = new LinkedBlockingQueue<>(); // FIFO
    
    /**
     * Main method for testing.
     * @see <a href="https://docs.oracle.com/javase/tutorial/getStarted/application/index.html">Java Tutorials: A Closer Look at the "Hello World!" Application</a>
     * @param args [address, port, descriptor] command-line arguments are an array of optional String parameters that are passed from execution environment during invocation
     */
    public static void main(String[] args)
    {
        System.out.println("*** DisThreadedNetworkInterface main() test started...");
        
        DisThreadedNetworkInterface disThreadedNetworkInterface;
        String selfTestDescriptor = "DisThreadedNetworkInterface main() self test";
        if (args.length == 3)
            selfTestDescriptor = args[2];
        if ((args == null) || (args.length == 0))
             disThreadedNetworkInterface = new DisThreadedNetworkInterface( /* default address, port */ selfTestDescriptor);
        else disThreadedNetworkInterface = new DisThreadedNetworkInterface(args[0], Integer.parseInt(args[1]), selfTestDescriptor);
        
        System.out.println("*** DisThreadedNetworkInterface main() self test created instance.");
        
        disThreadedNetworkInterface.close();
        
        System.out.flush();
        System.err.flush();
        System.out.println("*** DisThreadedNetworkInterface main() self test complete.");
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
     * @param lis listener instance implementing the RawPduListener interface
     */
    public void addRawListener(RawPduListener lis)
    {
        rawListeners.add(lis);
    }

    /**
     * Remove previously added raw listener
     *
     * @param lis listener instance implementing the RawPduListener interface
     */
    public void removeRawListener(RawPduListener lis)
    {
        rawListeners.remove(lis);
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
        pdus2sendLinkedBlockingQueue.add(pdu);
    }

    /* *************** networking i/o ************* */
    private PduFactory pduFactory = new PduFactory();

    private Thread   senderThread;
    private Thread receiverThread;

    /** Initialization of threads, or confirmation that they remain running */
    private synchronized void initializeSocketSenderReceiverThreads()
    {
        if (receiverThread == null)
        {
            receiverThread = new Thread(receiverThreadRunnable, TRACE_PREFIX + "receiverThread");
            // https://stackoverflow.com/questions/2213340/what-is-a-daemon-thread-in-java
            receiverThread.setDaemon(false); // user thread, not system thread
            receiverThread.setPriority(Thread.NORM_PRIORITY);
            receiverThread.start();
        }

        if (senderThread == null)
        {
            senderThread = new Thread(senderThreadRunnable, TRACE_PREFIX + "senderThread");
            // https://stackoverflow.com/questions/2213340/what-is-a-daemon-thread-in-java
            senderThread.setDaemon(false); // user thread, not system thread
            senderThread.setPriority(Thread.NORM_PRIORITY);
            senderThread.start();
        }
    }
    /**
     * Can be used to restart DisThreadedNetworkInterface if closed.
     * Create datagram socket if not already available; can also be invoked by
     * either sender or receiver thread to ensure datagram socket is open.
     */
    public void start() // TODO rename begin()
    {
        createDatagramSocket(); // common asset, synchronized to prevent interleaved reentry
        
        initializeSocketSenderReceiverThreads();
    }
    /**
     * Create datagram socket if not already available; can also be invoked by
     * either sender or receiver thread to ensure datagram socket is open.
     * Synchronized method to prevent interleaved reentry.
     * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html">Java Tutorials: Synchronized Methods</a>
     */
    @SuppressWarnings("SleepWhileHoldingLock") // intentional
    private synchronized void createDatagramSocket()
    {
        boolean closedSocket = false;
        if ((datagramSocket != null))
        {
            if (datagramSocket.isClosed())
            {
                closedSocket   = true;
                datagramSocket = null;
                System.err.println(" *** " + TRACE_PREFIX + "datagramSocket was available but closed before createDatagramSocket(), resetting...");
            }
        }
        if ((datagramSocket == null) || closedSocket)
        {
            try
            {
                // The initial value of the SO_BROADCAST socket option is FALSE
                datagramSocket = new MulticastSocket(getPort());
                datagramSocket.setSoTimeout(1000); // msec timeout on reading and then continue looping in order to avoid blocking
                
                ((MulticastSocket) datagramSocket).joinGroup(inetSocket, networkInterface);
                
                if (hasVerboseOutput())
                {
                    String message = TRACE_PREFIX;
//                    if (hasVerboseOutputIncludesTimestamp())
//                        message += " (timestamp " + getTimestamp()); // TODO
                    message += "datagramSocket.joinGroup  address=" + inetSocket.getHostString() + " port=" + inetSocket.getPort() + " start() complete";
                    System.out.println(message);
                    System.out.flush();
                }
                Thread.sleep (100L); // allow threads, streams to catch up
            } 
            catch (InterruptedException ex) {
                // continue
            } 
            catch (IOException ex)
            {
                System.err.println(" *** " + TRACE_PREFIX + "Exception in DisThreadedNetworkInterface createDatagramSocket(): " + ex.getLocalizedMessage());
            }
        }
    }
  
    @SuppressWarnings("SleepWhileInLoop") // intentional
    private Runnable receiverThreadRunnable = () -> {

        int pduReceiptCounter = 0;

        // The capacity could go up to MAX_DIS_PDU_SIZE, but this should be good for now
        // The raw listeners will strip off any extra padding and process what is required
        ByteBuffer byteBuffer = ByteBuffer.allocate(MAX_TRANSMISSION_UNIT_SIZE);
        DatagramPacket packet = new DatagramPacket(byteBuffer.array(), byteBuffer.capacity());

        while (!killed) // keep trying even if error occurred
        {
            try
            {
                while (!killed) // loop until terminated
                {
                    datagramSocket.receive(packet); // blocks here waiting for next DIS pdu to be received on multicast IP and specified port
                    toRawListeners(packet.getData(), packet.getLength());

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
                Thread.sleep (100L); // loop successfully killed
            } 
            catch (InterruptedException ex) {
                // continue
            } 
            catch (IOException ex)
            {
                // read commonly times out while waiting for PDUs to arrive, and so this trace statement is for debugging
//              System.err.println(TRACE_PREFIX + "Exception in DisThreadedNetworkInterface receiverThread: " + ex.getLocalizedMessage());
            } 
        }
        // returning kills thread, do not put any other steps here
    };

    private final Runnable senderThreadRunnable = () -> {

        int pduSentCounter = 0;

        // The capacity could go up to MAX_DIS_PDU_SIZE, but this should be good for now
        ByteArrayOutputStream baos   = new ByteArrayOutputStream(MAX_TRANSMISSION_UNIT_SIZE);
        DataOutputStream      dos    = new DataOutputStream(baos);
        DatagramPacket        packet = new DatagramPacket(baos.toByteArray(), baos.size(), inetSocket);

        while (!killed) // keep trying even if error occurred 
        {
            try
            {
                while (!killed) // loop until terminated
                {
                    Pdu nextPdu = pdus2sendLinkedBlockingQueue.take();

                    nextPdu.marshal(dos);
                    packet.setData(baos.toByteArray());
                    datagramSocket.send(packet);
                    
                    pduSentCounter++; // TODO experimental, add to generator as a commented-out diagnostic; consider adding diagnostic mode
                    if (hasVerboseOutput() && hasVerboseSending())
                    {
                        String pad = "";
                        if (pduSentCounter < 10)
                               pad = " ";
                        String message = TRACE_PREFIX + "[sending " + pad + pduSentCounter + "] " + nextPdu.getPduType().toString();
                        if (hasVerboseOutputIncludesTimestamp())
                            message += " (timestamp " + DisTime.timeStampToString(nextPdu.getTimestamp());
                        message += ", size " + nextPdu.getMarshalledSize() + " bytes)";
                        System.err.flush();
                        System.out.println(message);
                        System.out.flush();
                    }
                    dos.flush();  // immediately force pdu write
                    baos.reset(); // prepare for next send
                }
                if (killed) // operations are finished
                {
                    // check if looping complete, cleanup here to ensure thread exit is clean
                    baos.close();
                    dos.close();
                    System.out.println("*** DisThreadedNetworkInterface senderThreadRunnable killed=true, close ByteArrayOutputStream baos and DataOutputStream dos\n");
                }
            }
            catch (Exception ex)
            {
                System.err.println(TRACE_PREFIX + "Exception in DisThreadedNetworkInterface senderThread: " + ex.getLocalizedMessage());
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
      setKillSentinel(); 
    }

    /** Finish pending send/receive activity and then close. */
    public void setKillSentinel()
    {
      killed = true; // set loop sentinel for threads to finish
    }

    /** Terminate the instance after completion of pending send/receive activity.
     * Synchronized to prevent interleaved invocation. */
    public synchronized void close()
    {
        try 
        {
            pdus2sendLinkedBlockingQueue.clear(); // all stop
            if (!killed)
            {
                setKillSentinel();
                Thread.sleep(100l); // let senderThread and receiverThread stop
            }
            try { // join and kill senderThread
                if (senderThread != null)
                {
                    senderThread.join(4000); // wait for thread to die, msec max duration
                    Thread.sleep(100l);
                }
            }
            catch (InterruptedException ie)
            {
                System.err.println ("*** DisThreadedNetworkInterface senderThread join() failed to wait for senderThread to die");
                System.err.flush();
                ie.printStackTrace(System.err);
            }
            // separate blocks since second join statement otherwise gets skipped if first thread timeout occurs
            try { // join and kill receiverThread
                if (receiverThread != null)
                {
                    receiverThread.join(4000); // wait for thread to die, msec max duration
                    Thread.sleep(100l);
                }
            }
            catch (InterruptedException ie)
            {
                System.err.println ("*** DisThreadedNetworkInterface receiverThread join() failed to wait for threads to die");
                System.err.flush();
                ie.printStackTrace(System.err);
            }
            // now close socket
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
                    message += "datagramSocket.leaveGroup address=" + getAddress() + " port=" + getPort() + " close() complete";
                    System.out.println(message);
                    System.out.flush();
                }
            }
        }
        catch (Exception e)
        {
            System.err.println ("*** DisThreadedNetworkInterface close()() unexpected exception!");
        }
        // report if successful
        String   senderThreadAlive = "null";
        String receiverThreadAlive = "null";
        if (senderThread != null)
            senderThreadAlive =   String.valueOf(  senderThread.isAlive());
        if (receiverThread != null)
            receiverThreadAlive = String.valueOf(receiverThread.isAlive());
        System.out.println ("*** Thread closing status: senderThread.isAlive()=" + senderThreadAlive +
                                                    " receiverThread.isAlive()=" + receiverThreadAlive);
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
        this.verbose   = newValue;
        verboseReceipt = verbose;
        verboseSending = verbose;
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
}
