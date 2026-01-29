/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.EulerAngles;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for EulerAngles data structure.
 * Validates construction, field access, marshal/unmarshal round-trip, and value ranges.
 */
@DisplayName("EulerAnglesTest")
public class EulerAnglesTest
{
    private static final float TOLERANCE = 1.0e-5f;
    private static boolean verbose = true;

    /** default constructor */
    public EulerAnglesTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** EulerAnglesTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** EulerAnglesTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** EulerAnglesTest testDefaultConstructor()");

        EulerAngles ea = new EulerAngles();
        assertEquals(0.0f, ea.getPsi(), TOLERANCE, "mismatched default psi");
        assertEquals(0.0f, ea.getTheta(), TOLERANCE, "mismatched default theta");
        assertEquals(0.0f, ea.getPhi(), TOLERANCE, "mismatched default phi");
    }

    @Test
    public void testSettersAndGetters()
    {
        if (verbose)
            System.out.println("*** EulerAnglesTest testSettersAndGetters()");

        EulerAngles ea = new EulerAngles();
        ea.setPsi(1.5f);
        ea.setTheta(0.3f);
        ea.setPhi(-0.7f);
        assertEquals(1.5f, ea.getPsi(), TOLERANCE, "mismatched psi");
        assertEquals(0.3f, ea.getTheta(), TOLERANCE, "mismatched theta");
        assertEquals(-0.7f, ea.getPhi(), TOLERANCE, "mismatched phi");
    }

    @Test
    public void testMarshalledSize()
    {
        if (verbose)
            System.out.println("*** EulerAnglesTest testMarshalledSize()");

        EulerAngles ea = new EulerAngles();
        assertEquals(12, ea.getMarshalledSize(), "mismatched marshalled size");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** EulerAnglesTest testMarshalUnmarshalDataStream()");

        EulerAngles original = new EulerAngles();
        original.setPsi((float) Math.PI);
        original.setTheta((float)(Math.PI / 4.0));
        original.setPhi((float)(-Math.PI / 6.0));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        EulerAngles restored = new EulerAngles();
        restored.unmarshal(dis);

        assertEquals(original.getPsi(), restored.getPsi(), TOLERANCE, "mismatched psi after unmarshal");
        assertEquals(original.getTheta(), restored.getTheta(), TOLERANCE, "mismatched theta after unmarshal");
        assertEquals(original.getPhi(), restored.getPhi(), TOLERANCE, "mismatched phi after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** EulerAnglesTest testMarshalUnmarshalByteBuffer()");

        EulerAngles original = new EulerAngles();
        original.setPsi(0.0f);
        original.setTheta((float)(Math.PI / 2.0));
        original.setPhi((float) Math.PI);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        EulerAngles restored = new EulerAngles();
        restored.unmarshal(buffer);

        assertEquals(original.getPsi(), restored.getPsi(), TOLERANCE, "mismatched psi after ByteBuffer unmarshal");
        assertEquals(original.getTheta(), restored.getTheta(), TOLERANCE, "mismatched theta after ByteBuffer unmarshal");
        assertEquals(original.getPhi(), restored.getPhi(), TOLERANCE, "mismatched phi after ByteBuffer unmarshal");
    }

    @Test
    public void testEquality()
    {
        if (verbose)
            System.out.println("*** EulerAnglesTest testEquality()");

        EulerAngles a = new EulerAngles();
        a.setPsi(1.0f);
        a.setTheta(2.0f);
        a.setPhi(3.0f);
        EulerAngles b = new EulerAngles();
        b.setPsi(1.0f);
        b.setTheta(2.0f);
        b.setPhi(3.0f);
        EulerAngles c = new EulerAngles();
        c.setPsi(1.0f);
        c.setTheta(2.0f);
        c.setPhi(4.0f);

        assertTrue(a.equals(b), "equal EulerAngles should be equal");
        assertFalse(a.equals(c), "different EulerAngles should not be equal");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("EulerAnglesTest start");
        EulerAnglesTest test = new EulerAnglesTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSettersAndGetters();
        test.testMarshalledSize();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        test.testEquality();
        tearDownClass();
        System.out.println("EulerAnglesTest complete");
    }
}
