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

import edu.nps.moves.dis7.enumerations.TransmitterTransmitState;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.TransmitterPdu;
import edu.nps.moves.dis7.pdus.Vector3Double;
import edu.nps.moves.dis7.pdus.Vector3Float;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of Transmitter PDU fields and values.
 */
@DisplayName("TransmitterPduTest")
public class TransmitterPduTest extends PduTest
{
    /** default constructor */
    public TransmitterPduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** TransmitterPduTest setUpClass()");
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** TransmitterPduTest testMultiplePdus()");

        TransmitterPdu transmitterPdu = pduFactory.makeTransmitterPdu();

        transmitterPdu.setTransmitState(TransmitterTransmitState.ON_BUT_NOT_TRANSMITTING);
        transmitterPdu.setAntennaLocation(new Vector3Double().setX(1000.0).setY(2000.0).setZ(3000.0));
        transmitterPdu.setRelativeAntennaLocation(new Vector3Float().setX(1.0f).setY(2.0f).setZ(3.0f));
        transmitterPdu.setFrequency(300000000L);
        transmitterPdu.setTransmitFrequencyBandwidth(10000.0f);
        transmitterPdu.setPower(100.0f);
        testOnePdu(transmitterPdu);

        transmitterPdu.setTransmitState(TransmitterTransmitState.ON_AND_TRANSMITTING);
        transmitterPdu.setFrequency(450000000L);
        testOnePdu(transmitterPdu);
    }

    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu);

        TransmitterPdu  createdCast = (TransmitterPdu) createdPdu;
        TransmitterPdu receivedCast = (TransmitterPdu) receivedPdus.get(0);

        assertEquals(createdCast.getHeader(),                      receivedCast.getHeader(),                      "mismatched Header");
        assertEquals(createdCast.getRadioEntityType(),             receivedCast.getRadioEntityType(),             "mismatched RadioEntityType");
        assertEquals(createdCast.getTransmitState(),               receivedCast.getTransmitState(),               "mismatched TransmitState");
        assertEquals(createdCast.getInputSource(),                 receivedCast.getInputSource(),                 "mismatched InputSource");
        assertEquals(createdCast.getAntennaLocation(),             receivedCast.getAntennaLocation(),             "mismatched AntennaLocation");
        assertEquals(createdCast.getRelativeAntennaLocation(),     receivedCast.getRelativeAntennaLocation(),     "mismatched RelativeAntennaLocation");
        assertEquals(createdCast.getAntennaPatternType(),          receivedCast.getAntennaPatternType(),          "mismatched AntennaPatternType");
        assertEquals(createdCast.getFrequency(),                   receivedCast.getFrequency(),                   "mismatched Frequency");
        assertEquals(createdCast.getTransmitFrequencyBandwidth(),  receivedCast.getTransmitFrequencyBandwidth(),  "mismatched TransmitFrequencyBandwidth");
        assertEquals(createdCast.getPower(),                       receivedCast.getPower(),                       "mismatched Power");
        assertEquals(createdCast.getModulationType(),              receivedCast.getModulationType(),              "mismatched ModulationType");
        assertEquals(createdCast.getCryptoSystem(),                receivedCast.getCryptoSystem(),                "mismatched CryptoSystem");
        assertEquals(createdCast.getCryptoKeyId(),                 receivedCast.getCryptoKeyId(),                 "mismatched CryptoKeyId");

        testPduCommonFields(createdPdu);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest test = new TransmitterPduTest();
        test.setUp();
        test.testMultiplePdus();
        test.tearDown();
    }
}
