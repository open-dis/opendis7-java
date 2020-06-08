/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.utilities;

import edu.nps.moves.dis7.Pdu;
import edu.nps.moves.dis7.enumerations.DISPDUType;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DisThreadedNetIF.java created on Jul 29, 2019.
 * <pre>
 * This is a thread-safe, multicast DIS network interface class.
 * </pre>
 * 
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class DisThreadedNetIF
{
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
  
  public static int DEFAULT_DIS_PORT = 3000;
  public static String DEFAULT_MCAST_GROUP = "225.4.5.6";
  private static final int MAX_DIS_PDU_SIZE = 8192;
  
  private int disPort;
  private String mcastGroup;
  private boolean killed = false;
  
  private InetAddress maddr;
  private InetSocketAddress group;
  private NetworkInterface ni;
  private MulticastSocket ssocket = null;
  private MulticastSocket rsocket = null;

  /**
   * Default constructor using default port 3000 and multicast address 225.4.5.6
   */
  public DisThreadedNetIF()
  {
    this(DEFAULT_DIS_PORT, DEFAULT_MCAST_GROUP);
  }

  /**
   * 
   * @param port the multicast port to utilize
   * @param mcastgroup the multicast group address to utilize
   */
  public DisThreadedNetIF(int port, String mcastgroup)
  {
    disPort = port;
    mcastGroup = mcastgroup;
      try {
          maddr = InetAddress.getByName(mcastGroup);
      } catch (UnknownHostException ex) {
          Logger.getLogger(DisThreadedNetIF.class.getName()).log(Level.SEVERE, null, ex);
      }
    group = new InetSocketAddress(maddr, disPort);
    ni = findIp4Interface();
    init();
  }

  /* *********** queues and lists  and public methods ************** */
  private final List<PduListener> everyTypeListeners = new ArrayList<>();
  private final Map<DISPDUType, List<PduListener>> typeListeners = new HashMap<>();
  private final List<RawPduListener> rawListeners = new ArrayList<>();
  private final LinkedBlockingQueue<Pdu> pdus2send = new LinkedBlockingQueue<>();

  /**
   * Add a listener to accept only pdus of a given typ
   * @param lis instance of PduListener
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
   * @param lis instance implementing the PduListener interface
   */
  public void addListener(PduListener lis)
  {
    everyTypeListeners.add(lis);
  }

  /**
   * Remove previously added listener
   * @param lis instance implementing the PduListener interface
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
   * @param lis instance implementing the RawPduListener interface
   */
  public void addRawListener(RawPduListener lis)
  {
    rawListeners.add(lis);
  }
  
  /**
   * Remove previously added raw listener
   * @param lis 
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
   * @param pdu 
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
    byte buffer[] = new byte[MAX_DIS_PDU_SIZE];
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
    Pdu pdu;
    
    while (!killed) { // keep trying on error
      try {
        rsocket = new MulticastSocket(disPort);
        rsocket.joinGroup(group, ni);
        
        while (!killed) {
          
          rsocket.receive(packet);   //blocks here waiting for next DIS pdu to be received on multicast IP and specified port
          toRawListeners(packet.getData(), packet.getLength());
          
          // the PduFactory will wrap data in a ByteBuffer
          pdu = pduFactory.createPdu(packet.getData());
          
          if (pdu != null)
          {
            counter++; // TODO experimental, add to generator as a commented-out diagnostic; consider adding diagnostic mode
            System.err.println(counter + ". received " + pdu.getPduType().name());
            toListeners(pdu);
          }
        }
      }
      catch (IOException ex) {
        System.err.println("Exception in DISThreadedNetIF receive thread: " + ex.getLocalizedMessage());
        System.err.println("Retrying in 1 second");
      } finally {
         if (rsocket != null && !rsocket.isClosed()) {
             try {
                 rsocket.leaveGroup(group, ni);
             } catch (IOException ex) {
                 Logger.getLogger(DisThreadedNetIF.class.getName()).log(Level.SEVERE, null, ex);
             }
             rsocket.close();
             rsocket = null;
         }
      }
//      if (!killed)
//        sleep(250);
    }
  };

  private final Runnable sendThread = () -> {
      
      Pdu pdu;
      byte[] data;
      DatagramPacket packet;
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      DataOutputStream dos = new DataOutputStream(baos);
      
     while (!killed) { // keep trying on error
      try {
        ssocket = new MulticastSocket(disPort);
        ssocket.joinGroup(group, ni);
        
        while (!killed) {
          pdu = pdus2send.take();

          // turn object into byte stream
          pdu.marshal(dos);
          data = baos.toByteArray();

          // Since we don't know the size of the PDU, reluctantly, we create a
          // new packet here when we finally know
          packet = new DatagramPacket(data, data.length, maddr, disPort);
          ssocket.send(packet);

          baos.reset();
        }
      }
      catch (Exception ex) {
        System.err.println("Exception in DISThreadedNetIF send thread: " + ex.getLocalizedMessage());
        System.err.println("Retrying in 1 second");
      } finally {
         if (ssocket != null && !ssocket.isClosed()) {
             try {
                 ssocket.leaveGroup(group, ni);
             } catch (IOException ex) {
                 Logger.getLogger(DisThreadedNetIF.class.getName()).log(Level.SEVERE, null, ex);
             }
             ssocket.close();
             ssocket = null;
         }
      }
//      if (!killed)
//        sleep(250);
    }
      try {
          dos.close();
      } catch (IOException e) {}
  };

  private void toListeners(Pdu pdu)
  {
    everyTypeListeners.forEach(lis -> lis.incomingPdu(pdu));
    if (pdu != null) {
      List<PduListener> arLis = typeListeners.get(pdu.getPduType());
      if (arLis != null)
        arLis.forEach(lis -> lis.incomingPdu(pdu));
    }
  }
  
  private void toRawListeners(byte[]data, int len)
  {
    if(rawListeners.isEmpty())
      return;
    
    BuffAndLength bl = new BuffAndLength(data,len);
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

  /** Find proper interface
   * @return a network interface to use to join a multicast group
   */
  public static NetworkInterface findIp4Interface()
  {
    Enumeration<NetworkInterface> ifaces = null;
      try {
          ifaces = NetworkInterface.getNetworkInterfaces();
      } catch (SocketException ex) {
          Logger.getLogger(DisThreadedNetIF.class.getName()).log(Level.SEVERE, null, ex);
      }
    NetworkInterface nif;
    Enumeration<InetAddress> addresses;
    InetAddress addr;
    
    while (ifaces != null && ifaces.hasMoreElements()) {
      nif = ifaces.nextElement();
      addresses = nif.getInetAddresses();
      while (addresses.hasMoreElements()) {
        addr = addresses.nextElement();
        if (addr instanceof Inet4Address && !addr.isLoopbackAddress()) {
          System.out.println("Using network interface " + nif.getDisplayName());
          return nif;
        }
      }
    }
    return null;
  }
}
