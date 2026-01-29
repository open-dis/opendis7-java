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

import edu.nps.moves.dis7.pdus.EntityType;
import edu.nps.moves.dis7.pdus.MinefieldDataPdu;
import edu.nps.moves.dis7.pdus.MinefieldIdentifier;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.SimulationAddress;
import edu.nps.moves.dis7.pdus.SimulationIdentifier;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import edu.nps.moves.dis7.pdus.Domain;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.enumerations.PlatformDomain;
import edu.nps.moves.dis7.enumerations.Country;

/**
 * Unit tests for satisfactory handling of Minefield Data PDU fields and values.
 */
@DisplayName("MinefieldDataPduTest")
public class MinefieldDataPduTest extends PduTest
{
    /** default constructor */
    public MinefieldDataPduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** MinefieldDataPduTest setUpClass()");
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** MinefieldDataPduTest testMultiplePdus()");

        MinefieldDataPdu mdPdu = pduFactory.makeMinefieldDataPdu();

        mdPdu.setMinefieldID(new MinefieldIdentifier().setSimulationAddress(new SimulationAddress().setSite(1).setApplication(2)).setMinefieldNumber(100));
        mdPdu.setRequestingEntityID(new SimulationIdentifier().setSimulationAddress(new SimulationAddress().setSite(3).setApplication(4)));
        mdPdu.setMinefieldSequenceNumbeer((short) 1);
        mdPdu.setRequestID((byte) 1);
        mdPdu.setPduSequenceNumber((byte) 1);
        mdPdu.setNumberOfPdus((byte) 1);
        mdPdu.setMineType(new EntityType().setEntityKind(EntityKind.PLATFORM).setDomain(Domain.inst(PlatformDomain.LAND)).setCountry(Country.UNITED_STATES_OF_AMERICA_USA));
        testOnePdu(mdPdu);

        mdPdu.setMinefieldSequenceNumbeer((short) 2);
        mdPdu.setRequestID((byte) 2);
        testOnePdu(mdPdu);
    }

    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu);

        MinefieldDataPdu  createdCast = (MinefieldDataPdu) createdPdu;
        MinefieldDataPdu receivedCast = (MinefieldDataPdu) receivedPdus.get(0);

        assertEquals(createdCast.getMinefieldID(),              receivedCast.getMinefieldID(),              "mismatched MinefieldID");
        assertEquals(createdCast.getRequestingEntityID(),       receivedCast.getRequestingEntityID(),       "mismatched RequestingEntityID");
        assertEquals(createdCast.getMinefieldSequenceNumbeer(), receivedCast.getMinefieldSequenceNumbeer(), "mismatched MinefieldSequenceNumbeer");
        assertEquals(createdCast.getRequestID(),                receivedCast.getRequestID(),                "mismatched RequestID");
        assertEquals(createdCast.getPduSequenceNumber(),        receivedCast.getPduSequenceNumber(),        "mismatched PduSequenceNumber");
        assertEquals(createdCast.getNumberOfPdus(),             receivedCast.getNumberOfPdus(),             "mismatched NumberOfPdus");
        assertEquals(createdCast.getDataFilter(),               receivedCast.getDataFilter(),               "mismatched DataFilter");
        assertEquals(createdCast.getMineType(),                 receivedCast.getMineType(),                 "mismatched MineType");
        assertEquals(createdCast.getSensorTypes(),              receivedCast.getSensorTypes(),              "mismatched SensorTypes");
        assertEquals(createdCast.getMineLocation(),             receivedCast.getMineLocation(),             "mismatched MineLocation");

        testPduCommonFields(createdPdu);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest test = new MinefieldDataPduTest();
        test.setUp();
        test.testMultiplePdus();
        test.tearDown();
    }
}
