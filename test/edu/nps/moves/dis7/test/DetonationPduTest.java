/*
Copyright (c) 1995-2022 held by the author(s).  All rights reserved.

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

import edu.nps.moves.dis7.pdus.DetonationPdu;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.Vector3Float;
import static edu.nps.moves.dis7.test.PduTest.isVerbose;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for satisfactory handling of Detonation PDU fields and values.
 * @author &lt;a href="mailto:tdnorbra@nps.edu?subject=edu.nps.moves.dis7.DetonationPduTest"&gt;Terry Norbraten, NPS MOVES&lt;/a&gt;
 */
@DisplayName("DetonationPduTest")
public class DetonationPduTest extends PduTest {

    /** constructor **/
    public DetonationPduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }
    
    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** DetonationPduTest setUpClass()");
        
        // superclass automatically runsprepareClass(), which includes setupNetwork()
    }

   /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** DetonationPduTest testMultiplePdus()");
        
        DetonationPdu detonationPdu = pduFactory.makeDetonationPdu();

        eventIdentifier.setEventNumber(incrementMasterEventNumber()); // simulationAddress already set in superclass PduTest
        detonationPdu.setEventID(eventIdentifier);
        testOnePdu(detonationPdu);

        detonationPdu.setEventID(eventIdentifier.setEventNumber(incrementMasterEventNumber())); // pipelining, TODO utility method seems needed in class Pdu 
        testOnePdu(detonationPdu.setVelocity(new Vector3Float().setX(10.0f).setY(30.0f).setZ(30.0f))); // TODO utility method seems needed in class Vector3Float etc.
              
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
     testPduSendReceiveHeaderMatch (createdPdu); // shared tests in superclass
     
     // can cast PDUs at this point since PduType matched
     DetonationPdu  createdDetonationPdu = (DetonationPdu) createdPdu;
     DetonationPdu receivedDetonationPdu = (DetonationPdu) receivedPdus.get(0); // TODO might be more than one on receivedPdus list

     assertEquals (createdDetonationPdu.getSourceEntityID(),            receivedDetonationPdu.getSourceEntityID(),           "mismatched SourceEntityID");
     assertEquals (createdDetonationPdu.getTargetEntityID(),            receivedDetonationPdu.getTargetEntityID(),           "mismatched TargetEntityID");
     assertEquals (createdDetonationPdu.getExplodingEntityID(),         receivedDetonationPdu.getExplodingEntityID(),        "mismatched  ExplodingEntityID");
     
     assertEquals (createdDetonationPdu.getEventID(),                   receivedDetonationPdu.getEventID(),                   "mismatched EventID");
     assertEquals (createdDetonationPdu.getLocationInWorldCoordinates(),receivedDetonationPdu.getLocationInWorldCoordinates(),"mismatched  LocationInWorldCoordinates");
     assertEquals (createdDetonationPdu.getLocationOfEntityCoordinates(),receivedDetonationPdu.getLocationOfEntityCoordinates(),"mismatched LocationOfEntityCoordinates");
     assertEquals (createdDetonationPdu.getVelocity(),                  receivedDetonationPdu.getVelocity(),                  "mismatched  Velocity");
     assertEquals (createdDetonationPdu.getDescriptor(),                receivedDetonationPdu.getDescriptor(),                "mismatched  Descripter");
     assertEquals (createdDetonationPdu.getDetonationResult(),          receivedDetonationPdu.getDetonationResult(),          "mismatched  MunitionDetonationResult");
     assertEquals (createdDetonationPdu.getPad(),                       receivedDetonationPdu.getPad(),                       "mismatched  Pad");
     
     testPduCommonFields(createdPdu); // shared tests in superclass
  }
  
  /** Command-line invocation (CLI) of program, execution starts here
    * @param args command-line arguments
    */
    public static void main(String[] args)
    {
        PduTest detonationPduTest = new DetonationPduTest();
        
        detonationPduTest.setupNetwork();
        detonationPduTest.testMultiplePdus();
        detonationPduTest.tearDown();
    }

}