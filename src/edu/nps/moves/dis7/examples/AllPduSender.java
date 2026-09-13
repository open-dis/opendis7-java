package edu.nps.moves.dis7.examples;

import java.io.*;
import java.net.*;
import java.util.*;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * This is an application example that sends every type of PDU defined
 * by the IEEE Distributed Interactive Simulation (DIS) Protocol.
 * This example program is useful for testing standards compliance by applications, or 
 * producing a full set of PDUs. It also writes the generated PDUs to an XML file.
 * Adapted from OpenDIS library example package edu.nps.moves.examples
 *
 * @author brutzman
 * @author DMcG
 * @version $Id:$
 */
public class AllPduSender
{
    /** Default multicast group address we send on.
      * @see <a href="https://en.wikipedia.org/wiki/Multicast_address" target="_blank">https://en.wikipedia.org/wiki/Multicast_address</a> */
    public static final String DEFAULT_MULTICAST_ADDRESS = "239.1.2.3"; // PduRecorder "225.4.5.6"; //
	
    /** Default multicast port used, matches Wireshark DIS capture default
      * @see <a href="https://en.wikipedia.org/wiki/Port_(computer_networking)" target="_blank">https://en.wikipedia.org/wiki/Port_(computer_networking)</a> */
    public static final int    DEFAULT_MULTICAST_PORT    = 3000;
	
    /** Duration in milliseconds, set to 0 to avoid pausing between PDU sends */
    private long               THREAD_SLEEP_INTERVAL = 0;
	
    /** Number of complete loops to perform.
     * Putting any upper limit on # packets sent avoids possibility of non-terminating infinite loops that continue sending packets. */
    private int                SEND_LOOPS_TO_PERFORM = 1;
    
    private static InetAddress multicastInetAddress;
    private static int         port;

    /** Object constructor
     * @param newMulticastAddress address of interest
     * @param newMulticastPort port of interest */
    public AllPduSender(String newMulticastAddress, int newMulticastPort)
    {
        this.port = DEFAULT_MULTICAST_PORT;
        try
		{
            multicastInetAddress = InetAddress.getByName(newMulticastAddress);
            if (!multicastInetAddress.isMulticastAddress())
			{
                System.out.println("Not a multicast address: " + newMulticastAddress);
            }
            this.port = newMulticastPort;
        } 
		catch (UnknownHostException e) {
            System.out.println("Unable to open socket: " + e);
        }
    }

