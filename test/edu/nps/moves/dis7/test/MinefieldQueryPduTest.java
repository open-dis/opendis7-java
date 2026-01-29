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

import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.EntityType;
import edu.nps.moves.dis7.pdus.MinefieldIdentifier;
import edu.nps.moves.dis7.pdus.MinefieldQueryPdu;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.SimulationAddress;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import edu.nps.moves.dis7.pdus.Domain;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.enumerations.PlatformDomain;
import edu.nps.moves.dis7.enumerations.Country;

/**
 * Unit tests for satisfactory handling of Minefield Query PDU fields and values.
 */
@DisplayName("MinefieldQueryPduTest")
public class MinefieldQueryPduTest extends PduTest
{
    /** default constructor */
    public MinefieldQueryPduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** MinefieldQueryPduTest setUpClass()");
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** MinefieldQueryPduTest testMultiplePdus()");

        MinefieldQueryPdu mqPdu = pduFactory.makeMinefieldQueryPdu();

        mqPdu.setMinefieldID(new MinefieldIdentifier().setSimulationAddress(new SimulationAddress().setSite(1).setApplication(2)).setMinefieldNumber(100));
        mqPdu.setRequestingEntityID(new EntityID().setSiteID(3).setApplicationID(4).setEntityID(5));
        mqPdu.setRequestID((byte) 1);
        mqPdu.setRequestedMineType(new EntityType().setEntityKind(EntityKind.PLATFORM).setDomain(Domain.inst(PlatformDomain.LAND)).setCountry(Country.UNITED_STATES_OF_AMERICA_USA));
        testOnePdu(mqPdu);

        mqPdu.setRequestID((byte) 2);
        testOnePdu(mqPdu);
    }

    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu);

        MinefieldQueryPdu  createdCast = (MinefieldQueryPdu) createdPdu;
        MinefieldQueryPdu receivedCast = (MinefieldQueryPdu) receivedPdus.get(0);

        assertEquals(createdCast.getMinefieldID(),             receivedCast.getMinefieldID(),             "mismatched MinefieldID");
        assertEquals(createdCast.getRequestingEntityID(),      receivedCast.getRequestingEntityID(),      "mismatched RequestingEntityID");
        assertEquals(createdCast.getRequestID(),               receivedCast.getRequestID(),               "mismatched RequestID");
        assertEquals(createdCast.getDataFilter(),              receivedCast.getDataFilter(),              "mismatched DataFilter");
        assertEquals(createdCast.getRequestedMineType(),       receivedCast.getRequestedMineType(),       "mismatched RequestedMineType");
        assertEquals(createdCast.getRequestedPerimeterPoints(), receivedCast.getRequestedPerimeterPoints(), "mismatched RequestedPerimeterPoints");
        assertEquals(createdCast.getSensorTypes(),             receivedCast.getSensorTypes(),             "mismatched SensorTypes");

        testPduCommonFields(createdPdu);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest test = new MinefieldQueryPduTest();
        test.setUp();
        test.testMultiplePdus();
        test.tearDown();
    }
}
