/*
Copyright (c) 1995-2026 held by the author(s).  All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer
      in the documentation and/or other materials provided with the
      distribution.
    * Neither the names of the Naval Postgraduate School (NPS)
      Modeling Virtual Environments and Simulation (MOVES) Institute
      https://www.nps.edu and https://www.nps.edu/web/moves
      nor the names of its contributors may be used to endorse or
      promote products derived from this software without specific
      prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
*/
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.CollisionElasticPdu;
import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.Vector3Float;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of Collision Elastic PDU fields and values.
 */
@DisplayName("CollisionElasticPduTest")
public class CollisionElasticPduTest extends PduTest
{
    /** default constructor */
    public CollisionElasticPduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** CollisionElasticPduTest setUpClass()");

        // superclass automatically setUp(), which includes setupNetwork()
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** CollisionElasticPduTest testMultiplePdus()");

        CollisionElasticPdu collisionElasticPdu = pduFactory.makeCollisionElasticPdu();

        collisionElasticPdu.setIssuingEntityID(new EntityID().setSiteID(1).setApplicationID(2).setEntityID(3));
        collisionElasticPdu.setCollidingEntityID(new EntityID().setSiteID(4).setApplicationID(5).setEntityID(6));
        collisionElasticPdu.setCollisionEventID(eventIdentifier.setEventNumber(incrementMasterEventNumber()));
        collisionElasticPdu.setContactVelocity(new Vector3Float().setX(10.0f).setY(20.0f).setZ(30.0f));
        collisionElasticPdu.setMass(5000.0f);
        collisionElasticPdu.setLocationOfImpact(new Vector3Float().setX(100.0f).setY(200.0f).setZ(300.0f));
        collisionElasticPdu.setCollisionIntermediateResultXX(1.0f);
        collisionElasticPdu.setCollisionIntermediateResultXY(0.5f);
        collisionElasticPdu.setCollisionIntermediateResultXZ(0.25f);
        collisionElasticPdu.setCollisionIntermediateResultYY(2.0f);
        collisionElasticPdu.setCollisionIntermediateResultYZ(0.75f);
        collisionElasticPdu.setCollisionIntermediateResultZZ(3.0f);
        collisionElasticPdu.setUnitSurfaceNormal(new Vector3Float().setX(0.0f).setY(0.0f).setZ(1.0f));
        collisionElasticPdu.setCoefficientOfRestitution(0.8f);
        testOnePdu(collisionElasticPdu);

        collisionElasticPdu.setCollisionEventID(eventIdentifier.setEventNumber(incrementMasterEventNumber()));
        testOnePdu(collisionElasticPdu.setMass(8000.0f).setCoefficientOfRestitution(0.5f));

        // TODO additional PDU-specific tests
        // TODO test various alternate constructors and utility methods
    }

    /** Test single PDU for correctness according to all contained fields in this PDU type
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param createdPdu separate PDU for comparison
     */
    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu); // shared tests in superclass

        // can cast PDUs at this point since PduType matched
        CollisionElasticPdu  createdPduCast = (CollisionElasticPdu) createdPdu;
        CollisionElasticPdu receivedPduCast = (CollisionElasticPdu) receivedPdus.get(0); // TODO might be more than one on receivedPdus list

        assertEquals(createdPduCast.getIssuingEntityID(),                receivedPduCast.getIssuingEntityID(),                "mismatched IssuingEntityID");
        assertEquals(createdPduCast.getCollidingEntityID(),              receivedPduCast.getCollidingEntityID(),              "mismatched CollidingEntityID");
        assertEquals(createdPduCast.getCollisionEventID(),               receivedPduCast.getCollisionEventID(),               "mismatched CollisionEventID");
        assertEquals(createdPduCast.getContactVelocity(),                receivedPduCast.getContactVelocity(),                "mismatched ContactVelocity");
        assertEquals(createdPduCast.getMass(),                           receivedPduCast.getMass(),                           "mismatched Mass");
        assertEquals(createdPduCast.getLocationOfImpact(),               receivedPduCast.getLocationOfImpact(),               "mismatched LocationOfImpact");
        assertEquals(createdPduCast.getCollisionIntermediateResultXX(),  receivedPduCast.getCollisionIntermediateResultXX(),  "mismatched CollisionIntermediateResultXX");
        assertEquals(createdPduCast.getCollisionIntermediateResultXY(),  receivedPduCast.getCollisionIntermediateResultXY(),  "mismatched CollisionIntermediateResultXY");
        assertEquals(createdPduCast.getCollisionIntermediateResultXZ(),  receivedPduCast.getCollisionIntermediateResultXZ(),  "mismatched CollisionIntermediateResultXZ");
        assertEquals(createdPduCast.getCollisionIntermediateResultYY(),  receivedPduCast.getCollisionIntermediateResultYY(),  "mismatched CollisionIntermediateResultYY");
        assertEquals(createdPduCast.getCollisionIntermediateResultYZ(),  receivedPduCast.getCollisionIntermediateResultYZ(),  "mismatched CollisionIntermediateResultYZ");
        assertEquals(createdPduCast.getCollisionIntermediateResultZZ(),  receivedPduCast.getCollisionIntermediateResultZZ(),  "mismatched CollisionIntermediateResultZZ");
        assertEquals(createdPduCast.getUnitSurfaceNormal(),              receivedPduCast.getUnitSurfaceNormal(),              "mismatched UnitSurfaceNormal");
        assertEquals(createdPduCast.getCoefficientOfRestitution(),       receivedPduCast.getCoefficientOfRestitution(),       "mismatched CoefficientOfRestitution");
        assertEquals(createdPduCast.getPad(),                            receivedPduCast.getPad(),                            "mismatched Pad");

        testPduCommonFields(createdPdu); // shared tests in superclass
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest collisionElasticPduTest = new CollisionElasticPduTest();

        collisionElasticPduTest.setUp();
        collisionElasticPduTest.testMultiplePdus();
        collisionElasticPduTest.tearDown();
    }
}