    /** Begin operations
     * @return number of PDUs received, -1 if exception occurs */
    @SuppressWarnings("SleepWhileInLoop")
    public int run()
	{
		System.out.println("OpenDis7Examples.AllPduSender started...");
        if (SEND_LOOPS_TO_PERFORM != 1)
        {
            float  waitIntervalSeconds = ((float)THREAD_SLEEP_INTERVAL / 1000);
            float  loopIntervalSeconds = ((float)THREAD_SLEEP_INTERVAL / 1000) * 72; // 72 PDUs
            float totalDurationSeconds = loopIntervalSeconds * SEND_LOOPS_TO_PERFORM ;
            System.out.println("... THREAD_SLEEP_INTERVAL = " + THREAD_SLEEP_INTERVAL + " milliseconds = "  + waitIntervalSeconds + " seconds");
            System.out.print  ("... running for ");
            if (SEND_LOOPS_TO_PERFORM > 1)
                System.out.print  (SEND_LOOPS_TO_PERFORM + " loops, ");
            if (THREAD_SLEEP_INTERVAL > 0)
                System.out.println("expected loop interval = " + loopIntervalSeconds + " seconds, total duration = " + 
                        totalDurationSeconds + " seconds = " + (totalDurationSeconds/60.0) + " minutes");
        }
           
        System.out.println("Generate list of all PDU types and note issues, if any...");
        List<Pdu> generatedPdusList = new ArrayList<>();
            
        for (int i = 0; i < SEND_LOOPS_TO_PERFORM; i++) {
            
            try {
                
                // Loop through all the enumerated PDU types, create a PDU for each type,
                // add that PDU to generatedPdusList, then send each one
                for (DisPduType pduTypeValue : DisPduType.values()) 
                {
    //                System.out.println("PDU " + pdu.getValue() + " " + pdu.name() + " " + pdu.getDescription()); // diagnostic

                    Pdu aPdu = null; // edu.​nps.​moves7.​dis.PDU superclass for all PDUs, in preparation for custom assignment

                    try {
                        switch (pduTypeValue) // using enumeration values from edu.​nps.​moves.​dis7.​enumerations.​DisPduType
                        {
                            // each case value is DisPduType
                            case OTHER: // 0
                                System.out.println ("*** Note: DisPduType." + pduTypeValue.name() + "=" + pduTypeValue.getValue() + " not supported"); // TODO why was this received?
                                break; // nothing to send

                            case ENTITY_STATE: // 1 
                                aPdu = new EntityStatePdu();

                                EntityStatePdu espdu = (EntityStatePdu) aPdu;
                                EntityMarking entityMarking = new EntityMarking ();
                                entityMarking.setCharacters("AllPduSender".getBytes());   //entityMarking.setCharacters(Byte.valueOf("0")); // 11 characters max?

                                espdu.setMarking(entityMarking);
                                Vector3Double espduLocation = new Vector3Double();
                                espduLocation.setX(1.0);
                                espduLocation.setY(2.0);
                                espduLocation.setZ(3.0);
                                espdu.setEntityLocation(espduLocation);
                                // it is important to identify questions as you think of them
                                // TODO how to set azimuth, i.e. course direction over ground?
                                break;

                            case FIRE: // 2
                                aPdu = new FirePdu();
                                break;

                            case DETONATION: // 3
                                aPdu = new DetonationPdu();
                                break;

                            case COLLISION: // 4
                                aPdu = new CollisionPdu();
                                break;

                            case SERVICE_REQUEST: // 5
                                aPdu = new ServiceRequestPdu();
                                break;

                            case RESUPPLY_OFFER: // 6
                                aPdu = new ResupplyOfferPdu();
                                break;

                            case RESUPPLY_RECEIVED: // 7
                                aPdu = new ResupplyReceivedPdu();
                                break;

                            case RESUPPLY_CANCEL: //8
                                aPdu = new ResupplyCancelPdu();
                                break;

                            case REPAIR_COMPLETE: // 9
                                aPdu = new RepairCompletePdu();
                                break;

                            case REPAIR_RESPONSE: // 10
                                aPdu = new RepairResponsePdu();
                                break;

                            case CREATE_ENTITY: // 11
                                aPdu = new CreateEntityPdu();
                                break;

                            case REMOVE_ENTITY: // 12
                                aPdu = new RemoveEntityPdu();
                                break;

                            case START_RESUME: // 13
                                aPdu = new StartResumePdu();
                                break;

                            case STOP_FREEZE: // 14
                                aPdu = new StopFreezePdu();
                                break;

                            case ACKNOWLEDGE: // 15
                                aPdu = new AcknowledgePdu();
                                break;

                            case ACTION_REQUEST: // 16
                                aPdu = new ActionRequestPdu();
                                break;

                            case ACTION_RESPONSE: // 17
                                aPdu = new ActionResponsePdu();
                                break;

                            case DATA_QUERY: // 18
                                aPdu = new DataQueryPdu();
                                break;

                            case SET_DATA: // 19
                                aPdu = new SetDataPdu();
                                break;

                            case DATA: // 20
                                aPdu = new DataPdu();
                                break;

                            case EVENT_REPORT: // 21
                                aPdu = new EventReportPdu();
                                break;

                            case ELECTROMAGNETIC_EMISSION: // 23
                                aPdu = new ElectromagneticEmissionPdu();
                                break;

                            case DESIGNATOR: // 24
                                aPdu = new DesignatorPdu();
                                break;

                            case TRANSMITTER: // 25
                                aPdu = new TransmitterPdu();
                                break;

                            case SIGNAL: // 26
                                aPdu = new SignalPdu();
                                break;

                            case RECEIVER: // 27
                                aPdu = new ReceiverPdu();
                                break;

                            case IDENTIFICATION_FRIEND_OR_FOE: // 28
                                aPdu = new IdentificationFriendOrFoePdu();
                                break;

                            case UNDERWATER_ACOUSTIC: // 29
                                aPdu = new UnderwaterAcousticPdu();
                                break;

                            case SUPPLEMENTAL_EMISSION_ENTITY_STATE: // 30
                                aPdu = new SupplementalEmissionEntityStatePdu();
                                break;

                            case INTERCOM_SIGNAL: // 31
                                aPdu = new IntercomSignalPdu();
                                break;

                            case INTERCOM_CONTROL: // 32
                                aPdu = new IntercomControlPdu();
                                break;

                            case AGGREGATE_STATE: // 33
                                aPdu = new AggregateStatePdu();
                                break;

                            case ISGROUPOF: // 34
                                aPdu = new IsGroupOfPdu();
                                break;

                            case TRANSFER_OWNERSHIP: // 35
                                aPdu = new TransferOwnershipPdu();
                                break;

                            case ISPARTOF: // 36
                                aPdu = new IsPartOfPdu();
                                break;

                            case MINEFIELD_STATE: // 37
                                aPdu = new MinefieldStatePdu();
                                break;

                            case MINEFIELD_QUERY: // 38
                                aPdu = new MinefieldQueryPdu();
                                break;

                            case MINEFIELD_DATA: // 39
                                aPdu = new MinefieldDataPdu();
                                break;

                            case MINEFIELD_RESPONSE_NACK: // 40
                                aPdu = new MinefieldResponseNACKPdu();
                                break;

                            case ENVIRONMENTAL_PROCESS: // 41
                                aPdu = new EnvironmentalProcessPdu();
                                break;

                            case GRIDDED_DATA: // 42
                                aPdu = new GriddedDataPdu();
                                break;

                            case POINT_OBJECT_STATE: // 43
                                aPdu = new PointObjectStatePdu();
                                break;

                            case LINEAR_OBJECT_STATE: // 44
                                aPdu = new LinearObjectStatePdu();
                                break;

                            case AREAL_OBJECT_STATE: // 45
                                aPdu = new ArealObjectStatePdu();
                                break;

                            case TIME_SPACE_POSITION_INFORMATION: // 46
                                aPdu = new TimeSpacePositionInformationPdu();
                                break;

                            case APPEARANCE: // 47
                                aPdu = new AppearancePdu();
                                break;

                            case ARTICULATED_PARTS: // 48
                                aPdu = new ArticulatedPartsPdu();
                                break;

                            case LIVE_ENTITY_FIRE: // 49
                                aPdu = new LiveEntityFirePdu();
                                break;

                            case LIVE_ENTITY_DETONATION: // 50
                                aPdu = new LiveEntityDetonationPdu();
                                break;

                            case CREATE_ENTITY_RELIABLE: // 51
                                aPdu = new CreateEntityReliablePdu();
                                break;

                            case REMOVE_ENTITY_RELIABLE: // 52
                                aPdu = new RemoveEntityReliablePdu();
                                break;

                            case START_RESUME_RELIABLE: // 53
                                aPdu = new StartResumeReliablePdu();
                                break;

                            case STOP_FREEZE_RELIABLE: // 54
                                aPdu = new StopFreezeReliablePdu();
                                break;

                            case ACKNOWLEDGE_RELIABLE: // 55
                                aPdu = new AcknowledgeReliablePdu();
                                break;

                            case ACTION_REQUEST_RELIABLE: // 56
                                aPdu = new ActionRequestReliablePdu();
                                break;

                            case ACTION_RESPONSE_RELIABLE: // 57
                                aPdu = new ActionResponseReliablePdu();
                                break;

                            case DATA_QUERY_RELIABLE: // 58
                                aPdu = new DataQueryReliablePdu();
                                break;

                            case SET_DATA_RELIABLE: // 59
                                aPdu = new SetDataReliablePdu();
                                break;

                            case DATA_RELIABLE: // 60
                                aPdu = new DataReliablePdu();
                                break;

                            case EVENT_REPORT_RELIABLE: // 61
                                aPdu = new EventReportReliablePdu();
                                break;

                            case COMMENT_RELIABLE: // 62
                                aPdu = new CommentReliablePdu();
                                break;

                            case RECORD_RELIABLE: // 63
                                aPdu = new RecordReliablePdu();
                                break;

                            case SET_RECORD_RELIABLE: // 64
                                aPdu = new SetRecordReliablePdu();
                                break;

                            case RECORD_QUERY_RELIABLE: // 65
                                aPdu = new RecordQueryReliablePdu();
                                break;

                            case COLLISION_ELASTIC: // 66
                                aPdu = new CollisionElasticPdu();
                                break;

                            case ENTITY_STATE_UPDATE: // 67
                                aPdu = new EntityStateUpdatePdu();
                                break;

                            case DIRECTED_ENERGY_FIRE: // 68
                                aPdu = new DirectedEnergyFirePdu();
                                break;

                            case ENTITY_DAMAGE_STATUS: // 69
                                aPdu = new EntityDamageStatusPdu();
                                break;

                            case INFORMATION_OPERATIONS_ACTION: // 70
                                aPdu = new InformationOperationsActionPdu();
                                break;

                            case INFORMATION_OPERATIONS_REPORT: // 71
                                aPdu = new InformationOperationsReportPdu();
                                break;

                            case ATTRIBUTE: // 72
                                aPdu = new AttributePdu();
                                break;

                            case COMMENT:
                                // aPdu = new CommentPdu(); // default for this switch logic

                                // see Garrett Loffelman and Pete Severson's code for OpenDis version 4 example
                                // https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/tree/master/assignments/src/MV3500Cohort2018JulySeptember/projects/LoeffelmanSeverson

                                CommentPdu    newCommentPdu = new CommentPdu();
                                ArrayList<VariableDatum> payloadList = new ArrayList<>();
                                ArrayList<String> commentsList = new ArrayList<>();
                                commentsList.add("Hello CommentPDU");
                                commentsList.add("Here is a second line of text in this comment.");
                                if (!commentsList.isEmpty())
                                    System.out.println("Preparing CommentPDU:");

                                for (String comment : commentsList)
                                {
                                    VariableDatum newVariableDatum = new VariableDatum();
                                    newVariableDatum.setVariableDatumValue (comment.getBytes());               // conversion
                                    // TODO confirm whether method overloading is appropriate
//                                  newVariableDatum.setVariableDatumLength(comment.getBytes().length); 
                                    newVariableDatum.setVariableDatumLengthInBytes(comment.getBytes().length); // also available in bits, see spec and javadoc
                                    // alternatively, you do not need to set this and the marshaller will figure it out from the byte array
                                    // (see javadoc for VariableDatum.setVariableDatumLength())
                                    payloadList.add(newVariableDatum);
                                    System.out.println("   \"" + comment + "\"");
                                }
                                newCommentPdu.setVariableDatums(payloadList);

                                aPdu = newCommentPdu; // hand off for sending
                                break;

                            default:
                                System.out.println("*** Warning: PDU " + pduTypeValue.getValue() + " " + pduTypeValue + " not supported, created or sent ");

                                // code generation block for this class follows:
    //                            System.out.println("                    case " + pdu + ": // " + pdu.getValue());
    //                            System.out.println("                        aPdu = new " + pdu.getDescription().replace(" ","").replace("-","").replace("/","") + 
    //                                                                                      "Pdu();");
    //                            System.out.println("                        break;");
    //                            System.out.println();
                        }
                        if (aPdu != null)
                        {
                            // leave aPdu timestamp at default value for consistency of output unit tests
                            generatedPdusList.add(aPdu); 
                        }   
                    }
                    catch (Exception e)
                    {
                        System.out.print("Exception thrown for PDU " + pduTypeValue.getValue() + " " + pduTypeValue);
                        System.out.print(Arrays.toString(e.getStackTrace()));
                        // continue looping
                    }
                }
                if (generatedPdusList.size() != 72) // TODO create an enumeration DISType.TOTAL_PDU_TYPES
                    System.out.println("Error: " + generatedPdusList.size() + " PDUs generated, but 72 PDUs expected.");

                // Send the PDUs we created
                System.out.println("Send the " + generatedPdusList.size() + " PDUs we created...");

                // =======================================================================
                // prior appproach
//                InetAddress localMulticastAddress = InetAddress.getByName(DEFAULT_MULTICAST_ADDRESS);
//                MulticastSocket multicastSocket = new MulticastSocket(DEFAULT_MULTICAST_PORT);
//                if (!localMulticastAddress.isMulticastAddress())
//                {
//                    throw new RuntimeException("*** Error: sending to multicast address, but destination address " + localMulticastAddress.toString() + "is not multicast");
//                }
//                multicastSocket.joinGroup(localMulticastAddress); // deprecated
                // =======================================================================
                // updated approach using NetworkInterface
                NetworkInterface networkInterface = NetworkInterface.getByInetAddress(multicastInetAddress);
                if (networkInterface != null)
                    System.out.println("networkInterface=" + networkInterface.getDisplayName()); // typically null if loopback
                SocketAddress localMulticastSocketAddress = new InetSocketAddress(multicastInetAddress, DEFAULT_MULTICAST_PORT);
                MulticastSocket multicastSocket = new MulticastSocket(DEFAULT_MULTICAST_PORT);
                multicastSocket.joinGroup(localMulticastSocketAddress, networkInterface);
                // =======================================================================

                byte[] buffer;
                Pdu aPdu;
                DatagramPacket packet;

                for (int idx = 0; idx < generatedPdusList.size(); idx++)
                {
                    // careful here!  keep object instantiations inside of loop to avoid endless array and packet growth
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    DataOutputStream       dos = new DataOutputStream(baos);
                
                    aPdu = generatedPdusList.get(idx);
                    try 
                    {
                        aPdu.marshal(dos); // dos is DataOutputStream connected to ByteArrayOutputStrea

                        buffer = baos.toByteArray();
                        packet = new DatagramPacket(buffer, buffer.length, multicastInetAddress, DEFAULT_MULTICAST_PORT);
                        multicastSocket.send(packet);
                        
                        DisPduType disPduType= aPdu.getPduType();
//                      disPduType.setTRACE(true);
                        String currentIndexPadded        = String.format("%2s",   (idx + 1));
                        String currentPduTypeValuePadded = String.format("%2s",   disPduType.getValue());
                        String currentPduTypePadded      = String.format("%-49s", aPdu.getPduType().toString()); // - indicates right padding of whitespace
                        String packetLengthPadded        = String.format("%3s",   packet.getLength());
                        
                        System.out.println ("Sent packet #" + currentIndexPadded + ", " + 
//                          currentPduTypeValuePadded + " " + 
                            currentPduTypePadded + 
                            "(packet.getLength()=" + packetLengthPadded + ")" + // diagnostic, beware of ever-growing packet size!
                            " of type " + aPdu.getClass().getSimpleName());

                        Thread.sleep(THREAD_SLEEP_INTERVAL); // pause for debugging, if zero this process still yields
                    } 
                    catch (Exception ex) {
                        System.out.println("Marshaling error" + ex);
                    }
                }
            }
            catch (IOException e)
            {
                System.out.println(e);
                return -1; // error condition
            }
        } // end repetion loop
            
        // TODO write the PDUs out to an XML file.
        //PduContainer container = new PduContainer();
        //container.setPdus(generatedPdus);
        //container.marshallToXml("examplePdus.xml");
        return generatedPdusList.size();
    }

    /**
     * Program invocation, execution starts here
     * @param args command-line arguments
     */
    public static void main(String args[])
	{
        AllPduSender allPduSender;
        int totalSentPdus;
            
        if (args.length == 2)
        {
            System.out.println("Usage:   AllPduSender <multicast group address> <port>");
            System.out.println("Actual:  AllPduSender  " + multicastInetAddress.getHostAddress() + "   " + port);
            allPduSender = new AllPduSender(args[0], Integer.parseInt(args[1]));
        } 
        else
        {
            System.out.println("Usage:   AllPduSender <multicast group address> <port>");
            System.out.println("Default: AllPduSender  " + DEFAULT_MULTICAST_ADDRESS + "   " + DEFAULT_MULTICAST_PORT);
            allPduSender = new AllPduSender(DEFAULT_MULTICAST_ADDRESS, DEFAULT_MULTICAST_PORT);
        }
        totalSentPdus = allPduSender.run(); // do it to it
        System.out.println("OpenDis7Examples.AllPduSender complete, sent " + totalSentPdus + " PDUs total.");
    }
}
