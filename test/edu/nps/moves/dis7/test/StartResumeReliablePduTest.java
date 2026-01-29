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

import edu.nps.moves.dis7.enumerations.RequiredReliabilityService;
import edu.nps.moves.dis7.pdus.ClockTime;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.SimulationIdentifier;
import edu.nps.moves.dis7.pdus.SimulationAddress;
import edu.nps.moves.dis7.pdus.StartResumeReliablePdu;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of Start/Resume Reliable PDU fields and values.
 */
@DisplayName("StartResumeReliablePduTest")
public class StartResumeReliablePduTest extends PduTest
{
    /** default constructor */
    public StartResumeReliablePduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** StartResumeReliablePduTest setUpClass()");
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** StartResumeReliablePduTest testMultiplePdus()");

        StartResumeReliablePdu srrPdu = pduFactory.makeStartResumeReliablePdu();

        srrPdu.setOriginatingID(new SimulationIdentifier().setSimulationAddress(new SimulationAddress().setSite(1).setApplication(2)));
        srrPdu.setReceivingID(new SimulationIdentifier().setSimulationAddress(new SimulationAddress().setSite(3).setApplication(4)));
        srrPdu.setRealWorldTime(new ClockTime().setHour(10).setTimePastHour(1000000));
        srrPdu.setSimulationTime(new ClockTime().setHour(5).setTimePastHour(500000));
        srrPdu.setRequiredReliabilityService(RequiredReliabilityService.ACKNOWLEDGED);
        srrPdu.setRequestID(301);
        testOnePdu(srrPdu);

        srrPdu.setRealWorldTime(new ClockTime().setHour(12).setTimePastHour(2000000));
        srrPdu.setRequestID(302);
        testOnePdu(srrPdu);
    }

    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu);

        StartResumeReliablePdu  createdCast = (StartResumeReliablePdu) createdPdu;
        StartResumeReliablePdu receivedCast = (StartResumeReliablePdu) receivedPdus.get(0);

        assertEquals(createdCast.getOriginatingID(),              receivedCast.getOriginatingID(),              "mismatched OriginatingID");
        assertEquals(createdCast.getReceivingID(),                receivedCast.getReceivingID(),                "mismatched ReceivingID");
        assertEquals(createdCast.getRealWorldTime(),              receivedCast.getRealWorldTime(),              "mismatched RealWorldTime");
        assertEquals(createdCast.getSimulationTime(),             receivedCast.getSimulationTime(),             "mismatched SimulationTime");
        assertEquals(createdCast.getRequiredReliabilityService(), receivedCast.getRequiredReliabilityService(), "mismatched RequiredReliabilityService");
        assertEquals(createdCast.getRequestID(),                  receivedCast.getRequestID(),                  "mismatched RequestID");

        testPduCommonFields(createdPdu);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest test = new StartResumeReliablePduTest();
        test.setUp();
        test.testMultiplePdus();
        test.tearDown();
    }
}
