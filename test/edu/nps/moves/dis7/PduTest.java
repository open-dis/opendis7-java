/* Copyright (c) 1995-2020 held by the author(s).  All rights reserved.

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
      (https://www.nps.edu and https://my.nps.edu/web/moves)
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

package edu.nps.moves.dis7;

import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.PduBase;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Abstract superclass for PDU testing, originally extracted using Netbeans refactoring feature.
 * @author Don Brutzman
 */

abstract public class PduTest
{
    protected final long THREAD_SLEEP_INTERVAL_MSEC_DEFAULT = 100l; // i.e. 100, type long
    private         long threadSleepInterval = THREAD_SLEEP_INTERVAL_MSEC_DEFAULT;
    
    @BeforeAll
    public static void setUpClass()
    {
        System.out.println("EntityStatePduTest");
    }

    @AfterAll
    public static void tearDownClass()
    {
    }

    DisThreadedNetworkInterface disNetworkInterface;
    Pdu receivedPdu;
    DisThreadedNetworkInterface.PduListener pduListener;

    /** Ensure network connections, listener and handler are prepared */
    @BeforeEach
    public void setUp()
    {
        disNetworkInterface = new DisThreadedNetworkInterface();
        pduListener = new DisThreadedNetworkInterface.PduListener()
        {
            @Override
            public void incomingPdu(Pdu createdPdu)
            {
                setUpReceiver(createdPdu);
            }
        };
        disNetworkInterface.addListener(pduListener);
    }

    /** Ensure network connections are removed */
    @AfterEach
    public void tearDown()
    {
        disNetworkInterface.removeListener(pduListener);
        disNetworkInterface.kill();
        disNetworkInterface = null;
    }

    /** 
     * Handler that passes PDU to DIS network interface for marshalling (serialization), 
     * which then sends IEEE Standard (binary) PDU to self, which is then read separately
     * for unmarshalling (deserialization) further unit testing.
     * @param createdPdu new PDU of interest
     */
    protected void sendIeeeStandardPdu(Pdu createdPdu)
    {
        try
        {
            disNetworkInterface.send(createdPdu);
            Thread.sleep(getThreadSleepInterval()); // TODO better way to wait?
        } 
        catch (InterruptedException ex)
        {
            System.err.println(this.getClass().getName() + ".sendIeeeStandardPdu(Pdu createdPdu), error sending Multicast: " + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    /** Compare all values of these two objects and report if identical
     * @param pdu1 first pdu
     * @param pdu2 second pdu
     * @return true if identical values found */
    protected boolean compare(Pdu pdu1, Pdu pdu2)
    {
        boolean result = (pdu1 != null) && (pdu2 != null) &&
                          pdu1.getPduType().equals(pdu2.getPduType()) &&
                          pdu1.equalsImpl(pdu2);
        return result;
    }

    /** 
     * Handler
     * @param newPdu new PDU of interest
     */
    protected void setUpReceiver(Pdu newPdu)
    {
        receivedPdu = newPdu;
    }
    /** 
     * Initial common tests for fields in PDU header.
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param createdPdu separate PDU for comparison
     */
    protected void testPduSendReceiveHeaderMatch (Pdu createdPdu)
    {
        String TEST_SUITE_WARNING = " (TODO note that test works standalone but mysteriously fails as part of project test suite)";

        sendIeeeStandardPdu(createdPdu); // send to self, then wait a while, then return receivedPdu
        assertTrue(receivedPdu != null,         "No response from network receive after " + getThreadSleepInterval() + " msec" 
                   + TEST_SUITE_WARNING);
     
        assertTrue((createdPdu != receivedPdu), "Exact match found between createdPdu and receivedPdu object references indicates improper test configuration");
        
        assertEquals (         createdPdu.getProtocolVersion(),         receivedPdu.getProtocolVersion(), "mismatched ProtocolVersion");
        // TODO compatibility version
        assertEquals (         createdPdu.getExerciseID(),              receivedPdu.getExerciseID(),      "mismatched ExerciseID");
        assertEquals (         createdPdu.getPduType(),                 receivedPdu.getPduType(),         "mismatched PduType");
        assertEquals (         createdPdu.getProtocolFamily(),          receivedPdu.getProtocolFamily(),  "mismatched ProtocolFamily"); // derived from PduType
        assertEquals(((PduBase)createdPdu).getPduStatus(),    ((PduBase)receivedPdu).getPduStatus(),      "mismatched PduStatus");
        assertEquals(((PduBase)createdPdu).getPadding(),      ((PduBase)receivedPdu).getPadding(),        "mismatched header padding");
        // TODO HDR length
        assertEquals (createdPdu.getTimestamp(),                        receivedPdu.getTimestamp(),       "mismatched Timestamp");
        
        // trace option to show strings if mismatched (prior to assertion error)
        if (!createdPdu.toString().equals(receivedPdu.toString())) // false true  TODO JSON or XML
        {
            System.out.println("String mismatch:");
            System.out.println("================================================================");
            System.out.println("     newEspdu=" +      createdPdu.toString());
            System.out.println("================================================================");
            System.out.println("receivedEspdu=" + receivedPdu.toString());
            System.out.println("================================================================");
        }
    }
    /** 
     * Final common tests of PDU characteristics after individual fields are checked.
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param createdPdu separate PDU for comparison
     */
    protected void testPduFinishingChecks (Pdu createdPdu)
    {
     assertEquals (createdPdu.toString(),          receivedPdu.toString(),    "mismatched toString()");
     
     // built-in object comparison
     assertTrue   (createdPdu.equalsImpl(receivedPdu),                        "createdPdu.equalsImpl(receivedPdu) built-in object comparison");
     // final recheck that everything adds up
     assertEquals(createdPdu.getMarshalledSize(),  receivedPdu.getMarshalledSize(),
        "Marshalled size mismatch," +
            "sent (" +      createdPdu.getMarshalledSize() + " bytes) and " +
        "recieved (" + receivedPdu.getMarshalledSize() + " bytes)");
     assertEquals (createdPdu.getLength(),         receivedPdu.getLength(), "mismatched length"); // from Pdu superclass
     
//   comparison of class Pdu is questionable
//   assertTrue(compare(createdPdu,receivedPdu), "compare() method failed for original and received PDUs");

     receivedPdu = null; // ensure cleared prior to next test
    }

    /** 
     * Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization)
     */
    public abstract void testRoundTrip();

    /** Test single PDU for correctness according to all contained fields in this PDU type
     * @param createdPdu separate PDU for comparison
     */
    protected abstract void testOnePdu(Pdu createdPdu);

    /**
     * Threaded sleep may be necessary to ensure completion of sending/receiving PDU
     * @return the threadSleepInterval
     */
    public long getThreadSleepInterval()
    {
        return threadSleepInterval;
    }

    /**
     * Threaded sleep may be necessary to ensure completion of sending/receiving PDU
     * @param threadSleepInterval the threadSleepInterval to set
     */
    public void setThreadSleepInterval(long threadSleepInterval)
    {
        this.threadSleepInterval = threadSleepInterval;
    }
    
}
