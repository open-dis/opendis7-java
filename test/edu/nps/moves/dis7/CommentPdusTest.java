/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.enumerations.VariableRecordType;
import edu.nps.moves.dis7.util.DisNetworking;
import edu.nps.moves.dis7.util.PduFactory;
import java.io.IOException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Comment Pdus Test")
public class CommentPdusTest
{
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
  }

  @AfterEach
  public void tearDown()
  {
  }

  private Pdu receivedPdu;

  @Test
  public void testRoundTrip()
  {
    PduFactory factory = new PduFactory();
    setUpReceiver();
    
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
     assertTrue(compare(pdu,receivedPdu),"Comparison failed");
     receivedPdu = null;
  }
  
  private void sendPdu(Pdu pdu)
  {
    try {
      Thread.sleep(250l); // make sure receiver is listening
      DisNetworking disnet = new DisNetworking();
      disnet.sendPdu(pdu);

      Thread.sleep(1000l);
    }
    catch (Exception ex) {
      System.err.println("Error sending Multicast: " + ex.getLocalizedMessage());
      System.exit(1);
    }
  }
 
  private boolean compare(Pdu pdu1, Pdu pdu2)
  {
    return pdu1.equals(pdu2);
  }
  
  private void setUpReceiver()
  {
    Thread rcvThread = new Thread(() -> {
      try {
        while(true) {
          receivedPdu = new DisNetworking().receivePdu();  // blocks
        }
      }
      catch (IOException ex) {
        System.err.println("Error receiving Multicast: " + ex.getLocalizedMessage());
        System.exit(1);
      }
    });

    rcvThread.setPriority(Thread.NORM_PRIORITY);
    rcvThread.setDaemon(true);
    rcvThread.start();
  }

  public static void main(String[] args)
  {
    new CommentPdusTest().testRoundTrip();
  }
}
