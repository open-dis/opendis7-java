/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.utilities.CoordinateConversions;
import edu.nps.moves.dis7.utilities.DisTime;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.PduFactory;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.*;

/**
 * Creates and sends ESPDUs in IEEE binary format.
 * <p>
 * This is legacy code ported to the edu.nps.moves.dis7 package
 *
 * @author DMcG
 * @author Mike Bailey
 */
public class PduSender
{
  /** default value avoids unterminated zombie senders */
  public static final int NUMBER_TO_SEND = 5000;
  
    /** default constructor */
    public PduSender()
    {
        // initialization code here
    }

  /** TCP/IP network modes */
  public enum NetworkMode
  {
    /** unicast socket */
    UNICAST,
    /** multicast socket */
    MULTICAST,
    /** broadcast socket */
    BROADCAST
  };

  /**
   * Possible system properties, passed in via -Dattr=val
   * networkMode: unicast, broadcast, multicast
   * destinationIp: where to send the packet. If in multicast mode, this can be multicast.
   * To determine broadcast destination IP, use an online broadcast address
   * calculator, for example http://www.remotemonitoringsystems.ca/broadcast.php
   * If in multicast mode, a join() will be done on the multicast address.
   * port: port used for both source and destination.
   *
   * @param args command-line arguments
   */
  @SuppressWarnings("SleepWhileInLoop")
  public static void main(String args[])
  {
    MulticastSocket socket = null; // must be initialized, even if null
    
    // Default settings. These are used if no system properties are set. 
    // If system properties are passed in, these are over ridden.
    int port = DisThreadedNetworkInterface.DEFAULT_DIS_PORT;
    NetworkMode mode;
    InetAddress destinationIp = null; // must be initialized, even if null

    try {
      destinationIp = InetAddress.getByName(DisThreadedNetworkInterface.DEFAULT_DIS_ADDRESS);
    }
    catch (UnknownHostException e) {
      System.err.println(e + " Cannot create multicast address");
      System.exit(1);
    }

    // All system properties, passed in on the command line via -Dattribute=value
    Properties systemProperties = System.getProperties();

    // IP address we sendPDU to
    String destinationIpString = systemProperties.getProperty("destinationIp");

    // Port we sendPDU to, and local port we open the socket on
    String portString = systemProperties.getProperty("port");

    // Network mode: unicast, multicast, broadcast
    String networkModeString = systemProperties.getProperty("networkMode"); // unicast or multicast or broadcast
    InetSocketAddress group = null;

    // Set up a socket to sendPDU information
    try {
      // Port we sendPDU to
      if (portString != null)
        port = Integer.parseInt(portString);

      socket = new MulticastSocket();

      // Where we sendPDU packets to, the destination IP address
      if (destinationIpString != null) {
        destinationIp = InetAddress.getByName(destinationIpString);
      }

      // Type of transport: unicast, broadcast, or multicast
      // TODO convert to String constants
      if (networkModeString != null) {
        if (networkModeString.equalsIgnoreCase("unicast"))
          mode = NetworkMode.UNICAST;
        else if (networkModeString.equalsIgnoreCase("broadcast"))
          mode = NetworkMode.BROADCAST;
        else if (networkModeString.equalsIgnoreCase("multicast")) {
          mode = NetworkMode.MULTICAST;
          if (!destinationIp.isMulticastAddress()) {
            throw new RuntimeException("Sending to multicast address, but destination address " + destinationIp.toString() + " is not multicast");
          }

          group = new InetSocketAddress(destinationIp, port);
          socket.joinGroup(group, DisThreadedNetworkInterface.findIpv4Interface());
        }
      } // end networkModeString
    }
    catch (IOException | RuntimeException e) {
      System.err.println("Unable to initialize networking. Exiting.");
      System.err.println(e);
      System.exit(-1);
    }
    
    // Factory with default absolute time
    PduFactory     pduFactory = new PduFactory();
    EntityStatePdu espdu      = pduFactory.makeEntityStatePdu();

    // ICBM coordinates for my office
    double lat = 36.595517;
    double lon = -121.877000;

    // Set the entity type. SISO has a big list of enumerations, so that by
    // specifying various numbers we can say this is an M1A2 American tank,
    // the USS Enterprise, and so on. We'll make this a tank. There is a 
    // separate project elsehwhere in this project that implements DIS 
    // enumerations in C++ and Java, but to keep things simple we just use
    // numbers here.
    // Manual method:
    /*
    EntityType entityType = espdu.getEntityType();
    entityType.setEntityKind(EntityKind.PLATFORM);      // Platform (vs lifeform, munition, sensor, etc.)
    entityType.setCountry(Country.UNITED_STATES_OF_AMERICA_USA); 
    entityType.setDomain(Domain.inst(PlatformDomain.LAND));          // Land (vs air, surface, subsurface, space)
    entityType.setCategory((byte)1);        // Tank
    entityType.setSubCategory((byte)1);     // M1 Abrams
    entityType.setSpecific((byte)3);            // M1A2 Abrams
     */
    // Using entitytype jar
    espdu.setEntityType(new edu.nps.moves.dis7.entities.usa.platform.land.M1A2());

    Set<InetAddress> broadcastAddresses = getBroadcastAddresses();
    
    // Loop through sending N ESPDUs
    try {
      System.out.println("Sending " + NUMBER_TO_SEND + " ESPDU packets to " + destinationIp.toString());
      int timestamp;
      double direction;
      double disCoordinates[];
      Vector3Double location;
      FirePdu fire;
      ByteBuffer fireArray;
      byte[] data;
      DatagramPacket packet;
      
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      DataOutputStream dos = new DataOutputStream(baos);
        
      for (int idx = 0; idx < NUMBER_TO_SEND; idx++) {
        // DIS time is a pain in the ass. DIS time units are 2^31-1 units per
        // hour, and time is set to DIS time units from the top of the hour. 
        // This means that if you begin sending just before the top of the hour
        // the time units can roll over to zero as you are sending. The receivers
        // (escpecially homegrown ones) are often not able to detect rollover
        // and may begin discarding packets as dupes or out of order. We use
        // an NPS timestamp here, hundredths of a second since the begin of the
        // year. The DIS standard for time is often ignored in the wild; I've seen
        // people use Unix time (seconds since 1970) and more. Or you can
        // just stuff idx into the timestamp field to get something that is monotonically
        // increasing.

        // Note that timestamp is used to detect duplicate and out of order packets. 
        // That means if you DON'T change the timestamp, many implementations will simply
        // discard subsequent packets that have an identical timestamp. Also, if they
        // receive a PDU with an timestamp lower than the last one they received, they
        // may discard it as an earlier, out-of-order PDU. So it is a good idea to
        // update the timestamp on ALL packets sent.
        // An alterative approach: actually follow the standard. It's a crazy concept,
        // but it might just work.
        timestamp = DisTime.getCurrentDisTimestamp();
        espdu.setTimestamp(timestamp);

        // Set the position of the entity in the world. DIS uses a cartesian 
        // coordinate system with the origin at the center of the earth, the x
        // axis out at the equator and prime meridian, y out at the equator and
        // 90 deg east, and z up and out the north pole. To place an object on
        // the earth's surface you also need a model for the shape of the earth
        // (it's not a sphere.) All the fancy math necessary to do this is in
        // the SEDRIS SRM package. There are also some one-off formulas for 
        // doing conversions from, for example, lat/lon/altitude to DIS coordinates.
        // Here we use those one-off formulas.
        // Modify the position of the object. This will sendPDU the object a little
        // due east by adding some to the longitude every iteration. Since we
        // are on the Pacific coast, this sends the object east. Assume we are
        // at zero altitude. In other worlds you'd use DTED to determine the
        // local ground altitude at that lat/lon, or you'd just use ground clamping.
        // The x and y values will change, but the z value should not.
        //lon = lon + (double)((double)idx / 100000.0);
        //System.out.println("lla=" + lat + "," + lon + ", 0.0");
        direction = Math.pow(-1.0, idx);
        lon = lon + (direction * 0.00006);
//        System.out.println(lon);

        disCoordinates = CoordinateConversions.getXYZfromLatLonDegrees(lat, lon, 1.0);
        location = espdu.getEntityLocation();
        location.setX(disCoordinates[0]);
        location.setY(disCoordinates[1]);
        location.setZ(disCoordinates[2]);
//        System.out.println("lat, lon: (" + lat + ", " + lon + ")");
//        System.out.println("DIS coord: (" + disCoordinates[0] + ", " + disCoordinates[1] + ", " + disCoordinates[2] + ")");

        // Optionally, we can do some rotation of the entity
        /*
            Orientation orientation = espdu.getEntityOrientation();
            float psi = orientation.getPsi();
            psi = psi + idx;
            orientation.setPsi(psi);
            orientation.setTheta((float)(orientation.getTheta() + idx /2.0));
         */
        
        // You can set other ESPDU values here, such as the velocity, acceleration,
        // and so on.
        // Marshal out the espdu object to a byte array, then sendPDU a datagram
        // packet with that data in it.
        espdu.marshal(dos);

        // The byte array here is the packet in DIS format. We put that into a 
        // datagram and sendPDU it.
        data = baos.toByteArray();
        
        fire = pduFactory.makeFirePdu();
        fireArray = fire.marshal();

        for (InetAddress broadcast : broadcastAddresses) {
            System.out.println("Sending broadcast datagram packets to " + broadcast);
            packet = new DatagramPacket(data, data.length, broadcast, port);
            socket.send(packet);
            
            // TODO experiment with these!  8)
            packet = new DatagramPacket(fireArray.array(), fire.getMarshalledSize(), broadcast, port); // alternate
            socket.send(packet);
        }

        // Send every 1 seccond, otherwise this will be all over in a fraction of a second.
        Thread.sleep(1000L);

        baos.reset();

        System.out.println("Espdu #" + idx + " EID=[" + espdu.getEntityID().getSiteID() + ", " + espdu.getEntityID().getApplicationID() + ", " + espdu.getEntityID().getEntityID() + "]");
        System.out.println(" DIS coordinates location=[" + location.getX() + ", " + location.getY() + ", " + location.getZ() + "]");
//        double c[] = {location.getX(), location.getY(), location.getZ()};
//        double lla[] = CoordinateConversions.xyzToLatLonDegrees(c);
//      System.out.println(" Location (lat/lon/alt): [" + lla[0] + ", " + lla[1] + ", " + lla[2] + "]");

        System.out.println("FirePdu #" + idx + " EID=[" + fire.getFiringEntityID().getSiteID() + ", " + fire.getFiringEntityID().getApplicationID() + ", " + fire.getFiringEntityID().getEntityID() + "]");
      }
    }
    catch (Exception ex) {
      System.err.println(ex);
    }
  }

