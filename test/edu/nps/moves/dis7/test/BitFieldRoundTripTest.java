/**
 * Copyright (c) 2008-2022, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
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

/**
 * Unit tests for satisfactory handling of various necessary bit fields, supporting each data type.
 * @author Don McGregor
 */
@DisplayName("Bit Field Round Trip Test")
public class BitFieldRoundTripTest
{
    /** default constructor */
    public BitFieldRoundTripTest()
    {
        // initialization code here
    }

    Pdu receivedPdu;
    DisThreadedNetworkInterface disNetworkInterface;
    DisThreadedNetworkInterface.PduListener pduListener;

  /** test method override */
  @BeforeAll
  public static void setUpClass()
  {
    System.out.println("BitFieldRoundTripTest setUpClass()");
  }

  /** test method override */
  @AfterAll
  public static void tearDownClass()
  {
    System.out.println("BitFieldRoundTripTest tearDownClass()");
  }

  /** setup disNetworkInterface and pduListener */
  @BeforeEach
  public void setUp()
  {   
      disNetworkInterface = new DisThreadedNetworkInterface();
      pduListener = (Pdu pdu) -> {
          setUpReceiver(pdu);
      };
      disNetworkInterface.addListener(pduListener);
  }

  /** Tear down disNetworkInterface */
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

  /** Callback method for pduListener
   * @param pdu received PDU*/
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
  
    /**
     * Main method for testing.
     * @see <a href="https://docs.oracle.com/javase/tutorial/getStarted/application/index.html">Java Tutorials: A Closer Look at the "Hello World!" Application</a>
     * @param args [address, port, descriptor] command-line arguments are an array of optional String parameters that are passed from execution environment during invocation
     */
    public static void main(String[] args)
    {
        BitFieldRoundTripTest bitFieldRoundTripTest = new BitFieldRoundTripTest();
        bitFieldRoundTripTest.setUp();
        bitFieldRoundTripTest.testRoundTrip();
        bitFieldRoundTripTest.tearDown();
    }
}
