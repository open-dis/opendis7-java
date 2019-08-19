/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.EntityID;
import edu.nps.moves.dis7.EntityStatePdu;
import edu.nps.moves.dis7.EulerAngles;
import edu.nps.moves.dis7.Vector3Double;
import java.net.DatagramPacket;
import java.net.InetAddress;
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
  /**
   * multicast group we send on
   */
  public static final String MULTICAST_GROUP = "239.1.2.3";

  /**
   * Port we send on
   */
  public static final int PORT = 3000;

  public static void main(String args[])
  {
    EntityStatePdu espdu = new EntityStatePdu();
    MulticastSocket socket;
    InetAddress address;

    espdu.setExerciseID((byte) 0);

    // The EID is the unique identifier for objects in the world. This 
    // EID should match up with the ID for the object specified in the 
    // VMRL/x3d world.
    EntityID eid = espdu.getEntityID();
    eid.setSiteID((short) 1); // 0 is apparently not a valid site number
    eid.setApplicationID((short) 1);
    eid.setEntityID((short) 2);

    try {
      socket = new MulticastSocket(PORT);
      address = InetAddress.getByName(MULTICAST_GROUP);
      socket.joinGroup(address);

      while (true) {
        for (int idx = 0; idx < 100; idx++) {
          // The timestamp should be monotonically increasing. Many implementations
          // discard packets that have earlier timestamps (assumption is that it
          // arrived out of order) or non-increasing timestamp (dupe packet).
          // The time should be slaved to clock time, so we can determine the time
          // between packets, but this is the minimum for testing.
          int timestamp = espdu.getTimestamp();
          timestamp++;
          espdu.setTimestamp(timestamp);

          // Modify the x-axis position of the object
          Vector3Double location = espdu.getEntityLocation();
          location.setX(idx);
          location.setY(idx);

          // Do some rotation to make sure that works
          EulerAngles orientation = espdu.getEntityOrientation();
          float psi = orientation.getPsi();
          psi = psi + idx;
          orientation.setPsi(psi);
          orientation.setTheta((float) (orientation.getTheta() + idx / 2.0));

          // Marshal out the object to a byte array, then send a datagram
          // packet with that data in it. This uses Robert Harder's NIO
          // code for marshalling.
          byte data[] = espdu.marshal();
          DatagramPacket packet = new DatagramPacket(data, data.length, address, PORT);

          socket.send(packet);

          // Almost any sender will overwhelm a receiver if not constrained. This
          // slows down the send rate so the receiver has enough time to process it
          Thread.sleep(1000);

          System.out.println("Sending espdu");
        }
      }
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

}
