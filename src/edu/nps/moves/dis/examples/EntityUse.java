/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis.examples;

import edu.nps.moves.dis.EntityStatePdu;
import edu.nps.moves.dis.EntityType;
import edu.nps.moves.dis.util.DisNetworking;
import edu.nps.moves.dis.util.PduFactory;
import edu.nps.moves.dis.entities.EntityTypeFactory;
import edu.nps.moves.dis.enumerations.DISPDUType;
import java.io.IOException;

/**
 * The Entity Type record, described in section 6.2.30 of IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols, is
 * implemented in this library as edu.nps.moves.dis.EntityType.java. There are 8 fields in the record: kind, domain, country, category, subcategory, specific and extra.  For
 * describing a particular entity in DIS, such as a vehicle, munition, or other, the values for each of these fields are enumerated in the SISO specification,
 * SISO-REF-010-v25, 2018-08-29.<p>
 * 
 * The code generator in the open-dis7-source-generator project produces a class for each entity described in the SISO specification.  Each of these classes is
 * a subclass of EntityType, so may be used in PDUs requiring EntityType instances.  The source for each of these classes is trivial.  As an example, here is
 * the source to Hawk102.java, which is described in the SISO specification under uid 28585:<pre>
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
 * Entity classes are found in several jars included in this project. They are typically separated into countries and/or platforms.  Assuming one or more are in the application
 * classpath, individual entity types may be used/instantiated in either of 2 ways:<p>
 * 
 * 1. By name, including package.  For example, you may include the following statements in your application:<pre>
 * import edu.nps.moves.dis.entities.are.platform.air.Hawk102;
 * EntityType et = new Hawk102();</pre>
 * 
 * 2. By <b>SISO uid</b>. Included in the <u>edu.nps.moves.dis.entities</u> package is the EntityTypeFactory class.  It has a static method with a makeEntity method.  You would do:<pre>
 * import edu.nps.moves.dis.entities.EntityFactory;
 * EntityType et = EntityTypeFactory.makeEntity(28585);</pre>
 * 
 * Importantly, if you pass a legal uid to the makeEntity method, but do not have the appropriate entity jar in your classpath, the method returns null,
 * and displays a message on System.err.<p>
 * 
 * The code in this class illustrates EntityType use.
 * 
 */
public class EntityUse
{
  /**
   * Using two methods, create and send an EntityState PDU, describing an AD44 Shenandoah destroyer tender, uid 11963.
   * @throws IOException 
   */
  public static void exampleUse() throws IOException
  {
    PduFactory pduFactory = new PduFactory();  // uses defaults: usa, exercise id 1, site id 2, app id 3, absolute time

    EntityStatePdu pdu = pduFactory.makeEntityStatePdu();  
    /* set desired entity state fields here */
    
    EntityType et = EntityTypeFactory.makeEntity(11963);
    if(et == null) {
      System.err.println("Missing USA SURFACE entity jar in classpath");
      return;
    }
    
    pdu.setEntityType(et);
    DisNetworking disnet = new DisNetworking(); // uses defaults: multicast port 3000 ip 230.0.0.0
    disnet.sendPdu(pdu);  // possibly throws IOException
    
    /* Do the same for the second way of creating a Shenandoah entity type and show an alternate way of creating an ESPDU */
    
    EntityStatePdu pdu2 = (EntityStatePdu)pduFactory.createPdu(DISPDUType.ENTITY_STATE);
    /* set desired entity state fields here */

    edu.nps.moves.dis.entities.usa.platform.surface.AD44Shenandoah et2 = new edu.nps.moves.dis.entities.usa.platform.surface.AD44Shenandoah();
    /* Use import statement to make the code above more readable */
    
    pdu2.setEntityType(et2);
    disnet.sendPdu(pdu2);  // possibly throws IOException
  }
}
