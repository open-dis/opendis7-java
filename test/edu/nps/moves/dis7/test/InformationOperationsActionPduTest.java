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

import edu.nps.moves.dis7.enumerations.IOActionIOActionPhase;
import edu.nps.moves.dis7.enumerations.IOActionIOActionType;
import edu.nps.moves.dis7.enumerations.IOActionIOWarfareType;
import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.InformationOperationsActionPdu;
import edu.nps.moves.dis7.pdus.Pdu;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of Information Operations Action PDU fields and values.
 */
@DisplayName("InformationOperationsActionPduTest")
public class InformationOperationsActionPduTest extends PduTest
{
    /** default constructor */
    public InformationOperationsActionPduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** InformationOperationsActionPduTest setUpClass()");
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** InformationOperationsActionPduTest testMultiplePdus()");

        InformationOperationsActionPdu ioaPdu = pduFactory.makeInformationOperationsActionPdu();

        ioaPdu.setOriginatingSimID(new EntityID().setSiteID(1).setApplicationID(2).setEntityID(3));
        ioaPdu.setReceivingSimID(new EntityID().setSiteID(4).setApplicationID(5).setEntityID(6));
        ioaPdu.setIoAttackerID(new EntityID().setSiteID(7).setApplicationID(8).setEntityID(9));
        ioaPdu.setIoPrimaryTargetID(new EntityID().setSiteID(10).setApplicationID(11).setEntityID(12));
        ioaPdu.setRequestID(101);
        ioaPdu.setIOWarfareType(IOActionIOWarfareType.ELECTRONIC_WARFARE_EW);
        ioaPdu.setIOActionType(IOActionIOActionType.NO_STATEMENT);
        ioaPdu.setIOActionPhase(IOActionIOActionPhase.START_ATTACK_PROFILE);
        testOnePdu(ioaPdu);

        ioaPdu.setRequestID(102);
        ioaPdu.setIOActionPhase(IOActionIOActionPhase.END_ATTACK_PROFILE);
        testOnePdu(ioaPdu);
    }

    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu);

        InformationOperationsActionPdu  createdCast = (InformationOperationsActionPdu) createdPdu;
        InformationOperationsActionPdu receivedCast = (InformationOperationsActionPdu) receivedPdus.get(0);

        assertEquals(createdCast.getOriginatingSimID(),  receivedCast.getOriginatingSimID(),  "mismatched OriginatingSimID");
        assertEquals(createdCast.getReceivingSimID(),    receivedCast.getReceivingSimID(),    "mismatched ReceivingSimID");
        assertEquals(createdCast.getRequestID(),         receivedCast.getRequestID(),         "mismatched RequestID");
        assertEquals(createdCast.getIOWarfareType(),     receivedCast.getIOWarfareType(),     "mismatched IOWarfareType");
        assertEquals(createdCast.getIOActionType(),      receivedCast.getIOActionType(),      "mismatched IOActionType");
        assertEquals(createdCast.getIOActionPhase(),     receivedCast.getIOActionPhase(),     "mismatched IOActionPhase");
        assertEquals(createdCast.getIoAttackerID(),      receivedCast.getIoAttackerID(),      "mismatched IoAttackerID");
        assertEquals(createdCast.getIoPrimaryTargetID(), receivedCast.getIoPrimaryTargetID(), "mismatched IoPrimaryTargetID");
        assertEquals(createdCast.getIoRecords(),         receivedCast.getIoRecords(),         "mismatched IoRecords");

        testPduCommonFields(createdPdu);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest test = new InformationOperationsActionPduTest();
        test.setUp();
        test.testMultiplePdus();
        test.tearDown();
    }
}
