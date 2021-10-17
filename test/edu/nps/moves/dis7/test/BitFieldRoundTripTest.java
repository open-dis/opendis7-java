/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.enumerations.AppearanceCamouflageType;
import edu.nps.moves.dis7.enumerations.ForceID;
import edu.nps.moves.dis7.enumerations.LandPlatformAppearance;
import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.EulerAngles;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.Vector3Double;
import edu.nps.moves.dis7.pdus.Vector3Float;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.PduFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Bit Field Round TripTest")
public class BitFieldRoundTripTest
{
    Pdu receivedPdu;
    DisThreadedNetworkInterface disNetworkInterface;
    DisThreadedNetworkInterface.PduListener pduListener;

  @BeforeAll
  public static void setUpClass()
  {
    System.out.println("BitFieldRoundTripTest");
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
      disNetworkInterface.close();
  }

  @Test
  public void testRoundTrip()
  {
    PduFactory factory = new PduFactory();

    EntityStatePdu espdu = factory.makeEntityStatePdu();
    
    espdu.setForceId(ForceID.FRIENDLY_9);
    espdu.setEntityType(new edu.nps.moves.dis7.entities.usa.platform.land.MK4814logisticsplatformtruck());
    Vector3Float lv = new Vector3Float();
    lv.setX(5.0f);
    espdu.setEntityLinearVelocity(lv);
    Vector3Double loc = new Vector3Double();
    loc.setX(10.0d).setY(20.0d).setZ(1.0d);
    espdu.setEntityLocation(loc);
    
    EulerAngles euler = new EulerAngles();
    euler.setPhi(25.0f).setPsi(35.0f).setTheta(45.0f);
    espdu.setEntityOrientation(euler);
    
    LandPlatformAppearance app = new LandPlatformAppearance();
    app.set(LandPlatformAppearance.BLACKOUTBRAKELIGHTSON, 1)
      .set(LandPlatformAppearance.CAMOUFLAGETYPE, AppearanceCamouflageType.FOREST_CAMOUFLAGE.getValue())
      .set(LandPlatformAppearance.ISFROZEN,1);
  
    try {
      disNetworkInterface.send(espdu);
      Thread.sleep(100l); 
    }
    catch (InterruptedException ex) {
      System.err.println("Error sending Multicast: " + ex.getLocalizedMessage());
      System.exit(1);
    }

    // Compare
    // If we made it this far, we've sent and received.  Now compare.
    dump("Sent pdu: ",espdu);
    dump("Rcvd pdu: ",espdu);
    boolean same = receivedPdu.equals(espdu);
    assertTrue(same, "Sent and received pdu not the same");
  }

  private void setUpReceiver(Pdu pdu)
  {
    receivedPdu = pdu;
  }
  
  private void dump(String s, EntityStatePdu espdu)
  {
    System.out.println(s);
    System.out.println("Alternative EntityType: "+espdu.getAlternativeEntityType().toString());
    System.out.println("Entity Capabilities: "+espdu.getCapabilities().toString());
    System.out.println("Dead Reckoning Parameters: "+ espdu.getDeadReckoningParameters().toString());
    System.out.println("Entity Appearance: "+ espdu.getEntityAppearance());
    System.out.println("Entity ID: "+ espdu.getEntityID().toString());
    System.out.println("Entity Linear Velocity: "+ espdu.getEntityLinearVelocity().toString());
    System.out.println("Entity Location: "+ espdu.getEntityLocation().toString());
    System.out.println("Entity Orientation: "+ espdu.getEntityOrientation().toString());
    System.out.println("Entity Type: "+ espdu.getEntityType().toString());
    System.out.println("Exercise ID: "+ espdu.getExerciseID());
    System.out.println("Force ID: "+ espdu.getForceId().toString());
    System.out.println("Length: "+ espdu.getLength());
    System.out.println("Marking: "+ espdu.getMarking().toString());
    System.out.println("Pdu Status: "+ espdu.getPduStatus().toString());
    System.out.println("Pdu Type: "+ espdu.getPduType().toString());
    System.out.println("Protocol Family: "+ espdu.getProtocolFamily().toString());
    System.out.println("Protocol Version: "+ espdu.getProtocolVersion());
    System.out.println("Timestamp: "+ espdu.getTimestamp());
    System.out.println("Variable Parameters: "+ espdu.getVariableParameters().toString());
    System.out.println();
 }
  
  public static void main(String[] args)
  {
    BitFieldRoundTripTest brt = new BitFieldRoundTripTest();
    brt.setUp();
    brt.testRoundTrip();
    brt.tearDown();
  }
}
