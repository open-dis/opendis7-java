/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.utilities.CoordinateConversions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CoordinateConversions utility class.
 * Validates WGS84 ECEF (xyz) to geodetic (lat/lon/alt) conversions and vice versa.
 * Reference values computed from known geodetic coordinates.
 */
@DisplayName("CoordinateConversionsTest")
public class CoordinateConversionsTest
{
    /** tolerance for lat/lon round-trip in radians (sub-millimeter surface accuracy) */
    private static final double LAT_LON_TOLERANCE_RAD = 1.0e-10;

    /** tolerance for altitude round-trip in meters */
    private static final double ALT_TOLERANCE_M = 0.01;

    /** tolerance for xyz round-trip in meters */
    private static final double XYZ_TOLERANCE_M = 0.01;

    /** verbose output flag */
    private static boolean verbose = true;

    /** default constructor */
    public CoordinateConversionsTest()
    {
    }

    /** preparation */
    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** CoordinateConversionsTest setUpClass()");
    }

    /** cleanup */
    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** CoordinateConversionsTest tearDownClass()");
    }

    /**
     * Test conversion constants are correct
     */
    @Test
    public void testConversionConstants()
    {
        if (verbose)
            System.out.println("*** CoordinateConversionsTest testConversionConstants()");

        assertEquals(180.0 / Math.PI, CoordinateConversions.RADIANS_TO_DEGREES, 1.0e-12, "mismatched RADIANS_TO_DEGREES");
        assertEquals(Math.PI / 180.0, CoordinateConversions.DEGREES_TO_RADIANS, 1.0e-12, "mismatched DEGREES_TO_RADIANS");
        assertEquals(1.0, CoordinateConversions.RADIANS_TO_DEGREES * CoordinateConversions.DEGREES_TO_RADIANS, 1.0e-12, "conversion constants should be inverses");
    }

    /**
     * Test round-trip: lat/lon/alt (radians) -> xyz -> lat/lon/alt (radians)
     * Using NPS Monterey, CA as reference point (36.5967N, 121.8770W, 0m)
     */
    @Test
    public void testRoundTripMonterey()
    {
        if (verbose)
            System.out.println("*** CoordinateConversionsTest testRoundTripMonterey()");

        double latRad = 36.5967 * CoordinateConversions.DEGREES_TO_RADIANS;
        double lonRad = -121.8770 * CoordinateConversions.DEGREES_TO_RADIANS;
        double altM = 0.0;

        double[] xyz = CoordinateConversions.getXYZfromLatLonRadians(latRad, lonRad, altM);
        assertNotNull(xyz, "xyz result should not be null");
        assertEquals(3, xyz.length, "xyz should have 3 elements");

        double[] latLonAlt = CoordinateConversions.xyzToLatLonRadians(xyz);
        assertNotNull(latLonAlt, "latLonAlt result should not be null");
        assertEquals(3, latLonAlt.length, "latLonAlt should have 3 elements");

        assertEquals(latRad, latLonAlt[0], LAT_LON_TOLERANCE_RAD, "mismatched latitude after round-trip");
        assertEquals(lonRad, latLonAlt[1], LAT_LON_TOLERANCE_RAD, "mismatched longitude after round-trip");
        assertEquals(altM, latLonAlt[2], ALT_TOLERANCE_M, "mismatched altitude after round-trip");
    }

    /**
     * Test round-trip with altitude: lat/lon/alt (radians) -> xyz -> lat/lon/alt (radians)
     * Using NPS Monterey at 100m elevation
     */
    @Test
    public void testRoundTripWithAltitude()
    {
        if (verbose)
            System.out.println("*** CoordinateConversionsTest testRoundTripWithAltitude()");

        double latRad = 36.5967 * CoordinateConversions.DEGREES_TO_RADIANS;
        double lonRad = -121.8770 * CoordinateConversions.DEGREES_TO_RADIANS;
        double altM = 100.0;

        double[] xyz = CoordinateConversions.getXYZfromLatLonRadians(latRad, lonRad, altM);
        double[] latLonAlt = CoordinateConversions.xyzToLatLonRadians(xyz);

        assertEquals(latRad, latLonAlt[0], LAT_LON_TOLERANCE_RAD, "mismatched latitude after round-trip with altitude");
        assertEquals(lonRad, latLonAlt[1], LAT_LON_TOLERANCE_RAD, "mismatched longitude after round-trip with altitude");
        assertEquals(altM, latLonAlt[2], ALT_TOLERANCE_M, "mismatched altitude after round-trip with altitude");
    }

    /**
     * Test round-trip using degree convenience methods
     * Using Washington DC (38.8977N, 77.0365W, 0m)
     */
    @Test
    public void testRoundTripDegrees()
    {
        if (verbose)
            System.out.println("*** CoordinateConversionsTest testRoundTripDegrees()");

        double latDeg = 38.8977;
        double lonDeg = -77.0365;
        double altM = 0.0;

        double[] xyz = CoordinateConversions.getXYZfromLatLonDegrees(latDeg, lonDeg, altM);
        double[] latLonAltDeg = CoordinateConversions.xyzToLatLonDegrees(xyz);

        double tolerance = LAT_LON_TOLERANCE_RAD * CoordinateConversions.RADIANS_TO_DEGREES;
        assertEquals(latDeg, latLonAltDeg[0], tolerance, "mismatched latitude (degrees) after round-trip");
        assertEquals(lonDeg, latLonAltDeg[1], tolerance, "mismatched longitude (degrees) after round-trip");
        assertEquals(altM, latLonAltDeg[2], ALT_TOLERANCE_M, "mismatched altitude after round-trip");
    }

    /**
     * Test equator/prime meridian intersection (0, 0, 0)
     */
    @Test
    public void testEquatorPrimeMeridian()
    {
        if (verbose)
            System.out.println("*** CoordinateConversionsTest testEquatorPrimeMeridian()");

        double latRad = 0.0;
        double lonRad = 0.0;
        double altM = 0.0;

        double[] xyz = CoordinateConversions.getXYZfromLatLonRadians(latRad, lonRad, altM);

        // at equator/prime meridian, x should be the semi-major axis, y and z should be 0
        double semiMajorAxis = 6378137.0;
        assertEquals(semiMajorAxis, xyz[0], XYZ_TOLERANCE_M, "mismatched X at equator/prime meridian");
        assertEquals(0.0, xyz[1], XYZ_TOLERANCE_M, "mismatched Y at equator/prime meridian");
        assertEquals(0.0, xyz[2], XYZ_TOLERANCE_M, "mismatched Z at equator/prime meridian");

        // round-trip
        double[] latLonAlt = CoordinateConversions.xyzToLatLonRadians(xyz);
        assertEquals(latRad, latLonAlt[0], LAT_LON_TOLERANCE_RAD, "mismatched latitude at equator/prime meridian");
        assertEquals(lonRad, latLonAlt[1], LAT_LON_TOLERANCE_RAD, "mismatched longitude at equator/prime meridian");
        assertEquals(altM, latLonAlt[2], ALT_TOLERANCE_M, "mismatched altitude at equator/prime meridian");
    }

    /**
     * Test equator at 90 degrees east (0, 90E, 0)
     */
    @Test
    public void testEquator90East()
    {
        if (verbose)
            System.out.println("*** CoordinateConversionsTest testEquator90East()");

        double latRad = 0.0;
        double lonRad = 90.0 * CoordinateConversions.DEGREES_TO_RADIANS;
        double altM = 0.0;

        double[] xyz = CoordinateConversions.getXYZfromLatLonRadians(latRad, lonRad, altM);

        // at equator/90E, y should be the semi-major axis, x and z should be 0
        double semiMajorAxis = 6378137.0;
        assertEquals(0.0, xyz[0], XYZ_TOLERANCE_M, "mismatched X at equator/90E");
        assertEquals(semiMajorAxis, xyz[1], XYZ_TOLERANCE_M, "mismatched Y at equator/90E");
        assertEquals(0.0, xyz[2], XYZ_TOLERANCE_M, "mismatched Z at equator/90E");
    }

    /**
     * Test north pole (90N, 0, 0)
     * Note: the algorithm comments state it may not be 100% accurate near poles
     */
    @Test
    public void testNorthPole()
    {
        if (verbose)
            System.out.println("*** CoordinateConversionsTest testNorthPole()");

        double latRad = 90.0 * CoordinateConversions.DEGREES_TO_RADIANS;
        double lonRad = 0.0;
        double altM = 0.0;

        double[] xyz = CoordinateConversions.getXYZfromLatLonRadians(latRad, lonRad, altM);

        // at north pole, x and y should be ~0, z should be the semi-minor axis
        double semiMinorAxis = 6356752.3142;
        assertEquals(0.0, xyz[0], XYZ_TOLERANCE_M, "mismatched X at north pole");
        assertEquals(0.0, xyz[1], XYZ_TOLERANCE_M, "mismatched Y at north pole");
        assertEquals(semiMinorAxis, xyz[2], XYZ_TOLERANCE_M, "mismatched Z at north pole");
    }

    /**
     * Test southern hemisphere: Sydney, Australia (33.8688S, 151.2093E, 0m)
     */
    @Test
    public void testSouthernHemisphere()
    {
        if (verbose)
            System.out.println("*** CoordinateConversionsTest testSouthernHemisphere()");

        double latRad = -33.8688 * CoordinateConversions.DEGREES_TO_RADIANS;
        double lonRad = 151.2093 * CoordinateConversions.DEGREES_TO_RADIANS;
        double altM = 0.0;

        double[] xyz = CoordinateConversions.getXYZfromLatLonRadians(latRad, lonRad, altM);
        double[] latLonAlt = CoordinateConversions.xyzToLatLonRadians(xyz);

        assertEquals(latRad, latLonAlt[0], LAT_LON_TOLERANCE_RAD, "mismatched latitude for southern hemisphere");
        assertEquals(lonRad, latLonAlt[1], LAT_LON_TOLERANCE_RAD, "mismatched longitude for southern hemisphere");
        assertEquals(altM, latLonAlt[2], ALT_TOLERANCE_M, "mismatched altitude for southern hemisphere");
    }

    /**
     * Test high altitude: geostationary orbit (~35786 km)
     */
    @Test
    public void testHighAltitude()
    {
        if (verbose)
            System.out.println("*** CoordinateConversionsTest testHighAltitude()");

        double latRad = 0.0;
        double lonRad = 0.0;
        double altM = 35786000.0; // geostationary orbit

        double[] xyz = CoordinateConversions.getXYZfromLatLonRadians(latRad, lonRad, altM);
        double[] latLonAlt = CoordinateConversions.xyzToLatLonRadians(xyz);

        assertEquals(latRad, latLonAlt[0], LAT_LON_TOLERANCE_RAD, "mismatched latitude at high altitude");
        assertEquals(lonRad, latLonAlt[1], LAT_LON_TOLERANCE_RAD, "mismatched longitude at high altitude");
        assertEquals(altM, latLonAlt[2], 1.0, "mismatched altitude at high altitude (relaxed tolerance)");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("CoordinateConversionsTest start");
        CoordinateConversionsTest test = new CoordinateConversionsTest();

        setUpClass();
        test.testConversionConstants();
        test.testRoundTripMonterey();
        test.testRoundTripWithAltitude();
        test.testRoundTripDegrees();
        test.testEquatorPrimeMeridian();
        test.testEquator90East();
        test.testNorthPole();
        test.testSouthernHemisphere();
        test.testHighAltitude();
        tearDownClass();

        System.out.println("CoordinateConversionsTest complete");
    }
}
