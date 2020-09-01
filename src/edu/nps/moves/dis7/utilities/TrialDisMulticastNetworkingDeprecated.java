/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.utilities;

import edu.nps.moves.dis7.pdus.Pdu;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Trial code producing simple multicast receive and send methods, no longer used.
 * <pre>
 * Inefficient since a socket is opened and closed for each pdu send/receive.
 * </pre>
 * 
 * @since Jul 29, 2019.
 * @deprecated Use {@link edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface} instead
 */
@Deprecated(since="dis7")
public class TrialDisMulticastNetworkingDeprecated
{
  public class ByteArrayBufferAndLength
  {
    public byte[] bufferByteArray;
    public int length;

    public ByteArrayBufferAndLength(byte[] bufferByteArray, int length)
    {
      this.bufferByteArray = bufferByteArray;
      this.length = length;
    }
  }

  private int DIS_PORT;
  private String MCAST_GROUP;
  
  private ByteArrayOutputStream baos;
  private DataOutputStream dos;
  
  private InetAddress maddr;
  private InetSocketAddress group;
  private NetworkInterface ni;

  public TrialDisMulticastNetworkingDeprecated()
  {
    this(DisThreadedNetworkInterface.DEFAULT_DIS_PORT, DisThreadedNetworkInterface.DEFAULT_MULTICAST_ADDRESS);
  }

  public TrialDisMulticastNetworkingDeprecated(int port, String mcastgroup)
  {
    DIS_PORT = port;
    MCAST_GROUP = mcastgroup;
      try {
          maddr = InetAddress.getByName(MCAST_GROUP);
      } catch (UnknownHostException ex) {
          Logger.getLogger(TrialDisMulticastNetworkingDeprecated.class.getName()).log(Level.SEVERE, null, ex);
      }
    group = new InetSocketAddress(maddr, DIS_PORT);
    ni = DisThreadedNetworkInterface.findIpv4Interface();
    baos = new ByteArrayOutputStream();
    dos = new DataOutputStream(baos);
  }

  public int getPort()
  {
    return DIS_PORT;
  }

  public String getIp()
  {
    return MCAST_GROUP;
  }

  public void stop()
  {
    if(rsocket != null) {
      rsocket.close();
      rsocket = null;
    }
    
    if(ssocket != null) {
      ssocket.close();
      ssocket = null;
    }
  }
  
  public Pdu receivePdu() throws IOException
  {
    PduFactory pduFactory = new PduFactory();
    ByteArrayBufferAndLength blen = receiveRawPdu();
    return pduFactory.createPdu(blen.bufferByteArray);
  }
  
  private MulticastSocket rsocket;
  byte buffer[];
  DatagramPacket packet;
  public ByteArrayBufferAndLength receiveRawPdu() throws IOException
  {
    rsocket = new MulticastSocket(DIS_PORT);
    rsocket.joinGroup(group, ni);
    buffer = new byte[DisThreadedNetworkInterface.MAX_DIS_PDU_SIZE];
    packet = new DatagramPacket(buffer, buffer.length);

    //System.out.println("Listening on " + MCAST_GROUP + ":" + DIS_PORT + " if:" + socket.getNetworkInterface().getDisplayName());
    rsocket.receive(packet);   //blocks here waiting for next DIS pdu to be received on broadcast IP and specified port 
    //System.out.println("packet received from " + packet.getSocketAddress());
    
    rsocket.leaveGroup(group, ni);
    rsocket.close();
    rsocket = null;
    return new ByteArrayBufferAndLength(packet.getData(), packet.getLength());
  }

  public void sendPdu(Pdu pdu) throws Exception
  {
    // turn object into byte stream
    pdu.marshal(dos);
    sendRawPdu(baos.toByteArray());
    baos.reset();
  }

  private MulticastSocket ssocket;
  public void sendRawPdu(byte[] data) throws IOException
  {
    ssocket = new MulticastSocket();
    ssocket.joinGroup(group, ni);
    
    // load byte buffer into packet and send
    packet = new DatagramPacket(data, data.length, maddr, DIS_PORT);
    ssocket.send(packet);

    ssocket.leaveGroup(group, ni);
    ssocket.close();
    ssocket = null;
    //System.out.println("sent to " + maddr.getHostAddress() + ":" + DIS_PORT);
  }
}
