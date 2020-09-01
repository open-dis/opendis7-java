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
import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.EntityType;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.PduBase;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Entity State Pdu Test")
public class EntityStatePduTest extends PduTest
{
  /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
  @Test
  @Override
  public void testRoundTrip()
  {
    PduFactory pduFactory = new PduFactory();
    
    EntityStatePdu    espdu = pduFactory.makeEntityStatePdu(); 
    // TODO alternate constructors and utility methods
    EntityID       entityID = new EntityID().setSiteID((short)1).setApplicationID((short)2).setEntityID((short)3);
    EntityType   entityType = new EntityType()
                    .setEntityKind (EntityKind.PLATFORM).setEntityKind(EntityKind.PLATFORM)  //(short) 1); // Platform (vs lifeform, munition, sensor, etc.); //(short) 1); // Platform (vs lifeform, munition, sensor, etc.)
                    .setCountry    (Country.UNITED_STATES_OF_AMERICA_USA)  // 225 USA
                    .setDomain     (Domain.inst(PlatformDomain.LAND))      // Land (vs air, surface, subsurface, space)
                    .setCategory   ((byte) 1)   // Tank
                    .setSubCategory((byte) 1)   // M1 Abrams
                    .setSpecific   ((byte) 3);  // M1A2 Abrams
    
    espdu.setEntityType(entityType);
    // Alternate way using entity jar(s)
    espdu.setEntityType(new edu.nps.moves.dis7.entities.usa.platform.land.M1A2());
    // or simply use an enumeration by name, with accompanying import statement above
    espdu.setEntityType(new M1A2()); 
        
    testOnePdu(espdu);
    testOnePdu(espdu.setEntityID(entityID).setEntityType(entityType));   
  }
  
  /** 
   * Test single PDU for correctness according to all contained fields in this PDU type
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
     EntityStatePdu      newEspdu = (EntityStatePdu) newPdu;
     EntityStatePdu receivedEspdu = (EntityStatePdu) newPdu;
     assertEquals (newEspdu.getEntityID(),                receivedEspdu.getEntityID(),                "mismatched EntityID");
     // TODO Sequence number
     assertEquals (newEspdu.getEntityType(),              receivedEspdu.getEntityType(),              "mismatched EntityType");
     // padding?
     assertEquals (newEspdu.getEntityAppearance(),        receivedEspdu.getEntityAppearance(),        "mismatched EntityAppearance");
     assertEquals (newEspdu.getCapabilities(),            receivedEspdu.getCapabilities(),            "mismatched EntityCapabilities");
     assertEquals (newEspdu.getEntityLocation(),          receivedEspdu.getEntityLocation(),          "mismatched EntityLocation");
     assertEquals (newEspdu.getEntityOrientation(),       receivedEspdu.getEntityOrientation(),       "mismatched EntityOrientation");
     assertEquals (newEspdu.getForceId(),                 receivedEspdu.getForceId(),                 "mismatched EntityForceId");
     assertEquals (newEspdu.getMarking(),                 receivedEspdu.getMarking(),                 "mismatched Marking");
     assertEquals (newEspdu.getDeadReckoningParameters(), receivedEspdu.getDeadReckoningParameters(), "mismatched DeadReckoningParameters");
     
     // attached parts, utility method for NumberVariableParameters
     assertEquals (newEspdu.getVariableParameters(),      receivedEspdu.getVariableParameters(),      "mismatched VariableParameters");
     assertEquals (newEspdu.getEntityLinearVelocity(),    receivedEspdu.getEntityLinearVelocity(),    "mismatched EntityLinearVelocity");

     // trace option to compare strings, JSON or XML
     if (false) // true || !newEspdu.toString().equals(receivedEspdu.toString())) 
     {
         System.err.println("     newEspdu=" +      newEspdu.toString());
         System.err.println("receivedEspdu=" + receivedEspdu.toString());
     }
     assertEquals (newEspdu.toString(),    receivedEspdu.toString(),    "mismatched toString()");
     // built-in object comparison
     assertTrue   (newEspdu.equalsImpl(receivedEspdu),                                                "EntityStatePdu.equalsImpl() built-in object comparison");
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
        EntityStatePduTest entityStatePduTest = new EntityStatePduTest();
        
        entityStatePduTest.setUp();
        entityStatePduTest.testRoundTrip();
        entityStatePduTest.tearDown();
    }
}
