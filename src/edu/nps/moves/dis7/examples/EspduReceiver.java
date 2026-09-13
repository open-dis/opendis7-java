package edu.nps.moves.dis7.examples; 

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.utilities.*;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Receives PDUs from the network in IEEE DIS format.
 * Adapted from OpenDIS library example package edu.nps.moves.examples
 *
 * @author DMcG
 * @version $Id:$
 */
public class EspduReceiver
{
    /** Default constructor */
    public EspduReceiver()
    {
        // default constructor
    }
    /** Max size of a PDU in binary format that we can receive. This is actually
     * somewhat outdated--PDUs can be larger--but this is a reasonable starting point.
     */
    private static final int MAX_PDU_SIZE = 8192;

    /** Default multicast group address we send on.
     * @see <a href="https://en.wikipedia.org/wiki/Multicast_address" target="_blank">https://en.wikipedia.org/wiki/Multicast_address</a> */
    public static final String DEFAULT_MULTICAST_ADDRESS = EspduSender.DEFAULT_MULTICAST_ADDRESS;
	
    /** Default multicast port used, matches Wireshark DIS capture default
     * @see <a href="https://en.wikipedia.org/wiki/Port_(computer_networking)" target="_blank">https://en.wikipedia.org/wiki/Port_(computer_networking)</a> */
    public static final int    DEFAULT_MULTICAST_PORT    = EspduSender.DEFAULT_MULTICAST_PORT;
    
	/** Output prefix to identify this class */
    private final static String TRACE_PREFIX = "[" + EspduReceiver.class.getName() + "] ";

    /**
     * Program invocation, execution starts here
     * @param args command-line arguments
     */
    public static void main(String args[])
	{
        MulticastSocket multicastSocket;
        InetAddress     multicastInetAddress;
        DatagramPacket  packet;
        PduFactory      pduFactory = new PduFactory();
        DisTime.TimestampStyle       timestampStyle        = DisTime.TimestampStyle.IEEE_ABSOLUTE;
        DisTime.setTimestampStyle(timestampStyle);
        int pduCount = 0;

        System.out.println(TRACE_PREFIX + "started...");
		
        try {
            // Specify the socket to receive data
            multicastSocket = new MulticastSocket(DEFAULT_MULTICAST_PORT);
//          socket.setBroadcast(true);
       
            multicastInetAddress = InetAddress.getByName(DEFAULT_MULTICAST_ADDRESS);
//          socket.joinGroup(address); // deprecated
            // =======================================================================
            // new approach using interface
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(multicastInetAddress);
            SocketAddress localMulticastSocketAddress = new InetSocketAddress(multicastInetAddress, DEFAULT_MULTICAST_PORT);
            multicastSocket.joinGroup(localMulticastSocketAddress, networkInterface);
            // =======================================================================
        
            System.out.println(TRACE_PREFIX + "listening for PDU packets on " + multicastInetAddress.getHostAddress() + " port " + DEFAULT_MULTICAST_PORT);
            System.out.println("To quit: stop or kill this process");
            System.out.println("===============");
            
            while (true) // Loop infinitely, receiving datagrams
			{
                byte buffer[] = new byte[MAX_PDU_SIZE];
                packet = new DatagramPacket(buffer, buffer.length); // reset packet each time

                multicastSocket.receive(packet); // process blocks here until receipt of network packet with PDU

                List<Pdu> pduBundle = pduFactory.getPdusFromBundle(packet.getData(),packet.getLength());
                if (pduBundle.size() > 1)
                    System.out.println("Received PDU bundle size is " + pduBundle.size());

                for (Pdu nextPdu : pduBundle) // iterator loop through PDU bundle
                {
                    pduCount++;
                    String receiptMessage = String.format("%3s", pduCount) // right justify, 3 characters
                           + ". received PDU type " + nextPdu.getPduType().getValue() + "=" + nextPdu.getPduType().name() + " " + nextPdu.getClass().getSimpleName();
                    if (nextPdu instanceof EntityStatePdu)
                    {
                        System.out.println(receiptMessage);
                        EntityID      entityID = ((EntityStatePdu)nextPdu).getEntityID();
                        Vector3Double position = ((EntityStatePdu)nextPdu).getEntityLocation();
                        System.out.println("     entityID triplet: [" + entityID.getSiteID()+ ", " + entityID.getApplicationID()+ ", " + entityID.getEntityID()+ "] ");
                        System.out.println("     Location in DIS coordinates:        [" + position.getX() + ", " + position.getY() + ", " + position.getZ() + "]");
                    }
                    else if (nextPdu instanceof FirePdu)
                    {    
                        System.out.println(receiptMessage);
                        Vector3Double position = ((FirePdu)nextPdu).getLocationInWorldCoordinates();
                        System.out.println("     FirePdu locationInWorldCoordinates: [" + position.getX() + ", " + position.getY() + ", " + position.getZ() + "]");
                        System.out.println("===============");
                    }
                    else
                    {    
                        System.out.println(receiptMessage);
                    }
                } // end of bundle loop
            } // end of while loop
        } // end try block
        catch (IOException ioe)
		{
            System.out.println(TRACE_PREFIX + "Problem with input/output, see exception trace:");
            System.out.println(ioe);
        }
		System.out.println(TRACE_PREFIX + "complete.");
    } // end main
} // end class
