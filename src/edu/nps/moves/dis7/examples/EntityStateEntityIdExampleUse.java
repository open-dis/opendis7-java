/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.utilities.PduFactory;
import edu.nps.moves.dis7.enumerations.DisPduType;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import java.io.IOException;
import edu.nps.moves.dis7.entities.usa.platform.surface.*;

/**
 * <p>The Entity Type record, described in section 6.2.30 of IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols, is
 * implemented in this library as edu.nps.moves.dis.EntityType.java. There are 8 fields in the record: kind, domain, country, category, subcategory, specific and extra.  For
 * describing a particular entity in DIS, such as a vehicle, munition, or other, the values for each of these fields are enumerated in the SISO specification,
 * SISO-REF-010-v25, 2018-08-29.</p>
 * 
 * <p>The code generator in the open-dis7-source-generator project produces a class for each entity described in the SISO specification.  Each of these classes is
 * a subclass of EntityType, so may be used in PDUs requiring EntityType instances.  The source for each of these classes is trivial.  As an example, here is
 * the source to Hawk102.java, which is described in the SISO specification under uid 28585</p>
 * <pre>
 * package edu.nps.moves.dis.entities.are.platform.air;
 *
 * import edu.nps.moves.dis.*;
 * import edu.nps.moves.dis.enumerations.*;
 *
 * //SISO-REF-010-v25, 2018-08-29
 *
 * //Country: United Arab Emirates (ARE)
 * //Entity kind: Platform
 * //Domain: AIR
 *
 * //Entity uid: 28578
 *
 * public class Hawk102 extends EntityType
 * {
 *   public Hawk102()
 *   {
 *      setCountry(Country.UNITED_ARAB_EMIRATES_ARE);
 *      setEntityKind(EntityKind.PLATFORM);
 *      setDomain(Domain.inst(PlatformDomain.AIR));
 *
 *      setCategory((byte)40); // uid 28579, Trainer
 *      setSubCategory((byte)1); // uid 28580, BAE Systems Hawk
 *      setSpecific((byte)3); // uid 28585, Hawk 102
 *   }
 * }
 * </pre>
 * <p>Entity classes are found in several jars included in this project. They are typically separated into countries and/or platforms.  Assuming one or more are in the application
 * classpath, individual entity types may be used/instantiated in either of 2 ways:</p>
 * 
 * <p>1. By name, including package.  For example, you may include the following statements in your application:</p>
 *  <pre>import edu.nps.moves.dis.entities.are.platform.air.Hawk102;
 * EntityType et = new Hawk102();</pre>
 * 
 * <p>2. By <b>SISO uid</b>. Included in the <u>edu.nps.moves.dis.entities</u> package is the EntityTypeFactory class.  
 * It has a static method with a makeEntity method.  You would do:</p>
 * <pre>import edu.nps.moves.dis.entities.EntityFactory;
 * EntityType et = EntityTypeFactory.makeEntity(28585);</pre>
 * 
 * <p>Importantly, if you pass a legal uid to the makeEntity method, but do not have the appropriate entity jar in your classpath, the method returns null,
 * and displays a message on System.err.</p>
 * 
 * The code in this class illustrates EntityStatePDU and EntityType use.
 * 
 */
public class EntityStateEntityIdExampleUse
{
    /** default constructor */
    public EntityStateEntityIdExampleUse()
    {
        // initialization code here
    }
  /**
   * Using two methods, create and send an EntityStatePDU, describing an AD44 Shenandoah destroyer tender, uid 11963.
   * @throws IOException report if problem occurs
   */
  public static void exampleUse() throws Exception
  {
    DisThreadedNetworkInterface disNetworkInterface = new DisThreadedNetworkInterface(); // uses defaults
    
    // We want to listen also, so add a listener, using JDK8+ lambda grammar
    disNetworkInterface.addListener(pdu->handleReceivedPdu(pdu));
    
    PduFactory pduFactory = new PduFactory();  // uses defaults: usa, exercise id 1, site id 2, app id 3, absolute time

    EntityStatePdu espdu = pduFactory.makeEntityStatePdu();  
    /* set desired entity state fields here */
    
    // TODO check
//    EntityType et = EntityTypeFactory.makeEntity(11963);
//    if(et == null) {
//      System.err.println("Missing USA SURFACE entity jar in classpath");
//      return;
//    }
//    espdu.setEntityType(et);
    
    System.out.println("Sending " + espdu.getClass().getSimpleName());
    disNetworkInterface.send(espdu);  // possibly throws IOException
    Thread.sleep(100L); // TODO unnecessary?
    
    /* Do the same for the second way of creating a Shenandoah entity type and show an alternate way of creating an ESPDU */
    
    espdu = (EntityStatePdu)pduFactory.createPdu(DisPduType.ENTITY_STATE);
    /* set desired entity state fields here */

    AD44Shenandoah entityType2 = new AD44Shenandoah(); // edu.nps.moves.dis7.entities.usa.platform.surface
    
    espdu.setEntityType(entityType2);
    System.out.println("Sending " + espdu.getClass().getSimpleName());
    disNetworkInterface.send(espdu);  // possibly throws IOException
  }
  
  private static void handleReceivedPdu(Pdu pdu)
  {
    // Do something here with the pdu you received
    System.out.println("Received "+pdu.getClass().getSimpleName());
  }

  /** Command-line invocation (CLI)
    * @param args command-line arguments
    * @throws java.lang.Exception if fails
    */
  public static void main(String[] args) throws Exception
  {
      EntityStateEntityIdExampleUse.exampleUse(); // run example showing use
  }
}
