/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.Vector3Double;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Vector3Double data structure.
 * Validates construction, field access, marshal/unmarshal round-trip, and equality.
 */
@DisplayName("Vector3DoubleTest")
public class Vector3DoubleTest
{
    private static final double TOLERANCE = 1.0e-10;
    private static boolean verbose = true;

    /** default constructor */
    public Vector3DoubleTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** Vector3DoubleTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** Vector3DoubleTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** Vector3DoubleTest testDefaultConstructor()");

        Vector3Double v = new Vector3Double();
        assertEquals(0.0, v.getX(), TOLERANCE, "mismatched default x");
        assertEquals(0.0, v.getY(), TOLERANCE, "mismatched default y");
        assertEquals(0.0, v.getZ(), TOLERANCE, "mismatched default z");
    }

    @Test
    public void testSettersAndGetters()
    {
        if (verbose)
            System.out.println("*** Vector3DoubleTest testSettersAndGetters()");

        Vector3Double v = new Vector3Double();
        v.setX(1234567.890123);
        v.setY(-9876543.210987);
        v.setZ(0.000001);
        assertEquals(1234567.890123, v.getX(), TOLERANCE, "mismatched x");
        assertEquals(-9876543.210987, v.getY(), TOLERANCE, "mismatched y");
        assertEquals(0.000001, v.getZ(), TOLERANCE, "mismatched z");
    }

    @Test
    public void testMarshalledSize()
    {
        if (verbose)
            System.out.println("*** Vector3DoubleTest testMarshalledSize()");

        Vector3Double v = new Vector3Double();
        assertEquals(24, v.getMarshalledSize(), "mismatched marshalled size");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** Vector3DoubleTest testMarshalUnmarshalDataStream()");

        Vector3Double original = new Vector3Double();
        original.setX(-2685587.8486);
        original.setY(-4315429.2014);
        original.setZ(3836698.4738);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        Vector3Double restored = new Vector3Double();
        restored.unmarshal(dis);

        assertEquals(original.getX(), restored.getX(), TOLERANCE, "mismatched x after unmarshal");
        assertEquals(original.getY(), restored.getY(), TOLERANCE, "mismatched y after unmarshal");
        assertEquals(original.getZ(), restored.getZ(), TOLERANCE, "mismatched z after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** Vector3DoubleTest testMarshalUnmarshalByteBuffer()");

        Vector3Double original = new Vector3Double();
        original.setX(Double.MAX_VALUE);
        original.setY(Double.MIN_VALUE);
        original.setZ(-1.0);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        Vector3Double restored = new Vector3Double();
        restored.unmarshal(buffer);

        assertEquals(original.getX(), restored.getX(), TOLERANCE, "mismatched x after ByteBuffer unmarshal");
        assertEquals(original.getY(), restored.getY(), TOLERANCE, "mismatched y after ByteBuffer unmarshal");
        assertEquals(original.getZ(), restored.getZ(), TOLERANCE, "mismatched z after ByteBuffer unmarshal");
    }

    @Test
    public void testEquality()
    {
        if (verbose)
            System.out.println("*** Vector3DoubleTest testEquality()");

        Vector3Double a = new Vector3Double();
        a.setX(1.0);
        a.setY(2.0);
        a.setZ(3.0);
        Vector3Double b = new Vector3Double();
        b.setX(1.0);
        b.setY(2.0);
        b.setZ(3.0);
        Vector3Double c = new Vector3Double();
        c.setX(1.0);
        c.setY(2.0);
        c.setZ(4.0);

        assertTrue(a.equals(b), "equal Vector3Doubles should be equal");
        assertFalse(a.equals(c), "different Vector3Doubles should not be equal");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("Vector3DoubleTest start");
        Vector3DoubleTest test = new Vector3DoubleTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSettersAndGetters();
        test.testMarshalledSize();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        test.testEquality();
        tearDownClass();
        System.out.println("Vector3DoubleTest complete");
    }
}
