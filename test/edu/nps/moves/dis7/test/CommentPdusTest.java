/**
 * Copyright (c) 2008-2022, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.enumerations.VariableRecordType;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.PduFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/** 
 * Unit testing for CommentPdus, which can serve as a free-form holder for any kind of narrative information or simulation data.
 * @author brutzman
 */
@DisplayName("Comment Pdus Test")
public class CommentPdusTest
{
  DisThreadedNetworkInterface             disNetworkInterface;
  Pdu                                     receivedPdu;
  DisThreadedNetworkInterface.PduListener pduListener;
  
    /** default constructor */
    public CommentPdusTest()
    {
        // initialization code here
    }
    
    /** Setup initialization before each test */
  @BeforeAll
  public static void setUpClass()
  {
    System.out.println("CommentPdusTest");
  }

    /** Housekeeping after each test */
  @AfterAll
  public static void tearDownClass()
  {
  }

    /** Setup initialization before each test */
  @BeforeEach
  public void setUp()
  {   
      disNetworkInterface = new DisThreadedNetworkInterface();
      pduListener = (Pdu newPdu) -> {
          setUpReceiver(newPdu);
      };
      disNetworkInterface.addListener(pduListener);
  }

    /** Housekeeping after each test */
  @AfterEach
  public void tearDown()
  {
      disNetworkInterface.removeListener(pduListener);
      disNetworkInterface.close();
  }

  /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
  @Test
  public void testRoundTrip()
  {
    PduFactory pduFactory = new PduFactory();
    
    testOne(pduFactory.makeCommentPdu());
    testOne(pduFactory.makeCommentPdu("123_test_string"));
    testOne(pduFactory.makeCommentPdu(VariableRecordType.MODEL_TYPE, "456_test with type = modeltype"));
    testOne(pduFactory.makeCommentPdu("xyz first message","mno second message", "jkl third message"));
    
    // TODO alternate constructors, setters and getters for CommentPdu
    
    testOne(pduFactory.makeCommentReliablePdu());
    testOne(pduFactory.makeCommentReliablePdu("789_test_string"));
    testOne(pduFactory.makeCommentReliablePdu(VariableRecordType.ACLS_AIRCRAFT_REPORT, "abc_test with type = acls_aircraft_report"));
    testOne(pduFactory.makeCommentReliablePdu("xyz R first message","mno R second message", "jkl R third message"));   
  }
  
  /** Test single PDU for correctness according to all contained fields in this PDU type
    * @param newPdu PDU of interest */
  private void testOne(Pdu newPdu)
  {
     sendPdu(newPdu); // sendPDU to self, then wait a while, then return receivedPdu
     assertTrue(receivedPdu != null, "No response from network receiver");
     
     String marshallSizeMismatchMessage = 
        "Marshalled size mismatch," +
            "sent (" +      newPdu.getMarshalledSize() + " bytes) and " +
        "recieved (" + receivedPdu.getMarshalledSize() + " bytes)";
     // https://stackoverflow.com/questions/20631621/cannot-find-symbol-assertequals/20631672
     assertEquals(newPdu.getMarshalledSize(), receivedPdu.getMarshalledSize(), marshallSizeMismatchMessage);
     assertTrue(compare(newPdu,receivedPdu), "Comparison failed");
     assertEquals(newPdu.getPduType(), receivedPdu.getPduType(), "PDU type mismatch");
     
     receivedPdu = null; // ensure cleared prior to next test
  }
  
    /** sendPDU the PDU of interest */
  private void sendPdu(Pdu pdu)
  {
    try {
      disNetworkInterface.sendPDU(pdu);
      Thread.sleep(100); // TODO consider refactoring the wait logic and moving externally
    }
    catch (InterruptedException ex) {
      System.err.println("Error sending Multicast: " + ex.getLocalizedMessage());
      System.exit(1);
    }
  }
 
  /** comparison test */
  private boolean compare(Pdu pdu1, Pdu pdu2)
  {
    return pdu1.equals(pdu2);
  }
  
  private void setUpReceiver(Pdu newPdu)
  {
    receivedPdu = newPdu;
  }

  /** Command-line invocation (CLI) of program, execution starts here
    * @param args command-line arguments
    */
  public static void main(String[] args)
  {
    CommentPdusTest commentPdusTest = new CommentPdusTest();
    
    commentPdusTest.setUp();
    commentPdusTest.testRoundTrip();
    commentPdusTest.tearDown();
  }
}
