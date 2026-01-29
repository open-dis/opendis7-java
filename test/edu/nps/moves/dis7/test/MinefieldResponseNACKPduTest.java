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

import edu.nps.moves.dis7.pdus.MinefieldIdentifier;
import edu.nps.moves.dis7.pdus.MinefieldResponseNACKPdu;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.SimulationAddress;
import edu.nps.moves.dis7.pdus.SimulationIdentifier;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of Minefield Response NACK PDU fields and values.
 */
@DisplayName("MinefieldResponseNACKPduTest")
public class MinefieldResponseNACKPduTest extends PduTest
{
    /** default constructor */
    public MinefieldResponseNACKPduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** MinefieldResponseNACKPduTest setUpClass()");
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** MinefieldResponseNACKPduTest testMultiplePdus()");

        MinefieldResponseNACKPdu mrnPdu = pduFactory.makeMinefieldResponseNackPdu();

        mrnPdu.setMinefieldID(new MinefieldIdentifier().setSimulationAddress(new SimulationAddress().setSite(1).setApplication(2)).setMinefieldNumber(100));
        mrnPdu.setRequestingEntityID(new SimulationIdentifier().setSiteID(3).setApplicationID(4));
        mrnPdu.setRequestID((byte) 1);
        testOnePdu(mrnPdu);

        mrnPdu.setRequestID((byte) 2);
        testOnePdu(mrnPdu);
    }

    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu);

        MinefieldResponseNACKPdu  createdCast = (MinefieldResponseNACKPdu) createdPdu;
        MinefieldResponseNACKPdu receivedCast = (MinefieldResponseNACKPdu) receivedPdus.get(0);

        assertEquals(createdCast.getMinefieldID(),               receivedCast.getMinefieldID(),               "mismatched MinefieldID");
        assertEquals(createdCast.getRequestingEntityID(),        receivedCast.getRequestingEntityID(),        "mismatched RequestingEntityID");
        assertEquals(createdCast.getRequestID(),                 receivedCast.getRequestID(),                 "mismatched RequestID");
        assertArrayEquals(createdCast.getMissingPduSequenceNumbers(), receivedCast.getMissingPduSequenceNumbers(), "mismatched MissingPduSequenceNumbers");

        testPduCommonFields(createdPdu);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest test = new MinefieldResponseNACKPduTest();
        test.setUp();
        test.testMultiplePdus();
        test.tearDown();
    }
}
