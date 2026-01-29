/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.ModulationType;
import edu.nps.moves.dis7.enumerations.TransmitterMajorModulation;
import edu.nps.moves.dis7.enumerations.TransmitterModulationTypeSystem;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ModulationType data structure.
 * Validates construction, field access, and marshal/unmarshal round-trip.
 */
@DisplayName("ModulationTypeTest")
public class ModulationTypeTest
{
    private static boolean verbose = true;

    /** default constructor */
    public ModulationTypeTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** ModulationTypeTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** ModulationTypeTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** ModulationTypeTest testDefaultConstructor()");

        ModulationType mt = new ModulationType();
        assertEquals(0, mt.getSpreadSpectrum(), "mismatched default spreadSpectrum");
        assertEquals(0, mt.getDetail(), "mismatched default detail");
    }

    @Test
    public void testSettersAndGetters()
    {
        if (verbose)
            System.out.println("*** ModulationTypeTest testSettersAndGetters()");

        ModulationType mt = new ModulationType();
        mt.setSpreadSpectrum(1);
        mt.setMajorModulation(TransmitterMajorModulation.AMPLITUDE_2);
        mt.setDetail(3);
        mt.setRadioSystem(TransmitterModulationTypeSystem.GENERIC_RADIO_OR_SIMPLE_INTERCOM);

        assertEquals(1, mt.getSpreadSpectrum(), "mismatched spreadSpectrum");
        assertEquals(TransmitterMajorModulation.AMPLITUDE_2, mt.getMajorModulation(), "mismatched majorModulation");
        assertEquals(3, mt.getDetail(), "mismatched detail");
        assertEquals(TransmitterModulationTypeSystem.GENERIC_RADIO_OR_SIMPLE_INTERCOM, mt.getRadioSystem(), "mismatched radioSystem");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** ModulationTypeTest testMarshalUnmarshalDataStream()");

        ModulationType original = new ModulationType();
        original.setSpreadSpectrum(2);
        original.setMajorModulation(TransmitterMajorModulation.AMPLITUDE_2);
        original.setDetail(5);
        original.setRadioSystem(TransmitterModulationTypeSystem.GENERIC_RADIO_OR_SIMPLE_INTERCOM);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        ModulationType restored = new ModulationType();
        restored.unmarshal(dis);

        assertEquals(original.getSpreadSpectrum(), restored.getSpreadSpectrum(), "mismatched spreadSpectrum after unmarshal");
        assertEquals(original.getMajorModulation(), restored.getMajorModulation(), "mismatched majorModulation after unmarshal");
        assertEquals(original.getDetail(), restored.getDetail(), "mismatched detail after unmarshal");
        assertEquals(original.getRadioSystem(), restored.getRadioSystem(), "mismatched radioSystem after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** ModulationTypeTest testMarshalUnmarshalByteBuffer()");

        ModulationType original = new ModulationType();
        original.setSpreadSpectrum(0);
        original.setMajorModulation(TransmitterMajorModulation.AMPLITUDE_2);
        original.setDetail(1);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        ModulationType restored = new ModulationType();
        restored.unmarshal(buffer);

        assertEquals(original.getSpreadSpectrum(), restored.getSpreadSpectrum(), "mismatched spreadSpectrum after ByteBuffer unmarshal");
        assertEquals(original.getMajorModulation(), restored.getMajorModulation(), "mismatched majorModulation after ByteBuffer unmarshal");
        assertEquals(original.getDetail(), restored.getDetail(), "mismatched detail after ByteBuffer unmarshal");
    }

    @Test
    public void testEquality()
    {
        if (verbose)
            System.out.println("*** ModulationTypeTest testEquality()");

        ModulationType a = new ModulationType();
        a.setSpreadSpectrum(1);
        a.setDetail(2);
        ModulationType b = new ModulationType();
        b.setSpreadSpectrum(1);
        b.setDetail(2);
        ModulationType c = new ModulationType();
        c.setSpreadSpectrum(1);
        c.setDetail(3);

        assertTrue(a.equals(b), "equal ModulationTypes should be equal");
        assertFalse(a.equals(c), "different ModulationTypes should not be equal");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("ModulationTypeTest start");
        ModulationTypeTest test = new ModulationTypeTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSettersAndGetters();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        test.testEquality();
        tearDownClass();
        System.out.println("ModulationTypeTest complete");
    }
}
