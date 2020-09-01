/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.entities.usa.munition.other.M1A2;
import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.utilities.PduFactory;
import edu.nps.moves.dis7.enumerations.PlatformDomain;
import edu.nps.moves.dis7.pdus.Domain;
import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.FirePdu;
import edu.nps.moves.dis7.pdus.EntityType;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.PduBase;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Fire Pdu Test")
public class FirePduTest extends PduTest
{
  /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
  @Test
  @Override
  public void testRoundTrip()
  {
    PduFactory pduFactory = new PduFactory();
    
    FirePdu    firePdu = pduFactory.makeFirePdu(); 
    // TODO alternate constructors and utility methods
    
    // TODO update PDU-specific tests
    
    testOnePdu(firePdu);
  }
  
  /** Test single PDU for correctness according to all contained fields in this PDU type
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @param newPdu separate PDU for comparison
   */
  @Override
  protected void testOnePdu(Pdu newPdu)
  {
     sendPdu(newPdu); // will wait a while
     assertTrue(receivedPdu != null,         "No response from network receive after " + getThreadSleepInterval() + " msec");
     
     testPduHeaderMatch(newPdu);
     
     // can cast PDUs at this point since PduType matched
     FirePdu      newEspdu = (FirePdu) newPdu;
     FirePdu receivedEspdu = (FirePdu) newPdu;

     assertEquals (newEspdu.getFiringEntityID(),            receivedEspdu.getFiringEntityID(),           "mismatched FiringEntityID");
     assertEquals (newEspdu.getTargetEntityID(),            receivedEspdu.getTargetEntityID(),           "mismatched TargetEntityID");
     // TODO Target Entity ID (App, Entity)
     // TODO Munition/Expendable Entity ID (Site, App)
     // TODO Munition/Expendable Entity ID (Entity)
     assertEquals (newEspdu.getEventID(),                   receivedEspdu.getEventID(),                   "mismatched EventID");
     assertEquals (newEspdu.getLocationInWorldCoordinates(),receivedEspdu.getLocationInWorldCoordinates(),"mismatched  LocationInWorldCoordinates");
     assertEquals (newEspdu.getVelocity(),                  receivedEspdu.getVelocity(),                  "mismatched  Velocity");
     assertEquals (newEspdu.getFireMissionIndex(),          receivedEspdu.getFireMissionIndex(),          "mismatched  FireMissionIndex");
     assertEquals (newEspdu.getMunitionExpendibleID(),      receivedEspdu.getMunitionExpendibleID(),      "mismatched  MunitionExpendibleID");
     // TODO Munition Descriptor
     assertEquals (newEspdu.getPadding(),                   receivedEspdu.getPadding(),                   "mismatched  Padding");
     assertEquals (newEspdu.getRange(),                     receivedEspdu.getRange(),                     "mismatched  Range");
     // TODO Fire Type, Padding2, Num Variable Records
     // TODO Variable Records
     
     // trace option to compare strings, JSON or XML
     if (false) // true || !newEspdu.toString().equals(receivedEspdu.toString())) 
     {
         System.err.println("     newEspdu=" +      newEspdu.toString());
         System.err.println("receivedEspdu=" + receivedEspdu.toString());
     }
     assertEquals (newEspdu.toString(),    receivedEspdu.toString(),    "mismatched toString()");
     // built-in object comparison
     assertTrue   (newEspdu.equalsImpl(receivedEspdu),                                                "FirePdu.equalsImpl() built-in object comparison");
     // final recheck that everything adds up
     assertEquals(newPdu.getMarshalledSize(),receivedPdu.getMarshalledSize(),
        "Marshalled size mismatch," +
            "sent (" +      newPdu.getMarshalledSize() + " bytes) and " +
        "recieved (" + receivedPdu.getMarshalledSize() + " bytes)");
     assertEquals (newPdu.getLength(),         receivedPdu.getLength(), "mismatched length"); // from Pdu superclass
     
//   comparison of class Pdu is questionable
//   assertTrue(compare(newPdu,receivedPdu), "compare() method failed for original and received PDUs");
     receivedPdu = null; // ensure cleared prior to next test
  }
  
    public static void main(String[] args)
    {
        FirePduTest firePduTest = new FirePduTest();
        
        firePduTest.setUp();
        firePduTest.testRoundTrip();
        firePduTest.tearDown();
    }
}
