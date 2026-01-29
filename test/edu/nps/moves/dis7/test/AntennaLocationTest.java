/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.AntennaLocation;
import edu.nps.moves.dis7.pdus.Vector3Double;
import edu.nps.moves.dis7.pdus.Vector3Float;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for AntennaLocation data structure.
 * Validates construction, field access, and marshal/unmarshal round-trip.
 */
@DisplayName("AntennaLocationTest")
public class AntennaLocationTest
{
    private static final float FLOAT_TOLERANCE = 1.0e-5f;
    private static final double DOUBLE_TOLERANCE = 1.0e-10;
    private static boolean verbose = true;

    /** default constructor */
    public AntennaLocationTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** AntennaLocationTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** AntennaLocationTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** AntennaLocationTest testDefaultConstructor()");

        AntennaLocation al = new AntennaLocation();
        assertNotNull(al.getAntennaLocation(), "antennaLocation should not be null");
        assertNotNull(al.getRelativeAntennaLocation(), "relativeAntennaLocation should not be null");
    }

    @Test
    public void testSettersAndGetters()
    {
        if (verbose)
            System.out.println("*** AntennaLocationTest testSettersAndGetters()");

        AntennaLocation al = new AntennaLocation();
        al.getAntennaLocation().setX(-2685587.8486);
        al.getAntennaLocation().setY(-4315429.2014);
        al.getAntennaLocation().setZ(3836698.4738);
        al.getRelativeAntennaLocation().setX(0.0f);
        al.getRelativeAntennaLocation().setY(0.0f);
        al.getRelativeAntennaLocation().setZ(2.5f);

        assertEquals(-2685587.8486, al.getAntennaLocation().getX(), DOUBLE_TOLERANCE, "mismatched antenna x");
        assertEquals(-4315429.2014, al.getAntennaLocation().getY(), DOUBLE_TOLERANCE, "mismatched antenna y");
        assertEquals(3836698.4738, al.getAntennaLocation().getZ(), DOUBLE_TOLERANCE, "mismatched antenna z");
        assertEquals(0.0f, al.getRelativeAntennaLocation().getX(), FLOAT_TOLERANCE, "mismatched relative x");
        assertEquals(0.0f, al.getRelativeAntennaLocation().getY(), FLOAT_TOLERANCE, "mismatched relative y");
        assertEquals(2.5f, al.getRelativeAntennaLocation().getZ(), FLOAT_TOLERANCE, "mismatched relative z");
    }

    @Test
    public void testMarshalledSize()
    {
        if (verbose)
            System.out.println("*** AntennaLocationTest testMarshalledSize()");

        AntennaLocation al = new AntennaLocation();
        assertEquals(36, al.getMarshalledSize(), "mismatched marshalled size");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** AntennaLocationTest testMarshalUnmarshalDataStream()");

        AntennaLocation original = new AntennaLocation();
        original.getAntennaLocation().setX(100.0);
        original.getAntennaLocation().setY(200.0);
        original.getAntennaLocation().setZ(300.0);
        original.getRelativeAntennaLocation().setX(1.0f);
        original.getRelativeAntennaLocation().setY(2.0f);
        original.getRelativeAntennaLocation().setZ(3.0f);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        AntennaLocation restored = new AntennaLocation();
        restored.unmarshal(dis);

        assertEquals(original.getAntennaLocation().getX(), restored.getAntennaLocation().getX(), DOUBLE_TOLERANCE, "mismatched antenna x after unmarshal");
        assertEquals(original.getAntennaLocation().getY(), restored.getAntennaLocation().getY(), DOUBLE_TOLERANCE, "mismatched antenna y after unmarshal");
        assertEquals(original.getAntennaLocation().getZ(), restored.getAntennaLocation().getZ(), DOUBLE_TOLERANCE, "mismatched antenna z after unmarshal");
        assertEquals(original.getRelativeAntennaLocation().getX(), restored.getRelativeAntennaLocation().getX(), FLOAT_TOLERANCE, "mismatched relative x after unmarshal");
        assertEquals(original.getRelativeAntennaLocation().getY(), restored.getRelativeAntennaLocation().getY(), FLOAT_TOLERANCE, "mismatched relative y after unmarshal");
        assertEquals(original.getRelativeAntennaLocation().getZ(), restored.getRelativeAntennaLocation().getZ(), FLOAT_TOLERANCE, "mismatched relative z after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** AntennaLocationTest testMarshalUnmarshalByteBuffer()");

        AntennaLocation original = new AntennaLocation();
        original.getAntennaLocation().setX(-1000.5);
        original.getAntennaLocation().setY(2000.5);
        original.getAntennaLocation().setZ(3000.5);
        original.getRelativeAntennaLocation().setX(0.5f);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        AntennaLocation restored = new AntennaLocation();
        restored.unmarshal(buffer);

        assertEquals(original.getAntennaLocation().getX(), restored.getAntennaLocation().getX(), DOUBLE_TOLERANCE, "mismatched antenna x after ByteBuffer unmarshal");
        assertEquals(original.getAntennaLocation().getY(), restored.getAntennaLocation().getY(), DOUBLE_TOLERANCE, "mismatched antenna y after ByteBuffer unmarshal");
        assertEquals(original.getAntennaLocation().getZ(), restored.getAntennaLocation().getZ(), DOUBLE_TOLERANCE, "mismatched antenna z after ByteBuffer unmarshal");
        assertEquals(original.getRelativeAntennaLocation().getX(), restored.getRelativeAntennaLocation().getX(), FLOAT_TOLERANCE, "mismatched relative x after ByteBuffer unmarshal");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("AntennaLocationTest start");
        AntennaLocationTest test = new AntennaLocationTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSettersAndGetters();
        test.testMarshalledSize();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        tearDownClass();
        System.out.println("AntennaLocationTest complete");
    }
}
