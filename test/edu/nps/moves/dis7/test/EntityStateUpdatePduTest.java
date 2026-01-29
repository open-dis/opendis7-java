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

import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.EntityStateUpdatePdu;
import edu.nps.moves.dis7.pdus.EulerAngles;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.Vector3Double;
import edu.nps.moves.dis7.pdus.Vector3Float;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of Entity State Update PDU fields and values.
 */
@DisplayName("EntityStateUpdatePduTest")
public class EntityStateUpdatePduTest extends PduTest
{
    /** default constructor */
    public EntityStateUpdatePduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** EntityStateUpdatePduTest setUpClass()");

        // superclass automatically setUp(), which includes setupNetwork()
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** EntityStateUpdatePduTest testMultiplePdus()");

        EntityStateUpdatePdu updatePdu = pduFactory.makeEntityStateUpdatePdu();

        updatePdu.setEntityID(new EntityID().setSiteID(1).setApplicationID(2).setEntityID(3));
        updatePdu.setEntityLinearVelocity(new Vector3Float().setX(10.0f).setY(20.0f).setZ(0.0f));
        updatePdu.setEntityLocation(new Vector3Double().setX(1000.0).setY(2000.0).setZ(3000.0));
        updatePdu.setEntityOrientation(new EulerAngles().setPsi(1.0f).setTheta(0.5f).setPhi(0.25f));
        updatePdu.setEntityAppearance(0x00010000);
        testOnePdu(updatePdu);

        updatePdu.setEntityLinearVelocity(new Vector3Float().setX(15.0f).setY(25.0f).setZ(5.0f));
        updatePdu.setEntityLocation(new Vector3Double().setX(1100.0).setY(2100.0).setZ(3100.0));
        testOnePdu(updatePdu);

        // TODO additional PDU-specific tests
        // TODO test various alternate constructors and utility methods
    }

    /** Test single PDU for correctness according to all contained fields in this PDU type
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param createdPdu separate PDU for comparison
     */
    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu); // shared tests in superclass

        // can cast PDUs at this point since PduType matched
        EntityStateUpdatePdu  createdUpdatePdu = (EntityStateUpdatePdu) createdPdu;
        EntityStateUpdatePdu receivedUpdatePdu = (EntityStateUpdatePdu) receivedPdus.get(0); // TODO might be more than one on receivedPdus list

        assertEquals(createdUpdatePdu.getEntityID(),              receivedUpdatePdu.getEntityID(),              "mismatched EntityID");
        assertEquals(createdUpdatePdu.getEntityLinearVelocity(),  receivedUpdatePdu.getEntityLinearVelocity(),  "mismatched EntityLinearVelocity");
        assertEquals(createdUpdatePdu.getEntityLocation(),        receivedUpdatePdu.getEntityLocation(),        "mismatched EntityLocation");
        assertEquals(createdUpdatePdu.getEntityOrientation(),     receivedUpdatePdu.getEntityOrientation(),     "mismatched EntityOrientation");
        assertEquals(createdUpdatePdu.getEntityAppearance(),      receivedUpdatePdu.getEntityAppearance(),      "mismatched EntityAppearance");
        assertEquals(createdUpdatePdu.getVariableParameters(),    receivedUpdatePdu.getVariableParameters(),    "mismatched VariableParameters");

        testPduCommonFields(createdPdu); // shared tests in superclass
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest entityStateUpdatePduTest = new EntityStateUpdatePduTest();

        entityStateUpdatePduTest.setUp();
        entityStateUpdatePduTest.testMultiplePdus();
        entityStateUpdatePduTest.tearDown();
    }
}
