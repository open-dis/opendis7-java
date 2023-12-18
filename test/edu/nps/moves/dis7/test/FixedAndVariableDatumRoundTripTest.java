/**
 * Copyright (c) 2008-2022, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.enumerations.VariableRecordType;
import edu.nps.moves.dis7.pdus.ActionResponsePdu;
import edu.nps.moves.dis7.pdus.FixedDatum;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.VariableDatum;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.PduFactory;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for satisfactory handling of FixedDatum and VariableRecordType
 * fields and values.
 */
@DisplayName("Fixed and Variable Datum Round Trip Test")
public class FixedAndVariableDatumRoundTripTest {

    private static final FixedDatum fixedDatum1 = new FixedDatum();
    private static final int FIXED_DATUM_VALUE = 0x111111FF;
    private static final VariableRecordType FIXED_DATUM_1_VAR_RECORD_TYPE = VariableRecordType.ACTIVATE_OWNSHIP;

    private static final FixedDatum fixedDatum2 = new FixedDatum();
    private static final int FIXED_DATUM2_VALUE = 0x222222FF;
    private static final VariableRecordType FIXED_DATUM_2_VAR_RECORD_TYPE = VariableRecordType.HUMIDITY;

    private static final FixedDatum fixedDatum3 = new FixedDatum();
    private static final int FIXED_DATUM_3_VALUE = 0x333333FF;
    private static final VariableRecordType FIXED_DATUM_3_VAR_RECORD_TYPE = VariableRecordType.SKE_FREQUENCY;

    private static final VariableDatum variableDatum1 = new VariableDatum();
    private static final VariableRecordType VARIABLE_DATUM_1_TYPE = VariableRecordType.ACLS_AIRCRAFT_REPORT;
    private static final byte[] variableDatum1Value = "varDatum1Value111".getBytes();

    private static final VariableDatum variableDatum2 = new VariableDatum();
    private static final VariableRecordType VARIABLE_DATUM_2_TYPE = VariableRecordType.Z_ACCELERATION;
    private static final byte[] variableDatum2Value = "varDatum2Value222".getBytes();

    static {
        fixedDatum1.setFixedDatumValue(FIXED_DATUM_VALUE);
        fixedDatum1.setFixedDatumID(FIXED_DATUM_1_VAR_RECORD_TYPE);

        fixedDatum2.setFixedDatumValue(FIXED_DATUM2_VALUE);
        fixedDatum2.setFixedDatumID(FIXED_DATUM_2_VAR_RECORD_TYPE);

        fixedDatum3.setFixedDatumValue(FIXED_DATUM_3_VALUE);
        fixedDatum3.setFixedDatumID(FIXED_DATUM_3_VAR_RECORD_TYPE);

        variableDatum1.setVariableDatumValue(variableDatum1Value);
        variableDatum1.setVariableDatumLengthInBytes(variableDatum1Value.length);
        variableDatum1.setVariableDatumID(VARIABLE_DATUM_1_TYPE);

        variableDatum2.setVariableDatumValue(variableDatum2Value);
        variableDatum2.setVariableDatumLengthInBytes(variableDatum2Value.length);
        variableDatum2.setVariableDatumID(VARIABLE_DATUM_2_TYPE);
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println(FixedAndVariableDatumRoundTripTest.class.getName() + " setUpClass()");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println(FixedAndVariableDatumRoundTripTest.class.getName() + " tearDownClass()");
    }

    Pdu receivedPdu;
    DisThreadedNetworkInterface disNetworkInterface;
    DisThreadedNetworkInterface.PduListener pduListener;

    /**
     * default constructor
     */
    public FixedAndVariableDatumRoundTripTest() {
        // initialization code here
    }
    
    /**
     * setup disNetworkInterface and pduListener
     */
    @BeforeEach
    public void setUp() {
        disNetworkInterface = new DisThreadedNetworkInterface();
        pduListener = (Pdu pdu) -> {
            setUpReceiver(pdu);
        };
        disNetworkInterface.addListener(pduListener);
    }

    /**
     * Tear down disNetworkInterface
     */
    @AfterEach
    public void tearDown() {
        disNetworkInterface.removeListener(pduListener);
        disNetworkInterface.close();
        disNetworkInterface = null;
        receivedPdu = null;
    }

    /**
     * Test PDU sending, receiving, marshalling (serialization) and
     * unmarshalling (deserialization)
     */
    @Test
    public void testRoundTrip() {
        PduFactory factory = new PduFactory();
        ActionResponsePdu sentPdu = factory.makeActionResponsePdu();

        sentPdu.getFixedDatums().add(fixedDatum1);
        sentPdu.getFixedDatums().add(fixedDatum2);
        sentPdu.getFixedDatums().add(fixedDatum3);

        sentPdu.getVariableDatums().add(variableDatum1);
        sentPdu.getVariableDatums().add(variableDatum2);

        try {
            // Padding for the VariableDatum records can not be determined until the PDU has been marshalled.
            // Therefore, marshalled size is not correct until after marshalling
            sentPdu.marshal(ByteBuffer.allocate(1500));
            sentPdu.setLength(sentPdu.getMarshalledSize());
        } catch (Exception ex) {
            Logger.getLogger(FixedAndVariableDatumRoundTripTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        disNetworkInterface.sendPDU(sentPdu);
        try {
            Thread.sleep(100l);
        } catch (InterruptedException ex) {
            System.err.println("Error sending Multicast: " + ex.getLocalizedMessage());
            System.exit(1);
        }

        // Compare
        // If we made it this far, we've sent and received.  Now compare.
        assertTrue(receivedPdu != null, "No response from network");
        assertTrue(receivedPdu.equals(sentPdu), "Sent and received pdus not identical");
    }
    
    /**
     * Compare test PDU received by copying Pdu
     */
    @Test
    public void testCopyPdu() {
        testRoundTrip();
        
        Pdu pdu = receivedPdu.copyByPduFactory();
        assertTrue(receivedPdu.equals(pdu), "Sent and copied pdus not identical");
    }

    /**
     * Callback method for pduListener
     *
     * @param pdu received PDU
     */
    private void setUpReceiver(Pdu pdu) {
        receivedPdu = pdu;
    }

    /**
     * Main method for testing.
     *
     * @see <a href="https://docs.oracle.com/javase/tutorial/getStarted/application/index.html">Java
     * Tutorials: A Closer Look at the "Hello World!" Application</a>
     * @param args [address, port, descriptor] command-line arguments are an
     * array of optional String parameters that are passed from execution
     * environment during invocation
     */
    public static void main(String[] args) {
        FixedAndVariableDatumRoundTripTest frt = new FixedAndVariableDatumRoundTripTest();
        frt.setUp();
        frt.testRoundTrip();
        frt.testCopyPdu();
        frt.tearDown();
    }
}
