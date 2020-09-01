/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
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
  public static void main(String args[])
  {
    MulticastSocket   socket;
    InetAddress       multicastAddress;
    InetSocketAddress group;
    PduFactory        pduFactory = new PduFactory();
    byte              buffer[] = new byte[DisThreadedNetworkInterface.MAX_DIS_PDU_SIZE];
    DatagramPacket    packet = new DatagramPacket(buffer, buffer.length);
    Pdu pdu;
    int pduCounter = 0;
    
    try 
    {
      // Specify the socket to receive data
                socket = new MulticastSocket(DisThreadedNetworkInterface.DEFAULT_DIS_PORT);
      multicastAddress = InetAddress.getByName(DisThreadedNetworkInterface.DEFAULT_MULTICAST_ADDRESS);
                 group = new InetSocketAddress(multicastAddress, DisThreadedNetworkInterface.DEFAULT_DIS_PORT);
      socket.joinGroup(group, DisThreadedNetworkInterface.findIpv4Interface()); // picks best candidate

      while (true) // Loop indefinitely, receiving datagrams
      {
        socket.receive(packet);

        pdu = pduFactory.createPdu(packet.getData());

        pduCounter++;
        System.out.println(pduCounter + ". got PDU of type: " + pdu.getClass().getSimpleName());
        
      } // end while
    } // End try
    catch (IOException e)
    {
      System.err.println(e);
    }

  } // end main
} // end class
