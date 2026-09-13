package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.entities.usa.platform.land.M1A2;
import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.enumerations.PlatformDomain;
import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.utilities.*;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Creates and sends ESPDUs in IEEE binary format. Adapted from OpenDIS library
 * example package edu.nps.moves.examples
 *
 * @author Don McGregor
 * @author Don Brutzman
 */
public class EspduSender
{
    /** Default constructor */
    public EspduSender()
    {
        // default constructor
    }
	/**
	 * Number of complete loops to perform.
     * Putting any upper limit on # packets sent avoids possibility of non-terminating infinite loops that continue sending packets. */
	public static final int SEND_LOOPS_TO_PERFORM = 5; // 5

	/**
	 * Default multicast group address we send on.
     * @see <a href="https://en.wikipedia.org/wiki/Multicast_address" target="_blank">https://en.wikipedia.org/wiki/Multicast_address</a> */
	public static final String DEFAULT_MULTICAST_ADDRESS = "239.1.2.3";

	/**
	 * Default multicast port used, matches Wireshark DIS capture default
     * @see <a href="https://en.wikipedia.org/wiki/Port_(computer_networking)" target="_blank">https://en.wikipedia.org/wiki/Port_(computer_networking)</a> */
	public static final int    DEFAULT_MULTICAST_PORT    = 3000;

    /** Type of network connection:
     * Point to point <a href="https://en.wikipedia.org/wiki/Unicast" target="_blank">UNICAST</a>,
     * Many to many <a href="https://en.wikipedia.org/wiki/Multicast" target="_blank">MULTICAST</a>, or 
     * (rarely used, potentially harmful) <a href="https://en.wikipedia.org/wiki/Broadcasting_(networking)" target="_blank">BROADCAST</a>
     */
	public enum NetworkMode {
        /** Point to point @see <a href="https://en.wikipedia.org/wiki/Unicast" target="_blank">https://en.wikipedia.org/wiki/Unicast</a> */
		UNICAST,
        /** Many to many @see <a href="https://en.wikipedia.org/wiki/Multicast" target="_blank">https://en.wikipedia.org/wiki/Multicast</a> */
        MULTICAST,
        /** (rarely used, potentially harmful) @see <a href="https://en.wikipedia.org/wiki/Broadcasting_(networking)" target="_blank">https://en.wikipedia.org/wiki/Broadcasting_(networking)</a> */
        BROADCAST
	};
    
	/**
	 * Output prefix to identify this class, helps with logging
	 */
    private final static String TRACE_PREFIX = "[" + EspduSender.class.getName() + "] ";

