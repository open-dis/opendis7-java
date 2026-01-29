/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.Vector3Float;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Vector3Float data structure.
 * Validates construction, field access, marshal/unmarshal round-trip, and equality.
 */
@DisplayName("Vector3FloatTest")
public class Vector3FloatTest
{
    private static final float TOLERANCE = 1.0e-5f;
    private static boolean verbose = true;

    /** default constructor */
    public Vector3FloatTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** Vector3FloatTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** Vector3FloatTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** Vector3FloatTest testDefaultConstructor()");

        Vector3Float v = new Vector3Float();
        assertEquals(0.0f, v.getX(), TOLERANCE, "mismatched default x");
        assertEquals(0.0f, v.getY(), TOLERANCE, "mismatched default y");
        assertEquals(0.0f, v.getZ(), TOLERANCE, "mismatched default z");
    }

    @Test
    public void testSettersAndGetters()
    {
        if (verbose)
            System.out.println("*** Vector3FloatTest testSettersAndGetters()");

        Vector3Float v = new Vector3Float();
        v.setX(1.5f);
        v.setY(2.5f);
        v.setZ(3.5f);
        assertEquals(1.5f, v.getX(), TOLERANCE, "mismatched x");
        assertEquals(2.5f, v.getY(), TOLERANCE, "mismatched y");
        assertEquals(3.5f, v.getZ(), TOLERANCE, "mismatched z");
    }

    @Test
    public void testMarshalledSize()
    {
        if (verbose)
            System.out.println("*** Vector3FloatTest testMarshalledSize()");

        Vector3Float v = new Vector3Float();
        assertEquals(12, v.getMarshalledSize(), "mismatched marshalled size");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** Vector3FloatTest testMarshalUnmarshalDataStream()");

        Vector3Float original = new Vector3Float();
        original.setX(10.1f);
        original.setY(20.2f);
        original.setZ(30.3f);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        Vector3Float restored = new Vector3Float();
        restored.unmarshal(dis);

        assertEquals(original.getX(), restored.getX(), TOLERANCE, "mismatched x after unmarshal");
        assertEquals(original.getY(), restored.getY(), TOLERANCE, "mismatched y after unmarshal");
        assertEquals(original.getZ(), restored.getZ(), TOLERANCE, "mismatched z after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** Vector3FloatTest testMarshalUnmarshalByteBuffer()");

        Vector3Float original = new Vector3Float();
        original.setX(-5.5f);
        original.setY(100.0f);
        original.setZ(0.001f);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        Vector3Float restored = new Vector3Float();
        restored.unmarshal(buffer);

        assertEquals(original.getX(), restored.getX(), TOLERANCE, "mismatched x after ByteBuffer unmarshal");
        assertEquals(original.getY(), restored.getY(), TOLERANCE, "mismatched y after ByteBuffer unmarshal");
        assertEquals(original.getZ(), restored.getZ(), TOLERANCE, "mismatched z after ByteBuffer unmarshal");
    }

    @Test
    public void testEquality()
    {
        if (verbose)
            System.out.println("*** Vector3FloatTest testEquality()");

        Vector3Float a = new Vector3Float();
        a.setX(1.0f);
        a.setY(2.0f);
        a.setZ(3.0f);
        Vector3Float b = new Vector3Float();
        b.setX(1.0f);
        b.setY(2.0f);
        b.setZ(3.0f);
        Vector3Float c = new Vector3Float();
        c.setX(1.0f);
        c.setY(2.0f);
        c.setZ(4.0f);

        assertTrue(a.equals(b), "equal Vector3Floats should be equal");
        assertFalse(a.equals(c), "different Vector3Floats should not be equal");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("Vector3FloatTest start");
        Vector3FloatTest test = new Vector3FloatTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSettersAndGetters();
        test.testMarshalledSize();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        test.testEquality();
        tearDownClass();
        System.out.println("Vector3FloatTest complete");
    }
}