  /**
   * A number of sites get all snippy about using 255.255.255.255 for a broadcast
   * address; it trips their security software and they kick you off their
   * network. (Comcast, NPS.) This determines the broadcast address for all
   * connected interfaces, based on the IP and subnet mask. If you have
   * a dual-homed host it will return a broadcast address for both. If you have
   * some VMs running on your host this will pick up the addresses for those
   * as well--eg running VMWare on your laptop with a local IP this will
   * also pick up a 192.168 address assigned to the VM by the host OS.
   *
   * @return set of all broadcast addresses
   */
  public static Set<InetAddress> getBroadcastAddresses()
  {
    Set<InetAddress> broadcastAddresses = new HashSet<>();
    Enumeration<NetworkInterface> interfaces;

    try {
      interfaces = NetworkInterface.getNetworkInterfaces();
      Iterator<InterfaceAddress> it;
      InterfaceAddress anAddress;
      InetAddress broadcastAddress;
      while (interfaces.hasMoreElements()) {
        NetworkInterface anInterface = interfaces.nextElement();

        if (anInterface.isUp()) {
          it = anInterface.getInterfaceAddresses().iterator();
          while (it.hasNext()) {
            anAddress = it.next();
            if ((anAddress == null || anAddress.getAddress().isLinkLocalAddress()))
              continue;

            //System.out.println("Getting broadcast address for " + anAddress);
            broadcastAddress = anAddress.getBroadcast();
            if (broadcastAddress != null)
              broadcastAddresses.add(broadcastAddress);
          }
        }
      }
    }
    catch (SocketException e) {
      e.printStackTrace(System.err);
      System.err.println(e);
    }
    return broadcastAddresses;
  }

}
