/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */
package edu.nps.moves.dis7;

/**
 * This is a test class (which can also be run through its main() method) which tests round-tripping of pdus, i.e.,
 * creating a pdu instance in java, serializing it and sending over the network as a stream of bytes, at the same time
 * reading them back from the net.  It also uses the pdu logger in the Player class to  save the received pdus to disk.
 * 
 * Two tests for pdu equivalency are performed:
 * 1.  Sent vs. received
 * 2.  Sent vs. persisted
 * 
 * @author Mike Bailey, jmbailey@edu.nps.edu
 * @version $Id$
 */
import com.google.common.io.Files;
import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.enumerations.DISPDUType;
import edu.nps.moves.dis7.util.DisThreadedNetIF;
import edu.nps.moves.dis7.util.PduFactory;
import edu.nps.moves.dis7.util.playerrecorder.Player;
import edu.nps.moves.dis7.util.playerrecorder.Recorder;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("All Pdu Round Trip Test")

public class AllPduRoundTripTest
{
  private PduFactory fact;

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
      setupReceiver();
      setupRecorder();
        try {
            Thread.sleep(250L); // these have to be fully setup before continuing
        } 
        catch (InterruptedException ex2) {
        }
      
      fact = new PduFactory(Country.PHILIPPINES_PHL, (byte) 11, (byte) 22, (short) 33, true);

      sendOne(fact.makeAcknowledgePdu()); // TODO never received ??!!
      sendOne(fact.makeAcknowledgeReliablePdu());
      sendOne(fact.makeActionRequestPdu());
      sendOne(fact.makeActionRequestReliablePdu());
      sendOne(fact.makeActionResponsePdu());
      sendOne(fact.makeActionResponseReliablePdu());
      sendOne(fact.makeAggregateStatePdu());
      sendOne(fact.makeAppearancePdu());
      sendOne(fact.makeArealObjectStatePdu());
      sendOne(fact.makeArticulatedPartsPdu());
      sendOne(fact.makeAttributePdu());
      sendOne(fact.makeCollisionElasticPdu());
      sendOne(fact.makeCollisionPdu());
      sendOne(fact.makeCommentPdu());
      sendOne(fact.makeCommentReliablePdu());
      sendOne(fact.makeCreateEntityPdu());
      sendOne(fact.makeCreateEntityReliablePdu());
      sendOne(fact.makeDataPdu());
      sendOne(fact.makeDataQueryPdu());
      sendOne(fact.makeDataQueryReliablePdu());
      sendOne(fact.makeDataReliablePdu());
      sendOne(fact.makeDesignatorPdu());
      sendOne(fact.makeDetonationPdu());
      sendOne(fact.makeDirectedEnergyFirePdu());
      sendOne(fact.makeElectronicEmissionsPdu());
      sendOne(fact.makeEntityDamageStatusPdu());
      sendOne(fact.makeEntityStatePdu());
      sendOne(fact.makeEntityStateUpdatePdu());
      sendOne(fact.makeEnvironmentalProcessPdu());
      sendOne(fact.makeEventReportPdu());
      sendOne(fact.makeEventReportReliablePdu());
      sendOne(fact.makeFirePdu());
      sendOne(fact.makeGriddedDataPdu());
      sendOne(fact.makeIffPdu());
      sendOne(fact.makeInformationOperationsReportPdu());
      sendOne(fact.makeInformationOperationsActionPdu());
      sendOne(fact.makeIntercomControlPdu());
      sendOne(fact.makeIntercomSignalPdu());
      sendOne(fact.makeIsGroupOfPdu());
      sendOne(fact.makeIsPartOfPdu());
      sendOne(fact.makeLEDetonationPdu());
      sendOne(fact.makeLEFirePdu());
      sendOne(fact.makeLinearObjectStatePdu());
      sendOne(fact.makeMinefieldDataPdu());
      sendOne(fact.makeMinefieldQueryPdu());
      sendOne(fact.makeMinefieldResponseNackPdu());
      sendOne(fact.makeMinefieldStatePdu());
      sendOne(fact.makePointObjectStatePdu());
      sendOne(fact.makeReceiverPdu());
      sendOne(fact.makeRecordQueryReliablePdu());
      sendOne(fact.makeRecordReliablePdu());
      sendOne(fact.makeRemoveEntityPdu());
      sendOne(fact.makeRemoveEntityReliablePdu());
      sendOne(fact.makeRepairCompletePdu());
      sendOne(fact.makeRepairResponsePdu());
      sendOne(fact.makeResupplyCancelPdu());
      sendOne(fact.makeResupplyOfferPdu());
      sendOne(fact.makeResupplyReceivedPdu());
      sendOne(fact.makeSeesPdu());
      sendOne(fact.makeServiceRequestPdu());
      sendOne(fact.makeSetDataPdu());
      sendOne(fact.makeSetDataReliablePdu());
      sendOne(fact.makeSetRecordReliablePdu());
      sendOne(fact.makeSignalPdu());
      sendOne(fact.makeStartResumePdu());
      sendOne(fact.makeStartResumeReliablePdu());
      sendOne(fact.makeStopFreezePdu());
      sendOne(fact.makeStopFreezeReliablePdu());
      sendOne(fact.makeTransferOwnershipPdu());
      sendOne(fact.makeTransmitterPdu());
      sendOne(fact.makeTspiPdu());
      sendOne(fact.makeUnderwaterAcousticPdu());

