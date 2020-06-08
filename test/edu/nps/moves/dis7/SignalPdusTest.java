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
public class SignalPdusTest {
    
    DisThreadedNetIF netif;
    List<Pdu> receivedPdus;
    PduRecorder recorder;
    
    Semaphore mutex;
    PduFactory pduFac;
    List<Pdu> sentPdus;
    byte[] buff;
    int size;

    @BeforeAll
    public static void setUpClass() throws IOException {
        System.out.println("SignalPdusTest");
    }

    @AfterAll
    public static void tearDownClass() throws IOException {
    }

    @BeforeEach
    public void setUp() throws IOException, InterruptedException {
        recorder = new PduRecorder(); // default dir
        netif = recorder.getDisThreadedNetIF();
        netif.addListener(pdu -> handleReceivedPdu(pdu));
        
        mutex = new Semaphore(1);
        mutex.acquire();
        
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
    public void tearDown() throws IOException {
        pduFac = null;
        sentPdus.clear();
        sentPdus = null;
        receivedPdus.clear();
        receivedPdus = null;
        buff = null;
        mutex.release();
        mutex = null;
        recorder.end(); // kills the netif as well
        netif = null;
        recorder = null;
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

        System.out.println("testRoundTripNet finished");
    }

    @Test
    public void testRoundTripLog() throws IOException, InterruptedException {
        
        Path path = Path.of(recorder.getLogFile()).getParent();
        PduPlayer player = new PduPlayer(netif.getMcastGroup(), netif.getDisPort(), path);
        player.sendToNet(false);
        player.addRawListener(ba -> {
            if (ba != null)
                assertNotNull(pduFac.createPdu(ba), "PDU creation failure");
            else {
                player.end();
                mutex.release();
            }   
        });
    
        mutex.acquire();
        System.out.println("testRoundTripLog finished");
    }

    private void handleReceivedPdu(Pdu pdu) {
        if (receivedPdus != null)
            receivedPdus.add(pdu);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
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
