/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.utilities;

import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.DisTime;
import edu.nps.moves.dis7.enumerations.DISPDUType;

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
    /** Default value */
    public static String DEFAULT_MULTICAST_ADDRESS = "225.4.5.6";

    /** Default value */
    public static int DEFAULT_DIS_PORT = 3000;

    private static final String TRACE_PREFIX = "[" + DisThreadedNetworkInterface.class.getName() + "] ";
    private boolean verbose = true;
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

    private int disPort;
    private String multicastAddress;
    private boolean killed = false;

    private InetAddress inetAddress;
    private InetSocketAddress inetSocket;
    private NetworkInterface networkInterface;
    private DatagramSocket datagramSocket = null;

    /**
     * Default constructor using default port and multicast address
     */
    public DisThreadedNetworkInterface()
    {
        this(DEFAULT_MULTICAST_ADDRESS, DEFAULT_DIS_PORT);
    }

    /**
     * Constructor
     * @param multicastGroup the multicast group address to utilize
     * @param port the multicast port to utilize
     */
    public DisThreadedNetworkInterface(String multicastGroup, int port)
    {
        disPort = port;
        multicastAddress = multicastGroup;
        try
        {
            inetAddress = InetAddress.getByName(multicastAddress);
        }
        catch (UnknownHostException ex)
        {
            Logger.getLogger(DisThreadedNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        inetSocket = new InetSocketAddress(inetAddress, disPort);
        networkInterface = findIpv4Interface();
        init();
    }

    /* *********** queues and lists  and public methods ************** */
    private final List<PduListener> everyTypeListeners = new ArrayList<>();
    private final Map<DISPDUType, List<PduListener>> typeListeners = new HashMap<>();
    private final List<RawPduListener> rawListeners = new ArrayList<>();
    private final LinkedBlockingQueue<Pdu> pdus2send = new LinkedBlockingQueue<>();

    /**
     * Add a listener to accept only pdus of a given type
     * @param newListener listener instance implementing the RawPduListener interface
     * @param disPduType Pdu type
     */
    public void addListener(PduListener newListener, DISPDUType disPduType)
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
     * Get current port value
     * @return current port value
     */
    public int getDisPort()
    {
        return disPort;
    }

    /**
     * Get current multicast address value
     * @return current multicast address value
     */
    public String getMulticastGroup()
    {
        return multicastAddress;
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

    private Thread sender;
    private Thread receiver;

    /** Initialization */
    private void init()
    {
        createDatagramSocket(); // common asset, synchronized to prevent interleaved reentry

        receiver = new Thread(receiveThread, TRACE_PREFIX + " receive thread");
        receiver.setDaemon(true);
        receiver.setPriority(Thread.NORM_PRIORITY);
        receiver.start();

        sender = new Thread(sendThread, TRACE_PREFIX + " send thread");
        sender.setDaemon(true);
        sender.setPriority(Thread.NORM_PRIORITY);
        sender.start();
    }

    /**
     * Create datagram socket if not already available; can also be invoked by
     * either sender or receiver thread to ensure datagram socket is open.
     * Synchronized method to prevent interleaved reentry.
     * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html">Java Tutorials: Synchronized Methods</a>
     */
    private synchronized void createDatagramSocket()
    {
        boolean closedSocket = false;
        if ((datagramSocket != null) && datagramSocket.isClosed())
        {
            closedSocket = true;
            System.err.println(" *** " + TRACE_PREFIX + "datagramSocket.isClosed() unexpectedly, retrying...");
        }
        if ((datagramSocket == null) || closedSocket)
        {
            try
            {
                // The initial value of the SO_BROADCAST socket option is FALSE
                datagramSocket = new MulticastSocket(getDisPort());
                ((MulticastSocket) datagramSocket).joinGroup(inetSocket, networkInterface);
            }
            catch (IOException ex)
            {
                System.err.println(" *** " + TRACE_PREFIX + "Exception in DisThreadedNetworkInterface receive thread: " + ex.getLocalizedMessage());
            }
        }
    }
  
    private Runnable receiveThread = () -> {

        int counter = 0;

        // The capacity could go up to MAX_DIS_PDU_SIZE, but this should be good for now
        // The raw listeners will strip off any extra padding and process what is
        // required
        ByteBuffer byteBuffer = ByteBuffer.allocate(MAX_TRANSMISSION_UNIT_SIZE);
        DatagramPacket packet = new DatagramPacket(byteBuffer.array(), byteBuffer.capacity());
        Pdu pdu;

        while (!killed) { // keep trying on error
            
            // If something trips up with the socket, this thread will attempt to
            // re-establish for both send/receive threads
            try {
                createDatagramSocket (); // ensure socket open, recreate if needed, other thread may occur first

                while (!killed)
                {
                    datagramSocket.receive(packet); // blocks here waiting for next DIS pdu to be received on multicast IP and specified port
                    toRawListeners(packet.getData(), packet.getLength());

                    pdu = pduFactory.createPdu(byteBuffer);

                    if (pdu != null)
                    {
                        counter++; // TODO experimental, add to generator as a commented-out diagnostic; consider adding diagnostic mode
                        if (isVerbose())
                        {
                            String message = TRACE_PREFIX + counter + ". received " + pdu.getPduType().toString();
                            if (isVerboseIncludesTimestamp())
                                message += " (timestamp " + DisTime.timeStampToString(pdu.getTimestamp());
                            message +=", size " + pdu.getMarshalledSize() + " bytes)";
                            System.out.println(message);
                            System.out.flush();
                        }
                        toListeners(pdu);
                    }
                    byteBuffer.clear();
                }
            } 
            catch (IOException ex) {
                System.err.println(TRACE_PREFIX + "Exception in DisThreadedNetworkInterface receive thread: " + ex.getLocalizedMessage());
                System.err.println(TRACE_PREFIX + "Retrying new socket...");
            } 
            finally
            {
                if (datagramSocket != null && !datagramSocket.isClosed()) {
                    try {
                        ((MulticastSocket)datagramSocket).leaveGroup(inetSocket, networkInterface);
                    } catch (IOException ex) {
                        Logger.getLogger(DisThreadedNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    datagramSocket.close();
                    sleep(100l); // TODO needed?
                    datagramSocket = null;
                }
            }
//      if (!killed)
//        sleep(250);
        }
    };

    private final Runnable sendThread = () -> {

        Pdu pdu;

        // The capacity could go up to MAX_DIS_PDU_SIZE, but this should be good for now
        ByteArrayOutputStream baos   = new ByteArrayOutputStream(MAX_TRANSMISSION_UNIT_SIZE);
        DataOutputStream      dos    = new DataOutputStream(baos);
        DatagramPacket        packet = new DatagramPacket(baos.toByteArray(), baos.size(), inetSocket);

        while (!killed) { // keep trying on error

            // If something trips up with the socket, this thread will attempt to
            // re-establish for both send/receive threads
            try {
                createDatagramSocket (); // ensure socket open, recreate if needed, other thread may occur first

                while (!killed) {
                    pdu = pdus2send.take();

                    pdu.marshal(dos);
                    packet.setData(baos.toByteArray());
                    datagramSocket.send(packet);

                    dos.flush();  // immediately force pdu write
                    baos.reset();
                }
            } 
            catch (Exception ex)
            {
                System.err.println(TRACE_PREFIX + "Exception in DisThreadedNetworkInterface send thread: " + ex.getLocalizedMessage());
            }
        }
        try {
            dos.close();
        } catch (IOException e) {}
    };

    private void toListeners(Pdu pdu) {
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

  /** Terminate the instance */
  public void kill()
  {
    killed = true; // set loop sentinel for threads
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
        System.err.flush();
        System.err.println ("*** " + getClass().getName() + ".sleep(" + duration + ") failed to sleep");
        ie.printStackTrace();
    }
  }

    /**
     * Find proper IPV4 interface
     *
     * @return a network interface to use to join a multicast group
     */
    public static NetworkInterface findIpv4Interface() {
        try {
            Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
            NetworkInterface nif;
            Enumeration<InetAddress> addresses;
            InetAddress addr;

            while (ifaces != null && ifaces.hasMoreElements()) {
                nif = ifaces.nextElement();
                if (nif.isUp()) {
                    addresses = nif.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        addr = addresses.nextElement();
                        if (addr instanceof Inet4Address && !addr.isLoopbackAddress() && !addr.isLinkLocalAddress()) 
                        {
                            System.out.println(TRACE_PREFIX + " Using network interface " + nif.getDisplayName());
                            return nif;
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
     * @return the verbose
     */
    public boolean isVerbose()
    {
        return verbose;
    }

    /**
     * @param verbose the verbose to set
     */
    public void setVerbose(boolean verbose)
    {
        this.verbose = verbose;
    }

    /**
     * @return the verboseIncludesTimestamp value
     */
    public boolean isVerboseIncludesTimestamp()
    {
        return verboseIncludesTimestamp;
    }

    /**
     * @param verboseIncludesTimestamp the value to set
     */
    public void setVerboseIncludesTimestamp(boolean verboseIncludesTimestamp)
    {
        this.verboseIncludesTimestamp = verboseIncludesTimestamp;
    }

    /**
     * @param disPort the disPort value to set
     */
    public void setDisPort(int disPort)
    {
        this.disPort = disPort;
    }
}
