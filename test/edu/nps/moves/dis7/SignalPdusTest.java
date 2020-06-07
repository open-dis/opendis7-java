/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.utilities.DisThreadedNetIF;
import edu.nps.moves.dis7.utilities.PduFactory;
import edu.nps.moves.dis7.utilities.stream.PduPlayer;
import edu.nps.moves.dis7.utilities.stream.PduRecorder;
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
 * This is an important unit test as it examines the validity of our two special
 * case signal PDUs
 *
 * @author tdnorbra@nps.edu
 */
@DisplayName("Signal Pdus Test")
public class SignalPdusTest {

    static DisThreadedNetIF netif;
    static List<Pdu> receivedPdus;
    static PduRecorder recorder;
    PduFactory pduFac;
    List<Pdu> sentPdus;
    byte[] buff;
    int size;

    @BeforeAll
    public static void setUpClass() throws IOException {
        System.out.println("SignalPdusTest");
        recorder = new PduRecorder(); // default dir
        netif = recorder.getDisThreadedNetIF();
        netif.addListener(pdu -> handleReceivedPdu(pdu));
    }

    @AfterAll
    public static void tearDownClass() throws IOException {
        recorder.end(); // kills the netif as well
        recorder = null;
        netif = null;

        receivedPdus.clear();
        receivedPdus = null;
    }

    @BeforeEach
    public void setUp() {
        sentPdus = new ArrayList<>();
        receivedPdus = new ArrayList<>();
        pduFac = new PduFactory();

        Pdu pdu = pduFac.makeSignalPdu();  // empty contents
        sentPdus.add(pdu);

        pdu = pduFac.makeSignalPdu();
        ((SignalPdu) pdu).setEncodingScheme((short) 0x1111);
        ((SignalPdu) pdu).setSampleRate(0x22222222);
        ((SignalPdu) pdu).setSamples((short) 0x3333);
        ((SignalPdu) pdu).setData("SignalPdu-testdata".getBytes());
        sentPdus.add(pdu);

        pdu = pduFac.makeIntercomSignalPdu();
        sentPdus.add(pdu);

        pdu = pduFac.makeIntercomSignalPdu();
        ((IntercomSignalPdu) pdu).setEncodingScheme((short) 0x1111);
        ((IntercomSignalPdu) pdu).setSampleRate(0x22222222);
        ((IntercomSignalPdu) pdu).setSamples((short) 0x3333);
        ((IntercomSignalPdu) pdu).setData("IntercomSignalPdu-testdata".getBytes());
        sentPdus.add(pdu);

        try {
            Thread.sleep(250l); // give receive time to spool up
            sentPdus.forEach(p -> netif.send(p));
            Thread.sleep(250l); // give receiver time to process
        } catch (InterruptedException ex) {
            fail("NetIF Send: " + ex);
        }
    }

    @AfterEach
    public void tearDown() {
        pduFac = null;
        sentPdus.clear();
        sentPdus = null;
        buff = null;
    }

    @Test
    public void testRoundTripNet() {

        // Compare
        assertEquals(sentPdus, receivedPdus, "Sent and received pdus not identical");

        // Let's see how these unmarshall
        receivedPdus.forEach(pdu -> {
            try {
                buff = pdu.marshal();
                size = pdu.unmarshal(ByteBuffer.wrap(buff));
                assertTrue(size > 0, "Unmarshalling error: Unmarshalled size: " + size);

                // This also unmarshalls the pdu
                pdu = pduFac.createPdu(buff);
                assertNotNull(pdu, "Unmarshalling error " + pdu);
            } catch (Exception ex) {
                Logger.getLogger(SignalPdusTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        receivedPdus.clear();

        System.out.println("testRoundTripNet finished");
    }

    @Test
    public void testRoundTripLog() throws IOException {

        PduPlayer player = new PduPlayer(netif.getMcastGroup(), netif.getDisPort(), Path.of(recorder.getLogFile()));
        player.sendToNet(false);
        player.addRawListener(ba -> {
            if (ba != null) {
                Pdu pdu = pduFac.createPdu(ba);
                receivedPdus.add(pdu);
            } else {
                player.end();
            }
        });
        player.startResume();
    
        // Compare
        assertEquals(sentPdus, receivedPdus, "Sent and received pdus not identical");

        System.out.println("testRoundTripLog finished");
    }

    static private void handleReceivedPdu(Pdu pdu) {
        receivedPdus.add(pdu);
    }

    public static void main(String[] args) throws IOException {
        SignalPdusTest.setUpClass();
        SignalPdusTest spt = new SignalPdusTest();

        spt.setUp();
        spt.testRoundTripNet();
        spt.tearDown();

        spt.setUp();
        spt.testRoundTripLog();
        spt.tearDown();
        SignalPdusTest.tearDownClass();
    }

}
