/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;
import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.PduFactory;
import edu.nps.moves.dis7.utilities.stream.PduPlayer;
import edu.nps.moves.dis7.utilities.stream.PduRecorder;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

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

@DisplayName("All Pdu Round Trip Test")
public class AllPduRoundTripTest
{
  DisThreadedNetworkInterface disNetworkInterface;
  DisThreadedNetworkInterface.PduListener pduListener;
  List<Pdu> pdusSent = new ArrayList<>();
  List<Pdu> pdusReceived = new ArrayList<>();
  List<Pdu> pdusRead = new ArrayList<>();
  PduFactory pduFactory;
  PduRecorder pduRecorder;

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
    public void setUp() {
        File file = new File("./pduLog");

        for (File subFile : file.listFiles()) {
            subFile.delete();
        }
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
      System.out.println ("*** AllPduRoundTripTest testRoundTripAllPdus() start...");
      setupSenderRecorder();
      
      pduFactory = new PduFactory(Country.PHILIPPINES_PHL, (byte) 11, (byte) 22, (short) 33, PduFactory.TimestampStyle.IEEE_ABSOLUTE);

      pdusSent.add(pduFactory.makeAcknowledgePdu());
      pdusSent.add(pduFactory.makeAcknowledgeReliablePdu());
      pdusSent.add(pduFactory.makeActionRequestPdu());
      pdusSent.add(pduFactory.makeActionRequestReliablePdu());
      pdusSent.add(pduFactory.makeActionResponsePdu());
      pdusSent.add(pduFactory.makeActionResponseReliablePdu());
      pdusSent.add(pduFactory.makeAggregateStatePdu());
      pdusSent.add(pduFactory.makeAppearancePdu());
      pdusSent.add(pduFactory.makeArealObjectStatePdu());
      pdusSent.add(pduFactory.makeArticulatedPartsPdu());
      pdusSent.add(pduFactory.makeAttributePdu());
      pdusSent.add(pduFactory.makeCollisionElasticPdu());
      pdusSent.add(pduFactory.makeCollisionPdu());
      pdusSent.add(pduFactory.makeCommentPdu());
      pdusSent.add(pduFactory.makeCommentReliablePdu());
      pdusSent.add(pduFactory.makeCreateEntityPdu());
      pdusSent.add(pduFactory.makeCreateEntityReliablePdu());
      pdusSent.add(pduFactory.makeDataPdu());
      pdusSent.add(pduFactory.makeDataQueryPdu());
      pdusSent.add(pduFactory.makeDataQueryReliablePdu());
      pdusSent.add(pduFactory.makeDataReliablePdu());
      pdusSent.add(pduFactory.makeDesignatorPdu());
      pdusSent.add(pduFactory.makeDetonationPdu());
      pdusSent.add(pduFactory.makeDirectedEnergyFirePdu());
      pdusSent.add(pduFactory.makeElectronicEmissionsPdu());
      pdusSent.add(pduFactory.makeEntityDamageStatusPdu());
      pdusSent.add(pduFactory.makeEntityStatePdu());
      pdusSent.add(pduFactory.makeEntityStateUpdatePdu());
      pdusSent.add(pduFactory.makeEnvironmentalProcessPdu());
      pdusSent.add(pduFactory.makeEventReportPdu());
      pdusSent.add(pduFactory.makeEventReportReliablePdu());
      pdusSent.add(pduFactory.makeFirePdu());
      pdusSent.add(pduFactory.makeGriddedDataPdu());
      pdusSent.add(pduFactory.makeIffPdu());
      pdusSent.add(pduFactory.makeInformationOperationsReportPdu());
      pdusSent.add(pduFactory.makeInformationOperationsActionPdu());
      pdusSent.add(pduFactory.makeIntercomControlPdu());
      pdusSent.add(pduFactory.makeIntercomSignalPdu());
      pdusSent.add(pduFactory.makeIsGroupOfPdu());
      pdusSent.add(pduFactory.makeIsPartOfPdu());
      pdusSent.add(pduFactory.makeLEDetonationPdu());
      pdusSent.add(pduFactory.makeLEFirePdu());
      pdusSent.add(pduFactory.makeLinearObjectStatePdu());
      pdusSent.add(pduFactory.makeMinefieldDataPdu());
      pdusSent.add(pduFactory.makeMinefieldQueryPdu());
      pdusSent.add(pduFactory.makeMinefieldResponseNackPdu());
      pdusSent.add(pduFactory.makeMinefieldStatePdu());
      pdusSent.add(pduFactory.makePointObjectStatePdu());
      pdusSent.add(pduFactory.makeReceiverPdu());
      pdusSent.add(pduFactory.makeRecordQueryReliablePdu());
      pdusSent.add(pduFactory.makeRecordReliablePdu());
      pdusSent.add(pduFactory.makeRemoveEntityPdu());
      pdusSent.add(pduFactory.makeRemoveEntityReliablePdu());
      pdusSent.add(pduFactory.makeRepairCompletePdu());
      pdusSent.add(pduFactory.makeRepairResponsePdu());
      pdusSent.add(pduFactory.makeResupplyCancelPdu());
      pdusSent.add(pduFactory.makeResupplyOfferPdu());
      pdusSent.add(pduFactory.makeResupplyReceivedPdu());
      pdusSent.add(pduFactory.makeSeesPdu());
      pdusSent.add(pduFactory.makeServiceRequestPdu());
      pdusSent.add(pduFactory.makeSetDataPdu());
      pdusSent.add(pduFactory.makeSetDataReliablePdu());
      pdusSent.add(pduFactory.makeSetRecordReliablePdu());
      pdusSent.add(pduFactory.makeSignalPdu());
      pdusSent.add(pduFactory.makeStartResumePdu());
      pdusSent.add(pduFactory.makeStartResumeReliablePdu());
      pdusSent.add(pduFactory.makeStopFreezePdu());
      pdusSent.add(pduFactory.makeStopFreezeReliablePdu());
      pdusSent.add(pduFactory.makeTransferOwnershipPdu());
      pdusSent.add(pduFactory.makeTransmitterPdu());
      pdusSent.add(pduFactory.makeTspiPdu());
      pdusSent.add(pduFactory.makeUnderwaterAcousticPdu());
      
      pdusSent.forEach(p -> {
          disNetworkInterface.send(p);
          sleep(200l); // give receiver time to process, longer time needed when in debug mode
      });
      System.out.println ("*** AllPduRoundTripTest testRoundTripAllPdus() all PDUs sent, shutDownSenderRecorder()");

      shutDownSenderRecorder();
      
      System.out.println("pdusSent.size()=" + pdusSent.size() + ", pdusReceived.size()=" + pdusReceived.size() + 
           ", match=" + (pdusSent.size() == pdusReceived.size()));
        
      testForEquals();
      
//      testRecorderForEquals(); // TODO not tested successfully
    }
    catch (Exception t) {
      ex = t;
      System.err.println(t.getLocalizedMessage());
      t.printStackTrace(System.err);
    }

