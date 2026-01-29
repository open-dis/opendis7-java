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

import edu.nps.moves.dis7.pdus.ClockTime;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.SimulationIdentifier;
import edu.nps.moves.dis7.pdus.SimulationAddress;
import edu.nps.moves.dis7.pdus.StartResumePdu;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of Start/Resume PDU fields and values.
 */
@DisplayName("StartResumePduTest")
public class StartResumePduTest extends PduTest
{
    /** default constructor */
    public StartResumePduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** StartResumePduTest setUpClass()");
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** StartResumePduTest testMultiplePdus()");

        StartResumePdu startResumePdu = pduFactory.makeStartResumePdu();

        startResumePdu.setOriginatingID(new SimulationIdentifier().setSimulationAddress(new SimulationAddress().setSite(1).setApplication(2)));
        startResumePdu.setReceivingID(new SimulationIdentifier().setSimulationAddress(new SimulationAddress().setSite(3).setApplication(4)));
        startResumePdu.setRealWorldTime(new ClockTime().setHour(10).setTimePastHour(500000));
        startResumePdu.setSimulationTime(new ClockTime().setHour(0).setTimePastHour(0));
        startResumePdu.setRequestID(3001);
        testOnePdu(startResumePdu);

        startResumePdu.setRequestID(3002);
        startResumePdu.setRealWorldTime(new ClockTime().setHour(11).setTimePastHour(600000));
        testOnePdu(startResumePdu);
    }

    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu);

        StartResumePdu  createdCast = (StartResumePdu) createdPdu;
        StartResumePdu receivedCast = (StartResumePdu) receivedPdus.get(0);

        assertEquals(createdCast.getOriginatingID(),  receivedCast.getOriginatingID(),  "mismatched OriginatingID");
        assertEquals(createdCast.getReceivingID(),    receivedCast.getReceivingID(),    "mismatched ReceivingID");
        assertEquals(createdCast.getRealWorldTime(),  receivedCast.getRealWorldTime(),  "mismatched RealWorldTime");
        assertEquals(createdCast.getSimulationTime(), receivedCast.getSimulationTime(), "mismatched SimulationTime");
        assertEquals(createdCast.getRequestID(),      receivedCast.getRequestID(),      "mismatched RequestID");

        testPduCommonFields(createdPdu);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest test = new StartResumePduTest();
        test.setUp();
        test.testMultiplePdus();
        test.tearDown();
    }
}
