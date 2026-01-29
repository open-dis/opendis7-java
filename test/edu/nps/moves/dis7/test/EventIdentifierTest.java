/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.EventIdentifier;
import edu.nps.moves.dis7.pdus.SimulationAddress;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for EventIdentifier data structure.
 * Validates construction, field access, marshal/unmarshal round-trip, and equality.
 */
@DisplayName("EventIdentifierTest")
public class EventIdentifierTest
{
    private static boolean verbose = true;

    /** default constructor */
    public EventIdentifierTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** EventIdentifierTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** EventIdentifierTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** EventIdentifierTest testDefaultConstructor()");

        EventIdentifier ei = new EventIdentifier();
        assertNotNull(ei.getSimulationAddress(), "simulationAddress should not be null");
        assertEquals(0, ei.getEventNumber(), "mismatched default eventNumber");
    }

    @Test
    public void testSettersAndGetters()
    {
        if (verbose)
            System.out.println("*** EventIdentifierTest testSettersAndGetters()");

        EventIdentifier ei = new EventIdentifier();
        SimulationAddress sa = new SimulationAddress();
        sa.setSite(10);
        sa.setApplication(20);
        ei.setSimulationAddress(sa);
        ei.setEventNumber(42);

        assertEquals(10, ei.getSimulationAddress().getSite(), "mismatched site");
        assertEquals(20, ei.getSimulationAddress().getApplication(), "mismatched application");
        assertEquals(42, ei.getEventNumber(), "mismatched eventNumber");
    }

    @Test
    public void testMarshalledSize()
    {
        if (verbose)
            System.out.println("*** EventIdentifierTest testMarshalledSize()");

        EventIdentifier ei = new EventIdentifier();
        assertEquals(6, ei.getMarshalledSize(), "mismatched marshalled size");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** EventIdentifierTest testMarshalUnmarshalDataStream()");

        EventIdentifier original = new EventIdentifier();
        original.getSimulationAddress().setSite(100);
        original.getSimulationAddress().setApplication(200);
        original.setEventNumber(300);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        EventIdentifier restored = new EventIdentifier();
        restored.unmarshal(dis);

        assertEquals(original.getSimulationAddress().getSite(), restored.getSimulationAddress().getSite(), "mismatched site after unmarshal");
        assertEquals(original.getSimulationAddress().getApplication(), restored.getSimulationAddress().getApplication(), "mismatched application after unmarshal");
        assertEquals(original.getEventNumber(), restored.getEventNumber(), "mismatched eventNumber after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** EventIdentifierTest testMarshalUnmarshalByteBuffer()");

        EventIdentifier original = new EventIdentifier();
        original.getSimulationAddress().setSite(500);
        original.getSimulationAddress().setApplication(600);
        original.setEventNumber(700);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        EventIdentifier restored = new EventIdentifier();
        restored.unmarshal(buffer);

        assertEquals(original.getSimulationAddress().getSite(), restored.getSimulationAddress().getSite(), "mismatched site after ByteBuffer unmarshal");
        assertEquals(original.getSimulationAddress().getApplication(), restored.getSimulationAddress().getApplication(), "mismatched application after ByteBuffer unmarshal");
        assertEquals(original.getEventNumber(), restored.getEventNumber(), "mismatched eventNumber after ByteBuffer unmarshal");
    }

    @Test
    public void testEquality()
    {
        if (verbose)
            System.out.println("*** EventIdentifierTest testEquality()");

        EventIdentifier a = new EventIdentifier();
        a.getSimulationAddress().setSite(1);
        a.getSimulationAddress().setApplication(2);
        a.setEventNumber(3);

        EventIdentifier b = new EventIdentifier();
        b.getSimulationAddress().setSite(1);
        b.getSimulationAddress().setApplication(2);
        b.setEventNumber(3);

        EventIdentifier c = new EventIdentifier();
        c.getSimulationAddress().setSite(1);
        c.getSimulationAddress().setApplication(2);
        c.setEventNumber(4);

        assertTrue(a.equals(b), "equal EventIdentifiers should be equal");
        assertFalse(a.equals(c), "different EventIdentifiers should not be equal");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("EventIdentifierTest start");
        EventIdentifierTest test = new EventIdentifierTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSettersAndGetters();
        test.testMarshalledSize();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        test.testEquality();
        tearDownClass();
        System.out.println("EventIdentifierTest complete");
    }
}
