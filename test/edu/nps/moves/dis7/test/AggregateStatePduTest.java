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

import edu.nps.moves.dis7.enumerations.AggregateStateAggregateState;
import edu.nps.moves.dis7.enumerations.AggregateStateFormation;
import edu.nps.moves.dis7.enumerations.ForceID;
import edu.nps.moves.dis7.pdus.AggregateIdentifier;
import edu.nps.moves.dis7.pdus.AggregateMarking;
import edu.nps.moves.dis7.pdus.AggregateStatePdu;
import edu.nps.moves.dis7.pdus.AggregateType;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.SimulationAddress;
import edu.nps.moves.dis7.pdus.Vector3Double;
import edu.nps.moves.dis7.pdus.Vector3Float;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of Aggregate State PDU fields and values.
 */
@DisplayName("AggregateStatePduTest")
public class AggregateStatePduTest extends PduTest
{
    /** default constructor */
    public AggregateStatePduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** AggregateStatePduTest setUpClass()");
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** AggregateStatePduTest testMultiplePdus()");

        AggregateStatePdu asPdu = pduFactory.makeAggregateStatePdu();

        asPdu.setAggregateID(new AggregateIdentifier().setSimulationAddress(new SimulationAddress().setSite(1).setApplication(2)).setAggregateID(100));
        asPdu.setForceID(ForceID.FRIENDLY);
        asPdu.setAggregateState(AggregateStateAggregateState.AGGREGATED);
        asPdu.setAggregateType(new AggregateType().setAggregateKind((byte) 1).setDomain((byte) 1).setCountry(225));
        asPdu.setFormation(AggregateStateFormation.VEE);
        asPdu.setAggregateMarking(new AggregateMarking().setCharacters("TestAgg1".getBytes()));
        asPdu.setDimensions(new Vector3Float().setX(100.0f).setY(200.0f).setZ(50.0f));
        asPdu.setCenterOfMass(new Vector3Double().setX(1000.0).setY(2000.0).setZ(3000.0));
        asPdu.setVelocity(new Vector3Float().setX(10.0f).setY(5.0f).setZ(0.0f));
        testOnePdu(asPdu);

        asPdu.setAggregateState(AggregateStateAggregateState.DISAGGREGATED);
        asPdu.setFormation(AggregateStateFormation.ASSEMBLY);
        testOnePdu(asPdu);
    }

    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu);

        AggregateStatePdu  createdCast = (AggregateStatePdu) createdPdu;
        AggregateStatePdu receivedCast = (AggregateStatePdu) receivedPdus.get(0);

        assertEquals(createdCast.getAggregateID(),               receivedCast.getAggregateID(),               "mismatched AggregateID");
        assertEquals(createdCast.getForceID(),                   receivedCast.getForceID(),                   "mismatched ForceID");
        assertEquals(createdCast.getAggregateState(),            receivedCast.getAggregateState(),            "mismatched AggregateState");
        assertEquals(createdCast.getAggregateType(),             receivedCast.getAggregateType(),             "mismatched AggregateType");
        assertEquals(createdCast.getFormation(),                 receivedCast.getFormation(),                 "mismatched Formation");
        assertEquals(createdCast.getAggregateMarking(),          receivedCast.getAggregateMarking(),          "mismatched AggregateMarking");
        assertEquals(createdCast.getDimensions(),                receivedCast.getDimensions(),                "mismatched Dimensions");
        assertEquals(createdCast.getOrientation(),               receivedCast.getOrientation(),               "mismatched Orientation");
        assertEquals(createdCast.getCenterOfMass(),              receivedCast.getCenterOfMass(),              "mismatched CenterOfMass");
        assertEquals(createdCast.getVelocity(),                  receivedCast.getVelocity(),                  "mismatched Velocity");
        assertEquals(createdCast.getAggregateIDList(),           receivedCast.getAggregateIDList(),           "mismatched AggregateIDList");
        assertEquals(createdCast.getEntityIDList(),              receivedCast.getEntityIDList(),              "mismatched EntityIDList");
        assertEquals(createdCast.getSilentAggregateSystemList(), receivedCast.getSilentAggregateSystemList(), "mismatched SilentAggregateSystemList");
        assertEquals(createdCast.getSilentEntitySystemList(),    receivedCast.getSilentEntitySystemList(),    "mismatched SilentEntitySystemList");
        assertEquals(createdCast.getVariableDatumList(),         receivedCast.getVariableDatumList(),         "mismatched VariableDatumList");

        testPduCommonFields(createdPdu);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest test = new AggregateStatePduTest();
        test.setUp();
        test.testMultiplePdus();
        test.tearDown();
    }
}
