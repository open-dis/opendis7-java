/**
 * Copyright (c) 2008-2022, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.enumerations.VariableRecordType;
import edu.nps.moves.dis7.pdus.DataQueryPdu;
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

/** Unit tests for DataQuery PDU fields and values.
 * 
 * @author brutzman
 */
@DisplayName("Data Query Pdu Round Test")
public class DataQueryPduRoundTripTest
{

  private static final int REQUEST_ID = 0x00112233;
  private static final int TIME_INTERVAL = 0x15151515;

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
        System.out.println(DataQueryPduRoundTripTest.class.getName() + " setUpClass()");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println(DataQueryPduRoundTripTest.class.getName() + " tearDownClass()");
    }

 Pdu receivedPdu;
 DisThreadedNetworkInterface disNetworkInterface;
 DisThreadedNetworkInterface.PduListener pduListener;

    /** default constructor */
    public DataQueryPduRoundTripTest()
    {
        // initialization code here
    }
    
  /** Setup initialization before each test */
  @BeforeEach
  public void setUp()
  {   
      disNetworkInterface = new DisThreadedNetworkInterface();
      pduListener = (Pdu pdu) -> {
          setUpReceiver(pdu);
      };
      disNetworkInterface.addListener(pduListener);
  }

  /** Housekeeping after each test */
  @AfterEach
  public void tearDown()
  {
      disNetworkInterface.removeListener(pduListener);
      disNetworkInterface.close();
      disNetworkInterface = null;
      receivedPdu = null;
  }

  /** Perform test of interest */
  @Test
  public void testRoundTrip()
  {
    PduFactory factory = new PduFactory();

    DataQueryPdu sendingPdu = factory.makeDataQueryPdu();
    sendingPdu.setRequestID(REQUEST_ID);
    sendingPdu.setTimeInterval(TIME_INTERVAL);

    sendingPdu.getFixedDatums().add(fixedDatum1);
    sendingPdu.getFixedDatums().add(fixedDatum2);
    sendingPdu.getFixedDatums().add(fixedDatum3);

    sendingPdu.getVariableDatums().add(variableDatum1);
    sendingPdu.getVariableDatums().add(variableDatum2);

    try {
            // Padding for the VariableDatum records can not be determined until the PDU has been marshalled.
            // Therefore, marshalled size is not correct until after marshalling
            sendingPdu.marshal(ByteBuffer.allocate(1500));
            sendingPdu.setLength(sendingPdu.getMarshalledSize());
        } catch (Exception ex) {
            Logger.getLogger(FixedAndVariableDatumRoundTripTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        disNetworkInterface.sendPDU(sendingPdu);
        try {
            Thread.sleep(100l);
        } catch (InterruptedException ex) {
            System.err.println("Error sending Multicast: " + ex.getLocalizedMessage());
            System.exit(1);
        }

    // Compare
    // If we made it this far, we've sent and received.  Now compare.
    assertTrue(receivedPdu != null, "No response from network");
    assertTrue(receivedPdu.equals(sendingPdu), "Sent and received pdu not the same");
  }

  private void setUpReceiver(Pdu pdu)
  {
    receivedPdu = pdu;
  }

  /** Command-line invocation (CLI) of program, execution starts here
    * @param args command-line arguments
    */
  public static void main(String[] args)
  {
    DataQueryPduRoundTripTest drt = new DataQueryPduRoundTripTest();
    drt.setUp();
    drt.testRoundTrip();
    drt.tearDown();
  }
}
