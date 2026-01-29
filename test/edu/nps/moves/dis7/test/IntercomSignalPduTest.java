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

import edu.nps.moves.dis7.pdus.IntercomSignalPdu;
import edu.nps.moves.dis7.pdus.Pdu;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of Intercom Signal PDU fields and values.
 */
@DisplayName("IntercomSignalPduTest")
public class IntercomSignalPduTest extends PduTest
{
    /** default constructor */
    public IntercomSignalPduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** IntercomSignalPduTest setUpClass()");
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** IntercomSignalPduTest testMultiplePdus()");

        IntercomSignalPdu intercomSignalPdu = pduFactory.makeIntercomSignalPdu();

        intercomSignalPdu.setIntercomNumber((short) 1);
        intercomSignalPdu.setEncodingScheme((short) 1);
        intercomSignalPdu.setSampleRate(8000);
        intercomSignalPdu.setData(new byte[]{10, 20, 30, 40, 50, 60, 70, 80});
        intercomSignalPdu.setDataLength((short) 64); // 8 bytes * 8 bits
        testOnePdu(intercomSignalPdu);

        intercomSignalPdu.setSampleRate(16000);
        testOnePdu(intercomSignalPdu);
    }

    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu);

        IntercomSignalPdu  createdCast = (IntercomSignalPdu) createdPdu;
        IntercomSignalPdu receivedCast = (IntercomSignalPdu) receivedPdus.get(0);

        assertEquals(createdCast.getIntercomReferenceID(), receivedCast.getIntercomReferenceID(), "mismatched IntercomReferenceID");
        assertEquals(createdCast.getIntercomNumber(),      receivedCast.getIntercomNumber(),      "mismatched IntercomNumber");
        assertEquals(createdCast.getEncodingScheme(),      receivedCast.getEncodingScheme(),      "mismatched EncodingScheme");
        assertEquals(createdCast.getTdlType(),             receivedCast.getTdlType(),             "mismatched TdlType");
        assertEquals(createdCast.getSampleRate(),          receivedCast.getSampleRate(),          "mismatched SampleRate");
        assertEquals(createdCast.getDataLength(),          receivedCast.getDataLength(),          "mismatched DataLength");
        assertEquals(createdCast.getSamples(),             receivedCast.getSamples(),             "mismatched Samples");
        assertArrayEquals(createdCast.getData(),           receivedCast.getData(),                "mismatched Data");

        testPduCommonFields(createdPdu);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest test = new IntercomSignalPduTest();
        test.setUp();
        test.testMultiplePdus();
        test.tearDown();
    }
}
