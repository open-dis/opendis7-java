/**
 * NullFieldsMarshallTest()); created on May 20, 2019 MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 *
 * @author Mike Bailey, jmbailey@edu.nps.edu
 * @version $Id$
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.entities.usa.platform.land.LAV_105;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Null Fields Entity Marshal")
public class NullFieldsMarshallTest
{
    LAV_105 lav105;

    @BeforeAll
    public static void beforeAllTests()
    {}
    
    @AfterAll
    public static void afterAllTests()
    {}
    
    @BeforeEach
    public void setUp()
    {
        lav105 = new LAV_105();
    }
    
    @AfterEach
    public void tearDown()
    {
        lav105 = null;
    }

    @Test
    public void testNoSpecificNoExtraMarshal()
    {
        System.out.println("Test no specific, no extra marshal");
        Exception ex=null;
        ByteBuffer bb = ByteBuffer.allocate(100);
        try {
            dumpET(lav105);
            lav105.marshal(bb);
            dumpBb(bb);
            System.out.println("Test complete, no exception");
        }
        catch(Exception e) {
          System.err.println(e.getClass().getSimpleName()+": "+e.getLocalizedMessage());
            ex = e;
        }
   //temp     assertNull(ex,"Exception should be null if successful marshal");
   //temp     assertEquals(8, bb.position(), "Marshalled array should be 8 bytes long");
    }
    
    @Test
    public void testGoodMarshall()
    {
        /*
        System.out.println("Test with FF for specific and extra marshal");
        lav105.setExtra((byte)0xff);
        lav105.setSpecific((byte)0xff);
        Exception ex=null;
        ByteBuffer bb = ByteBuffer.allocate(100);
        try {
            dumpET(lav105);     
            lav105.marshal(bb);
            dumpBb(bb);
        }
        catch(Exception e) {
            ex = e;
        }
        assertNull(ex,"Exception should be null if successful marshal");
        assertEquals(8,bb.position(), "Marshalled array should be 8 bytes long");
*/
    }

    private void dumpBb(ByteBuffer bb)
    {
        for (int i=0;i<bb.position();i++)
          System.out.print(String.format("%02X ", bb.array()[i]));
        System.out.println();
    }
    private void dumpET(EntityType et)
    {
        System.out.println("LAV_105 country: "+et.getCountry());
        System.out.println("LAV_105 domain: "+et.getDomain());
        System.out.println("LAV_105 entity kind: "+et.getEntityKind());
        System.out.println("LAV_105 category: "+et.getCategory());
        System.out.println("LAV_105 subcategory: "+et.getSubCategory());
        System.out.println("LAV_105 specific: "+et.getSpecific());
        System.out.println("LAV_105 extra: "+et.getExtra());
    }
    
    public static void main(String[] args)
    {
      NullFieldsMarshallTest inst = new NullFieldsMarshallTest();
      inst.setUp();
      inst.testNoSpecificNoExtraMarshal();
    }
}
