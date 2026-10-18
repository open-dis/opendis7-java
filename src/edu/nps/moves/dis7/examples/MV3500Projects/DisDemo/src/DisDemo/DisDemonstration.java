package DisDemo;

import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.enumerations.ForceID;
import edu.nps.moves.dis7.enumerations.PlatformDomain;
import edu.nps.moves.dis7.utilities.DisTime;
import edu.nps.moves.dis7.pdus.Domain;
import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.Vector3Double;
import edu.nps.moves.spatial.*;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.*;

/**
 * Simple DIS demonstration program
 * @author DMcG
 */
public class DisDemonstration
{
    /** Default constructor */
    public DisDemonstration()
    {
        // default constructor
    }
    /**
     * Program invocation, execution starts here
     * @param args command-line arguments
     * @throws java.lang.Exception execution error
     */
    public static void main(String[] args) throws Exception 
    {
        EntityStatePdu espdu = new EntityStatePdu();

        int NUMBER_OF_SENDS =   20;
        int PORT            = 3000;
        int INTERVAL_MSEC   = 1000; // 1 second
        
        // Create a new coordinate system at the give latitude, longitude, and altitude
        RangeCoordinates rangeCoordinates = new RangeCoordinates(31.435, 45.223, 17.0);
        
        // Convert from the coodinate system with the origin above to DIS coordinates
        Vector3Double disCoordinates = rangeCoordinates.DISCoordFromLocalFlat(0, 0, 0);
        espdu.setEntityLocation(disCoordinates);
        
        // Set various fields--entityID, entity type, etc.
        espdu.setExerciseID((byte)1);
        
        espdu.getEntityID().setSiteID(17);
        espdu.getEntityID().setApplicationID(42);
        espdu.getEntityID().setEntityID(104);
        
        espdu.getEntityType().setEntityKind(EntityKind.PLATFORM); // platform
        espdu.getEntityType().setDomain(Domain.inst(PlatformDomain.LAND)); // land
        espdu.getEntityType().setCategory((short)2);
        espdu.getEntityType().setSubCategory(1);
        espdu.getEntityType().setSpecific((short)1);
        espdu.getEntityType().setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        
        espdu.getMarking().setCharacters("lulz".getBytes());
        espdu.setForceId(ForceID.FRIENDLY);
        
        try (DatagramSocket socket = new DatagramSocket(PORT))
        {
           
           // We set the starting position to (0,0,0) in the local coordinate
           // system, which is equivalent to the (lat, lon, alt) set above as
           // the origin, which also corresponds to some DIS geocentric point.
           // All three coordinate system points correspond to the same point
           // in space.
           Vector3Double startPosition = new Vector3Double();
           startPosition.setX(0.0);
           startPosition.setY(0.0);
           startPosition.setZ(0.0);
           
           // Our mover is told to start at (0,0,0) in the local coordinate system
           EntityMoverSquare mover = new EntityMoverSquare(startPosition);
           
           List<InetAddress> allBcasts = getBroadcastAddresses();
           Vector3Double currentPosition, currentPositionDisCoords;
           ByteBuffer buffer;
           DatagramPacket packet;
               
           // Do some movement for a while
           System.out.println ("DisDemo.DisDemonstration: sending " + NUMBER_OF_SENDS + " ESPDU packets at " +
               INTERVAL_MSEC + " msec (" + INTERVAL_MSEC/1000.0 +
               " second) intervals on");
           System.out.println ("  broadcast address=" + allBcasts + " port " + PORT);
           for(int index = 1; index <= NUMBER_OF_SENDS; index++)
           {
               mover.step();
               
               // get the current position of the enity in the local coordinate system
               currentPosition = mover.getPosition();
               
               // Convert that point to the DIS geocentric coordinate system
               currentPositionDisCoords = rangeCoordinates.DISCoordFromLocalFlat(currentPosition.getX(), currentPosition.getY(), currentPosition.getZ());
               
               // Set entity position in the espdu
               espdu.setEntityLocation(currentPositionDisCoords);
               
               // Marshall it, send it
               espdu.setTimestamp(DisTime.getCurrentDisTimestamp());
               buffer = espdu.marshal();
               
               for(InetAddress aBcast: allBcasts)
               {
                    packet = new DatagramPacket(buffer.array(), buffer.array().length, aBcast, PORT);
                    socket.send(packet);
               }
               System.out.println("... sent DIS ESPDU " + index + " of " + NUMBER_OF_SENDS);
               Thread.sleep(INTERVAL_MSEC);
           }
        }
        catch(IOException | InterruptedException e)
        {
            System.err.println(e);
        }
    }
    /** Get list of network addresses for broadcast packets
     * @return list of network addresses */
    public static List<InetAddress> getBroadcastAddresses()
    {
        List<InetAddress> broadcastAddresses = new ArrayList<>();

        try
        {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) 
            {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isLoopback())
                    continue;    // Don't want to broadcast to the loopback interface

                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) 
                {
                    InetAddress broadcast = interfaceAddress.getBroadcast();
                    if (broadcast == null)
                        continue;

                    // Use the address
                    broadcastAddresses.add(broadcast);
                }
            }
        }
        catch(SocketException e)
        {
            System.err.println(e);
        }

        return broadcastAddresses;
    }
    
}
