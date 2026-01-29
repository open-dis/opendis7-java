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
import edu.nps.moves.dis7.pdus.EntityType;
import edu.nps.moves.dis7.pdus.EulerAngles;
import edu.nps.moves.dis7.pdus.MinefieldIdentifier;
import edu.nps.moves.dis7.pdus.MinefieldStatePdu;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.SimulationAddress;
import edu.nps.moves.dis7.pdus.Vector3Double;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of Minefield State PDU fields and values.
 */
@DisplayName("MinefieldStatePduTest")
public class MinefieldStatePduTest extends PduTest
{
    /** default constructor */
    public MinefieldStatePduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** MinefieldStatePduTest setUpClass()");
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** MinefieldStatePduTest testMultiplePdus()");

        MinefieldStatePdu msPdu = pduFactory.makeMinefieldStatePdu();

        msPdu.setMinefieldID(new MinefieldIdentifier().setSimulationAddress(new SimulationAddress().setSite(1).setApplication(2)).setMinefieldNumber(100));
        msPdu.setMinefieldSequence((short) 1);
        msPdu.setForceID(ForceID.FRIENDLY);
        msPdu.setMinefieldType(new EntityType().setEntityKind((byte) 1).setDomain((byte) 1).setCountry(225));
        msPdu.setMinefieldLocation(new Vector3Double().setX(1000.0).setY(2000.0).setZ(0.0));
        msPdu.setMinefieldOrientation(new EulerAngles().setPhi(0.0f).setTheta(0.0f).setPsi(1.57f));
        testOnePdu(msPdu);

        msPdu.setMinefieldSequence((short) 2);
        msPdu.setMinefieldLocation(new Vector3Double().setX(3000.0).setY(4000.0).setZ(0.0));
        testOnePdu(msPdu);
    }

    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu);

        MinefieldStatePdu  createdCast = (MinefieldStatePdu) createdPdu;
        MinefieldStatePdu receivedCast = (MinefieldStatePdu) receivedPdus.get(0);

        assertEquals(createdCast.getMinefieldID(),          receivedCast.getMinefieldID(),          "mismatched MinefieldID");
        assertEquals(createdCast.getMinefieldSequence(),    receivedCast.getMinefieldSequence(),    "mismatched MinefieldSequence");
        assertEquals(createdCast.getForceID(),              receivedCast.getForceID(),              "mismatched ForceID");
        assertEquals(createdCast.getMinefieldType(),        receivedCast.getMinefieldType(),        "mismatched MinefieldType");
        assertEquals(createdCast.getMinefieldLocation(),    receivedCast.getMinefieldLocation(),    "mismatched MinefieldLocation");
        assertEquals(createdCast.getMinefieldOrientation(), receivedCast.getMinefieldOrientation(), "mismatched MinefieldOrientation");
        assertEquals(createdCast.getAppearance(),           receivedCast.getAppearance(),           "mismatched Appearance");
        assertEquals(createdCast.getProtocolMode(),         receivedCast.getProtocolMode(),         "mismatched ProtocolMode");
        assertEquals(createdCast.getPerimeterPoints(),      receivedCast.getPerimeterPoints(),      "mismatched PerimeterPoints");
        assertEquals(createdCast.getMineType(),             receivedCast.getMineType(),             "mismatched MineType");

        testPduCommonFields(createdPdu);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest test = new MinefieldStatePduTest();
        test.setUp();
        test.testMultiplePdus();
        test.tearDown();
    }
}
