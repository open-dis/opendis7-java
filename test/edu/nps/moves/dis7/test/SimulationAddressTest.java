/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.SimulationAddress;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for SimulationAddress data structure.
 * Validates construction, field access, marshal/unmarshal round-trip, and equality.
 */
@DisplayName("SimulationAddressTest")
public class SimulationAddressTest
{
    private static boolean verbose = true;

    /** default constructor */
    public SimulationAddressTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** SimulationAddressTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** SimulationAddressTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** SimulationAddressTest testDefaultConstructor()");

        SimulationAddress sa = new SimulationAddress();
        assertEquals(0, sa.getSite(), "mismatched default site");
        assertEquals(0, sa.getApplication(), "mismatched default application");
    }

    @Test
    public void testSettersAndGetters()
    {
        if (verbose)
            System.out.println("*** SimulationAddressTest testSettersAndGetters()");

        SimulationAddress sa = new SimulationAddress();
        sa.setSite(42);
        sa.setApplication(99);
        assertEquals(42, sa.getSite(), "mismatched site");
        assertEquals(99, sa.getApplication(), "mismatched application");
    }

    @Test
    public void testMarshalledSize()
    {
        if (verbose)
            System.out.println("*** SimulationAddressTest testMarshalledSize()");

        SimulationAddress sa = new SimulationAddress();
        assertEquals(4, sa.getMarshalledSize(), "mismatched marshalled size");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** SimulationAddressTest testMarshalUnmarshalDataStream()");

        SimulationAddress original = new SimulationAddress();
        original.setSite(101);
        original.setApplication(202);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        SimulationAddress restored = new SimulationAddress();
        restored.unmarshal(dis);

        assertEquals(original.getSite(), restored.getSite(), "mismatched site after unmarshal");
        assertEquals(original.getApplication(), restored.getApplication(), "mismatched application after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** SimulationAddressTest testMarshalUnmarshalByteBuffer()");

        SimulationAddress original = new SimulationAddress();
        original.setSite(500);
        original.setApplication(600);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        SimulationAddress restored = new SimulationAddress();
        restored.unmarshal(buffer);

        assertEquals(original.getSite(), restored.getSite(), "mismatched site after ByteBuffer unmarshal");
        assertEquals(original.getApplication(), restored.getApplication(), "mismatched application after ByteBuffer unmarshal");
    }

    @Test
    public void testEquality()
    {
        if (verbose)
            System.out.println("*** SimulationAddressTest testEquality()");

        SimulationAddress a = new SimulationAddress();
        a.setSite(1);
        a.setApplication(2);
        SimulationAddress b = new SimulationAddress();
        b.setSite(1);
        b.setApplication(2);
        SimulationAddress c = new SimulationAddress();
        c.setSite(1);
        c.setApplication(3);

        assertTrue(a.equals(b), "equal SimulationAddresses should be equal");
        assertFalse(a.equals(c), "different SimulationAddresses should not be equal");
        assertEquals(a.hashCode(), b.hashCode(), "equal objects should have equal hashCodes");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("SimulationAddressTest start");
        SimulationAddressTest test = new SimulationAddressTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSettersAndGetters();
        test.testMarshalledSize();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        test.testEquality();
        tearDownClass();
        System.out.println("SimulationAddressTest complete");
    }
}
