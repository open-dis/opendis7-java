/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.EntityMarking;
import edu.nps.moves.dis7.enumerations.EntityMarkingCharacterSet;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for EntityMarking data structure.
 * Validates construction, character encoding, marshal/unmarshal round-trip, and equality.
 */
@DisplayName("EntityMarkingTest")
public class EntityMarkingTest
{
    private static boolean verbose = true;

    /** default constructor */
    public EntityMarkingTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** EntityMarkingTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** EntityMarkingTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** EntityMarkingTest testDefaultConstructor()");

        EntityMarking em = new EntityMarking();
        assertNotNull(em.getCharacters(), "characters array should not be null");
        assertEquals(11, em.getCharacters().length, "characters array should be 11 bytes");
    }

    @Test
    public void testSetCharacterSet()
    {
        if (verbose)
            System.out.println("*** EntityMarkingTest testSetCharacterSet()");

        EntityMarking em = new EntityMarking();
        em.setCharacterSet(EntityMarkingCharacterSet.ASCII);
        assertEquals(EntityMarkingCharacterSet.ASCII, em.getCharacterSet(), "mismatched characterSet");
    }

    @Test
    public void testSetCharacters()
    {
        if (verbose)
            System.out.println("*** EntityMarkingTest testSetCharacters()");

        EntityMarking em = new EntityMarking();
        em.setCharacterSet(EntityMarkingCharacterSet.ASCII);
        byte[] marking = "TANK01".getBytes();
        byte[] padded = new byte[11];
        System.arraycopy(marking, 0, padded, 0, Math.min(marking.length, 11));
        em.setCharacters(padded);

        byte[] result = em.getCharacters();
        assertEquals((byte)'T', result[0], "mismatched character [0]");
        assertEquals((byte)'A', result[1], "mismatched character [1]");
        assertEquals((byte)'N', result[2], "mismatched character [2]");
        assertEquals((byte)'K', result[3], "mismatched character [3]");
        assertEquals((byte)'0', result[4], "mismatched character [4]");
        assertEquals((byte)'1', result[5], "mismatched character [5]");
        assertEquals(0, result[6], "padding should be zero");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** EntityMarkingTest testMarshalUnmarshalDataStream()");

        EntityMarking original = new EntityMarking();
        original.setCharacterSet(EntityMarkingCharacterSet.ASCII);
        byte[] marking = "F16EAGLE".getBytes();
        byte[] padded = new byte[11];
        System.arraycopy(marking, 0, padded, 0, Math.min(marking.length, 11));
        original.setCharacters(padded);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        EntityMarking restored = new EntityMarking();
        restored.unmarshal(dis);

        assertEquals(original.getCharacterSet(), restored.getCharacterSet(), "mismatched characterSet after unmarshal");
        assertArrayEquals(original.getCharacters(), restored.getCharacters(), "mismatched characters after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** EntityMarkingTest testMarshalUnmarshalByteBuffer()");

        EntityMarking original = new EntityMarking();
        original.setCharacterSet(EntityMarkingCharacterSet.ASCII);
        byte[] marking = "HELO99".getBytes();
        byte[] padded = new byte[11];
        System.arraycopy(marking, 0, padded, 0, Math.min(marking.length, 11));
        original.setCharacters(padded);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        EntityMarking restored = new EntityMarking();
        restored.unmarshal(buffer);

        assertEquals(original.getCharacterSet(), restored.getCharacterSet(), "mismatched characterSet after ByteBuffer unmarshal");
        assertArrayEquals(original.getCharacters(), restored.getCharacters(), "mismatched characters after ByteBuffer unmarshal");
    }

    @Test
    public void testEquality()
    {
        if (verbose)
            System.out.println("*** EntityMarkingTest testEquality()");

        EntityMarking a = new EntityMarking();
        a.setCharacterSet(EntityMarkingCharacterSet.ASCII);
        byte[] m1 = new byte[11];
        m1[0] = (byte)'A';
        a.setCharacters(m1);

        EntityMarking b = new EntityMarking();
        b.setCharacterSet(EntityMarkingCharacterSet.ASCII);
        byte[] m2 = new byte[11];
        m2[0] = (byte)'A';
        b.setCharacters(m2);

        EntityMarking c = new EntityMarking();
        c.setCharacterSet(EntityMarkingCharacterSet.ASCII);
        byte[] m3 = new byte[11];
        m3[0] = (byte)'B';
        c.setCharacters(m3);

        assertTrue(a.equals(b), "equal EntityMarkings should be equal");
        assertFalse(a.equals(c), "different EntityMarkings should not be equal");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("EntityMarkingTest start");
        EntityMarkingTest test = new EntityMarkingTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSetCharacterSet();
        test.testSetCharacters();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        test.testEquality();
        tearDownClass();
        System.out.println("EntityMarkingTest complete");
    }
}
