/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.Pdu;
import edu.nps.moves.dis7.utilities.DisThreadedNetIF;
import edu.nps.moves.dis7.utilities.PduFactory;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

/**
 * Receives PDUs from the network in IEEE format. Very similar to EspduReciver, but this
 * uses Robert Harder's more memory-efficient NIO code.
 *
 * @author DMcG rharder
 */
public class EspduReceiverNIO
{
  /**
   * Max size of a PDU in binary format that we can receive. This is actually
   * somewhat outdated--PDUs can be larger--but this is a reasonable starting point
   * <p>
   * This is legacy code ported to the edu.nps.moves.dis7 package
   */
  public static final int MAX_PDU_SIZE = 8192; // This has actually been superceded by a larger buffer size, but good enough for now

  public static void main(String args[])
  {
    MulticastSocket socket;
    InetAddress maddr;
    InetSocketAddress group;
    PduFactory pduFactory = new PduFactory();
    byte buffer[] = new byte[MAX_PDU_SIZE];
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
    Pdu pdu;
    
    try {
        
      // Specify the socket to receive data
      socket = new MulticastSocket(EspduSenderNIO.PORT);
      maddr = InetAddress.getByName(EspduSenderNIO.MULTICAST_GROUP);
      group = new InetSocketAddress(maddr, EspduSenderNIO.PORT);
      socket.joinGroup(group, DisThreadedNetIF.findIp4Interface());

      // Loop infinitely, receiving datagrams
      while (true) {
        
        socket.receive(packet);

        pdu = pduFactory.createPdu(packet.getData());

        System.out.println("got PDU of type: " + pdu.getClass().getSimpleName());

      } // end while
    } // End try
    catch (IOException e) {
      System.err.println(e);
    }

  } // end main
} // end class
