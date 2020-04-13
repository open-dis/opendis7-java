/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.Pdu;
import edu.nps.moves.dis7.util.PduFactory;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.ByteBuffer;

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
    DatagramPacket packet;
    InetAddress address;
    PduFactory pduFactory = new PduFactory();

    try {
      // Specify the socket to receive data
      socket = new MulticastSocket(EspduSender.DIS_DESTINATION_PORT);
      address = InetAddress.getByName(EspduSender.DEFAULT_MULTICAST_GROUP);
      socket.joinGroup(address);

      // Loop infinitely, receiving datagrams
      while (true) {
        byte buffer[] = new byte[MAX_PDU_SIZE];
        packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);

        // Uses the NIO byte buffer class--wrap a ByteBuffer instance around
        // the data we get from the packet
        ByteBuffer byteBuffer = ByteBuffer.wrap(packet.getData());
        Pdu pdu = pduFactory.createPdu(byteBuffer);

        System.out.println("got PDU of type: " + pdu.getClass().getSimpleName());

      } // end while
    } // End try
    catch (Exception e) {
      System.out.println(e);
    }

  } // end main
} // end class
