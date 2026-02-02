/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.VariableDatum;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for VariableDatum data structure.
 * Validates construction, variable length handling, and marshal/unmarshal round-trip.
 */
@DisplayName("VariableDatumTest")
public class VariableDatumTest
{
    private static boolean verbose = true;

    /** default constructor */
    public VariableDatumTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** VariableDatumTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** VariableDatumTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** VariableDatumTest testDefaultConstructor()");

        VariableDatum vd = new VariableDatum();
        assertNotNull(vd.getVariableDatumValue(), "variableDatumValue should not be null");
    }

    @Test
    public void testSetVariableDatumValue()
    {
        if (verbose)
            System.out.println("*** VariableDatumTest testSetVariableDatumValue()");

        VariableDatum vd = new VariableDatum();
        byte[] data = {0x01, 0x02, 0x03, 0x04, 0x05};
        vd.setVariableDatumValue(data);
        byte[] result = vd.getVariableDatumValue();
        assertEquals(5, result.length, "mismatched value length");
        assertEquals(0x01, result[0], "mismatched value byte 0");
        assertEquals(0x05, result[4], "mismatched value byte 4");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** VariableDatumTest testMarshalUnmarshalDataStream()");

        VariableDatum original = new VariableDatum();
        byte[] data = "test data".getBytes();
        original.setVariableDatumValue(data);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        VariableDatum restored = new VariableDatum();
        restored.unmarshal(dis);

        assertArrayEquals(original.getVariableDatumValue(), restored.getVariableDatumValue(), "mismatched variableDatumValue after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** VariableDatumTest testMarshalUnmarshalByteBuffer()");

        VariableDatum original = new VariableDatum();
        byte[] data = {(byte)0xFF, 0x00, (byte)0xAB, (byte)0xCD};
        original.setVariableDatumValue(data);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        VariableDatum restored = new VariableDatum();
        restored.unmarshal(buffer);

        assertArrayEquals(original.getVariableDatumValue(), restored.getVariableDatumValue(), "mismatched variableDatumValue after ByteBuffer unmarshal");
    }

    @Test
    public void testEmptyDatum() throws Exception
    {
        if (verbose)
            System.out.println("*** VariableDatumTest testEmptyDatum()");

        VariableDatum original = new VariableDatum();
        original.setVariableDatumValue(new byte[0]);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        VariableDatum restored = new VariableDatum();
        restored.unmarshal(dis);

        assertEquals(0, restored.getVariableDatumValue().length, "empty datum should unmarshal to empty value");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("VariableDatumTest start");
        VariableDatumTest test = new VariableDatumTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSetVariableDatumValue();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        test.testEmptyDatum();
        tearDownClass();
        System.out.println("VariableDatumTest complete");
    }
}
