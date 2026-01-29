/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.EntityID;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for EntityID data structure.
 * Validates construction, field access, marshal/unmarshal round-trip, and equality.
 */
@DisplayName("EntityIDTest")
public class EntityIDTest
{
    private static boolean verbose = true;

    /** default constructor */
    public EntityIDTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** EntityIDTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** EntityIDTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** EntityIDTest testDefaultConstructor()");

        EntityID id = new EntityID();
        assertEquals(0, id.getSiteID(), "mismatched default siteID");
        assertEquals(0, id.getApplicationID(), "mismatched default applicationID");
        assertEquals(0, id.getEntityID(), "mismatched default entityID");
    }

    @Test
    public void testSettersAndGetters()
    {
        if (verbose)
            System.out.println("*** EntityIDTest testSettersAndGetters()");

        EntityID id = new EntityID();
        id.setSiteID(1);
        id.setApplicationID(2);
        id.setEntityID(3);
        assertEquals(1, id.getSiteID(), "mismatched siteID");
        assertEquals(2, id.getApplicationID(), "mismatched applicationID");
        assertEquals(3, id.getEntityID(), "mismatched entityID");
    }

    @Test
    public void testProgressiveSetters()
    {
        if (verbose)
            System.out.println("*** EntityIDTest testProgressiveSetters()");

        EntityID id = new EntityID().setSiteID(10).setApplicationID(20).setEntityID(30);
        assertEquals(10, id.getSiteID(), "mismatched siteID");
        assertEquals(20, id.getApplicationID(), "mismatched applicationID");
        assertEquals(30, id.getEntityID(), "mismatched entityID");
    }

    @Test
    public void testMarshalledSize()
    {
        if (verbose)
            System.out.println("*** EntityIDTest testMarshalledSize()");

        EntityID id = new EntityID();
        assertEquals(6, id.getMarshalledSize(), "mismatched marshalled size");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** EntityIDTest testMarshalUnmarshalDataStream()");

        EntityID original = new EntityID();
        original.setSiteID(100);
        original.setApplicationID(200);
        original.setEntityID(300);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        EntityID restored = new EntityID();
        restored.unmarshal(dis);

        assertEquals(original.getSiteID(), restored.getSiteID(), "mismatched siteID after unmarshal");
        assertEquals(original.getApplicationID(), restored.getApplicationID(), "mismatched applicationID after unmarshal");
        assertEquals(original.getEntityID(), restored.getEntityID(), "mismatched entityID after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** EntityIDTest testMarshalUnmarshalByteBuffer()");

        EntityID original = new EntityID();
        original.setSiteID(500);
        original.setApplicationID(600);
        original.setEntityID(700);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        EntityID restored = new EntityID();
        restored.unmarshal(buffer);

        assertEquals(original.getSiteID(), restored.getSiteID(), "mismatched siteID after ByteBuffer unmarshal");
        assertEquals(original.getApplicationID(), restored.getApplicationID(), "mismatched applicationID after ByteBuffer unmarshal");
        assertEquals(original.getEntityID(), restored.getEntityID(), "mismatched entityID after ByteBuffer unmarshal");
    }

    @Test
    public void testEquality()
    {
        if (verbose)
            System.out.println("*** EntityIDTest testEquality()");

        EntityID a = new EntityID().setSiteID(1).setApplicationID(2).setEntityID(3);
        EntityID b = new EntityID().setSiteID(1).setApplicationID(2).setEntityID(3);
        EntityID c = new EntityID().setSiteID(1).setApplicationID(2).setEntityID(4);

        assertTrue(a.equals(b), "equal EntityIDs should be equal");
        assertFalse(a.equals(c), "different EntityIDs should not be equal");
        assertEquals(a.hashCode(), b.hashCode(), "equal objects should have equal hashCodes");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("EntityIDTest start");
        EntityIDTest test = new EntityIDTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSettersAndGetters();
        test.testProgressiveSetters();
        test.testMarshalledSize();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        test.testEquality();
        tearDownClass();
        System.out.println("EntityIDTest complete");
    }
}
