/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

/**
 * This is a test class (which can also be run through its main() method) which tests round-tripping of pdus, i.e.,
 * creating a pdu instance in java, serializing it and sending over the network as a stream of bytes, at the same time
 * reading them back from the net.  It also uses the pdu logger in the Player class to save the received pdus to disk.
 * 
 * Two tests for pdu equivalency are performed:
 * 1.  Sent vs. received
 * 2.  Sent vs. persisted
 * 
 * @author Mike Bailey, jmbailey@edu.nps.edu
 * @version $Id$
 */
import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.enumerations.DISPDUType;
import edu.nps.moves.dis7.utilities.DisThreadedNetIF;
import edu.nps.moves.dis7.utilities.PduFactory;
import edu.nps.moves.dis7.utilities.stream.PduPlayer;
import edu.nps.moves.dis7.utilities.stream.PduRecorder;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("All Pdu Round Trip Test")
public class AllPduRoundTripTest
{
  private PduFactory pduFactory;

  @BeforeAll
  public static void beforeAllTests()
  {
    System.out.println("AllPduRoundTripTest");
  }

  @AfterAll
  public static void afterAllTests()
  {
  }

  @BeforeEach
  public void setUp()
  {
  }

  @AfterEach
  public void tearDown()
  {
  }

  @Test
  public void testRoundTripAllPdus()
  {
    Throwable ex = null;
    try {
      setupSenderRecorder();
      
      pduFactory = new PduFactory(Country.PHILIPPINES_PHL, (byte) 11, (byte) 22, (short) 33, true);

      sendOnePdu(pduFactory.makeAcknowledgePdu());
      sendOnePdu(pduFactory.makeAcknowledgeReliablePdu());
      sendOnePdu(pduFactory.makeActionRequestPdu());
      sendOnePdu(pduFactory.makeActionRequestReliablePdu());
      sendOnePdu(pduFactory.makeActionResponsePdu());
      sendOnePdu(pduFactory.makeActionResponseReliablePdu());
      sendOnePdu(pduFactory.makeAggregateStatePdu());
      sendOnePdu(pduFactory.makeAppearancePdu());
      sendOnePdu(pduFactory.makeArealObjectStatePdu());
      sendOnePdu(pduFactory.makeArticulatedPartsPdu());
      sendOnePdu(pduFactory.makeAttributePdu());
      sendOnePdu(pduFactory.makeCollisionElasticPdu());
      sendOnePdu(pduFactory.makeCollisionPdu());
      sendOnePdu(pduFactory.makeCommentPdu());
      sendOnePdu(pduFactory.makeCommentReliablePdu());
      sendOnePdu(pduFactory.makeCreateEntityPdu());
      sendOnePdu(pduFactory.makeCreateEntityReliablePdu());
      sendOnePdu(pduFactory.makeDataPdu());
      sendOnePdu(pduFactory.makeDataQueryPdu());
      sendOnePdu(pduFactory.makeDataQueryReliablePdu());
      sendOnePdu(pduFactory.makeDataReliablePdu());
      sendOnePdu(pduFactory.makeDesignatorPdu());
      sendOnePdu(pduFactory.makeDetonationPdu());
      sendOnePdu(pduFactory.makeDirectedEnergyFirePdu());
      sendOnePdu(pduFactory.makeElectronicEmissionsPdu());
      sendOnePdu(pduFactory.makeEntityDamageStatusPdu());
      sendOnePdu(pduFactory.makeEntityStatePdu());
      sendOnePdu(pduFactory.makeEntityStateUpdatePdu());
      sendOnePdu(pduFactory.makeEnvironmentalProcessPdu());
      sendOnePdu(pduFactory.makeEventReportPdu());
      sendOnePdu(pduFactory.makeEventReportReliablePdu());
      sendOnePdu(pduFactory.makeFirePdu());
      sendOnePdu(pduFactory.makeGriddedDataPdu());
      sendOnePdu(pduFactory.makeIffPdu());
      sendOnePdu(pduFactory.makeInformationOperationsReportPdu());
      sendOnePdu(pduFactory.makeInformationOperationsActionPdu());
      sendOnePdu(pduFactory.makeIntercomControlPdu());
      sendOnePdu(pduFactory.makeIntercomSignalPdu());
      sendOnePdu(pduFactory.makeIsGroupOfPdu());
      sendOnePdu(pduFactory.makeIsPartOfPdu());
      sendOnePdu(pduFactory.makeLEDetonationPdu());
      sendOnePdu(pduFactory.makeLEFirePdu());
      sendOnePdu(pduFactory.makeLinearObjectStatePdu());
      sendOnePdu(pduFactory.makeMinefieldDataPdu());
      sendOnePdu(pduFactory.makeMinefieldQueryPdu());
      sendOnePdu(pduFactory.makeMinefieldResponseNackPdu());
      sendOnePdu(pduFactory.makeMinefieldStatePdu());
      sendOnePdu(pduFactory.makePointObjectStatePdu());
      sendOnePdu(pduFactory.makeReceiverPdu());
      sendOnePdu(pduFactory.makeRecordQueryReliablePdu());
      sendOnePdu(pduFactory.makeRecordReliablePdu());
      sendOnePdu(pduFactory.makeRemoveEntityPdu());
      sendOnePdu(pduFactory.makeRemoveEntityReliablePdu());
      sendOnePdu(pduFactory.makeRepairCompletePdu());
      sendOnePdu(pduFactory.makeRepairResponsePdu());
      sendOnePdu(pduFactory.makeResupplyCancelPdu());
      sendOnePdu(pduFactory.makeResupplyOfferPdu());
      sendOnePdu(pduFactory.makeResupplyReceivedPdu());
      sendOnePdu(pduFactory.makeSeesPdu());
      sendOnePdu(pduFactory.makeServiceRequestPdu());
      sendOnePdu(pduFactory.makeSetDataPdu());
      sendOnePdu(pduFactory.makeSetDataReliablePdu());
      sendOnePdu(pduFactory.makeSetRecordReliablePdu());
      sendOnePdu(pduFactory.makeSignalPdu());
      sendOnePdu(pduFactory.makeStartResumePdu());
      sendOnePdu(pduFactory.makeStartResumeReliablePdu());
      sendOnePdu(pduFactory.makeStopFreezePdu());
      sendOnePdu(pduFactory.makeStopFreezeReliablePdu());
      sendOnePdu(pduFactory.makeTransferOwnershipPdu());
      sendOnePdu(pduFactory.makeTransmitterPdu());
      sendOnePdu(pduFactory.makeTspiPdu());
      sendOnePdu(pduFactory.makeUnderwaterAcousticPdu());

      //sleep(100L); // go sender/receiver go!  is this enough time to receive?
                    
      // TODO is there a more reliable way to determine whether receiver is complete?

      shutDownSenderRecorder();
      
      System.out.println("pduReceivedMap.size()=" + pduReceivedMap.size() + ", pduSentMap.size()=" + pduSentMap.size() + 
           ", match=" + (pduReceivedMap.size() == pduSentMap.size()));
           
      assertEquals(pduReceivedMap.size(), pduSentMap.size(), "No pdus, or not all sent pdus, received");

      testForEquals();
      
      Semaphore mutex = new Semaphore(1);
      getAllFromRecorder(mutex);
      mutex.acquire(); // wait until above method is done
      
      testRecorderForEquals();
    }
    catch (Exception t) {
      ex = t;
      System.err.println(t.getLocalizedMessage());
      t.printStackTrace(System.err);
    }

    assertNull(ex, "Exception should be null if successful creation of all objects");
  }

