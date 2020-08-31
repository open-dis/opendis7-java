/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.objectTypes.LinearObject.Culturalfeature.TracksTire.TracksTire;
import edu.nps.moves.dis7.objectTypes.LinearObject.Obstacle.ConcertinaWire._2Roll;
import edu.nps.moves.dis7.pdus.ObjectType;
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
            _2Roll roll2 = new _2Roll();
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
        ByteBuffer bb = ByteBuffer.allocate(100);
        dumpOT(ot);
        ot.marshal(bb);
        assertEquals(4, bb.position(), "Marshalled array should be 4 bytes long");
        dumpBb(bb);
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
        String formatStr = "Name: %s\tDomain: %s\tKind: %s\tCategory: %s\tSubcategory: %s";
        String dom = ot.getDomain().toString();
        String kind = ot.getObjectKind().toString();
        String nm = ot.getClass().getName();
        System.out.println(String.format(formatStr, nm, dom, kind, ot.getCategory(), ot.getSubCategory()));
    }
    
    public static void main(String[] args)
    {
      ObjectTypeMarshallTest inst = new ObjectTypeMarshallTest();
      inst.testGoodMarshall();
      inst.testNoSubCategory();
    }
}