	/**
	 * Possible system properties, passed in via -Dattr=val networkMode:
	 * unicast, broadcast, multicast destinationIp: where to send the packet. If
	 * in multicast mode, this can be multicast. To determine broadcast
	 * destination IP, use an online broadcast address calculator, for example
	 * http://www.remotemonitoringsystems.ca/broadcast.php If in multicast mode,
	 * a join() will be done on the multicast address. port: port used for both
	 * source and destination.
	 *
	 * @param args command-line arguments
	 */
    @SuppressWarnings("SleepWhileInLoop") // allows Thread.sleep(value) without warning in code
	public static void main(String args[])
	{
        System.out.println(TRACE_PREFIX + " started...");

        // Default settings. These are used if no system properties are set. 
        // If system properties are passed in, these are overridden later.
        NetworkMode          networkMode = NetworkMode.MULTICAST;
        InetAddress multicastInetAddress = null; // must be initialized, even if null
        int                         port = DEFAULT_MULTICAST_PORT;
        MulticastSocket           socket = null; // must be initialized to avoid later error, even if null;
        EntityStatePdu             espdu = new EntityStatePdu();
//        DisTime                  disTime = new DisTime();

		// ICBM coordinates for my office
		double latitude  =   36.595517;
		double longitude = -121.877000;
		try
        {
			multicastInetAddress = InetAddress.getByName(DEFAULT_MULTICAST_ADDRESS);
		}
        catch (UnknownHostException e)
        {
			System.out.println(TRACE_PREFIX + e + " Cannot create multicast address");
			System.exit(0);
		}

		// All system properties, passed in on the command line via -Dattribute=value
		Properties systemProperties = System.getProperties();

		// IP address we send to
		String destinationIpString = systemProperties.getProperty("destinationIp");

		// Port we send to, and local port we open the socket on
		String portString = systemProperties.getProperty("port");

		// Network mode: unicast, multicast, broadcast
		String networkModeString = systemProperties.getProperty("networkMode"); // unicast or multicast or broadcast

		// Set up socket to send information
		try
        {
			if (portString != null) // Update port we send to, if provided
			{
				port = Integer.parseInt(portString);
			}
			socket = new MulticastSocket(port);

			// Where we send packets to, the destination IP address
			if (destinationIpString != null) 
			{
				multicastInetAddress = InetAddress.getByName(destinationIpString);
			}

			// Type of transport: unicast, broadcast, or multicast
			if (networkModeString != null)
            {
				if (networkModeString.equalsIgnoreCase("unicast")) 
				{
					networkMode = NetworkMode.UNICAST;
				} 
				else if (networkModeString.equalsIgnoreCase("broadcast"))
                {
					networkMode = NetworkMode.BROADCAST;
				} 
				else if (networkModeString.equalsIgnoreCase("multicast"))
                {
					networkMode = NetworkMode.MULTICAST;
					if (!multicastInetAddress.isMulticastAddress())
					{
						throw new RuntimeException("*** Error: sending to multicast address, but destination address " + multicastInetAddress.toString() + "is not multicast");
					}
//					socket.joinGroup(multicastInetAddress); // deprecated, TODO select correct NetworkInterface
                    // =======================================================================
                    // updated approach using NetworkInterface
                    NetworkInterface networkInterface = NetworkInterface.getByInetAddress(multicastInetAddress);
                    if (networkInterface != null)
                        System.out.println("networkInterface=" + networkInterface.getDisplayName()); // typically null if loopback
                    SocketAddress localMulticastSocketAddress = new InetSocketAddress(multicastInetAddress, DEFAULT_MULTICAST_PORT);
                    MulticastSocket multicastSocket = new MulticastSocket(DEFAULT_MULTICAST_PORT);
                    multicastSocket.joinGroup(localMulticastSocketAddress, networkInterface);
                    // =======================================================================
				}
			} // end networkModeString
            else if (networkMode == NetworkMode.MULTICAST)
            {
                networkModeString = "multicast";
            }
            else if (networkMode == NetworkMode.UNICAST)
            {
                networkModeString = "unicast";
            }
            else if (networkMode == NetworkMode.BROADCAST)
            {
                networkModeString = "broadcast";
            }
		}
		catch (IOException | RuntimeException e)
		{
			System.out.println(TRACE_PREFIX + "Unable to initialize network correctly, exiting.");
			System.out.println(e);
			System.exit(-1); // outta here
		}
        System.out.println(TRACE_PREFIX + " sending " + networkModeString + " ESPDU packets to " +
                            multicastInetAddress.getHostAddress() + " port " + port);

		// Initialize values in the Entity State PDU object. The exercise ID is 
		// a way to differentiate between different virtual worlds on one network.
		// Note that some values (such as the PDU type and PDU family) are set
		// automatically when you create the ESPDU.
		espdu.setExerciseID((byte)1); //(short) 1);

		// The EID is the unique identifier for objects in the world. This 
		// EID should match up with the ID for the object specified in the 
		// VMRL/x3d/virtual world.
    
  		EntityID entityID = espdu.getEntityID(); // initialize, reset, override
        // TODO check: 0 is apparently not a valid site number, per DIS specification
		entityID.setSiteID       ((short)1); // TODO utility method to allow int values
		entityID.setApplicationID((short)2);
		entityID.setEntityID     ((short)3);
        espdu.setEntityID(entityID);         // TODO utility method to allow setting all three at once

		// Set the entity type. SISO has a big list of enumerations, so that by
		// specifying various numbers we can say this is an M1A2 American tank,
		// the USS Enterprise, and so on. We'll make this a tank. There is a 
		// separate project elsehwhere in this project that implements DIS 
		// enumerations in C++ and Java, but to keep things simple we just use
		// numbers here.
    
        // Manual way to override platform information:
		EntityType entityType = espdu.getEntityType() 
		        .setEntityKind (EntityKind.PLATFORM).setEntityKind (EntityKind.PLATFORM)  //(short) 1); // Platform (vs lifeform, munition, sensor, etc.); //(short) 1); // Platform (vs lifeform, munition, sensor, etc.)
		        .setCountry    (Country.UNITED_STATES_OF_AMERICA_USA)  // 225 USA
		        .setDomain     (Domain.inst(PlatformDomain.LAND))      // Land (vs air, surface, subsurface, space)
		        .setCategory   ((byte) 1)   // Tank
		        .setSubCategory((byte) 1)   // M1 Abrams
		        .setSpecific   ((byte) 3);  // M1A2 Abrams
    
        // New way using entity jar(s)
        espdu.setEntityType(new edu.nps.moves.dis7.entities.usa.platform.land.M1A2());
        // or simply use an enumeration by name, with accompanying import statement at top of file
        espdu.setEntityType(new M1A2()); 
        
        // Inspecting an enumeration
        System.out.println("===============");
        System.out.println("espdu entityType information:");
        System.out.println("  EntityKind =" + espdu.getEntityType().getEntityKind());
        System.out.println("  Country    =" + espdu.getEntityType().getCountry());
        System.out.println("  Domain     =" + espdu.getEntityType().getDomain());
        System.out.println("  Category   =" + espdu.getEntityType().getCategory());
        System.out.println("  SubCategory=" + espdu.getEntityType().getSubCategory());
        System.out.println("  Specific   =" + espdu.getEntityType().getCountry());
        // TODO round trip lookup
        
		Set<InetAddress> localNetworkAddresses;

		try // Loop through sending N ESPDUs
		{
			System.out.println(TRACE_PREFIX + "sending " + SEND_LOOPS_TO_PERFORM + " sets of packets:"); // + address.toString()
			
			for (int index = 1; index <= SEND_LOOPS_TO_PERFORM; index++)
            {
				// DIS time is a pain in the uh, neck. DIS time units are 2^31-1 units per
				// hour, and time is set to DIS time units from the top of the hour. 
				// This means that if you start sending just before the top of the hour
				// the time units can roll over to zero as you are sending. The receivers
				// (escpecially homegrown ones) are often not able to detect rollover
				// and may start discarding packets as dupes or out of order. We use
				// an NPS timestamp here, hundredths of a second since the start of the
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
				int timestamp = DisTime.getCurrentDisTimestamp();
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
				// Modify the position of the object. This will send the object a little
				// due east by adding some to the longitude every iteration. Since we
				// are on the Pacific coast, this sends the object east. Assume we are
				// at zero altitude. In other worlds you'd use DTED to determine the
				// local ground altitude at that lat/lon, or you'd just use ground clamping.
				// The x and y values will change, but the z value should not.
				//lon = lon + (double)((double)idx / 100000.0);
				//System.out.println("lla=" + lat + "," + lon + ", 0.0");
				double direction = Math.pow(-1.0, index);
				longitude = longitude + (direction * 0.00006);

				double disCoordinates[] = CoordinateConversions.getXYZfromLatLonDegrees(latitude, longitude, 1.0);
				Vector3Double location = espdu.getEntityLocation();
				location.setX(disCoordinates[0]);
				location.setY(disCoordinates[1]);
				location.setZ(disCoordinates[2]);
				System.out.println("===============");
				System.out.println("Create new PDUs");
				System.out.println("  latitude, longitude:   [" + latitude + ", " + longitude + "]");
				System.out.println("  coordinate conversion: [" + disCoordinates[0] + ", " + disCoordinates[1] + ", " + disCoordinates[2] + "]");

				location = espdu.getEntityLocation();

				System.out.println("Espdu #" + index + " entityID=[" + entityID.getSiteID()+ "," + entityID.getApplicationID()+ "," + entityID.getEntityID()+ "]");
				double c[]   = {location.getX(), location.getY(), location.getZ()};
				double lla[] = CoordinateConversions.xyzToLatLonDegrees(c);
//              System.out.println("  DIS entityLocation: [" + location.getX() + "," + location.getY() + "," + location.getZ() + "]");
				String debugString = " Location (latitude/longitude/altitude): [" + lla[0] + ", " + lla[1] + ", " + lla[2] + "]";
//      		System.out.println(debugString);

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
				// Marshal out the espdu object to a byte array, then send a datagram
				// packet with that data in it.
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				DataOutputStream dos = new DataOutputStream(baos);
                DatagramPacket packet;

				// The byte array here is the packet in DIS format. We put that into a 
				// datagram and send it.
				espdu.marshal(dos);
				byte[] espduArray = baos.toByteArray();

				FirePdu firePdu = new FirePdu();
                firePdu.setLocationInWorldCoordinates(espdu.getEntityLocation());
				byte[] fireArray = firePdu.marshal().array(); // can also use ByteBuffer

				System.out.println("FirePdu #" + index + " firePdu=[FireMissionIndex=" + firePdu.getFireMissionIndex() + ", descriptor=" + firePdu.getDescriptor()+ "]");

//                CommentPdu    newCommentPdu = new CommentPdu();
//                ArrayList<VariableDatum> payloadList = new ArrayList<>();
//                ArrayList<String> commentsList = new ArrayList<>();
//                commentsList.add("Hello CommentPDU");
//                commentsList.add("Here is a second line of text in this comment.");
//                if (!commentsList.isEmpty())
//                    System.out.println("Preparing CommentPDU:");
//
//                for (String comment : commentsList)
//                {
//                    VariableDatum newVariableDatum = new VariableDatum();
//                    newVariableDatum.setVariableDatumValue (comment.getBytes());               // conversion
//                    newVariableDatum.setVariableDatumLengthInBytes(comment.getBytes().length); // also available in bits, see spec and javadoc
//                    // alternatively, you do not need to set this and the marshaller will figure it out from the byte array
//                    // (see javadoc for VariableDatum.setVariableDatumLength())
//                    payloadList.add(newVariableDatum);
//                    System.out.println("   \"" + comment + "\"");
//                }
//                newCommentPdu.setVariableDatums(payloadList);
//				byte[] commentArray = newCommentPdu.marshal();

				localNetworkAddresses = getBroadcastAddresses();
                for (InetAddress networkAddress : localNetworkAddresses) {
                    if (espduArray.length > 0)
                    {
                        packet = new DatagramPacket(espduArray, espduArray.length, networkAddress, port);
                        System.out.println(TRACE_PREFIX + "sending datagram packet [" + espdu.getPduType().toString() + "] " + 
                                           "packet.getLength()=" + packet.getLength() + ", " + // diagnostic, beware of ever-growing packet size
                                           String.format("to %-15s", networkAddress.getHostAddress()) + " port " + port);
                        socket.send(packet);
                    }
                    // TODO experiment with these!  8)
                    if (fireArray.length > 0)
                    {
                        packet = new DatagramPacket(fireArray, fireArray.length, networkAddress, port); // alternate
                        System.out.println(TRACE_PREFIX + "sending datagram packet [" + firePdu.getPduType().toString() + "        ] " + 
                                           "packet.getLength()= " + packet.getLength() + ", " + // diagnostic, beware of ever-growing packet size
                                           String.format("to %-15s", networkAddress.getHostAddress()) + " port " + port);
                        socket.send(packet);
                    }       
//                    // TODO experiment with these!  8)
//                    if (newCommentPdu != null)
//                    {
//                        System.out.println(TRACE_PREFIX + "sending datagram packet [" + newCommentPdu.getPduType().toString() + "        ] to " + 
//                                           String.format("%-15s", networkAddress.getHostAddress()) + " port " + port);
//                        packet = new DatagramPacket(commentArray, commentArray.length, networkAddress, port); // alternate
//                        socket.send(packet);
//                    }
                }
				// Send every 1 second within loop. Otherwise all this will be all over in a fraction of a second.
				Thread.sleep(1000); // msec
			}
		}
		catch (Exception e)
		{
            System.out.println(TRACE_PREFIX + "Problem with " + e + ", see exception trace:");
			System.out.println(e);
		}
        System.out.println("===============");
		System.out.println(TRACE_PREFIX + "complete.");
	}

