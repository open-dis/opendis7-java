/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.objecttypes.LinearObject.Culturalfeature.Tracks_Tire.Tracks_Tire;
import edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ConcertinaWire._2_Roll._2_Roll;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Object Type Marshal Test")
public class ObjectTypeMarshallTest
{
    @BeforeAll
    public static void setUpClass()
    {
      System.out.println("ObjectTypeMarshallTest");
    }
    @AfterAll
    public static void tearDownClass(){}
    @BeforeEach
    public void setUp(){}
    @AfterEach
    public void tearDown(){}

    @Test
    public void testGoodMarshall()
    {
        Throwable thr = null;
        try {
            _2_Roll roll2 = new _2_Roll();
            common(roll2);
        }
        catch (Throwable t) {
            thr = t;
        }
        assertNull(thr, "Exception should be null if successful marshal");
    }
    
    @Test
    public void testNoSubCategory()
    {
        Throwable thr = null;
        try {
            Tracks_Tire tracksTire = new Tracks_Tire();
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
        ByteBuffer bb = ByteBuffer.allocate(100);
        //dumpOT(ot);
        ot.marshal(bb);
        assertEquals(4, bb.position(), "Marshalled array should be 4 bytes long");
        //dumpBb(bb);
    }
    
    private void dumpBb(ByteBuffer bb)
    {
        for (int i = 0; i < bb.position(); i++) {
            System.out.print(String.format("%02X ", bb.array()[i]));
        }
        System.out.println();
    }

    private void dumpOT(ObjectType ot)
    {
        System.out.println("ObjectType domain: " + ot.getDomain());
        System.out.println("ObjectType object kind: " + ot.getObjectKind());
        System.out.println("ObjectType category: " + ot.getCategory());
        System.out.println("ObjectType subcategory: " + ot.getSubCategory());
    }
    
    public static void main(String[] args)
    {
      ObjectTypeMarshallTest inst = new ObjectTypeMarshallTest();
      inst.testGoodMarshall();
      inst.testNoSubCategory();
    }
}
