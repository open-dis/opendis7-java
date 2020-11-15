/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.EulerAngles;
import edu.nps.moves.dis7.pdus.Vector3Double;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

/**
 * Creates and sends ESPDUs in IEEE binary format. very similar to EspduSender.java, but
 * this uses Robert Harder's more memory efficient NIO methods for marshalling.
 * <p>
 * This is legacy code ported to the edu.nps.moves.dis7 package
 *
 * @author DMcG
 */
public class EspduSenderNIO
{
  /** Command-line invocation (CLI)
    * @param args command-line arguments
    */
  public static void main(String args[])
  {
    MulticastSocket   socket;
    InetAddress       multicastAddress;
    InetSocketAddress group;

    EntityStatePdu    espdu = new EntityStatePdu();
    espdu.setExerciseID((byte) 0);

    // The EID is the unique identifier for objects in the world. This EID
    // should match up with the ID for the object specified in the VMRL/x3d world.
    EntityID eid = espdu.getEntityID();
    eid.setSiteID       ((short) 1); // 0 is apparently not a valid site number
    eid.setApplicationID((short) 1);
    eid.setEntityID     ((short) 2);

    try
    {
                socket = new MulticastSocket();
      multicastAddress = InetAddress.getByName(DisThreadedNetworkInterface.DEFAULT_MULTICAST_ADDRESS);
                 group = new InetSocketAddress(multicastAddress, DisThreadedNetworkInterface.DEFAULT_DIS_PORT);
      socket.joinGroup(group, DisThreadedNetworkInterface.findIpv4Interface()); // picks best candidate
      
      Vector3Double location;
      EulerAngles orientation;
      float psi;
      byte[] data = new byte[144];
      DatagramPacket packet = new DatagramPacket(data, data.length, group);

      while (true)
      {
        for (int idx = 0; idx < 100; idx++)
        {
          // The timestamp should be monotonically increasing. Many implementations
          // discard packets that have earlier timestamps (assumption is that it
          // arrived out of order) or non-increasing timestamp (dupe packet).
          // The time should be slaved to clock time, so we can determine the time
          // between packets, but this is the minimum for testing.
          int timestamp = espdu.getTimestamp();
          timestamp++;
          espdu.setTimestamp(timestamp);

          // Modify the x-axis position of the object
          location = espdu.getEntityLocation();
          location.setX(idx);
          location.setY(idx);

          // Do some rotation to make sure that works
          orientation = espdu.getEntityOrientation();
          psi = orientation.getPsi();
          psi = psi + idx;
          orientation.setPsi(psi);
          orientation.setTheta((float) (orientation.getTheta() + idx / 2.0));

          // Marshal out the object to a byte array, then send a datagram
          // packet with that data in it. This uses Robert Harder's NIO
          // code for marshalling.
          data = espdu.marshal();
          packet.setData(data);

          socket.send(packet);

          // Almost any sender will overwhelm a receiver if not constrained. This
          // slows down the send rate so the receiver has enough time to process it
          Thread.sleep(1000);

          System.out.println("Sending " + espdu.getClass().getName());
        }
      }
    }
    catch (Exception e)
    {
      System.err.println(e);
    }
  }

}
