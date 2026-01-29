/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.Vector3Double;
import edu.nps.moves.spatial.RangeCoordinates;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for RangeCoordinates spatial utility class.
 * Validates DIS global to local tangent plane conversion, local to DIS global conversion,
 * round-trip accuracy, and known reference point validation using WGS-84 geodesy.
 */
@DisplayName("RangeCoordinatesTest")
public class RangeCoordinatesTest
{
    /** WGS-84 semi-major axis in meters */
    private static final double WGS84_SEMI_MAJOR_AXIS = 6378137.0;

    /** WGS-84 semi-minor axis in meters */
    private static final double WGS84_SEMI_MINOR_AXIS = 6356752.3142;

    /** Tolerance for coordinate conversions in meters (1 millimeter) */
    private static final double TOLERANCE_METERS = 0.001;

    /** Tolerance for round-trip conversions in meters (1 centimeter, accounts for accumulated floating-point error) */
    private static final double ROUND_TRIP_TOLERANCE = 0.01;

    private static boolean verbose = true;

    /** default constructor */
    public RangeCoordinatesTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest tearDownClass()");
    }

    @Test
    public void testConstructorPrimeMeridianEquator()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest testConstructorPrimeMeridianEquator()");

        RangeCoordinates rc = new RangeCoordinates(0.0, 0.0, 0.0);
        assertNotNull(rc, "RangeCoordinates at equator/prime meridian should not be null");
    }

    @Test
    public void testConstructorArbitraryLocation()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest testConstructorArbitraryLocation()");

        RangeCoordinates rc = new RangeCoordinates(36.6, -121.9, 10.0);
        assertNotNull(rc, "RangeCoordinates at Monterey-area location should not be null");
    }

    @Test
    public void testDISCoordFromLocalFlatAtOriginPrimeMeridian()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest testDISCoordFromLocalFlatAtOriginPrimeMeridian()");

        // At equator/prime meridian (lat=0, lon=0, alt=0), the local origin (0,0,0)
        // should map to DIS geocentric coordinates approximately (6378137, 0, 0)
        // which is the WGS-84 semi-major axis along the x-axis
        RangeCoordinates rc = new RangeCoordinates(0.0, 0.0, 0.0);
        Vector3Double disCoord = rc.DISCoordFromLocalFlat(0.0, 0.0, 0.0);

        assertNotNull(disCoord, "DIS coordinate should not be null");
        assertEquals(WGS84_SEMI_MAJOR_AXIS, disCoord.getX(), TOLERANCE_METERS, "mismatched DIS x at equator/prime meridian");
        assertEquals(0.0, disCoord.getY(), TOLERANCE_METERS, "mismatched DIS y at equator/prime meridian");
        assertEquals(0.0, disCoord.getZ(), TOLERANCE_METERS, "mismatched DIS z at equator/prime meridian");
    }

    @Test
    public void testDISCoordFromLocalFlatAtEquator90East()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest testDISCoordFromLocalFlatAtEquator90East()");

        // At equator/90-deg-east (lat=0, lon=90, alt=0), the local origin
        // should map to DIS geocentric coordinates approximately (0, 6378137, 0)
        RangeCoordinates rc = new RangeCoordinates(0.0, 90.0, 0.0);
        Vector3Double disCoord = rc.DISCoordFromLocalFlat(0.0, 0.0, 0.0);

        assertNotNull(disCoord, "DIS coordinate should not be null");
        assertEquals(0.0, disCoord.getX(), TOLERANCE_METERS, "mismatched DIS x at equator/90E");
        assertEquals(WGS84_SEMI_MAJOR_AXIS, disCoord.getY(), TOLERANCE_METERS, "mismatched DIS y at equator/90E");
        assertEquals(0.0, disCoord.getZ(), TOLERANCE_METERS, "mismatched DIS z at equator/90E");
    }

    @Test
    public void testDISCoordFromLocalFlatAtNorthPole()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest testDISCoordFromLocalFlatAtNorthPole()");

        // At north pole (lat=90, lon=0, alt=0), the local origin
        // should map to DIS geocentric coordinates approximately (0, 0, 6356752.3142)
        // which is the WGS-84 semi-minor axis along the z-axis
        RangeCoordinates rc = new RangeCoordinates(90.0, 0.0, 0.0);
        Vector3Double disCoord = rc.DISCoordFromLocalFlat(0.0, 0.0, 0.0);

        assertNotNull(disCoord, "DIS coordinate should not be null");
        assertEquals(0.0, disCoord.getX(), TOLERANCE_METERS, "mismatched DIS x at north pole");
        assertEquals(0.0, disCoord.getY(), TOLERANCE_METERS, "mismatched DIS y at north pole");
        assertEquals(WGS84_SEMI_MINOR_AXIS, disCoord.getZ(), TOLERANCE_METERS, "mismatched DIS z at north pole");
    }

    @Test
    public void testLocalCoordFromDisAtOriginPrimeMeridian()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest testLocalCoordFromDisAtOriginPrimeMeridian()");

        // DIS geocentric (6378137, 0, 0) should map back to local origin (0,0,0)
        // when the range is centered at equator/prime meridian
        RangeCoordinates rc = new RangeCoordinates(0.0, 0.0, 0.0);
        Vector3Double localCoord = rc.localCoordFromDis(WGS84_SEMI_MAJOR_AXIS, 0.0, 0.0);

        assertNotNull(localCoord, "local coordinate should not be null");
        assertEquals(0.0, localCoord.getX(), TOLERANCE_METERS, "mismatched local x from DIS origin");
        assertEquals(0.0, localCoord.getY(), TOLERANCE_METERS, "mismatched local y from DIS origin");
        assertEquals(0.0, localCoord.getZ(), TOLERANCE_METERS, "mismatched local z from DIS origin");
    }

    @Test
    public void testRoundTripLocalToDISAndBack()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest testRoundTripLocalToDISAndBack()");

        // Create range at Monterey area
        RangeCoordinates rc = new RangeCoordinates(36.6, -121.9, 10.0);

        double localX = 500.0;
        double localY = -300.0;
        double localZ = 50.0;

        // Convert local to DIS
        Vector3Double disCoord = rc.DISCoordFromLocalFlat(localX, localY, localZ);
        assertNotNull(disCoord, "DIS coordinate should not be null");

        // Convert DIS back to local
        Vector3Double roundTrip = rc.localCoordFromDis(disCoord.getX(), disCoord.getY(), disCoord.getZ());
        assertNotNull(roundTrip, "round-trip local coordinate should not be null");

        assertEquals(localX, roundTrip.getX(), ROUND_TRIP_TOLERANCE, "mismatched round-trip x");
        assertEquals(localY, roundTrip.getY(), ROUND_TRIP_TOLERANCE, "mismatched round-trip y");
        assertEquals(localZ, roundTrip.getZ(), ROUND_TRIP_TOLERANCE, "mismatched round-trip z");
    }

    @Test
    public void testRoundTripDISToLocalAndBack()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest testRoundTripDISToLocalAndBack()");

        // Use range at equator/prime meridian
        RangeCoordinates rc = new RangeCoordinates(0.0, 0.0, 0.0);

        // A point slightly offset from the surface along x-axis
        double disX = WGS84_SEMI_MAJOR_AXIS + 100.0;
        double disY = 200.0;
        double disZ = 300.0;

        // Convert DIS to local
        Vector3Double localCoord = rc.localCoordFromDis(disX, disY, disZ);
        assertNotNull(localCoord, "local coordinate should not be null");

        // Convert local back to DIS
        Vector3Double roundTrip = rc.DISCoordFromLocalFlat(localCoord.getX(), localCoord.getY(), localCoord.getZ());
        assertNotNull(roundTrip, "round-trip DIS coordinate should not be null");

        assertEquals(disX, roundTrip.getX(), ROUND_TRIP_TOLERANCE, "mismatched round-trip DIS x");
        assertEquals(disY, roundTrip.getY(), ROUND_TRIP_TOLERANCE, "mismatched round-trip DIS y");
        assertEquals(disZ, roundTrip.getZ(), ROUND_TRIP_TOLERANCE, "mismatched round-trip DIS z");
    }

    @Test
    public void testChangeVectorToDisCoordFromLocalFlat()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest testChangeVectorToDisCoordFromLocalFlat()");

        // Verify that the in-place conversion method produces the same result
        // as the returning method
        RangeCoordinates rc = new RangeCoordinates(0.0, 0.0, 0.0);

        Vector3Double expected = rc.DISCoordFromLocalFlat(0.0, 0.0, 0.0);
        assertNotNull(expected, "expected DIS coordinate should not be null");

        Vector3Double inPlace = new Vector3Double();
        inPlace.setX(0.0);
        inPlace.setY(0.0);
        inPlace.setZ(0.0);
        rc.changeVectorToDisCoordFromLocalFlat(inPlace);

        assertEquals(expected.getX(), inPlace.getX(), TOLERANCE_METERS, "mismatched in-place DIS x");
        assertEquals(expected.getY(), inPlace.getY(), TOLERANCE_METERS, "mismatched in-place DIS y");
        assertEquals(expected.getZ(), inPlace.getZ(), TOLERANCE_METERS, "mismatched in-place DIS z");
    }

    @Test
    public void testChangeVectorToLocalCoordFromDIS()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest testChangeVectorToLocalCoordFromDIS()");

        // Verify that the in-place conversion method produces the same result
        // as the returning method
        RangeCoordinates rc = new RangeCoordinates(0.0, 0.0, 0.0);

        Vector3Double expected = rc.localCoordFromDis(WGS84_SEMI_MAJOR_AXIS, 0.0, 0.0);
        assertNotNull(expected, "expected local coordinate should not be null");

        Vector3Double inPlace = new Vector3Double();
        inPlace.setX(WGS84_SEMI_MAJOR_AXIS);
        inPlace.setY(0.0);
        inPlace.setZ(0.0);
        rc.changeVectorToLocalCoordFromDIS(inPlace);

        assertEquals(expected.getX(), inPlace.getX(), TOLERANCE_METERS, "mismatched in-place local x");
        assertEquals(expected.getY(), inPlace.getY(), TOLERANCE_METERS, "mismatched in-place local y");
        assertEquals(expected.getZ(), inPlace.getZ(), TOLERANCE_METERS, "mismatched in-place local z");
    }

    @Test
    public void testLocalOffsetProducesNonZeroDISDelta()
    {
        if (verbose)
            System.out.println("*** RangeCoordinatesTest testLocalOffsetProducesNonZeroDISDelta()");

        RangeCoordinates rc = new RangeCoordinates(0.0, 0.0, 0.0);

        Vector3Double origin = rc.DISCoordFromLocalFlat(0.0, 0.0, 0.0);
        Vector3Double offset = rc.DISCoordFromLocalFlat(1000.0, 0.0, 0.0);

        assertNotNull(origin, "origin DIS coordinate should not be null");
        assertNotNull(offset, "offset DIS coordinate should not be null");

        // A 1000m east offset should produce a different DIS coordinate
        double distance = Math.sqrt(
            Math.pow(offset.getX() - origin.getX(), 2) +
            Math.pow(offset.getY() - origin.getY(), 2) +
            Math.pow(offset.getZ() - origin.getZ(), 2));
        assertTrue(distance > 900.0, "1000m local offset should produce significant DIS coordinate change");
        assertTrue(distance < 1100.0, "1000m local offset should not exceed expected DIS coordinate change");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("RangeCoordinatesTest start");
        RangeCoordinatesTest test = new RangeCoordinatesTest();
        setUpClass();
        test.testConstructorPrimeMeridianEquator();
        test.testConstructorArbitraryLocation();
        test.testDISCoordFromLocalFlatAtOriginPrimeMeridian();
        test.testDISCoordFromLocalFlatAtEquator90East();
        test.testDISCoordFromLocalFlatAtNorthPole();
        test.testLocalCoordFromDisAtOriginPrimeMeridian();
        test.testRoundTripLocalToDISAndBack();
        test.testRoundTripDISToLocalAndBack();
        test.testChangeVectorToDisCoordFromLocalFlat();
        test.testChangeVectorToLocalCoordFromDIS();
        test.testLocalOffsetProducesNonZeroDISDelta();
        tearDownClass();
        System.out.println("RangeCoordinatesTest complete");
    }
}
