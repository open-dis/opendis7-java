/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.ClockTime;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ClockTime data structure.
 * Validates construction, field access, and marshal/unmarshal round-trip.
 */
@DisplayName("ClockTimeTest")
public class ClockTimeTest
{
    private static boolean verbose = true;

    /** default constructor */
    public ClockTimeTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** ClockTimeTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** ClockTimeTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** ClockTimeTest testDefaultConstructor()");

        ClockTime ct = new ClockTime();
        assertEquals(0, ct.getHour(), "mismatched default hour");
        assertEquals(0, ct.getTimePastHour(), "mismatched default timePastHour");
    }

    @Test
    public void testSettersAndGetters()
    {
        if (verbose)
            System.out.println("*** ClockTimeTest testSettersAndGetters()");

        ClockTime ct = new ClockTime();
        ct.setHour(14);
        ct.setTimePastHour(1800000);
        assertEquals(14, ct.getHour(), "mismatched hour");
        assertEquals(1800000, ct.getTimePastHour(), "mismatched timePastHour");
    }

    @Test
    public void testMarshalledSize()
    {
        if (verbose)
            System.out.println("*** ClockTimeTest testMarshalledSize()");

        ClockTime ct = new ClockTime();
        assertEquals(8, ct.getMarshalledSize(), "mismatched marshalled size");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** ClockTimeTest testMarshalUnmarshalDataStream()");

        ClockTime original = new ClockTime();
        original.setHour(23);
        original.setTimePastHour(3599999);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        ClockTime restored = new ClockTime();
        restored.unmarshal(dis);

        assertEquals(original.getHour(), restored.getHour(), "mismatched hour after unmarshal");
        assertEquals(original.getTimePastHour(), restored.getTimePastHour(), "mismatched timePastHour after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** ClockTimeTest testMarshalUnmarshalByteBuffer()");

        ClockTime original = new ClockTime();
        original.setHour(0);
        original.setTimePastHour(0);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        ClockTime restored = new ClockTime();
        restored.unmarshal(buffer);

        assertEquals(original.getHour(), restored.getHour(), "mismatched hour after ByteBuffer unmarshal");
        assertEquals(original.getTimePastHour(), restored.getTimePastHour(), "mismatched timePastHour after ByteBuffer unmarshal");
    }

    @Test
    public void testEquality()
    {
        if (verbose)
            System.out.println("*** ClockTimeTest testEquality()");

        ClockTime a = new ClockTime();
        a.setHour(5);
        a.setTimePastHour(1000);
        ClockTime b = new ClockTime();
        b.setHour(5);
        b.setTimePastHour(1000);
        ClockTime c = new ClockTime();
        c.setHour(5);
        c.setTimePastHour(2000);

        assertTrue(a.equals(b), "equal ClockTimes should be equal");
        assertFalse(a.equals(c), "different ClockTimes should not be equal");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("ClockTimeTest start");
        ClockTimeTest test = new ClockTimeTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSettersAndGetters();
        test.testMarshalledSize();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        test.testEquality();
        tearDownClass();
        System.out.println("ClockTimeTest complete");
    }
}
