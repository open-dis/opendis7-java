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
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author brutzman
 */

abstract public class PduTest
{

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

    @AfterEach
    public void tearDown()
    {
        disNetworkInterface.removeListener(pduListener);
        disNetworkInterface.kill();
        disNetworkInterface = null;
    }

    protected void sendPdu(Pdu pdu)
    {
        try
        {
            disNetworkInterface.send(pdu);
            Thread.sleep(100);
        } catch (InterruptedException ex)
        {
            System.err.println("Error sending Multicast: " + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    /** Compare all values of these two obects and report if identical
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

    protected void setUpReceiver(Pdu newPdu)
    {
        receivedPdu = newPdu;
    }

  /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    public abstract void testRoundTrip();

    /** Test single PDU for correctness according to all contained fields in this PDU type
     * @param newPdu PDU of interest*/
    protected abstract void testOnePdu(Pdu newPdu);
    
}