    assertNull(ex, "Exception should be null if successful creation of all objects");
    
    System.out.println ("*** AllPduRoundTripTest testRoundTripAllPdus() complete");
  }
  
    private void setupSenderRecorder() throws Exception {
        pduRecorder = new PduRecorder(); // default network address, port, logfile dir
        pduRecorder.setDescriptor(this.getClass().getName() + " unit test");
        pduRecorder.start();
        disNetworkInterface = pduRecorder.getDisThreadedNetworkInterface();

        // When the DisThreadedNetworkInterface receives a pdu, a call is made to the
        // everyTypeListeners which makes a lamba call back here to capture received
        // pdus
        pduListener = new DisThreadedNetworkInterface.PduListener() {
            @Override
            public void incomingPdu(Pdu pdu) {
                if (!pdusReceived.contains(pdu)) {
                    pdusReceived.add(pdu);
                }
            }
        };
        disNetworkInterface.addListener(pduListener);
        System.out.println("Recorder log at " + pduRecorder.getLogFilePath());
    }

  /** Will shutdown the common send/receive network interface */
  private void shutDownSenderRecorder() throws Exception
  {
    disNetworkInterface.removeListener(pduListener);
    pduRecorder.stop();
  }

  private void testForEquals() throws Exception
  {
//    System.out.println("*** Warning: ensure no prior dislog files are present in pduLog directory or assertion count of replay will fail.");
    
    assertEquals(pdusSent.size(), pdusReceived.size(), "Different number of pdus received than sent");
    System.out.println("... testForEquals() assertEquals() passed");
    
    // TODO is this sufficient?  has each PDU value been fully compared as well?
    assertIterableEquals(pdusSent, pdusReceived, "Sent and received pdus not identical");
    System.out.println("... testForEquals() assertIterableEquals() passed");
  }

  private void getAllFromRecorder(Semaphore sem) throws Exception
  {
    sem.acquire();
    Path path = Path.of(pduRecorder.getLogFilePath()).getParent();
    PduPlayer player = new PduPlayer(disNetworkInterface.getAddress(), disNetworkInterface.getPort(), path, false);
    player.addRawListener(ba -> {
      if (ba != null) {
        Pdu pdu = pduFactory.createPdu(ba);
        pdusRead.add(pdu);
      }
      else {
        player.end();
        sem.release();
      }
    });
  }

    private void testRecorderForEquals() throws Exception 
    {
        // TODO this may fail if prior dislog files are present in pduLog directory, ignore them to make it less brittle
        
        
        System.out.println("pdusSent.size()=" + pdusSent.size() + ", pdusRead.size()=" + pdusRead.size() + 
           ", match=" + (pdusSent.size() == pdusRead.size()));
      
        assertEquals(pdusSent.size(), pdusRead.size(), "Different number of pdus sent than read");
        System.out.println("... testRecorderForEquals() assertEquals() passed");

        assertIterableEquals(pdusSent, pdusRead, "Sent and read pdus not identical");
        System.out.println("... testRecorderForEquals() assertIterableEquals() passed");

        // TODO is this sufficient?  has each PDU value been compared as well?
    }
  
  private static void sleep(long ms) {
    try {
        Thread.sleep(ms);
    } catch (InterruptedException ex) {
        fail("NetIF Send: " + ex);
    }
  }
  
    public static void main(String[] args)
    {
        AllPduRoundTripTest allPduRoundTripTest = new AllPduRoundTripTest(); // create instance
        allPduRoundTripTest.testRoundTripAllPdus();
        System.out.println ("*** AllPduRoundTripTest main() complete");
        System.exit(0); // ensure exit if user threads are lingering
    }
}
