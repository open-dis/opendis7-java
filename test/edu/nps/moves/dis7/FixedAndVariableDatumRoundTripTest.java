/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.enumerations.ActionResponseRequestStatus;
import edu.nps.moves.dis7.enumerations.VariableRecordType;
import edu.nps.moves.dis7.util.DisNetworking;
import edu.nps.moves.dis7.util.PduFactory;
import java.io.IOException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Fixed and Variable Datum Round Trip Test")
public class FixedAndVariableDatumRoundTripTest
{
  public FixedAndVariableDatumRoundTripTest()
  {
  }

  @BeforeAll
  public static void setUpClass()
  {
    System.out.println("FixedAndVariableDatumRoundTripTest");
  }

  @AfterAll
  public static void tearDownClass()
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

  private static int REQUEST_ID = 0x00112233;
  private static ActionResponseRequestStatus REQUEST_STATUS = ActionResponseRequestStatus.RETRANSMIT_REQUEST_LATER;

  private static FixedDatum fixedDatum1 = new FixedDatum();
  private static int fixedDatum1Value = 0x111111FF;
  private static VariableRecordType fixedDatum1VarRecordType = VariableRecordType.ACTIVATE_OWNSHIP;
  private static FixedDatum fixedDatum2 = new FixedDatum();
  private static int fixedDatum2Value = 0x222222FF;
  private static VariableRecordType fixedDatum2VarRecordType = VariableRecordType.HUMIDITY;
  private static FixedDatum fixedDatum3 = new FixedDatum();
  private static int fixedDatum3Value = 0x333333FF;
  private static VariableRecordType fixedDatum3VarRecordType = VariableRecordType.SKE_FREQUENCY;

  private static VariableDatum variableDatum1 = new VariableDatum();
  private static VariableRecordType variableDatum1Type = VariableRecordType.ACLS_AIRCRAFT_REPORT;
  private static String variableDatum1String = "varDatum1Value111";
  private static byte[] variableDatum1Value = variableDatum1String.getBytes();
  private static int variableDatum1LengthInBits = variableDatum1String.length() * 8 - 1; // test

  private static VariableDatum variableDatum2 = new VariableDatum();
  private static VariableRecordType variableDatum2Type = VariableRecordType.Z_ACCELERATION;
  private static byte[] variableDatum2Value = new String("222varDatum1Value222").getBytes();

  static {
    fixedDatum1.setFixedDatumValue(fixedDatum1Value);
    fixedDatum1.setFixedDatumID(fixedDatum1VarRecordType);

    fixedDatum2.setFixedDatumValue(fixedDatum2Value);
    fixedDatum2.setFixedDatumID(fixedDatum2VarRecordType);

    fixedDatum3.setFixedDatumValue(fixedDatum3Value);
    fixedDatum3.setFixedDatumID(fixedDatum3VarRecordType);

    variableDatum1.setVariableDatumID(variableDatum1Type);
    variableDatum1.setVariableDatumValue(variableDatum1Value);
    //variableDatum1.setVariableDatumLength(variableDatum1LengthInBits);

    variableDatum2.setVariableDatumID(variableDatum2Type);
    variableDatum2.setVariableDatumValue(variableDatum2Value);
    //variableDatum2.setVariableDatumLength(variableDatum2Value.length * 8); //in bits
  }

  private Pdu receivedPdu;
  private Object waiter = new Object();

  @Test
  public void testRoundTrip()
  {
    PduFactory factory = new PduFactory();
    ActionResponsePdu sentPdu = factory.makeActionResponsePdu();

    sentPdu.getFixedDatums().add(fixedDatum1);
    sentPdu.getFixedDatums().add(fixedDatum2);
    sentPdu.getFixedDatums().add(fixedDatum3);

    sentPdu.getVariableDatums().add(variableDatum1);
    sentPdu.getVariableDatums().add(variableDatum2);

    setUpReceiver();

    try {
      Thread.sleep(250l); // make sure receiver is listening
      new DisNetworking().sendPdu(sentPdu);
      Thread.sleep(1000l);
    }
    catch (Exception ex) {
      System.err.println("Error sending Multicast: " + ex.getLocalizedMessage());
      System.exit(1);
    }

    // Compare
    // If we made it this far, we've sent and received.  Now compare.
    assertTrue(receivedPdu != null, "No response from network");
    assertTrue(receivedPdu.equals(sentPdu),"Sent and received pdus not identical");
  }

  private void setUpReceiver()
  {
    Thread rcvThread = new Thread(() -> {
      try {
        receivedPdu = new DisNetworking().receivePdu();  // blocks
      }
      catch (IOException ex) {
        System.err.println("Error receiving Multicast: " + ex.getLocalizedMessage());
        System.exit(1);
      }
      //   waiter.notify();
    });

    rcvThread.setPriority(Thread.NORM_PRIORITY);
    rcvThread.setDaemon(true);
    rcvThread.start();
  }

  public static void main(String[] args)
  {
    new FixedAndVariableDatumRoundTripTest().testRoundTrip();
  }
}
