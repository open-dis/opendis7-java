/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.EntityID;
import edu.nps.moves.dis7.EntityStatePdu;
import edu.nps.moves.dis7.Pdu;
import edu.nps.moves.dis7.Vector3Double;
import edu.nps.moves.dis7.util.PduFactory;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.util.Iterator;
import java.util.List;

/**
 * Receives PDUs from the network in IEEE format.
 * <p>
 * This is legacy code ported to the edu.nps.moves.dis7 package
 *
 * @author DMcG
 * @author Mike Bailey
 */
public class EspduReceiver
{
  /**
   * Max size of a PDU in binary format that we can receive. This is actually
   * somewhat outdated--PDUs can be larger--but this is a reasonable starting point
   */
  public static final int MAX_PDU_SIZE = 8192;

  public static void main(String args[])
  {
    MulticastSocket socket;
    DatagramPacket packet;
    PduFactory pduFactory = new PduFactory();

    try {
      // Specify the socket to receive data
      socket = new MulticastSocket(3000);
      socket.setBroadcast(true);

      //InetAddress address = InetAddress.getByName(EspduSender.DEFAULT_MULTICAST_GROUP);
      //socket.joinGroup(address);
      // Loop infinitely, receiving datagrams
      while (true) {
        byte buffer[] = new byte[MAX_PDU_SIZE];

        packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);

        List<Pdu> pduBundle = pduFactory.getPdusFromBundle(packet.getData(),packet.getLength());
        //System.out.println("Bundle size is " + pduBundle.size());

        Iterator it = pduBundle.iterator();

        while (it.hasNext()) {
          Pdu aPdu = (Pdu) it.next();

          System.out.print("got PDU of type: " + aPdu.getClass().getName());
          if (aPdu instanceof EntityStatePdu) {
            EntityID eid = ((EntityStatePdu) aPdu).getEntityID();
            Vector3Double position = ((EntityStatePdu) aPdu).getEntityLocation();
            System.out.print(" EID:[" + eid.getSiteID() + ", " + eid.getApplicationID() + ", " + eid.getEntityID() + "] ");
            System.out.print(" Location in DIS coordinates: [" + position.getX() + ", " + position.getY() + ", " + position.getZ() + "]");
          }
          System.out.println();
        } // end trop through PDU bundle
      } // end while
    } // End try
    catch (Exception e) {
      System.out.println(e);
    }
  } // end main
} // end class
