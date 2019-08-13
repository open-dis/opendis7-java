/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7.util;

import edu.nps.moves.dis7.Pdu;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

/**
 * DisNetworking.java created on Jul 29, 2019
 * Simple multicast receive and send methods
 */
public class DisNetworking
{
  public class BuffAndLength {
    public byte[] buff; public int length;
    public BuffAndLength(byte[]buff,int length)
    {this.buff=buff;this.length=length;}
  }
  
  private int DIS_PORT = 3000;
  private String MCAST_GROUP = "230.0.0.0";
  private static final int MAX_DIS_PDU_SIZE = 8192;

  public DisNetworking()
  {
    this(3000, "230.0.0.0");
  }

  public DisNetworking(int port, String mcastgroup)
  {
    DIS_PORT = port;
    MCAST_GROUP = mcastgroup;
  }
  
  public int getPort()
  {
    return DIS_PORT;
  }
  
  public String getIp()
  {
    return MCAST_GROUP;
  }
  
  public Pdu receivePdu() throws IOException
  {
    PduFactory pduFactory = new PduFactory();
    BuffAndLength blen = receiveRawPdu();
    return pduFactory.createPdu(blen.buff);
  }
  
  public BuffAndLength receiveRawPdu() throws IOException
  {
    MulticastSocket socket;
    DatagramPacket packet;
    PduFactory pduFactory = new PduFactory();

    socket = new MulticastSocket(DIS_PORT);
    InetAddress maddr = InetAddress.getByName(MCAST_GROUP);
    socket.setNetworkInterface(findIp4Interface());
    socket.joinGroup(maddr);

    byte buffer[] = new byte[MAX_DIS_PDU_SIZE];
    packet = new DatagramPacket(buffer, buffer.length);
    
    System.out.println("Listening on "+MCAST_GROUP+":"+DIS_PORT+" if:"+socket.getNetworkInterface().getDisplayName());
    socket.receive(packet);   //blocks here waiting for next DIS pdu to be received on broadcast IP and specified port

    //System.out.println("packet received from " + packet.getSocketAddress());
    socket.close();
    return new BuffAndLength(packet.getData(),packet.getLength());
  }
  
  public void sendPdu(Pdu pdu) throws IOException
  {
     // turn object into byte stream
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      DataOutputStream dos = new DataOutputStream(baos);
      pdu.marshal(dos);
      byte[] data = baos.toByteArray();
      
      MulticastSocket msocket = new MulticastSocket();
      InetAddress maddr = InetAddress.getByName(MCAST_GROUP);
      // load byte buffer into packet and send
      DatagramPacket packet = new DatagramPacket(data, data.length, maddr, DIS_PORT);
      msocket.setNetworkInterface(findIp4Interface());
      msocket.send(packet);

      msocket.close();
      System.out.println("sent to "+maddr.getHostAddress()+":"+DIS_PORT);
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
}