      //sleep(100L); // go sender/receiver go!  is this enough time to receive?
        try {
            Thread.sleep(250L); // TODO shouldn't this kind of delay timing be in a DIS sender class?
        } 
        catch (InterruptedException ex2) {
        }
                    
      // TODO is there a more reliable way to determine whether receiver is complete?

      shutDownReceiver(); // TODO hopefully this finishes reading the pending buffer before shutting down
      shutDownRecorder();
      
      System.out.println("pduReceivedMap.size()=" + pduReceivedMap.size() + ", pduSentMap.size()=" + pduSentMap.size() + 
           ", match=" + (pduReceivedMap.size() == pduSentMap.size()));
           

      assertTrue(pduReceivedMap.size() == pduSentMap.size(),"No pdus, or not all sent pdus, received"); // TODO debugger fails??

      testForEquals();
      
      Semaphore mutex = new Semaphore(1);
      getAllFromRecorder(mutex);
      mutex.acquire(); // wait until above method is done
      
      testRecorderForEquals();
    }
    catch (Throwable t) {
      ex = t;
      System.out.println(t.getLocalizedMessage());
      t.printStackTrace();
    }

    assertNull(ex, "Exception should be null if successful creation of all objects");
  }

  private File recorderDirectory;
  private HashMap<DISPDUType, Pdu> pduSentMap = new HashMap<>();
  private HashMap<DISPDUType, Pdu> pduReceivedMap = new HashMap<>();
  private HashMap<DISPDUType, Pdu> pduReadMap = new HashMap<>();

  DisThreadedNetIF disnetworking;
  Recorder recorder;

  private void setupReceiver()
  {
    disnetworking = new DisThreadedNetIF();
    disnetworking.addListener(pdu -> {
      pduReceivedMap.put(pdu.getPduType(), pdu);
    });
  }

  private void shutDownReceiver()
  {
    disnetworking.kill();
  }

  private void sendOne(Pdu pdu)
  {
    pduSentMap.put(pdu.getPduType(), pdu);
    if (pdu.getPduType() == DISPDUType.OTHER)
        System.out.println ("*** Note: DISPDUType.OTHER not supported");
    disnetworking.send(pdu);
    sleep(100L); // TODO debugging
  }

  private void setupRecorder() throws Exception
  {
    recorderDirectory = Files.createTempDir();
    recorder = new Recorder(recorderDirectory.getAbsolutePath(), disnetworking.getMcastGroup(), disnetworking.getDisPort());
    System.out.println("Recorder log at " + recorderDirectory.getAbsolutePath());
  }

  private void shutDownRecorder() throws Exception
  {
    recorder.end();
  }

  private void testForEquals() throws Exception
  {
    assertEquals(pduSentMap.size(), pduReceivedMap.size(), "Different number of pdus received than sent");

    pduSentMap.keySet().forEach(typ -> assertTrue(pduSentMap.get(typ).equals(pduReceivedMap.get(typ)), "Sent and received pdus not identical"));
    
    // TODO is this sufficient?  has each PDU value been compared as well?
  }

  private void getAllFromRecorder(Semaphore sem) throws Exception
  {
    sem.acquire();
    Player player = new Player(disnetworking.getMcastGroup(), disnetworking.getDisPort(), recorderDirectory.toPath());
    player.sendToNet(false);
    player.addRawListener(ba -> {
      if (ba != null) {
        Pdu pdu = fact.createPdu(ba);
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

    pduSentMap.keySet().forEach(typ -> assertTrue(pduSentMap.get(typ).equals(pduReadMap.get(typ)), "Sent and read pdus not identical"));
    
    // TODO is this sufficient?  has each PDU value been compared as well?
  }
  
//@formatter:off
  private void sleep(long ms)
  {
    try {Thread.sleep(ms);}catch (InterruptedException ex) {}
  }
//@formatter:on
  
  public static void main(String[] args)
  {
    new AllPduRoundTripTest().testRoundTripAllPdus();
  }
}
