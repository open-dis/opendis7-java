/**
 * Copyright (c) 2008-2022, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.objectTypes.LinearObject.Culturalfeature.TracksTire.TracksTire;
import edu.nps.moves.dis7.objectTypes.LinearObject.Obstacle.ConcertinaWire._2Roll;
import edu.nps.moves.dis7.pdus.ObjectType;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit tests for satisfactory handling of typed fields and values when marshalling object instances.
 */
@DisplayName("Object Type Marshal Test")
public class ObjectTypeMarshallTest
{
    /** default constructor */
    public ObjectTypeMarshallTest()
    {
        // initialization code here
    }
    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
      System.out.println("ObjectTypeMarshallTest");
    }
    /** Housekeeping after all tests */
    @AfterAll
    public static void tearDownClass(){}
    
    /** Setup initialization before each test */
    @BeforeEach
    public void setUp(){}
    
    /** Housekeeping after each test */
    @AfterEach
    public void tearDown(){}

  /** Perform test of interest */
    @Test
    public void testGoodMarshall()
    {
        Throwable thr = null;
        try {
            _2Roll roll2 = new _2Roll();
            common(roll2);
        }
        catch (Throwable t) {
            thr = t;
        }
        assertNull(thr, "Exception should be null if successful marshal");
    }
    
  /** Perform test of interest */
    @Test
    public void testNoSubCategory()
    {
        Throwable thr = null;
        try {
            TracksTire tracksTire = new TracksTire();
            common(tracksTire);
        }
        catch (Throwable t) {
            thr = t;
        }
        assertNull(thr, "Exception should be null if successful marshal");
    }
    
    private void common(ObjectType ot) throws Throwable
    {
        Exception ex = null;
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        dumpOT(ot);
        ot.marshal(byteBuffer);
        assertEquals(4, byteBuffer.position(), "Marshalled array should be 4 bytes long");
        dumpBb(byteBuffer);
    }
    
    private void dumpBb(ByteBuffer byteBuffer)
    {
        for (int i = 0; i < byteBuffer.position(); i++) {
            System.out.print(String.format("%02X ", byteBuffer.array()[i]));
        }
        System.out.println();
    }

    private void dumpOT(ObjectType ot)
    {   
        String formatStr = "Name: %s\tDomain: %s\tKind: %s\tCategory: %s\tSubcategory: %s";
        String dom = ot.getDomain().toString();
        String kind = ot.getObjectKind().toString();
        String nm = ot.getClass().getName();
        System.out.println(String.format(formatStr, nm, dom, kind, ot.getCategory(), ot.getSubCategory()));
    }
    
  /** Command-line invocation (CLI) of program, execution starts here
    * @param args command-line arguments
    */
    public static void main(String[] args)
    {
      ObjectTypeMarshallTest inst = new ObjectTypeMarshallTest();
      inst.testGoodMarshall();
      inst.testNoSubCategory();
    }
}
