/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.utilities;

import edu.nps.moves.dis7.Pdu;
import edu.nps.moves.dis7.DisTime;
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
  private static final String TRACE_PREFIX = "[" + DisThreadedNetworkInterface.class.getName() + "] ";
  private             boolean verbose = true;
  
  /** Pdu listener interface */
  public interface PduListener
  {
    void incomingPdu(Pdu pdu);
  }

  /** Raw pdu listener class and interface */
  public interface RawPduListener
  {
    void incomingPdu(BuffAndLength bAndL);
  }
  
  /**
   * Stores data for further processing
   */
  public class BuffAndLength
  {
    public byte[] buff;
    public int length;

    /**
     * Default constructor for data storage
     * @param buff the data buffer to store
     * @param length the length of the data buffer
     */
    public BuffAndLength(byte[] buff, int length)
    {
      this.buff = buff;
      this.length = length;
    }
  }
  
  /************ Begin class ***************/
  
  public static int    DEFAULT_DIS_PORT          = 3000;
  public static String DEFAULT_MULTICAST_ADDRESS = "225.4.5.6";
  
  /** 8192: This has actually been superseded by a larger buffer size, but good enough for now */
  public static final int MAX_DIS_PDU_SIZE = 8192;
  
  /** 1500:  size of an ethernet frame, common value to avoid packet segmentation */
  public static final int MAX_TRANSMISSION_UNIT_SIZE = 1500;
  
  private int disPort;
  private String mcastGroup;
  private boolean killed = false;
  
  private InetAddress maddr;
  private InetSocketAddress group;
  private NetworkInterface ni;
  private DatagramSocket socket = null;

  /**
   * Default constructor using default port 3000 and multicast address 225.4.5.6
   */
  public DisThreadedNetworkInterface()
  {
    this(DEFAULT_DIS_PORT, DEFAULT_MULTICAST_ADDRESS);
  }

  /**
   * 
   * @param port the multicast port to utilize
   * @param mcastgroup the multicast group address to utilize
   */
  public DisThreadedNetworkInterface(int port, String mcastgroup)
  {
    disPort = port;
    mcastGroup = mcastgroup;
      try {
          maddr = InetAddress.getByName(mcastGroup);
      } catch (UnknownHostException ex) {
          Logger.getLogger(DisThreadedNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
      }
    group = new InetSocketAddress(maddr, disPort);
    ni = findIpv4Interface();
    init();
  }

  /* *********** queues and lists  and public methods ************** */
  private final List<PduListener> everyTypeListeners = new ArrayList<>();
  private final Map<DISPDUType, List<PduListener>> typeListeners = new HashMap<>();
  private final List<RawPduListener> rawListeners = new ArrayList<>();
  private final LinkedBlockingQueue<Pdu> pdus2send = new LinkedBlockingQueue<>();

  /**
   * Add a listener to accept only pdus of a given type
   * @param lis listener instance implementing the RawPduListener interface
   * @param typ Pdu type
   */
  public void addListener(PduListener lis, DISPDUType typ)
  {
    if (typ == null)
      addListener(lis);
    else {
      List<PduListener> arLis = typeListeners.get(typ);
      if (arLis == null) {
        arLis = new ArrayList<>();
        typeListeners.put(typ, arLis);
      }
      arLis.add(lis);
    }
  }
  
  /**
   * Add a listener to accept all pdu types
   * @param lis listener instance implementing the RawPduListener interface
   */
  public void addListener(PduListener lis)
  {
    everyTypeListeners.add(lis);
  }

  /**
   * Remove previously added listener
   * @param lis listener instance implementing the RawPduListener interface
   */
  public void removeListener(PduListener lis)
  {
    everyTypeListeners.remove(lis);

    typeListeners.entrySet().forEach(entry -> {
      List<PduListener> arLis = entry.getValue();
      if (arLis.contains(lis))
        arLis.remove(lis);
    });
  }
  
  /**
   * Add a listener to accept pdus of all types in the form of a byte array
   * @param lis listener instance implementing the RawPduListener interface
   */
  public void addRawListener(RawPduListener lis)
  {
    rawListeners.add(lis);
  }
  
  /**
   * Remove previously added raw listener
   * @param lis listener instance implementing the RawPduListener interface
   */
  public void removeRawListener(RawPduListener lis)
  {
    rawListeners.remove(lis);
  }
  
  public int getDisPort()
  {
    return disPort;
  }

  public String getMcastGroup()
  {
    return mcastGroup;
  }

  /**
   * Send the given pdu to the network using the ip and port given to the constructor
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

  private void init()
  {
    receiver = new Thread(receiveThread, "DisThreadedNetIF receive thread");
    receiver.setDaemon(true);
    receiver.setPriority(Thread.NORM_PRIORITY);
    receiver.start();

    sender = new Thread(sendThread, "DisThreadedNetIF send thread");
    sender.setDaemon(true);
    sender.setPriority(Thread.NORM_PRIORITY);
    sender.start();
  }
  
    private Runnable receiveThread = () -> {

        int counter = 0;

        // The capacity could go up to MAX_DIS_PDU_SIZE, but this should be good for now
        // The raw listeners will strip off any extra padding and process what is
        // required
        ByteBuffer buffer = ByteBuffer.allocate(MAX_TRANSMISSION_UNIT_SIZE);
        DatagramPacket packet = new DatagramPacket(buffer.array(), buffer.capacity());
        Pdu pdu;

        while (!killed) { // keep trying on error
            
            // If something trips up with the socket, this thread will attempt to
            // re-establish for both send/receive threads
            try {
                
                // The initial value of the SO_BROADCAST socket option is FALSE
                socket = new MulticastSocket(disPort);
                ((MulticastSocket)socket).joinGroup(group, ni);

                while (!killed) {

                    socket.receive(packet); // blocks here waiting for next DIS pdu to be received on multicast IP and specified port
                    toRawListeners(packet.getData(), packet.getLength());

                    pdu = pduFactory.createPdu(buffer);

                    if (pdu != null)
                    {
                        counter++; // TODO experimental, add to generator as a commented-out diagnostic; consider adding diagnostic mode
                        if (isVerbose())
                        {
                            System.out.println(TRACE_PREFIX + counter + ". received " + pdu.getPduType().toString()
                                                            + " (timestamp " + DisTime.timeStampToString(pdu.getTimestamp())
                                                            + ", size " + pdu.getMarshalledSize() + " bytes)");
                            System.out.flush();
                        }
                        toListeners(pdu);
                    }
                    buffer.clear();
                }
            } 
            catch (IOException ex) {
                System.err.println(TRACE_PREFIX + "Exception in DisThreadedNetIF receive thread: " + ex.getLocalizedMessage());
                System.err.println(TRACE_PREFIX + "Retrying new socket in 1 second");
            } 
            finally {
                if (socket != null && !socket.isClosed()) {
                    try {
                        ((MulticastSocket)socket).leaveGroup(group, ni);
                    } catch (IOException ex) {
                        Logger.getLogger(DisThreadedNetworkInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    socket.close();
                    socket = null;
                }
            }
//      if (!killed)
//        sleep(250);
        }
    };

    private final Runnable sendThread = () -> {

        Pdu pdu;

        // The capacity could go up to MAX_DIS_PDU_SIZE, but this should be good for now
        ByteArrayOutputStream baos = new ByteArrayOutputStream(MAX_TRANSMISSION_UNIT_SIZE);
        DataOutputStream dos = new DataOutputStream(baos);
        DatagramPacket packet = new DatagramPacket(baos.toByteArray(), baos.size(), group);

        while (!killed) { // keep trying on error
            try {
                while (!killed) {
                    pdu = pdus2send.take();

                    pdu.marshal(dos);
                    packet.setData(baos.toByteArray());
                    socket.send(packet);

                    baos.reset();
                }
            } 
            catch (Exception ex)
            {
                System.err.println(TRACE_PREFIX + "Exception in DisThreadedNetIF send thread: " + ex.getLocalizedMessage());
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
    
    BuffAndLength bl = new BuffAndLength(data, len);
    rawListeners.forEach(lis->lis.incomingPdu(bl));
  }
  
  public void kill()
  {
    killed = true;
  }

  private void sleep(long ms)
  {
    try {
      Thread.sleep(ms);
    }
    catch (InterruptedException ex) {}
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
                            System.out.println(TRACE_PREFIX + "Using network interface " + nif.getDisplayName());
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
}
