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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Abstract superclass for PDU testing, originally extracted using Netbeans refactoring feature.
 * @author Don Brutzman
 */

abstract public class PduTest
{
    protected final long THREAD_SLEEP_INTERVAL_MSEC_DEFAULT = 100l;
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
            public void incomingPdu(Pdu newPdu)
            {
                setUpReceiver(newPdu);
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
     * Handler
     * @param newPdu new PDU of interest
     */
    protected void sendPdu(Pdu newPdu)
    {
        try
        {
            disNetworkInterface.send(newPdu);
            Thread.sleep(getThreadSleepInterval()); // TODO better way to wait?
        } 
        catch (InterruptedException ex)
        {
            System.err.println(this.getClass().getName() + ".sendPdu(Pdu newPdu), error sending Multicast: " + ex.getLocalizedMessage());
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
     * Common tests for fields in PDU header
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param newPdu separate PDU for comparison
     */
    protected void testPduHeaderMatch (Pdu newPdu)
    {  
        assertEquals (         newPdu.getProtocolVersion(),         receivedPdu.getProtocolVersion(), "mismatched ProtocolVersion");
        // TODO compatibility version
        assertEquals (         newPdu.getExerciseID(),              receivedPdu.getExerciseID(),      "mismatched ExerciseID");
        assertEquals (         newPdu.getPduType(),                 receivedPdu.getPduType(),         "mismatched PduType");
        assertEquals (         newPdu.getProtocolFamily(),          receivedPdu.getProtocolFamily(),  "mismatched ProtocolFamily"); // derived from PduType
        assertEquals(((PduBase)newPdu).getPduStatus(),    ((PduBase)receivedPdu).getPduStatus(),      "mismatched PduStatus");
        assertEquals(((PduBase)newPdu).getPadding(),      ((PduBase)receivedPdu).getPadding(),        "mismatched header padding");
        // TODO HDR length
        assertEquals (newPdu.getTimestamp(),                        receivedPdu.getTimestamp(),       "mismatched Timestamp");
    }

    /** 
     * Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization)
     */
    public abstract void testRoundTrip();

    /** Test single PDU for correctness according to all contained fields in this PDU type
     * @param newPdu separate PDU for comparison
     */
    protected abstract void testOnePdu(Pdu newPdu);

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
