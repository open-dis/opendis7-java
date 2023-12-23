/*
Copyright (c) 1995-2023 held by the author(s).  All rights reserved.

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

import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.enumerations.MunitionDomain;
import edu.nps.moves.dis7.pdus.Domain;
import edu.nps.moves.dis7.pdus.EntityType;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** EntityType is instantiated with a default Domain of PlatformDomain-OTHER
 * which causes issues down the road with similar enum values of other Domain
 * types
 * @see <a href="https://github.com/open-dis/opendis7-source-generator/issues/9">https://github.com/open-dis/opendis7-source-generator/issues/9</a>
 * @author <a href="mailto:tdnorbra@nps.edu?subject=edu.nps.moves.dis7.test.Issue09">Terry D. Norbraten</a>
 */
@DisplayName("Issue 09 src gen")
public class Issue09 {
    
    ByteBuffer buffer;
    Domain d;
    EntityType et1, et2;
    
    /** Constructor */
    public Issue09 ()
    {
        // initializations can go here
    }
    
    @BeforeEach
    /** Initialize the test */
    public void setUp() {
        buffer = ByteBuffer.allocate(1500);
        d = Domain.inst(MunitionDomain.ANTI_ARMOR);
        et1 = new EntityType(); // PlatformDomain.OTHER is default Domain
        et2 = new EntityType(); // PlatformDomain.OTHER is default Domain
    }
    
    @AfterEach
    /** Tear down the test */
    public void tearDown() {
        buffer.clear();
        buffer = null;
        d = null;
        et1 = et2 = null;
    }
    
    @Test
    /** The test itself */
    public void testIssue09() {
        try {

            // marshal/ unmarshal Domain: correct
            d.marshal(buffer);
            buffer.rewind();
            d.unmarshal(buffer);
            System.out.println("Domain: " + d.toString());
            assertEquals(MunitionDomain.ANTI_ARMOR.getValue(), d.getValue(), "Domain error: ");
            buffer.clear();
            
            et1.setEntityKind(EntityKind.MUNITION).
                    setCountry(Country.GERMANY_DEU).
                    setDomain(d).setCategory(1).
                    setSubCategory(1).setSpecific(3);
            et1.marshal(buffer);
            System.out.println(et1.toString());
            System.out.println(et1.getEntityKind() + " Domain: " + et1.getDomain().toString());
            assertEquals(d, et1.getDomain(), "Domain error: ");
            buffer.rewind();
            
            // marshal/ unmarshal EntityType incorrect for entity types not equal PlatformDomain
            et2.unmarshal(buffer);
            System.out.println(et2.toString());
            System.out.println(et2.getEntityKind() + " Domain: " + et2.getDomain().toString());
            assertEquals(d, et2.getDomain(), "Domain error: ");
            
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    /** Command line invocation (CLI)
     * @param args arguments
     */
    public static void main(String[] args) {
        Issue09 i09 = new Issue09();
        i09.setUp();
        i09.testIssue09();
        i09.tearDown();
    }
//Domain: Anti-Armor
//EntityKind 2 MUNITION Domain: Anti-Armor
//EntityType entityKind:EntityKind 2 MUNITION domain:Air country:Country 78 GERMANY_DEU category:1 subCategory:1 specific:3 extra:0
//EntityKind 2 MUNITION Domain: Air

} // end class file Issue09
