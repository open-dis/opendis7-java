/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.enumerations.VariableRecordType;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.PduFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Data Query Pdu Round Test")
public class DataQueryPduRoundTripTest
{

 Pdu receivedPdu;
 DisThreadedNetworkInterface disNetworkInterface;
 DisThreadedNetworkInterface.PduListener pduListener;

  @BeforeAll
  public static void setUpClass()
  {
    System.out.println("DataQueryPduRoundTripTest");
  }

  @AfterAll
  public static void tearDownClass()
  {
  }

  @BeforeEach
  public void setUp()
  {   
      disNetworkInterface = new DisThreadedNetworkInterface();
      pduListener = new DisThreadedNetworkInterface.PduListener() {
          @Override
          public void incomingPdu(Pdu pdu) {
              setUpReceiver(pdu);
          }
      };
      disNetworkInterface.addListener(pduListener);
  }

  @AfterEach
  public void tearDown()
  {
      disNetworkInterface.removeListener(pduListener);
      disNetworkInterface.kill();
      disNetworkInterface = null;
  }

  private static int REQUEST_ID = 0x00112233;
  private static int TIME_INTERVAL = 0x15151515;

  private static FixedDatum fixedDatum1 = new FixedDatum();
  private static int fixedDatum1Value = 0x111111FF;
  private static VariableRecordType fixedDatum1VarRecordType = VariableRecordType._120_MM_HEAT_QUANTITY;
  private static FixedDatum fixedDatum2 = new FixedDatum();
  private static int fixedDatum2Value = 0x222222FF;
  private static VariableRecordType fixedDatum2VarRecordType = VariableRecordType.ACCELERATION;
  private static FixedDatum fixedDatum3 = new FixedDatum();
  private static int fixedDatum3Value = 0x333333FF;
  private static VariableRecordType fixedDatum3VarRecordType = VariableRecordType.NUMBER_OF_INTERCEPTORS_FIRED;

  private static VariableDatum variableDatum1 = new VariableDatum();
  private static VariableRecordType variableDatum1Type = VariableRecordType.ADA_SHOOTING_STATUS;
  private static byte[] variableDatum1Value = "varDatum1Value111".getBytes();

  private static VariableDatum variableDatum2 = new VariableDatum();
  private static VariableRecordType variableDatum2Type = VariableRecordType.ORDER_STATUS;
  private static byte[] variableDatum2Value = "222varDatum1Value222".getBytes();

  static {
    fixedDatum1.setFixedDatumValue(fixedDatum1Value);
    fixedDatum1.setFixedDatumID(fixedDatum1VarRecordType);

    fixedDatum2.setFixedDatumValue(fixedDatum2Value);
    fixedDatum2.setFixedDatumID(fixedDatum2VarRecordType);

    fixedDatum3.setFixedDatumValue(fixedDatum3Value);
    fixedDatum3.setFixedDatumID(fixedDatum3VarRecordType);

    variableDatum1.setVariableDatumID(variableDatum1Type);
    variableDatum1.setVariableDatumValue(variableDatum1Value);
    // variableDatum1.setVariableDatumLength(variableDatum1Value.length);  // should be done automatically

    variableDatum2.setVariableDatumID(variableDatum2Type);
    variableDatum2.setVariableDatumValue(variableDatum2Value);
    //  variableDatum2.setVariableDatumLength(variableDatum2Value.length);  // should be done automatically
  }

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
      disNetworkInterface.send(sendingPdu);
      Thread.sleep(100l);
    }
    catch (InterruptedException ex) {
      System.err.println("Error sending Multicast: " + ex.getLocalizedMessage());
      System.exit(1);
    }

    // Compare
    // If we made it this far, we've sent and received.  Now compare.
    assertTrue(receivedPdu.equals(sendingPdu), "Sent and received pdu not the same");
  }

  private void setUpReceiver(Pdu pdu)
  {
    receivedPdu = pdu;
  }

  public static void main(String[] args)
  {
    DataQueryPduRoundTripTest drt = new DataQueryPduRoundTripTest();
    drt.setUp();
    drt.testRoundTrip();
    drt.tearDown();
  }
}
