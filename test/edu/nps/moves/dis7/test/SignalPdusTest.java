/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.IntercomSignalPdu;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.SignalPdu;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.PduFactory;
import edu.nps.moves.dis7.utilities.stream.PduPlayer;
import edu.nps.moves.dis7.utilities.stream.PduRecorder;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is an important unit test as it examines the validity of our two special
 * case signal PDUs
 *
 * @author tdnorbra@nps.edu
 */
@DisplayName("Signal Pdus Test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SignalPdusTest
{    
    static DisThreadedNetworkInterface disNetworkInterface;
    static DisThreadedNetworkInterface.PduListener pduListener;
    static PduRecorder pduRecorder;
    
//    static Semaphore mutex; // TODO needed?
    static PduFactory pduFactory;
    static List<Pdu>     sentPdus = new ArrayList<>();
    static List<Pdu> receivedPdus = new ArrayList<>();
    byte[] bufferByteArray;
    int size;

    @BeforeAll
    public static void setUpClass() throws IOException 
    {
        System.out.println("SignalPdusTest");
        
//        mutex = new Semaphore(1); // TODO needed?
        
        setupNetwork();
        pduFactory = new PduFactory();
        Pdu pdu = pduFactory.makeSignalPdu();  // empty contents
        sentPdus.add(pdu);

        pdu = pduFactory.makeSignalPdu();
        ((SignalPdu) pdu).setEncodingScheme((short) 0x1111);
        ((SignalPdu) pdu).setSampleRate(0x22222222);
        ((SignalPdu) pdu).setSamples((short) 0x3333);
        ((SignalPdu) pdu).setData("SignalPdu-testdata".getBytes());
        sentPdus.add(pdu);

        pdu = pduFactory.makeIntercomSignalPdu();
        sentPdus.add(pdu);

        pdu = pduFactory.makeIntercomSignalPdu();
        ((IntercomSignalPdu) pdu).setEncodingScheme((short) 0x1111);
        ((IntercomSignalPdu) pdu).setSampleRate(0x22222222);
        ((IntercomSignalPdu) pdu).setSamples((short) 0x3333);
        ((IntercomSignalPdu) pdu).setData("IntercomSignalPdu-testdata".getBytes());
        sentPdus.add(pdu);

        sentPdus.forEach(p -> {
            disNetworkInterface.send(p);
            sleep(5l); // give receiver time to process // TODO needed?
        });
    }

    /** Prepare for network operations, must be called at beginning of setupClass()
     *  @throws IOException 
     */
    @SuppressWarnings("Convert2Lambda")
    public static void setupNetwork() throws IOException
    {
        pduRecorder = new PduRecorder(); // default dir
        pduRecorder.start();
        disNetworkInterface = pduRecorder.getDisThreadedNetworkInterface();
        pduListener = new DisThreadedNetworkInterface.PduListener() {
          @Override
          public void incomingPdu(Pdu pdu) {
              handleReceivedPdu(pdu);
          }
        };
        disNetworkInterface.addListener(pduListener);
    }

    @BeforeEach
    public void setUp() throws IOException, InterruptedException {
        new File("./pduLog/Pdusave.dislog").delete();
    }

    @AfterEach
    public void tearDown() throws IOException {
        disNetworkInterface.removeListener(pduListener);
        pduRecorder.stop(); // kills the disNetworkInterface as well
    }

    @AfterAll
    public static void tearDownClass() throws IOException {
    }

    @Test
    @Order(1)
    public void testRoundTripNet() {
        System.out.println("testRoundTripNet()");
        
        // Let's see how these unmarshall
        receivedPdus.forEach(pdu -> {
            try {
                bufferByteArray = pdu.marshal();
                size = pdu.unmarshal(ByteBuffer.wrap(bufferByteArray));
                assertTrue(size > 0, "Unmarshalling error: Unmarshalled size: " + size);

                // This also unmarshalls the pdu
                pdu = pduFactory.createPdu(bufferByteArray);
                assertNotNull(pdu, "Unmarshalling error " + pdu);
            } catch (Exception ex) {
                Logger.getLogger(SignalPdusTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // Compare
        assertEquals(sentPdus, receivedPdus, "Sent and received pdus not identical");
    }

    @Test
    @Order(2)
    public void testRoundTripLog() throws IOException, InterruptedException {   
        System.out.println("testRoundTripLog()");
        
//        mutex.acquire();
        Path path = Path.of("./pduLog");
        
        // Note: the player will playback all log files in the given path
        PduPlayer pduPlayer = new PduPlayer(DisThreadedNetworkInterface.DEFAULT_DIS_ADDRESS, DisThreadedNetworkInterface.DEFAULT_DIS_PORT, path, false);
        pduPlayer.addRawListener(ba -> {
            if (ba != null)
                assertNotNull(pduFactory.createPdu(ba), "PDU creation failure");
            else {
                pduPlayer.end();
//                mutex.release();
            }   
        });
    
//        mutex.acquire(); // TODO needed? appears to be unnecessarily blocking...
    }
    
    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            fail("NetIF Send: " + ex);
        }
    }

    private static void handleReceivedPdu(Pdu pdu) {
        if (!receivedPdus.contains(pdu))
             receivedPdus.add(pdu);
    }

    public static void main(String[] args) throws IOException, InterruptedException 
    {
        setUpClass();
        
        SignalPdusTest signalPdusTest = new SignalPdusTest();
        signalPdusTest.setUp();
        signalPdusTest.testRoundTripNet();
        signalPdusTest.tearDown();
        signalPdusTest.setUp();
        signalPdusTest.testRoundTripLog();
        signalPdusTest.tearDown();
    }

}
