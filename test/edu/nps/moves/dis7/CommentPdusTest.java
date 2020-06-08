/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.enumerations.VariableRecordType;
import edu.nps.moves.dis7.utilities.DisThreadedNetIF;
import edu.nps.moves.dis7.utilities.PduFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Comment Pdus Test")
public class CommentPdusTest
{
  DisThreadedNetIF netif;
  Pdu receivedPdu;
    
  @BeforeAll
  public static void setUpClass()
  {
    System.out.println("CommentPdusTest");
  }

  @AfterAll
  public static void tearDownClass()
  {
  }

  @BeforeEach
  public void setUp()
  {
      netif = new DisThreadedNetIF();
      netif.addListener(pdu -> setUpReceiver(pdu));
  }

  @AfterEach
  public void tearDown()
  {
      netif.kill();
      netif = null;
  }

  @Test
  public void testRoundTrip()
  {
    PduFactory factory = new PduFactory();
    
    testOne(factory.makeCommentPdu());
    testOne(factory.makeCommentPdu("123_test_string"));
    testOne(factory.makeCommentPdu(VariableRecordType.MODEL_TYPE, "456_test with type = modeltype"));
    testOne(factory.makeCommentPdu("xyz first message","mno second message", "jkl third message"));
    
    testOne(factory.makeCommentReliablePdu());
    testOne(factory.makeCommentReliablePdu("789_test_string"));
    testOne(factory.makeCommentReliablePdu(VariableRecordType.ACLS_AIRCRAFT_REPORT, "abc_test with type = acls_aircraft_report"));
    testOne(factory.makeCommentReliablePdu("xyz R first message","mno R second message", "jkl R third message"));   
  }
  
  private void testOne(Pdu pdu)
  {
     sendPdu(pdu); // will wait a while
     assertTrue(receivedPdu != null, "No response from network receive");
     assertTrue(compare(pdu,receivedPdu), "Comparison failed");
     receivedPdu = null;
  }
  
  private void sendPdu(Pdu pdu)
  {
    try {
      Thread.sleep(250l); // make sure receiver is listening
      netif.send(pdu);
      Thread.sleep(100l);
    }
    catch (InterruptedException ex) {
      System.err.println("Error sending Multicast: " + ex.getLocalizedMessage());
      System.exit(1);
    }
  }
 
  private boolean compare(Pdu pdu1, Pdu pdu2)
  {
    return pdu1.equals(pdu2);
  }
  
  private void setUpReceiver(Pdu pdu)
  {
    receivedPdu = pdu;
  }

  public static void main(String[] args)
  {
    CommentPdusTest cpt = new CommentPdusTest();
    cpt.setUp();
    cpt.testRoundTrip();
    cpt.tearDown();
  }
}