	/**
	 * A number of sites get all snippy about using 255.255.255.255 for a
	 * broadcast address; it trips their security software and they kick you off
	 * their network. (Comcast, NPS, etc.) This determines the broadcast address for
	 * all connected interfaces, based on the IP and subnet mask. If you have a
	 * dual-homed host it will return a broadcast address for both. If you have
	 * some VMs running on your host this will pick up the addresses for those
	 * as well--e.g. running VMWare on your laptop with a local IP this will also
	 * pick up a 192.168 address assigned to the VM by the host OS.
	 *
	 * @return set of all broadcast addresses
	 */
	public static Set<InetAddress> getBroadcastAddresses()
	{
		Set<InetAddress> broadcastAddresses = new HashSet<>();
		Enumeration<NetworkInterface> interfaces;

		try {
			interfaces = NetworkInterface.getNetworkInterfaces();

			while (interfaces.hasMoreElements())
			{
				NetworkInterface anInterface = interfaces.nextElement();

				if (anInterface.isUp())
				{
                    for (InterfaceAddress anAddress : anInterface.getInterfaceAddresses()) {
                        if ((anAddress == null || anAddress.getAddress().isLinkLocalAddress()))
                        {
                            continue;
                        }

                        //System.out.println("Getting broadcast address for " + anAddress);
                        InetAddress broadcastAddress = anAddress.getBroadcast();
                        if (broadcastAddress != null)
                        {
                            broadcastAddresses.add(broadcastAddress);
                        }
                    }
				}
			}
		}
		catch (SocketException e) 
		{
            System.out.println(TRACE_PREFIX + "Problem with .getBroadcastAddresses(), see exception trace:" + e);
			System.out.println(e);
		}
		return broadcastAddresses;
	}
}
