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

import edu.nps.moves.dis7.enumerations.ForceID;
import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.EulerAngles;
import edu.nps.moves.dis7.pdus.ObjectType;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.PointObjectStatePdu;
import edu.nps.moves.dis7.pdus.SimulationAddress;
import edu.nps.moves.dis7.pdus.Vector3Double;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of Point Object State PDU fields and values.
 */
@DisplayName("PointObjectStatePduTest")
public class PointObjectStatePduTest extends PduTest
{
    /** default constructor */
    public PointObjectStatePduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** PointObjectStatePduTest setUpClass()");
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** PointObjectStatePduTest testMultiplePdus()");

        PointObjectStatePdu posPdu = pduFactory.makePointObjectStatePdu();

        posPdu.setObjectID(new EntityID().setSiteID(1).setApplicationID(2).setEntityID(3));
        posPdu.setForceID(ForceID.FRIENDLY);
        posPdu.setObjectType(new ObjectType().setDomain((byte) 1).setObjectKind((byte) 1).setCategory((byte) 1));
        posPdu.setObjectLocation(new Vector3Double().setX(1000.0).setY(2000.0).setZ(3000.0));
        posPdu.setObjectOrientation(new EulerAngles().setPhi(0.1f).setTheta(0.2f).setPsi(0.3f));
        posPdu.setRequesterID(new SimulationAddress().setSite(1).setApplication(2));
        posPdu.setReceivingID(new SimulationAddress().setSite(3).setApplication(4));
        posPdu.setUpdateNumber(1);
        testOnePdu(posPdu);

        posPdu.setObjectLocation(new Vector3Double().setX(4000.0).setY(5000.0).setZ(6000.0));
        posPdu.setUpdateNumber(2);
        testOnePdu(posPdu);
    }

    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu);

        PointObjectStatePdu  createdCast = (PointObjectStatePdu) createdPdu;
        PointObjectStatePdu receivedCast = (PointObjectStatePdu) receivedPdus.get(0);

        assertEquals(createdCast.getObjectID(),                receivedCast.getObjectID(),                "mismatched ObjectID");
        assertEquals(createdCast.getReferencedObjectID(),      receivedCast.getReferencedObjectID(),      "mismatched ReferencedObjectID");
        assertEquals(createdCast.getUpdateNumber(),            receivedCast.getUpdateNumber(),            "mismatched UpdateNumber");
        assertEquals(createdCast.getForceID(),                 receivedCast.getForceID(),                 "mismatched ForceID");
        assertEquals(createdCast.getModifications(),           receivedCast.getModifications(),           "mismatched Modifications");
        assertEquals(createdCast.getObjectType(),              receivedCast.getObjectType(),              "mismatched ObjectType");
        assertEquals(createdCast.getObjectLocation(),          receivedCast.getObjectLocation(),          "mismatched ObjectLocation");
        assertEquals(createdCast.getObjectOrientation(),       receivedCast.getObjectOrientation(),       "mismatched ObjectOrientation");
        assertEquals(createdCast.getSpecificObjectAppearance(), receivedCast.getSpecificObjectAppearance(), "mismatched SpecificObjectAppearance");
        assertEquals(createdCast.getGenerObjectAppearance(),   receivedCast.getGenerObjectAppearance(),   "mismatched GenerObjectAppearance");
        assertEquals(createdCast.getRequesterID(),             receivedCast.getRequesterID(),             "mismatched RequesterID");
        assertEquals(createdCast.getReceivingID(),             receivedCast.getReceivingID(),             "mismatched ReceivingID");

        testPduCommonFields(createdPdu);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest test = new PointObjectStatePduTest();
        test.setUp();
        test.testMultiplePdus();
        test.tearDown();
    }
}
