/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.utilities.PduFactory;
import edu.nps.moves.dis7.utilities.stream.X3dCreateLineSet;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for X3dCreateLineSet utility class.
 * Validates ESPDU byte buffer processing and point accumulation
 * for X3D LineSet generation.
 */
@DisplayName("X3dCreateLineSetTest")
public class X3dCreateLineSetTest
{
    private static boolean verbose = true;

    /** default constructor */
    public X3dCreateLineSetTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** X3dCreateLineSetTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** X3dCreateLineSetTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** X3dCreateLineSetTest testDefaultConstructor()");

        X3dCreateLineSet lineSet = new X3dCreateLineSet();
        assertNotNull(lineSet, "X3dCreateLineSet should not be null");
    }

    @Test
    public void testAddPointsWithEspduBytes() throws Exception
    {
        if (verbose)
            System.out.println("*** X3dCreateLineSetTest testAddPointsWithEspduBytes()");

        PduFactory factory = new PduFactory();
        EntityStatePdu espdu = factory.makeEntityStatePdu();
        espdu.getEntityLocation().setX(100.0);
        espdu.getEntityLocation().setY(200.0);
        espdu.getEntityLocation().setZ(300.0);

        ByteBuffer buffer = espdu.marshal();
        byte[] bytes = new byte[buffer.limit()];
        buffer.rewind();
        buffer.get(bytes);

        X3dCreateLineSet lineSet = new X3dCreateLineSet();
        // addPointsToMap checks byte[2] == 1 for ENTITY_STATE
        lineSet.addPointsToMap(bytes);
        // no exception means successful processing
    }

    @Test
    public void testAddMultipleEspduPoints() throws Exception
    {
        if (verbose)
            System.out.println("*** X3dCreateLineSetTest testAddMultipleEspduPoints()");

        PduFactory factory = new PduFactory();
        X3dCreateLineSet lineSet = new X3dCreateLineSet();

        // add multiple points representing a trajectory
        double[][] positions = {
            {100.0, 200.0, 300.0},
            {110.0, 210.0, 310.0},
            {120.0, 220.0, 320.0},
            {130.0, 230.0, 330.0}
        };

        for (double[] pos : positions)
        {
            EntityStatePdu espdu = factory.makeEntityStatePdu();
            espdu.getEntityLocation().setX(pos[0]);
            espdu.getEntityLocation().setY(pos[1]);
            espdu.getEntityLocation().setZ(pos[2]);

            ByteBuffer buffer = espdu.marshal();
            byte[] bytes = new byte[buffer.limit()];
            buffer.rewind();
            buffer.get(bytes);

            lineSet.addPointsToMap(bytes);
        }
        // no exception means successful processing of multiple points
    }

    @Test
    public void testNonEspduBytesIgnored()
    {
        if (verbose)
            System.out.println("*** X3dCreateLineSetTest testNonEspduBytesIgnored()");

        X3dCreateLineSet lineSet = new X3dCreateLineSet();

        // create a byte array where byte[2] != 1 (not ENTITY_STATE)
        byte[] nonEspduBytes = new byte[144];
        nonEspduBytes[2] = 2; // Fire PDU type value
        lineSet.addPointsToMap(nonEspduBytes);
        // should silently ignore non-ESPDU bytes, no exception
    }

    @Test
    public void testMakeX3dLineSetEmpty()
    {
        if (verbose)
            System.out.println("*** X3dCreateLineSetTest testMakeX3dLineSetEmpty()");

        X3dCreateLineSet lineSet = new X3dCreateLineSet();
        // calling makeX3dLineSet with no points should not throw
        lineSet.makeX3dLineSet();
    }

    @Test
    public void testMakeX3dLineSetWithData() throws Exception
    {
        if (verbose)
            System.out.println("*** X3dCreateLineSetTest testMakeX3dLineSetWithData()");

        PduFactory factory = new PduFactory();
        X3dCreateLineSet lineSet = new X3dCreateLineSet();

        // add enough distinct points to produce a valid LineSet
        for (int i = 0; i < 5; i++)
        {
            EntityStatePdu espdu = factory.makeEntityStatePdu();
            espdu.getEntityLocation().setX(1000.0 + i * 100.0);
            espdu.getEntityLocation().setY(2000.0 + i * 50.0);
            espdu.getEntityLocation().setZ(3000.0 + i * 25.0);
            espdu.setTimestamp(i * 1300000); // use scaled timestamps

            ByteBuffer buffer = espdu.marshal();
            byte[] bytes = new byte[buffer.limit()];
            buffer.rewind();
            buffer.get(bytes);

            lineSet.addPointsToMap(bytes);
        }

        // should produce X3D LineSet output to console without exception
        lineSet.makeX3dLineSet();
    }

    @Test
    public void testInputBufferCloned() throws Exception
    {
        if (verbose)
            System.out.println("*** X3dCreateLineSetTest testInputBufferCloned()");

        PduFactory factory = new PduFactory();
        EntityStatePdu espdu = factory.makeEntityStatePdu();
        espdu.getEntityLocation().setX(500.0);
        espdu.getEntityLocation().setY(600.0);
        espdu.getEntityLocation().setZ(700.0);

        ByteBuffer buffer = espdu.marshal();
        byte[] bytes = new byte[buffer.limit()];
        buffer.rewind();
        buffer.get(bytes);
        byte[] originalCopy = bytes.clone();

        X3dCreateLineSet lineSet = new X3dCreateLineSet();
        lineSet.addPointsToMap(bytes);

        // verify input buffer was not modified
        assertArrayEquals(originalCopy, bytes, "input buffer should not be modified by addPointsToMap");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("X3dCreateLineSetTest start");
        X3dCreateLineSetTest test = new X3dCreateLineSetTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testAddPointsWithEspduBytes();
        test.testAddMultipleEspduPoints();
        test.testNonEspduBytesIgnored();
        test.testMakeX3dLineSetEmpty();
        test.testMakeX3dLineSetWithData();
        test.testInputBufferCloned();
        tearDownClass();
        System.out.println("X3dCreateLineSetTest complete");
    }
}
