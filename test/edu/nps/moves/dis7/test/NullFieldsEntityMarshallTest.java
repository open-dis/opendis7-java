/**
 * Copyright (c) 2008-2022, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.entities.usa.platform.land.LAV105;
import edu.nps.moves.dis7.pdus.EntityType;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for satisfactory handling of null fields and values when marshalling object instances.
 * 
 * @author Mike Bailey, jmbailey@edu.nps.edu
 * @version $Id$
 */
@DisplayName("Null Fields Entity Marshall Test")
public class NullFieldsEntityMarshallTest
{
    /** default constructor */
    public NullFieldsEntityMarshallTest()
    {
        // initialization code here
    }
    LAV105 lav105;

    /** preparation **/
    @BeforeAll
    public static void beforeAllTests()
    {
      System.out.println("NullFieldsEntityMarshallTest");
    }
    
    /** housekeeping **/
    @AfterAll
    public static void afterAllTests()
    {}
    
    /** Setup initialization before each test */
    @BeforeEach
    public void setUp()
    {
        lav105 = new LAV105();
    }
    
    /** Housekeeping after each test */
    @AfterEach
    public void tearDown()
    {
        lav105 = null;
    }

    /** Perform test of interest */
    @Test
    public void testNoSpecificNoExtraMarshal()
    {
        Exception ex=null;
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        try {
            //dumpET(lav105);
            lav105.marshal(byteBuffer);
            //dumpBb(bb);
        }
        catch(Exception e) {
          System.err.println(e.getClass().getSimpleName()+": "+e.getLocalizedMessage());
            ex = e;
        }
        assertNull(ex,"Exception should be null if successful marshal");
        assertEquals(8, byteBuffer.position(), "Marshalled array should be 8 bytes long");
    }
    
  /** Perform test of interest */
    @Test
    public void testGoodMarshall()
    {
        /*
        System.out.println("Test with FF for specific and extra marshal");
        lav105.setExtra((byte)0xff);
        lav105.setSpecific((byte)0xff);
        Exception ex=null;
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
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

    private void dumpBb(ByteBuffer byteBuffer)
    {
        for (int i=0;i<byteBuffer.position();i++)
          System.out.print(String.format("%02X ", byteBuffer.array()[i]));
        System.out.println();
    }
    private void dumpET(EntityType entityType)
    {
        System.out.println("LAV_105 country: "     + entityType.getCountry());
        System.out.println("LAV_105 domain: "      + entityType.getDomain());
        System.out.println("LAV_105 entity kind: " + entityType.getEntityKind());
        System.out.println("LAV_105 category: "    + entityType.getCategory());
        System.out.println("LAV_105 subcategory: " + entityType.getSubCategory());
        System.out.println("LAV_105 specific: "    + entityType.getSpecific());
        System.out.println("LAV_105 extra: "       + entityType.getExtra());
    }
    
  /** Command-line invocation (CLI) of program, execution starts here
    * @param args command-line arguments
    */
    public static void main(String[] args)
    {
      NullFieldsEntityMarshallTest inst = new NullFieldsEntityMarshallTest();
      inst.setUp();
      inst.testNoSpecificNoExtraMarshal();
    }
}
