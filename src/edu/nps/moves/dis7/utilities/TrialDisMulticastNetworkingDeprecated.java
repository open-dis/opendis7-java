/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
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
  /** deprecated */
  public class ByteArrayBufferAndLength
  {
    /** deprecated do not use */
    public byte[] bufferByteArray;
    /** deprecated do not use */
    public int length;

    /** deprecated do not use
       * @param bufferByteArray deprecated do not use
       * @param length deprecated do not use */
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

  /** deprecated do not use */
  public TrialDisMulticastNetworkingDeprecated()
  {
    this(DisThreadedNetworkInterface.DEFAULT_DIS_PORT, DisThreadedNetworkInterface.DEFAULT_DIS_ADDRESS);
  }

  /** deprecated do not use
     * @param port deprecated do not use
     * @param mcastgroup deprecated do not use */
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

  /** deprecated do not use
     * @return  deprecated do not use */
  public int getPort()
  {
    return DIS_PORT;
  }

  /** deprecated do not use
     * @return deprecated do not use */
  public String getIp()
  {
    return MCAST_GROUP;
  }

  /** deprecated do not use */
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

  /** deprecated do not use
     * @return deprecated do not use
     * @throws java.io.IOException if network-related error occurs */
  public Pdu receivePdu() throws IOException
  {
    PduFactory pduFactory = new PduFactory();
    ByteArrayBufferAndLength blen = receiveRawPdu();
    return pduFactory.createPdu(blen.bufferByteArray);
  }
  
  private MulticastSocket rsocket;
  byte buffer[];
  DatagramPacket packet;
  /** deprecated do not use
     * @return deprecated do not use
     * @throws java.io.IOException if network-related error occurs */
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

    /**
     * deprecated do not use
     * @param pdu deprecated do not use
     * @throws Exception if network-related error occurs
     */
    public void sendPdu(Pdu pdu) throws Exception
  {
    // turn object into byte stream
    pdu.marshal(dos);
    sendRawPdu(baos.toByteArray());
    baos.reset();
  }

  private MulticastSocket ssocket;

    /**
     * deprecated do not use
     * @param data deprecated do not use
     * @throws IOException if network-related error occurs
     */
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
