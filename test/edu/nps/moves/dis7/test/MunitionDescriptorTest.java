/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.MunitionDescriptor;
import edu.nps.moves.dis7.pdus.EntityType;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.enumerations.MunitionDescriptorWarhead;
import edu.nps.moves.dis7.enumerations.MunitionDescriptorFuse;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MunitionDescriptor data structure.
 * Validates construction, field access, and marshal/unmarshal round-trip.
 */
@DisplayName("MunitionDescriptorTest")
public class MunitionDescriptorTest
{
    private static boolean verbose = true;

    /** default constructor */
    public MunitionDescriptorTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** MunitionDescriptorTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** MunitionDescriptorTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** MunitionDescriptorTest testDefaultConstructor()");

        MunitionDescriptor md = new MunitionDescriptor();
        assertNotNull(md.getMunitionType(), "munitionType should not be null");
        assertEquals(0, md.getQuantity(), "mismatched default quantity");
        assertEquals(0, md.getRate(), "mismatched default rate");
    }

    @Test
    public void testSettersAndGetters()
    {
        if (verbose)
            System.out.println("*** MunitionDescriptorTest testSettersAndGetters()");

        MunitionDescriptor md = new MunitionDescriptor();
        md.getMunitionType().setEntityKind(EntityKind.MUNITION);
        md.getMunitionType().setCategory(2);
        md.setWarhead(MunitionDescriptorWarhead.HIGH_EXPLOSIVE_HE);
        md.setFuse(MunitionDescriptorFuse.CONTACT_INSTANT_IMPACT);
        md.setQuantity(10);
        md.setRate(5);

        assertEquals(EntityKind.MUNITION, md.getMunitionType().getEntityKind(), "mismatched entityKind");
        assertEquals(2, md.getMunitionType().getCategory(), "mismatched category");
        assertEquals(MunitionDescriptorWarhead.HIGH_EXPLOSIVE_HE, md.getWarhead(), "mismatched warhead");
        assertEquals(MunitionDescriptorFuse.CONTACT_INSTANT_IMPACT, md.getFuse(), "mismatched fuse");
        assertEquals(10, md.getQuantity(), "mismatched quantity");
        assertEquals(5, md.getRate(), "mismatched rate");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** MunitionDescriptorTest testMarshalUnmarshalDataStream()");

        MunitionDescriptor original = new MunitionDescriptor();
        original.getMunitionType().setEntityKind(EntityKind.MUNITION);
        original.getMunitionType().setCategory(1);
        original.getMunitionType().setSubCategory(2);
        original.setWarhead(MunitionDescriptorWarhead.HIGH_EXPLOSIVE_HE);
        original.setFuse(MunitionDescriptorFuse.CONTACT_INSTANT_IMPACT);
        original.setQuantity(50);
        original.setRate(10);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        MunitionDescriptor restored = new MunitionDescriptor();
        restored.unmarshal(dis);

        assertEquals(original.getMunitionType().getEntityKind(), restored.getMunitionType().getEntityKind(), "mismatched entityKind after unmarshal");
        assertEquals(original.getMunitionType().getCategory(), restored.getMunitionType().getCategory(), "mismatched category after unmarshal");
        assertEquals(original.getWarhead(), restored.getWarhead(), "mismatched warhead after unmarshal");
        assertEquals(original.getFuse(), restored.getFuse(), "mismatched fuse after unmarshal");
        assertEquals(original.getQuantity(), restored.getQuantity(), "mismatched quantity after unmarshal");
        assertEquals(original.getRate(), restored.getRate(), "mismatched rate after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** MunitionDescriptorTest testMarshalUnmarshalByteBuffer()");

        MunitionDescriptor original = new MunitionDescriptor();
        original.getMunitionType().setEntityKind(EntityKind.MUNITION);
        original.setQuantity(1);
        original.setRate(0);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        MunitionDescriptor restored = new MunitionDescriptor();
        restored.unmarshal(buffer);

        assertEquals(original.getMunitionType().getEntityKind(), restored.getMunitionType().getEntityKind(), "mismatched entityKind after ByteBuffer unmarshal");
        assertEquals(original.getQuantity(), restored.getQuantity(), "mismatched quantity after ByteBuffer unmarshal");
        assertEquals(original.getRate(), restored.getRate(), "mismatched rate after ByteBuffer unmarshal");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("MunitionDescriptorTest start");
        MunitionDescriptorTest test = new MunitionDescriptorTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSettersAndGetters();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        tearDownClass();
        System.out.println("MunitionDescriptorTest complete");
    }
}
