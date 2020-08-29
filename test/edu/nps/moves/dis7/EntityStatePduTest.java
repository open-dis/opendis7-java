/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.entities.usa.platform.land.M1A2;
import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.utilities.DisThreadedNetIF;
import edu.nps.moves.dis7.utilities.PduFactory;
import edu.nps.moves.dis7.enumerations.PlatformDomain;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Entity State Pdu Test")
public class EntityStatePduTest
{
  DisThreadedNetIF             disThreadedNetworkInterface;
  Pdu                          receivedPdu;
  DisThreadedNetIF.PduListener pduListener;
    
  @BeforeAll
  public static void setUpClass()
  {
    System.out.println("EntityStatePduTest");
  }

  @AfterAll
  public static void tearDownClass()
  {
  }

  @BeforeEach
  public void setUp()
  {
      disThreadedNetworkInterface = new DisThreadedNetIF();
      pduListener = new DisThreadedNetIF.PduListener() {
          @Override
          public void incomingPdu(Pdu newPdu) {
              setUpReceiver(newPdu);
  }
      };
      disThreadedNetworkInterface.addListener(pduListener);
  }

  @AfterEach
  public void tearDown()
  {
      disThreadedNetworkInterface.removeListener(pduListener);
      disThreadedNetworkInterface.kill();
      disThreadedNetworkInterface = null;
  }

  @Test
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
        
    testOne(espdu);
    testOne(espdu.setEntityID(entityID).setEntityType(entityType));   
  }
  
  private void testOne(Pdu newPdu)
  {
     sendPdu(newPdu); // will wait a while
     assertTrue(receivedPdu != null,         "No response from network receive");
     assertEquals(newPdu.getMarshalledSize(),receivedPdu.getMarshalledSize(),
        "Marshalled size mismatch," +
            "sent (" +      newPdu.getMarshalledSize() + " bytes) and " +
        "recieved (" + receivedPdu.getMarshalledSize() + " bytes)");
     assertTrue(compare(newPdu,receivedPdu), "Comparison failed");
     receivedPdu = null; // ensure cleared prior to next test
  }
  
  private void sendPdu(Pdu pdu)
  {
    try {
      disThreadedNetworkInterface.send(pdu);
      Thread.sleep(100);
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
  
  private void setUpReceiver(Pdu newPdu)
  {
    receivedPdu = newPdu;
  }
  
  public static void main(String[] args)
  {
    EntityStatePduTest entityStatePduTest = new EntityStatePduTest();
    
    entityStatePduTest.setUp();
    entityStatePduTest.testRoundTrip();
    entityStatePduTest.tearDown();
  }
}
