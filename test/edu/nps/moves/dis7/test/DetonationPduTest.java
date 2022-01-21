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
import edu.nps.moves.dis7.utilities.PduFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Detonation PDU fields and values.
 * @author &lt;a href="mailto:tdnorbra@nps.edu?subject=edu.nps.moves.dis7.DetonationPduTest"&gt;Terry Norbraten, NPS MOVES&lt;/a&gt;
 */
@DisplayName("Detonation Pdu Test")
public class DetonationPduTest extends PduTest {

    public DetonationPduTest() {
    }

   /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
  @Test
  @Override
  public void testRoundTrip()
  {
    PduFactory pduFactory = new PduFactory();
    
    DetonationPdu pdu = pduFactory.makeDetonationPdu();
    
    // TODO alternate constructors and utility methods
    
    // TODO update PDU-specific tests
    
    testOnePdu(pdu);
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
     DetonationPdu  createdDetonationPdu = (DetonationPdu)  createdPdu;
     DetonationPdu receivedDetonationPdu = (DetonationPdu) receivedPdu;

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
     
     testPduFinishingChecks(createdPdu); // shared tests in superclass
  }
  
    public static void main(String[] args)
    {
        PduTest detonationPduTest = new DetonationPduTest();
        
        detonationPduTest.setUp();
        detonationPduTest.testRoundTrip();
        detonationPduTest.tearDown();
    }

}