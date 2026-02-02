/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.EntityType;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.enumerations.Country;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for EntityType data structure.
 * Validates construction, field access, marshal/unmarshal round-trip, and equality.
 */
@DisplayName("EntityTypeTest")
public class EntityTypeTest
{
    private static boolean verbose = true;

    /** default constructor */
    public EntityTypeTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** EntityTypeTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** EntityTypeTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** EntityTypeTest testDefaultConstructor()");

        EntityType et = new EntityType();
        assertEquals(0, et.getCategory(), "mismatched default category");
        assertEquals(0, et.getSubCategory(), "mismatched default subCategory");
        assertEquals(0, et.getSpecific(), "mismatched default specific");
        assertEquals(0, et.getExtra(), "mismatched default extra");
    }

    @Test
    public void testSettersAndGetters()
    {
        if (verbose)
            System.out.println("*** EntityTypeTest testSettersAndGetters()");

        EntityType et = new EntityType();
        et.setEntityKind(EntityKind.PLATFORM);
        et.setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        et.setCategory(1);
        et.setSubCategory(2);
        et.setSpecific(3);
        et.setExtra(4);

        assertEquals(EntityKind.PLATFORM, et.getEntityKind(), "mismatched entityKind");
        assertEquals(Country.UNITED_STATES_OF_AMERICA_USA, et.getCountry(), "mismatched country");
        assertEquals(1, et.getCategory(), "mismatched category");
        assertEquals(2, et.getSubCategory(), "mismatched subCategory");
        assertEquals(3, et.getSpecific(), "mismatched specific");
        assertEquals(4, et.getExtra(), "mismatched extra");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** EntityTypeTest testMarshalUnmarshalDataStream()");

        EntityType original = new EntityType();
        original.setEntityKind(EntityKind.PLATFORM);
        original.setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        original.setCategory(1);
        original.setSubCategory(1);
        original.setSpecific(2);
        original.setExtra(0);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        EntityType restored = new EntityType();
        restored.unmarshal(dis);

        assertEquals(original.getEntityKind(), restored.getEntityKind(), "mismatched entityKind after unmarshal");
        assertEquals(original.getCountry(), restored.getCountry(), "mismatched country after unmarshal");
        assertEquals(original.getCategory(), restored.getCategory(), "mismatched category after unmarshal");
        assertEquals(original.getSubCategory(), restored.getSubCategory(), "mismatched subCategory after unmarshal");
        assertEquals(original.getSpecific(), restored.getSpecific(), "mismatched specific after unmarshal");
        assertEquals(original.getExtra(), restored.getExtra(), "mismatched extra after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** EntityTypeTest testMarshalUnmarshalByteBuffer()");

        EntityType original = new EntityType();
        original.setEntityKind(EntityKind.MUNITION);
        original.setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        original.setCategory(2);
        original.setSubCategory(3);
        original.setSpecific(4);
        original.setExtra(5);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        EntityType restored = new EntityType();
        restored.unmarshal(buffer);

        assertEquals(original.getEntityKind(), restored.getEntityKind(), "mismatched entityKind after ByteBuffer unmarshal");
        assertEquals(original.getCountry(), restored.getCountry(), "mismatched country after ByteBuffer unmarshal");
        assertEquals(original.getCategory(), restored.getCategory(), "mismatched category after ByteBuffer unmarshal");
        assertEquals(original.getSubCategory(), restored.getSubCategory(), "mismatched subCategory after ByteBuffer unmarshal");
        assertEquals(original.getSpecific(), restored.getSpecific(), "mismatched specific after ByteBuffer unmarshal");
        assertEquals(original.getExtra(), restored.getExtra(), "mismatched extra after ByteBuffer unmarshal");
    }

    @Test
    public void testEquality()
    {
        if (verbose)
            System.out.println("*** EntityTypeTest testEquality()");

        EntityType a = new EntityType();
        a.setEntityKind(EntityKind.PLATFORM);
        a.setCategory(1);
        a.setSubCategory(2);
        EntityType b = new EntityType();
        b.setEntityKind(EntityKind.PLATFORM);
        b.setCategory(1);
        b.setSubCategory(2);
        EntityType c = new EntityType();
        c.setEntityKind(EntityKind.MUNITION);
        c.setCategory(1);
        c.setSubCategory(2);

        assertTrue(a.equals(b), "equal EntityTypes should be equal");
        assertFalse(a.equals(c), "different EntityTypes should not be equal");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("EntityTypeTest start");
        EntityTypeTest test = new EntityTypeTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSettersAndGetters();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        test.testEquality();
        tearDownClass();
        System.out.println("EntityTypeTest complete");
    }
}
