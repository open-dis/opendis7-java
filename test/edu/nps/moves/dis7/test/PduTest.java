/* Copyright (c) 1995-2023 held by the author(s).  All rights reserved.

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

import edu.nps.moves.dis7.pdus.EventIdentifier;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.PduBase;
import edu.nps.moves.dis7.pdus.SimulationAddress;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.PduFactory;
import edu.nps.moves.dis7.utilities.stream.PduRecorder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Abstract superclass for PDU testing, containing shared methods.
 * Originally extracted using Netbeans refactoring feature, further
 * updated using SignalPdusTest exemplar patterns.
 * @author Don Brutzman
 */
abstract public class PduTest
{
    /** default thread sleep interval milliseconds */
    protected static final long    THREAD_SLEEP_INTERVAL_MSEC_DEFAULT = 1000l;
    private   static       long    threadSleepInterval = THREAD_SLEEP_INTERVAL_MSEC_DEFAULT;
    private                int     maximumRetryAttempts = 10;
    private   static       boolean verbose = true;

    PduFactory pduFactory;
    DisThreadedNetworkInterface             disNetworkInterface;
    DisThreadedNetworkInterface.PduListener pduListener;
    PduRecorder                             pduRecorder;
    
    SimulationAddress simulationAddress = new SimulationAddress().setSite(11).setApplication(22);
    EventIdentifier eventIdentifier = new EventIdentifier().setEventNumber(0).setSimulationAddress(simulationAddress);
    private int masterEventNumber = 0;
    
    List<Pdu> receivedPdus;
    byte[] bufferByteArray;
    int size;
    
    /** default constructor */
    public PduTest()
    {
        // report if this abstract class is tested in isolation 
        if (this.getClass().getSimpleName().equals("PduTest"))
            System.out.println("*** PduTest is an abstract class providing test utility methods, it does not send any PDUs itself");
    }
    
    /** preparation **/
    @BeforeAll // can be invoked in subclass
    public static void prepareClass()
    {
        if (isVerbose())
            System.out.println("*** abstract PduTest prepareClass()");
    }

    /** housekeeping **/
    @AfterAll
    public static void tearDownClass()
    {
        if (isVerbose())
            System.out.println("*** abstract PduTest tearDownClass()");
        
        sleep(getThreadSleepInterval()); // ensure shutdown
    }