  private Map<DISPDUType, Pdu> pduSentMap = new HashMap<>();
  private Map<DISPDUType, Pdu> pduReceivedMap = new HashMap<>();
  private Map<DISPDUType, Pdu> pduReadMap = new HashMap<>();

  DisThreadedNetIF disnetworking;
  PduRecorder recorder;

  private void sendOnePdu(Pdu pdu)
  {
    pduSentMap.put(pdu.getPduType(), pdu);
    if (pdu.getPduType() == DISPDUType.OTHER)
        System.out.println ("*** Note: DISPDUType.OTHER not supported");
    disnetworking.send(pdu);
//    sleep(100L); // TODO debugging
  }
  
  private void setupSenderRecorder() throws Exception
  { 
    recorder = new PduRecorder(); // default mcaddr, port, logfile dir
    disnetworking = recorder.getDisThreadedNetIF();
    
    // When the DisThreadedNetIF receives a pdu, a call is made to the
    // everyTypeListeners which makes a lamba call back here to record received
    // pdus
    disnetworking.addListener(pdu -> {
        pduReceivedMap.put(pdu.getPduType(), pdu);
    });
    System.out.println("Recorder log at " + recorder.getLogFile());
  }

  /** Will shutdown the common send/receive network interface */
  private void shutDownSenderRecorder() throws Exception
  {
    recorder.end();
  }

  private void testForEquals() throws Exception
  {
    assertEquals(pduSentMap.size(), pduReceivedMap.size(), "Different number of pdus received than sent");
    assertIterableEquals(pduSentMap.keySet(), pduReceivedMap.keySet(), "Sent and received pdus not identical");
    
    // TODO is this sufficient?  has each PDU value been compared as well?
  }

  private void getAllFromRecorder(Semaphore sem) throws Exception
  {
    sem.acquire();
    Path path = Path.of(recorder.getLogFile()).getParent();
    PduPlayer player = new PduPlayer(disnetworking.getMcastGroup(), disnetworking.getDisPort(), path);
    player.sendToNet(false);
    player.addRawListener(ba -> {
      if (ba != null) {
        Pdu pdu = pduFactory.createPdu(ba);
        pduReadMap.put(pdu.getPduType(), pdu);
      }
      else {
        player.end();
        sem.release();
      }
    });

    player.startResume();
  }

  private void testRecorderForEquals() throws Exception
  {
    assertEquals(pduSentMap.size(), pduReadMap.size(), "Different number of pdus sent than read");
    assertIterableEquals(pduSentMap.keySet(), pduReadMap.keySet(), "Sent and read pdus not identical");
    
    // TODO is this sufficient?  has each PDU value been compared as well?
  }
  
//@formatter:off
  private void sleep(long ms)
  {
    try {
        Thread.sleep(ms);
    }
    catch (InterruptedException ex) {}
  }
//@formatter:on
  
  public static void main(String[] args)
  {
    new AllPduRoundTripTest().testRoundTripAllPdus();
  }
}
