/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */
package edu.nps.moves.dis7.util;

import edu.nps.moves.dis7.Pdu;
import edu.nps.moves.dis7.enumerations.DISPDUType;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * DisThreadedNetIF.java created on Jul 29, 2019
 * This is a thread-safe, multicast DIS network interface class.
 * It is a singleton, meaning one instance per VM. If a DIS needs to send and receive over
 * more than one network address, this class can be modified to be multiply instantiated;
 * MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class DisThreadedNetIF
{
  /* ********** Pdu listener interface *********** */
  public interface PduListener
  {
    void incomingPdu(Pdu pdu);
  }

  /* ***** Raw pdu listener class and interface ******** */
  public class BuffAndLength
  {
    public byte[] buff;
    public int length;

    public BuffAndLength(byte[] buff, int length)
    {
      this.buff = buff;
      this.length = length;
    }
  }
  
  public interface RawPduListener
  {
    void incomingPdu(BuffAndLength bAndL);
  }
  
  /************ Begin class ***************/
  
  public static int DEFAULT_DIS_PORT = 3000;
  public static String DEFAULT_MCAST_GROUP = "225.4.5.6";
  private static final int MAX_DIS_PDU_SIZE = 8192;
  
  private int disPort;
  private String mcastGroup;
  private boolean killed = false;

  public DisThreadedNetIF()
  {
    this(DEFAULT_DIS_PORT, DEFAULT_MCAST_GROUP);
  }

  public DisThreadedNetIF(int port, String mcastgroup)
  {
    disPort = port;
    mcastGroup = mcastgroup;
    init();
  }

  /* *********** queues and lists  and public methods ************** */
  private final ArrayList<PduListener> everyTypeListeners = new ArrayList<>();
  private final HashMap<DISPDUType, ArrayList<PduListener>> typeListeners = new HashMap<>();
  
  private final ArrayList<RawPduListener> rawListeners = new ArrayList<>();

  private final LinkedBlockingQueue<Pdu> pdus2send = new LinkedBlockingQueue<>();

  /**
   * Add a listener to accept only pdus of the given typ
   * @param lis instance of PduListener
   * @param typ Pdu type
   */
  public void addListener(PduListener lis, DISPDUType typ)
  {
    if (typ == null)
      addListener(lis);
    else {
      ArrayList<PduListener> arLis = typeListeners.get(typ);
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

    typeListeners.entrySet().stream().forEach(entry -> {
      ArrayList<PduListener> arLis = entry.getValue();
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
   * Remove previously add raw listener
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
   * Sent the given pdu to the network, using the ip and port given to the constructor
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

  private MulticastSocket socket = null;

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
  int counter = 0;
  
  private Runnable receiveThread = () -> {
    DatagramPacket packet;
    while (!killed) { // keep trying on error
      try {
        socket = new MulticastSocket(disPort);
        InetAddress maddr = InetAddress.getByName(mcastGroup);
        socket.setNetworkInterface(findIp4Interface());
        socket.joinGroup(maddr);
        
        while (!killed) {
          byte buffer[] = new byte[MAX_DIS_PDU_SIZE];
          packet = new DatagramPacket(buffer, buffer.length);

          socket.receive(packet);   //blocks here waiting for next DIS pdu to be received on multicast IP and specified port
          toRawListeners(packet.getData(), packet.getLength());
          
          Pdu pdu = pduFactory.createPdu(packet.getData());
          if (pdu != null)
          {
            counter++; // TODO experimental, add to generator as a commented-out diagnostic; consider adding diagnostic mode
            System.err.println(counter + ". received " + pdu.getPduType().name());
            toListeners(pdu);
          }
        }
      }
      catch (IOException ex) {
        if (socket != null) {
          socket.close();
          socket = null;
        }
        System.err.println("Exception in DISThreadedNetIF receive thread: " + ex.getLocalizedMessage());
        System.err.println("Retrying in 5 seconds");

      }
      if (!killed)
        sleep(5000);
    }
  };

  private final Runnable sendThread = () -> {
    while (!killed) {
      try {
        InetAddress maddr = InetAddress.getByName(mcastGroup);

        while (!killed) {
          Pdu pdu = pdus2send.take();

          // turn object into byte stream
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          DataOutputStream dos = new DataOutputStream(baos);
          pdu.marshal(dos);
          byte[] data = baos.toByteArray();
          // load byte buffer into packet and send
          DatagramPacket packet = new DatagramPacket(data, data.length, maddr, disPort);
          socket.send(packet);
        }
      }

      catch (InterruptedException ex) {
        // probably killed
      }
      catch (Exception ex) {
        if (socket != null) {
          socket.close();
          socket = null;
        }
        System.err.println("Exception in DISThreadedNetIF send thread: " + ex.getLocalizedMessage());
        System.err.println("Retrying in 5 seconds");
      }
      if (!killed)
        sleep(5000);
    }
  };

  private void toListeners(Pdu pdu)
  {
    everyTypeListeners.stream().forEach(lis -> lis.incomingPdu(pdu));
    if (pdu != null) {
      ArrayList<PduListener> arLis = typeListeners.get(pdu.getPduType());
      if (arLis != null)
        arLis.stream().forEach(lis -> lis.incomingPdu(pdu));
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
    sender.interrupt();
    receiver.interrupt();
  }

  private void sleep(long ms)
  {
    try {
      Thread.sleep(ms);
    }
    catch (InterruptedException ex) {
    }
  }

  /* find proper interface */
  private static NetworkInterface findIp4Interface() throws SocketException
  {
    Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
    while (ifaces.hasMoreElements()) {
      NetworkInterface nif = ifaces.nextElement();
      Enumeration<InetAddress> addresses = nif.getInetAddresses();
      while (addresses.hasMoreElements()) {
        InetAddress addr = addresses.nextElement();
        if (addr instanceof Inet4Address && !addr.isLoopbackAddress()) {
          //System.out.println("Using network interface " + nif.getDisplayName());
          return nif;
        }
      }
    }
    return null;
  }

  /* simple test...
  public static void main(String[] args) {
    DisThreadedNetIF netif = new DisThreadedNetIF();
    
    PduListener list = (p)->{
      System.out.println("got "+p.getClass().getSimpleName());
    };
    netif.addListener(list);
    PduFactory factory = new PduFactory();
    Arrays.stream(DISPDUType.values()).forEach(typ->{
      Pdu pdu = factory.createPdu(typ);
      if(pdu != null)
      netif.send(factory.createPdu(typ));
    });
  }
   */
}