    /** Prepare for network operations, must be called at beginning of setup() */
    private void setupNetwork()
    {
        if (isVerbose())
            System.out.println("*** abstract PduTest setupNetwork()");
        try {
            if (pduRecorder == null)
                pduRecorder = new PduRecorder(); // default dir
            pduRecorder.start();
            if (disNetworkInterface == null)
                disNetworkInterface = pduRecorder.getDisThreadedNetworkInterface();
            if (pduListener == null)
            {
                pduListener = (Pdu pdu) -> {
                    handleReceivedPdu(pdu);
                };
                disNetworkInterface.addListener(pduListener);
            }
        } 
        catch (IOException ex)
        {
            Logger.getLogger(PduTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /** Ensure network connections, listener and handler are prepared */
    @BeforeEach
    public void setUp()
    {   
        setupNetwork();
        pduFactory = new PduFactory();
        receivedPdus = new ArrayList<>();
    }

    /** Ensure network connections are removed */
    @AfterEach
    public void tearDown()
    {   
        sleep(getThreadSleepInterval());
        
        disNetworkInterface.removeListener(pduListener);
        pduRecorder.stop();
        receivedPdus.clear();
        
        pduRecorder = null;
        disNetworkInterface = null;
        pduListener = null;
        receivedPdus = null;
    }

    /** 
     * Handler that passes PDU to DIS network interface for marshalling (serialization), 
     * which then sends IEEE Standard (binary) PDU to self, which is then read separately
     * for unmarshalling (deserialization) further unit testing.
     * @param createdPdu new PDU of interest
     */
    @SuppressWarnings("SleepWhileInLoop")
    protected synchronized void sendIeeeStandardPdu(Pdu createdPdu)
    {
        // https://stackoverflow.com/questions/6271417/java-get-the-current-class-name
        String invoker = "PduTest " + this.getClass().getSimpleName() + ".sendIeeeStandardPdu";
        
        if (createdPdu == null)
        {
            System.err.println ("*** " + invoker + "(null) cannot send a null createdPdu, ignored");
            return;
        }
        disNetworkInterface.sendPDU(createdPdu);
        
        int numberOfReadTests = 0;
        do // check at least once, perhaps multiple times for receipt before returning
        {
            sleep(invoker); // give receiver time to process the sent pdu

//            if (receivedPdu != null)
//                return;
            
            receivedPdus.forEach(pdu -> {
                try {
                    bufferByteArray = pdu.marshal();
                    size = pdu.unmarshal(ByteBuffer.wrap(bufferByteArray));
                    assertTrue(size > 0, "Unmarshalling error: Unmarshalled size: " + size);

                    // This also unmarshalls the pdu
                    pdu = pduFactory.createPdu(bufferByteArray);
                    assertNotNull(pdu, "Unmarshalling error " + pdu);
                } catch (Exception ex) {
                    Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
                }
            });
            if (!receivedPdus.isEmpty())
                return;
            // no receipt yet
            numberOfReadTests++;
            String padding1 = new String(); // count
            String padding2 = new String(); // duration
            if (numberOfReadTests < 10)
                padding1 = " ";
            if ((numberOfReadTests * getThreadSleepInterval()) < 1000l)
                padding2 = " ";
            System.err.println ("*** " + invoker + "(" + createdPdu.getPduType().name() + ")" +
                       " receipt reattempt " + padding1 + "#" + numberOfReadTests + ", " + padding2 +
                       (numberOfReadTests * getThreadSleepInterval()) + " msec total sleep");
            System.err.flush();
        }
        while (numberOfReadTests < getMaximumRetryAttempts());
        
        System.err.println ("*** " + invoker + "(" + createdPdu.getPduType().name() + ") did not succeed");
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

//    /** 
//     * Handler
//     * @param newPdu new PDU of interest
//     */
//    protected void setUpReceiver(Pdu newPdu)
//    {
//        receivedPdu = newPdu;
//    }
    
    /** 
     * Initial common tests for fields in PDU header.
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param createdPdu separate PDU for comparison
     */
    protected synchronized void testPduSendReceiveHeaderMatch (Pdu createdPdu)
    {
        String TEST_SUITE_WARNING = " (TODO note that test may work standalone but mysteriously fail as part of project test suite)";

        sendIeeeStandardPdu(createdPdu); // sends to self, then sleeps a while, then handles receivedPdu
        
        assertTrue(!receivedPdus.isEmpty(),         "No response from network receive after " + 
            Math.max(getMaximumRetryAttempts(), 1) + " retry attempts at " + getThreadSleepInterval() + " msec intervals"
               + TEST_SUITE_WARNING);
        
        receivedPdus.forEach(receivedPdu -> { // TODO might be more than one

            assertTrue((createdPdu != receivedPdu), "Exact match found between createdPdu and receivedPdu object references indicates improper test configuration");

            assertEquals (         createdPdu.getProtocolVersion(),         receivedPdu.getProtocolVersion(), "mismatched ProtocolVersion");
            // TODO compatibility version
            assertEquals (         createdPdu.getExerciseID(),              receivedPdu.getExerciseID(),      "mismatched ExerciseID");
            assertEquals (         createdPdu.getPduType(),                 receivedPdu.getPduType(),         "mismatched PduType");
            assertEquals (         createdPdu.getProtocolFamily(),          receivedPdu.getProtocolFamily(),  "mismatched ProtocolFamily"); // derived from PduType
            assertEquals(((PduBase)createdPdu).getPduStatus(),    ((PduBase)receivedPdu).getPduStatus(),      "mismatched PduStatus");
            assertEquals(((PduBase)createdPdu).getPadding(),      ((PduBase)receivedPdu).getPadding(),        "mismatched header padding");
     
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
            
        });
    }
    
    /** 
     * Test common PDU characteristics, independent of PDU type.
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param createdPdu separate PDU for comparison
     */
    protected void testPduCommonFields (Pdu createdPdu)
    {
        Pdu receivedPdu = receivedPdus.get(0); // TODO might be more than one on receivedPdus list

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

        receivedPdus.clear(); // ensure cleared prior to next test
    }

    /** 
     * Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization)
     */
    public abstract void testMultiplePdus();

    /** Test single PDU for correctness according to all contained fields in this PDU type
     * @param createdPdu separate PDU for comparison
     */
    protected abstract void testOnePdu(Pdu createdPdu);

    /**
     * Get preferred sleep interval
     * @return the threadSleepInterval
     */
    public static long getThreadSleepInterval()
    {
        return threadSleepInterval;
    }

    /**
     * Set preferred sleep interval
     * @param value the threadSleepInterval to set
     */
    public static void setThreadSleepInterval(long value)
    {
        threadSleepInterval = value;
    }

    /**
     * Accessor to set maximum retry attempts
     * @return the maximumRetryAttempts value
     */
    public int getMaximumRetryAttempts()
    {
        return maximumRetryAttempts;
    }

    /**
     * Accessor to get maximum retry attempts
     * @param value the maximumRetryAttempts value to set
     */
    public void setMaximumRetryAttempts(int value)
    {
        this.maximumRetryAttempts = value;
    }

    /**
     * Utility accessor whether verbose mode is set
     * @return whether verbose
     */
    public static boolean isVerbose() {
        return verbose;
    }

    /**
     * Utility accessor to set verbose mode
     * @param value the verbose value to set
     */
    public void setVerbose(boolean value) {
        verbose = value;
        if (disNetworkInterface != null)
            disNetworkInterface.setVerbose(value);
    }
    
    private void handleReceivedPdu(Pdu pdu) {
        if (!receivedPdus.contains(pdu))
             receivedPdus.add(pdu);
    }
    
    /** Convenience method to wrap Thread.sleep with exception handling
     * @param msec milliseconds */
    protected static void sleep(long msec)
    {
        try {
            Thread.sleep(msec);
        } 
        catch (InterruptedException ex) 
        {
            fail("*** PduTest sleep failure: " + ex);
        }
    }
    
    /** Convenience method to wrap Thread.sleep with exception handling
     * @param msec milliseconds
     * @param message name of invoking class, method */
    protected static void sleep(long msec, String message)
    {
        try {
            Thread.sleep(msec);
        } 
        catch (InterruptedException ex) 
        {
            fail("*** " + message + " sleep failure: " + ex);
        }
    }
    
    /** Convenience method to wrap Thread.sleep with exception handling, using 
     * @param message name of invoking class, method */
    protected static void sleep(String message)
    {
        try {
            Thread.sleep(getThreadSleepInterval());
        } 
        catch (InterruptedException ex) 
        {
            fail("*** " + message + " sleep failure: " + ex);
        }
    }

    /**
     * Accessor that first increments current value
     * @return the masterEventNumber
     */
    public int incrementMasterEventNumber() {
        masterEventNumber++;
        return masterEventNumber;
    }

    /**
     * Accessor to get value
     * @return the masterEventNumber
     */
    public int getMasterEventNumber() {
        return masterEventNumber;
    }

    /**
     * Accessor to set value
     * @param value the masterEventNumber to set
     */
    public void setMasterEventNumber(int value) {
        this.masterEventNumber = value;
    }
}
