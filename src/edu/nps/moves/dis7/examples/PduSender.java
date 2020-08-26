package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.DISPDUType;
import edu.nps.moves.dis7.utilities.DisThreadedNetIF;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is an example that sends many/most types of PDUs. Useful for testing standards
 * compliance or getting a full set of PDUs. It used to also write generated PDUs 
 * to an XML file. TODO: revisit this capability?
 *<p>
 * This is legacy code ported to the edu.nps.moves.dis7 package
 * 
 * @author DMcG
 * @author Mike Bailey
 */
public class PduSender
{

  private int port;
  InetAddress multicastAddress;

  public PduSender(int port, String multicast)
  {
    try {
      this.port = port;
      multicastAddress = InetAddress.getByName(multicast);
      if (!multicastAddress.isMulticastAddress()) {
        System.out.println("Not a multicast address: " + multicast);
      }
    }
    catch (UnknownHostException e) {
      System.err.println("Unable to open socket: " + e);
    }
  }

  public void run()
  {
    try {
      List<Pdu> generatedPdus = new ArrayList<>();

      // Loop through all the enumerated PDU types, create a PDU for each type,
      // and add that PDU to a list.
      for (DISPDUType pdu : DISPDUType.values()) { // results are in alphabetic, not numeric order
          
        Pdu aPdu = null;

        switch (pdu) {

          case ACKNOWLEDGE:
            aPdu = new AcknowledgePdu();
            break;
          case ACKNOWLEDGE_RELIABLE:
            aPdu = new AcknowledgeReliablePdu();
            break;
          case ACTION_REQUEST:
            aPdu = new ActionRequestPdu();
            break;
          case ACTION_REQUEST_RELIABLE:
            aPdu = new ActionRequestReliablePdu();
            break;
          case ACTION_RESPONSE:
            aPdu = new ActionResponsePdu();
            break;
          case ACTION_RESPONSE_RELIABLE:
            aPdu = new ActionResponseReliablePdu();
            break;
          case AGGREGATE_STATE:
            aPdu = new AggregateStatePdu();
            break;
          case APPEARANCE:
            aPdu = new AppearancePdu();
            break;
          case AREAL_OBJECT_STATE:
            aPdu = new ArealObjectStatePdu();
            break;
          case ARTICULATED_PARTS:
            aPdu = new ArticulatedPartsPdu();
            break;
          case ATTRIBUTE:
            aPdu = new AttributePdu();
            break;
          case COLLISION:
            aPdu = new CollisionPdu();
            break;
          case COLLISION_ELASTIC:
            aPdu = new CollisionElasticPdu();
            break;
          case COMMENT:
            aPdu = new CommentPdu();
            break;
          case COMMENT_RELIABLE:
            aPdu = new CommentReliablePdu();
            break;
          case CREATE_ENTITY:
            aPdu = new CreateEntityPdu();
            break;
          case CREATE_ENTITY_RELIABLE:
            aPdu = new CreateEntityReliablePdu();
            break;
          case DATA:
            aPdu = new DataPdu();
            break;
          case DATA_QUERY:
            aPdu = new DataQueryPdu();
            break;
          case DATA_QUERY_RELIABLE:
            aPdu = new DataQueryReliablePdu();
            break;
          case DATA_RELIABLE:
            aPdu = new DataReliablePdu();
            break;
          case DESIGNATOR:
            aPdu = new DesignatorPdu();
            break;
          case DETONATION:
            aPdu = new DetonationPdu();
            break;
          case DIRECTED_ENERGY_FIRE:
            aPdu = new DirectedEnergyFirePdu();
            break;
          case ELECTROMAGNETIC_EMISSION:
            aPdu = new ElectromagneticEmissionPdu();
            break;
          case ENTITY_DAMAGE_STATUS:
            aPdu = new EntityDamageStatusPdu();
            break;
          case ENTITY_STATE:
            aPdu = new EntityStatePdu();
            break;
          case ENTITY_STATE_UPDATE:
            aPdu = new EntityStateUpdatePdu();
            break;
          case ENVIRONMENTAL_PROCESS:
            aPdu = new EnvironmentalProcessPdu();
            break;
          case EVENT_REPORT:
            aPdu = new EventReportPdu();
            break;
          case EVENT_REPORT_RELIABLE:
            aPdu = new EventReportReliablePdu();
            break;
          case FIRE:
            aPdu = new FirePdu();
            break;
          case GRIDDED_DATA:
            aPdu = new GriddedDataPdu();
            break;
          case IDENTIFICATION_FRIEND_OR_FOE:
            aPdu = new IdentificationFriendOrFoePdu(); // alternatively, aPdu = new IFFPdu();
            break;
          case INFORMATION_OPERATIONS_ACTION:
            aPdu = new InformationOperationsActionPdu();
            break;
          case INFORMATION_OPERATIONS_REPORT:
            aPdu = new InformationOperationsReportPdu();
            break;
          case INTERCOM_CONTROL:
            aPdu = new IntercomControlPdu();
            break;
          case INTERCOM_SIGNAL:
            aPdu = new IntercomSignalPdu();
            break;
          case ISGROUPOF:
            aPdu = new IsGroupOfPdu();
            break;
          case ISPARTOF:
            aPdu = new IsPartOfPdu();
            break;
          case LINEAR_OBJECT_STATE:
            aPdu = new LinearObjectStatePdu();
            break;
          case LIVE_ENTITY_DETONATION:
            aPdu = new LiveEntityDetonationPdu();
            break;
          case LIVE_ENTITY_FIRE:
            aPdu = new LiveEntityFirePdu();
            break;
          case MINEFIELD_DATA:
            aPdu = new MinefieldDataPdu();
            break;
          case MINEFIELD_QUERY:
            aPdu = new MinefieldQueryPdu();
            break;
          case MINEFIELD_RESPONSE_NACK:
            aPdu = new MinefieldResponseNACKPdu();
            break;
          case MINEFIELD_STATE:
            aPdu = new MinefieldStatePdu();
            break;
          case POINT_OBJECT_STATE:
            aPdu = new PointObjectStatePdu();
            break;
          case RECEIVER:
            aPdu = new ReceiverPdu();
            break;
          case RECORD_QUERY_RELIABLE:
            aPdu = new RecordQueryReliablePdu();
            break;
          case RECORD_RELIABLE:
            aPdu = new RecordReliablePdu();
            break;
          case REMOVE_ENTITY:
            aPdu = new RemoveEntityPdu();
            break;
          case REMOVE_ENTITY_RELIABLE:
            aPdu = new RemoveEntityReliablePdu();
            break;
          case REPAIR_COMPLETE:
            aPdu = new RepairCompletePdu();
            break;
          case REPAIR_RESPONSE:
            aPdu = new RepairResponsePdu();
            break;
          case RESUPPLY_CANCEL:
            aPdu = new ResupplyCancelPdu();
            break;
          case RESUPPLY_OFFER:
            aPdu = new ResupplyOfferPdu();
            break;
          case RESUPPLY_RECEIVED:
            aPdu = new ResupplyReceivedPdu();
            break;
          case SERVICE_REQUEST:
            aPdu = new ServiceRequestPdu();
            break;
          case SET_DATA:
            aPdu = new SetDataPdu();
            break;
          case SET_DATA_RELIABLE:
            aPdu = new SetDataReliablePdu();
            break;
          case SET_RECORD_RELIABLE:
            aPdu = new SetRecordReliablePdu();
            break;
          case SIGNAL:
            aPdu = new SignalPdu();
            break;
          case START_RESUME:
            aPdu = new StartResumePdu();
            break;
          case START_RESUME_RELIABLE:
            aPdu = new StartResumeReliablePdu();
            break;
          case STOP_FREEZE:
            aPdu = new StopFreezePdu();
            break;
          case STOP_FREEZE_RELIABLE:
            aPdu = new StopFreezeReliablePdu();
            break;
          case SUPPLEMENTAL_EMISSION_ENTITY_STATE:
            aPdu = new SupplementalEmissionEntityStatePdu(); // alternatively, aPdu = new SEESPdu();
            break;
          case TIME_SPACE_POSITION_INFORMATION:
            aPdu = new TimeSpacePositionInformationPdu(); // alternatively, aPdu = new TSPIPdu();
            break;
          case TRANSFER_OWNERSHIP:
            aPdu = new TransferOwnershipPdu();
            break;
          case TRANSMITTER:
            aPdu = new TransmitterPdu();
            break;
          case UNDERWATER_ACOUSTIC:
            aPdu = new UnderwaterAcousticPdu();
            break;

          default:
            System.out.print("PDU of type " + pdu + " not created or sent ");
            System.out.println();
        }

        if (aPdu != null) {
          generatedPdus.add(aPdu);
        }
      }

      // Sort the created PDUs by class name
      Collections.sort(generatedPdus, new ClassNameComparator());

      // Send the PDUs we created
      DatagramPacket packet;
      MulticastSocket socket = new MulticastSocket();
      InetSocketAddress group = new InetSocketAddress(multicastAddress, port);
      socket.joinGroup(group, DisThreadedNetIF.findIpv4Interface());

      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      DataOutputStream dos = new DataOutputStream(baos);
      byte[] buffer;
      int pduCounter = 0;
      
      for (Pdu pdu : generatedPdus) {

//      Thread.sleep(300); // debug
        pduCounter++;
        pdu.marshal(dos);

        buffer = baos.toByteArray();
        packet = new DatagramPacket(buffer, buffer.length, group);
        socket.send(packet);

        System.out.println(pduCounter + ".  Sent PDU of type " + pdu.getPduType().getValue() + " "+ pdu.getClass().getSimpleName());
        baos.reset();
      }

      // write the PDUs out to an XML file.
      //PduContainer container = new PduContainer();
      //container.setPdus(generatedPdus);
      //container.marshallToXml("examplePdus.xml");
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }

  public static void main(String args[])
  {
    PduSender sender;
    if (args.length == 2) {
      sender = new PduSender(Integer.parseInt(args[0]), args[1]);
    }
    else {
      System.out.println("Usage:   AlphabeticalPduSender <port> <multicast group>");
      System.out.println("Default: AlphabeticalPduSender  " + DisThreadedNetIF.DEFAULT_DIS_PORT + "   " + DisThreadedNetIF.DEFAULT_MULTICAST_ADDRESS);
      sender = new PduSender(DisThreadedNetIF.DEFAULT_DIS_PORT, DisThreadedNetIF.DEFAULT_MULTICAST_ADDRESS);
    }
    sender.run();
  }
}
