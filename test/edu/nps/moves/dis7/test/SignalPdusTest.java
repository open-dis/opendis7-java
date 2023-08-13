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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is an important unit test that examines the validity of two special-case signal PDUs.
 *
 * @author tdnorbra@nps.edu
 */
@DisplayName("Signal Pdus Test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SignalPdusTest
{    
    static DisThreadedNetworkInterface             disNetworkInterface;
    static DisThreadedNetworkInterface.PduListener pduListener;
    static PduRecorder                             pduRecorder;

    static PduFactory  pduFactory;
    static List<Pdu>     sentPdus = new ArrayList<>();
    static List<Pdu> receivedPdus = new ArrayList<>();
    byte[] bufferByteArray;
    int size;

    /** preparation **/
    @BeforeAll
    public static void setUpClass() 
    {
        System.out.println("*** SignalPdusTest");
        
        setupNetwork();
        pduFactory = new PduFactory();
        Pdu pdu = pduFactory.makeSignalPdu();  // default field contents
        sentPdus.add(pdu);

        pdu = pduFactory.makeSignalPdu(); // recreate new pdu
        ((SignalPdu) pdu).setEncodingScheme((short) 0x1111);
        ((SignalPdu) pdu).setSampleRate(0x22222222);
        ((SignalPdu) pdu).setSamples((short) 0x3333);
        ((SignalPdu) pdu).setData("SignalPdu-testdata".getBytes());
        sentPdus.add(pdu);

        pdu = pduFactory.makeIntercomSignalPdu(); // recreate new pdu
        sentPdus.add(pdu);

        pdu = pduFactory.makeIntercomSignalPdu(); // recreate new pdu
        ((IntercomSignalPdu) pdu).setEncodingScheme((short) 0x1111);
        ((IntercomSignalPdu) pdu).setSampleRate(0x22222222);
        ((IntercomSignalPdu) pdu).setSamples((short) 0x3333);
        ((IntercomSignalPdu) pdu).setData("IntercomSignalPdu-testdata".getBytes());
        sentPdus.add(pdu);

        sentPdus.forEach(p -> {
            disNetworkInterface.send(p);
            sleep(100l); // give receiver time to process
        });
    }

    /** Prepare for network operations and send initial PDUs,
     *  must be called at beginning of setupClass()
     */
    @SuppressWarnings("Convert2Lambda")
    public static void setupNetwork()
    {
        try
        {
            if (pduRecorder == null)
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
        catch (IOException ex)
        {
            Logger.getLogger(SignalPdusTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @BeforeEach
    public void setUp() throws IOException, InterruptedException {
        new File("./pduLog/Pdusave.dislog").delete();
    }

    @AfterEach
    public void tearDown() throws IOException
    {
    }

    @AfterAll
    public static void tearDownClass() throws IOException
    {
        disNetworkInterface.removeListener(pduListener);
        pduRecorder.stop(); // kills the disNetworkInterface as well
        System.out.println("*** SignalPdusTest complete");
    }

    @Test
    @Order(1)
    public void testRoundTripNet() {
        System.out.println("*** testRoundTripNet()");
        
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
        System.out.println("*** testRoundTripLog()");
        
        Path path = Path.of("./pduLog");
        
        // Note: the player will playback all log files in the given path
        PduPlayer pduPlayer = new PduPlayer(DisThreadedNetworkInterface.DEFAULT_DIS_ADDRESS, DisThreadedNetworkInterface.DEFAULT_DIS_PORT, path, false);
        pduPlayer.addRawListener(ba -> {
            if (ba != null)
                assertNotNull(pduFactory.createPdu(ba), "PDU creation failure");
            else {
                pduPlayer.end();
            }   
        });
    }
    
    /** Convenience method to wrap Thread.sleep with exception handling
     * @param msec milliseconds */
    private static void sleep(long msec)
    {
        try {
            Thread.sleep(msec);
        } 
        catch (InterruptedException ex) 
        {
            fail("*** SignalPdusTest sleep failure: " + ex);
        }
    }

    private static void handleReceivedPdu(Pdu pdu) {
        if (!receivedPdus.contains(pdu))
             receivedPdus.add(pdu);
    }

    public static void main(String[] args) throws IOException, InterruptedException 
    {
        SignalPdusTest.setUpClass();
        SignalPdusTest signalPdusTest = new SignalPdusTest();
        
        signalPdusTest.setUp();
        signalPdusTest.testRoundTripNet();
        signalPdusTest.tearDown();
        // don't tearDownClass() if running multiple test squences
        
        signalPdusTest.setUp();
        signalPdusTest.testRoundTripLog();
        signalPdusTest.tearDown();
        
        SignalPdusTest.tearDownClass();
    }
}
