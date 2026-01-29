/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.FixedDatum;
import edu.nps.moves.dis7.enumerations.VariableRecordType;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for FixedDatum data structure.
 * Validates construction, field access, and marshal/unmarshal round-trip.
 */
@DisplayName("FixedDatumTest")
public class FixedDatumTest
{
    private static boolean verbose = true;

    /** default constructor */
    public FixedDatumTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** FixedDatumTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** FixedDatumTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** FixedDatumTest testDefaultConstructor()");

        FixedDatum fd = new FixedDatum();
        assertEquals(0, fd.getFixedDatumValue(), "mismatched default fixedDatumValue");
    }

    @Test
    public void testSettersAndGetters()
    {
        if (verbose)
            System.out.println("*** FixedDatumTest testSettersAndGetters()");

        FixedDatum fd = new FixedDatum();
        fd.setFixedDatumValue(12345);
        assertEquals(12345, fd.getFixedDatumValue(), "mismatched fixedDatumValue");
    }

    @Test
    public void testMarshalledSize()
    {
        if (verbose)
            System.out.println("*** FixedDatumTest testMarshalledSize()");

        FixedDatum fd = new FixedDatum();
        assertEquals(8, fd.getMarshalledSize(), "mismatched marshalled size");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** FixedDatumTest testMarshalUnmarshalDataStream()");

        FixedDatum original = new FixedDatum();
        original.setFixedDatumValue(99999);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        FixedDatum restored = new FixedDatum();
        restored.unmarshal(dis);

        assertEquals(original.getFixedDatumValue(), restored.getFixedDatumValue(), "mismatched fixedDatumValue after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** FixedDatumTest testMarshalUnmarshalByteBuffer()");

        FixedDatum original = new FixedDatum();
        original.setFixedDatumValue(77777);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        FixedDatum restored = new FixedDatum();
        restored.unmarshal(buffer);

        assertEquals(original.getFixedDatumValue(), restored.getFixedDatumValue(), "mismatched fixedDatumValue after ByteBuffer unmarshal");
    }

    @Test
    public void testEquality()
    {
        if (verbose)
            System.out.println("*** FixedDatumTest testEquality()");

        FixedDatum a = new FixedDatum();
        a.setFixedDatumValue(100);
        FixedDatum b = new FixedDatum();
        b.setFixedDatumValue(100);
        FixedDatum c = new FixedDatum();
        c.setFixedDatumValue(200);

        assertTrue(a.equals(b), "equal FixedDatums should be equal");
        assertFalse(a.equals(c), "different FixedDatums should not be equal");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("FixedDatumTest start");
        FixedDatumTest test = new FixedDatumTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSettersAndGetters();
        test.testMarshalledSize();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        test.testEquality();
        tearDownClass();
        System.out.println("FixedDatumTest complete");
    }
}
