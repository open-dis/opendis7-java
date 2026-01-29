/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.utilities.stream.X3dCoordinates;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for X3dCoordinates data holder class.
 * Validates constructors, getters, and setters for coordinate and orientation fields.
 */
@DisplayName("X3dCoordinatesTest")
public class X3dCoordinatesTest
{
    private static boolean verbose = true;

    /** default constructor */
    public X3dCoordinatesTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** X3dCoordinatesTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** X3dCoordinatesTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** X3dCoordinatesTest testDefaultConstructor()");

        X3dCoordinates coords = new X3dCoordinates();
        assertEquals(0.0, coords.getX(), 1e-9, "mismatched default X");
        assertEquals(0.0, coords.getY(), 1e-9, "mismatched default Y");
        assertEquals(0.0, coords.getZ(), 1e-9, "mismatched default Z");
        assertEquals(0.0, coords.getPhi(), 1e-9, "mismatched default phi");
        assertEquals(0.0, coords.getPsi(), 1e-9, "mismatched default psi");
        assertEquals(0.0, coords.getTheta(), 1e-9, "mismatched default theta");
    }

    @Test
    public void testParameterizedConstructor()
    {
        if (verbose)
            System.out.println("*** X3dCoordinatesTest testParameterizedConstructor()");

        X3dCoordinates coords = new X3dCoordinates(1.5, 2.5, 3.5, 0.1, 0.2, 0.3);
        assertEquals(1.5, coords.getX(), 1e-9, "mismatched X");
        assertEquals(2.5, coords.getY(), 1e-9, "mismatched Y");
        assertEquals(3.5, coords.getZ(), 1e-9, "mismatched Z");
        assertEquals(0.1, coords.getPhi(), 1e-9, "mismatched phi");
        assertEquals(0.2, coords.getPsi(), 1e-9, "mismatched psi");
        assertEquals(0.3, coords.getTheta(), 1e-9, "mismatched theta");
    }

    @Test
    public void testSetX()
    {
        if (verbose)
            System.out.println("*** X3dCoordinatesTest testSetX()");

        X3dCoordinates coords = new X3dCoordinates();
        coords.setX(100.0);
        assertEquals(100.0, coords.getX(), 1e-9, "mismatched X after set");
    }

    @Test
    public void testSetY()
    {
        if (verbose)
            System.out.println("*** X3dCoordinatesTest testSetY()");

        X3dCoordinates coords = new X3dCoordinates();
        coords.setY(200.0);
        assertEquals(200.0, coords.getY(), 1e-9, "mismatched Y after set");
    }

    @Test
    public void testSetZ()
    {
        if (verbose)
            System.out.println("*** X3dCoordinatesTest testSetZ()");

        X3dCoordinates coords = new X3dCoordinates();
        coords.setZ(300.0);
        assertEquals(300.0, coords.getZ(), 1e-9, "mismatched Z after set");
    }

    @Test
    public void testSetPhi()
    {
        if (verbose)
            System.out.println("*** X3dCoordinatesTest testSetPhi()");

        X3dCoordinates coords = new X3dCoordinates();
        coords.setPhi(1.5707);
        assertEquals(1.5707, coords.getPhi(), 1e-9, "mismatched phi after set");
    }

    @Test
    public void testSetPsi()
    {
        if (verbose)
            System.out.println("*** X3dCoordinatesTest testSetPsi()");

        X3dCoordinates coords = new X3dCoordinates();
        coords.setPsi(3.1416);
        assertEquals(3.1416, coords.getPsi(), 1e-9, "mismatched psi after set");
    }

    @Test
    public void testSetTheta()
    {
        if (verbose)
            System.out.println("*** X3dCoordinatesTest testSetTheta()");

        X3dCoordinates coords = new X3dCoordinates();
        coords.setTheta(0.7854);
        assertEquals(0.7854, coords.getTheta(), 1e-9, "mismatched theta after set");
    }

    @Test
    public void testNegativeCoordinates()
    {
        if (verbose)
            System.out.println("*** X3dCoordinatesTest testNegativeCoordinates()");

        X3dCoordinates coords = new X3dCoordinates(-10.5, -20.5, -30.5, -0.5, -1.0, -1.5);
        assertEquals(-10.5, coords.getX(), 1e-9, "mismatched negative X");
        assertEquals(-20.5, coords.getY(), 1e-9, "mismatched negative Y");
        assertEquals(-30.5, coords.getZ(), 1e-9, "mismatched negative Z");
        assertEquals(-0.5, coords.getPhi(), 1e-9, "mismatched negative phi");
        assertEquals(-1.0, coords.getPsi(), 1e-9, "mismatched negative psi");
        assertEquals(-1.5, coords.getTheta(), 1e-9, "mismatched negative theta");
    }

    @Test
    public void testLargeCoordinates()
    {
        if (verbose)
            System.out.println("*** X3dCoordinatesTest testLargeCoordinates()");

        // DIS geocentric coordinates can be very large (Earth radius ~6.4e6 meters)
        double earthRadiusX = 4510023.456;
        double earthRadiusY = 4510023.456;
        double earthRadiusZ = 4367098.123;
        X3dCoordinates coords = new X3dCoordinates(earthRadiusX, earthRadiusY, earthRadiusZ, 0.0, 0.0, 0.0);
        assertEquals(earthRadiusX, coords.getX(), 1e-9, "mismatched large X");
        assertEquals(earthRadiusY, coords.getY(), 1e-9, "mismatched large Y");
        assertEquals(earthRadiusZ, coords.getZ(), 1e-9, "mismatched large Z");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("X3dCoordinatesTest start");
        X3dCoordinatesTest test = new X3dCoordinatesTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testParameterizedConstructor();
        test.testSetX();
        test.testSetY();
        test.testSetZ();
        test.testSetPhi();
        test.testSetPsi();
        test.testSetTheta();
        test.testNegativeCoordinates();
        test.testLargeCoordinates();
        tearDownClass();
        System.out.println("X3dCoordinatesTest complete");
    }
}
