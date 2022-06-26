/**
 * Copyright (c) 2008-2022, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.enumerations.PlatformDomain;
import edu.nps.moves.dis7.pdus.Domain;
import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.EntityMarking;
import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.EntityType;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.utilities.PduFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of Entity State PDU (ESPDU) fields and values.
 */
@DisplayName("Entity State Pdu Test")
public class EntityStatePduTest extends PduTest
{
    /** default constructor */
    public EntityStatePduTest()
    {
        // initialization code here
    }
  /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
  @Test
  @Override
  public void testRoundTrip()
  {
    PduFactory pduFactory = new PduFactory();
    
    EntityStatePdu    espdu = pduFactory.makeEntityStatePdu(); 
    
    EntityID       entityID = new EntityID().setSiteID((short)1).setApplicationID((short)2).setEntityID((short)3);
    espdu.setEntityID(entityID);
    
    // TODO test various alternate constructors and utility methods
    
    EntityType   entityType = new EntityType()
                    .setEntityKind (EntityKind.PLATFORM)  //(short) 1); // Platform (vs lifeform, munition, sensor, etc.); //(short) 1); // Platform (vs lifeform, munition, sensor, etc.)
                    .setCountry    (Country.UNITED_STATES_OF_AMERICA_USA)  // 225 USA
                    .setDomain     (Domain.inst(PlatformDomain.LAND))      // Land (vs air, surface, subsurface, space)
                    .setCategory   (1)   // Tank
                    .setSubCategory(1)   // M1 Abrams
                    .setSpecific   (3);  // M1A2 Abrams
    espdu.setEntityType(entityType);
    // TODO this is screaming for utility methods...
    EntityMarking entityMarking = new EntityMarking().setCharacters("Espdu Test1".getBytes());
    espdu.setMarking   (entityMarking);
    
    // TODO causes failure, need to debug setter:
//    // Alternate way using entity jar(s)
//    espdu.setEntityType(new edu.nps.moves.dis7.entities.usa.platform.land.M1A2());
//    // or simply use an enumeration by name, with accompanying import statement above
//    espdu.setEntityType(new M1A2()); 
        
    testOnePdu(espdu);
    testOnePdu(espdu.setEntityID(entityID).setEntityType(entityType)
                    .setMarking(entityMarking.setCharacters("Espdu Test2".getBytes()))); // pipelining
  }
  
  /** 
   * Test single PDU for correctness according to all contained fields in this PDU type
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @param createdPdu separate PDU for comparison
   */
  @Override
  protected void testOnePdu(Pdu createdPdu)
  {
     testPduSendReceiveHeaderMatch (createdPdu); // shared tests in superclass
     
     // can cast PDUs at this point since PduType matched
     EntityStatePdu  createdEspdu = (EntityStatePdu)  createdPdu;
     EntityStatePdu receivedEspdu = (EntityStatePdu) receivedPdu;
     
     assertEquals (createdEspdu.getEntityID(),                receivedEspdu.getEntityID(),                "mismatched EntityID");
     // TODO Sequence number
     assertEquals (createdEspdu.getEntityType(),              receivedEspdu.getEntityType(),              "mismatched EntityType");
     // padding?
     assertEquals (createdEspdu.getEntityAppearance(),        receivedEspdu.getEntityAppearance(),        "mismatched EntityAppearance");
     assertEquals (createdEspdu.getCapabilities(),            receivedEspdu.getCapabilities(),            "mismatched EntityCapabilities");
     assertEquals (createdEspdu.getEntityLocation(),          receivedEspdu.getEntityLocation(),          "mismatched EntityLocation");
     assertEquals (createdEspdu.getEntityOrientation(),       receivedEspdu.getEntityOrientation(),       "mismatched EntityOrientation");
     assertEquals (createdEspdu.getForceId(),                 receivedEspdu.getForceId(),                 "mismatched EntityForceId");
     assertEquals (createdEspdu.getMarking(),                 receivedEspdu.getMarking(),                 "mismatched Marking");
     assertEquals (createdEspdu.getDeadReckoningParameters(), receivedEspdu.getDeadReckoningParameters(), "mismatched DeadReckoningParameters");
     
     // attached parts, utility method for NumberVariableParameters
     assertEquals (createdEspdu.getVariableParameters(),      receivedEspdu.getVariableParameters(),      "mismatched VariableParameters");
     assertEquals (createdEspdu.getEntityLinearVelocity(),    receivedEspdu.getEntityLinearVelocity(),    "mismatched EntityLinearVelocity");

     testPduFinishingChecks(createdPdu); // shared tests in superclass
  }
  
  /** Command-line invocation (CLI) of program, execution starts here
    * @param args command-line arguments
    */
    public static void main(String[] args)
    {
        EntityStatePduTest entityStatePduTest = new EntityStatePduTest();
        
        entityStatePduTest.setUp();
        entityStatePduTest.testRoundTrip();
        entityStatePduTest.tearDown();
    }
}
