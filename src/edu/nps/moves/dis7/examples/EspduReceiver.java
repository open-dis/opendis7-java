/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.EntityID;
import edu.nps.moves.dis7.EntityStatePdu;
import edu.nps.moves.dis7.Pdu;
import edu.nps.moves.dis7.Vector3Double;
import edu.nps.moves.dis7.utilities.DisThreadedNetIF;
import edu.nps.moves.dis7.utilities.PduFactory;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
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
  public static void main(String args[])
  {
    MulticastSocket socket;
    byte buffer[] = new byte[DisThreadedNetIF.MAX_DIS_PDU_SIZE];
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
    PduFactory pduFactory = new PduFactory();
    List<Pdu> pduBundle;

    try 
    {
      // Specify the socket to receive data
      socket = new MulticastSocket(DisThreadedNetIF.DEFAULT_DIS_PORT);
      
      InetAddress maddr = InetAddress.getByName(DisThreadedNetIF.DEFAULT_MULTICAST_ADDRESS);
      InetSocketAddress group = new InetSocketAddress(maddr, DisThreadedNetIF.DEFAULT_DIS_PORT);

      socket.joinGroup(group, DisThreadedNetIF.findIpv4Interface());
      
      // Loop infinitely, receiving datagrams
      EntityID eid;
      Vector3Double position;
      Iterator<Pdu> it;
      Pdu aPdu;
      int pduCounter = 0;
      
      while (true) {
        socket.receive(packet);

        pduBundle = pduFactory.getPdusFromBundle(packet.getData(), packet.getLength());
        //System.out.println("Bundle size is " + pduBundle.size());

        it = pduBundle.iterator();

        while (it.hasNext()) {
          aPdu = it.next();
          pduCounter++;

          System.out.print(pduCounter + ". got PDU of type: " + aPdu.getClass().getName());
          if (aPdu instanceof EntityStatePdu) {
            eid = ((EntityStatePdu) aPdu).getEntityID();
            position = ((EntityStatePdu) aPdu).getEntityLocation();
            System.out.print(" EID:[" + eid.getSiteID() + ", " + eid.getApplicationID() + ", " + eid.getEntityID() + "] ");
            System.out.print(" Location in DIS coordinates: [" + position.getX() + ", " + position.getY() + ", " + position.getZ() + "]");
          }
          System.out.println();
        } // end trop through PDU bundle
      } // end while
    } // End try
    catch (IOException e) {
      System.err.println(e);
    }
  } // end main
} // end class
