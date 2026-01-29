/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import SRM.*;
import edu.nps.moves.spatial.EntityBodyCoordinates;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for EntityBodyCoordinates spatial utility class.
 * Validates construction of body-centric lococentric Euclidean reference frames
 * embedded in parent spatial reference frames with known Euler angles and identity rotations.
 */
@DisplayName("EntityBodyCoordinatesTest")
public class EntityBodyCoordinatesTest
{
    private static boolean verbose = true;

    /** A reusable parent LTSE reference frame */
    private static SRF_LocalTangentSpaceEuclidean parentSRF;

    /** default constructor */
    public EntityBodyCoordinatesTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** EntityBodyCoordinatesTest setUpClass()");

        try
        {
            // Create a parent Local Tangent Space Euclidean SRF at equator/prime meridian
            parentSRF = new SRF_LocalTangentSpaceEuclidean(
                SRM_ORM_Code.ORMCOD_WGS_1984,
                SRM_RT_Code.RTCOD_WGS_1984_IDENTITY,
                0.0, 0.0,    // lon, lat in radians (equator/prime meridian)
                0.0,          // azimuth
                0.0, 0.0,    // false x, y origin
                0.0);         // height offset
        }
        catch (SrmException e)
        {
            fail("Failed to create parent SRF: " + e);
        }
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** EntityBodyCoordinatesTest tearDownClass()");
    }

    @Test
    public void testConstructionWithIdentityAxes()
    {
        if (verbose)
            System.out.println("*** EntityBodyCoordinatesTest testConstructionWithIdentityAxes()");

        // Identity orientation: u axis along x (1,0,0), v axis along y (0,1,0)
        // Origin at (0,0,0) in parent LTSE frame
        EntityBodyCoordinates ebc = new EntityBodyCoordinates(
            parentSRF,
            0.0f, 0.0f, 0.0f,        // lococenter origin
            1.0f, 0.0f, 0.0f,        // primary axis (u) along x
            0.0f, 1.0f, 0.0f);       // secondary axis (v) along y

        assertNotNull(ebc, "EntityBodyCoordinates with identity axes should not be null");
    }

    @Test
    public void testConstructionWithOffsetOrigin()
    {
        if (verbose)
            System.out.println("*** EntityBodyCoordinatesTest testConstructionWithOffsetOrigin()");

        // Place entity origin at (100, 200, 50) in parent frame
        EntityBodyCoordinates ebc = new EntityBodyCoordinates(
            parentSRF,
            100.0f, 200.0f, 50.0f,   // lococenter offset from range origin
            1.0f, 0.0f, 0.0f,        // primary axis (u) along x
            0.0f, 1.0f, 0.0f);       // secondary axis (v) along y

        assertNotNull(ebc, "EntityBodyCoordinates with offset origin should not be null");
    }

    @Test
    public void testConstructionWithRotatedAxes()
    {
        if (verbose)
            System.out.println("*** EntityBodyCoordinatesTest testConstructionWithRotatedAxes()");

        // Rotated 45 degrees: u axis along (cos45, sin45, 0), v axis along (-sin45, cos45, 0)
        float cos45 = (float) Math.cos(Math.toRadians(45.0));
        float sin45 = (float) Math.sin(Math.toRadians(45.0));

        EntityBodyCoordinates ebc = new EntityBodyCoordinates(
            parentSRF,
            0.0f, 0.0f, 0.0f,              // lococenter at origin
            cos45, sin45, 0.0f,             // primary axis (u) rotated 45 deg
            -sin45, cos45, 0.0f);           // secondary axis (v) perpendicular

        assertNotNull(ebc, "EntityBodyCoordinates with rotated axes should not be null");
    }

    @Test
    public void testConstructionWithDifferentParentLocation()
    {
        if (verbose)
            System.out.println("*** EntityBodyCoordinatesTest testConstructionWithDifferentParentLocation()");

        try
        {
            // Create parent LTSE at Monterey area (36.6 lat, -121.9 lon)
            SRF_LocalTangentSpaceEuclidean montereySRF = new SRF_LocalTangentSpaceEuclidean(
                SRM_ORM_Code.ORMCOD_WGS_1984,
                SRM_RT_Code.RTCOD_WGS_1984_IDENTITY,
                Math.toRadians(-121.9), Math.toRadians(36.6),  // lon, lat in radians
                0.0,          // azimuth
                0.0, 0.0,    // false x, y origin
                10.0);        // height offset

            EntityBodyCoordinates ebc = new EntityBodyCoordinates(
                montereySRF,
                500.0f, -300.0f, 25.0f,  // lococenter offset
                1.0f, 0.0f, 0.0f,        // primary axis (u) along x
                0.0f, 1.0f, 0.0f);       // secondary axis (v) along y

            assertNotNull(ebc, "EntityBodyCoordinates at Monterey location should not be null");
        }
        catch (SrmException e)
        {
            fail("Failed to create Monterey SRF: " + e);
        }
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("EntityBodyCoordinatesTest start");
        EntityBodyCoordinatesTest test = new EntityBodyCoordinatesTest();
        setUpClass();
        test.testConstructionWithIdentityAxes();
        test.testConstructionWithOffsetOrigin();
        test.testConstructionWithRotatedAxes();
        test.testConstructionWithDifferentParentLocation();
        tearDownClass();
        System.out.println("EntityBodyCoordinatesTest complete");
    }
}
