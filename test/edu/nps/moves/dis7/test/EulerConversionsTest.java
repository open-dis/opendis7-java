/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.utilities.CoordinateConversions;
import edu.nps.moves.dis7.utilities.EulerConversions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for EulerConversions utility class.
 * Validates conversions between Tait-Bryan angles (heading/pitch/roll in degrees)
 * and DIS Euler angles (psi/theta/phi in radians) given a geodetic position.
 */
@DisplayName("EulerConversionsTest")
public class EulerConversionsTest
{
    /** tolerance for angle round-trip in degrees */
    private static final double ANGLE_TOLERANCE_DEG = 0.001;

    /** tolerance for angle round-trip in radians */
    private static final double ANGLE_TOLERANCE_RAD = 0.00002;

    /** verbose output flag */
    private static boolean verbose = true;

    /** NPS Monterey latitude in radians */
    private static final double NPS_LAT_RAD = 36.5967 * CoordinateConversions.DEGREES_TO_RADIANS;

    /** NPS Monterey longitude in radians */
    private static final double NPS_LON_RAD = -121.8770 * CoordinateConversions.DEGREES_TO_RADIANS;

    /** default constructor */
    public EulerConversionsTest()
    {
    }

    /** preparation */
    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** EulerConversionsTest setUpClass()");
    }

    /** cleanup */
    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** EulerConversionsTest tearDownClass()");
    }

    /**
     * Test round-trip: heading/pitch/roll -> psi/theta/phi -> heading/pitch/roll
     * Entity heading north, level flight at NPS Monterey
     */
    @Test
    public void testRoundTripNorthLevel()
    {
        if (verbose)
            System.out.println("*** EulerConversionsTest testRoundTripNorthLevel()");

        double yaw = 0.0;   // north
        double pitch = 0.0; // level
        double roll = 0.0;  // wings level

        double psi   = EulerConversions.getPsiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double theta = EulerConversions.getThetaFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double phi   = EulerConversions.getPhiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch, roll);

        double headingBack = EulerConversions.getOrientationFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double pitchBack   = EulerConversions.getPitchFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double rollBack    = EulerConversions.getRollFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta, phi);

        assertEquals(yaw,   headingBack, ANGLE_TOLERANCE_DEG, "mismatched heading after round-trip (north, level)");
        assertEquals(pitch, pitchBack,   ANGLE_TOLERANCE_DEG, "mismatched pitch after round-trip (north, level)");
        assertEquals(roll,  rollBack,    ANGLE_TOLERANCE_DEG, "mismatched roll after round-trip (north, level)");
    }

    /**
     * Test round-trip: heading east (90 degrees)
     */
    @Test
    public void testRoundTripEastHeading()
    {
        if (verbose)
            System.out.println("*** EulerConversionsTest testRoundTripEastHeading()");

        double yaw = 90.0;  // east
        double pitch = 0.0;
        double roll = 0.0;

        double psi   = EulerConversions.getPsiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double theta = EulerConversions.getThetaFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double phi   = EulerConversions.getPhiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch, roll);

        double headingBack = EulerConversions.getOrientationFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double pitchBack   = EulerConversions.getPitchFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double rollBack    = EulerConversions.getRollFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta, phi);

        assertEquals(yaw,   headingBack, ANGLE_TOLERANCE_DEG, "mismatched heading after round-trip (east)");
        assertEquals(pitch, pitchBack,   ANGLE_TOLERANCE_DEG, "mismatched pitch after round-trip (east)");
        assertEquals(roll,  rollBack,    ANGLE_TOLERANCE_DEG, "mismatched roll after round-trip (east)");
    }

    /**
     * Test round-trip: heading south (180 degrees)
     */
    @Test
    public void testRoundTripSouthHeading()
    {
        if (verbose)
            System.out.println("*** EulerConversionsTest testRoundTripSouthHeading()");

        double yaw = 180.0;
        double pitch = 0.0;
        double roll = 0.0;

        double psi   = EulerConversions.getPsiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double theta = EulerConversions.getThetaFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double phi   = EulerConversions.getPhiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch, roll);

        double headingBack = EulerConversions.getOrientationFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double pitchBack   = EulerConversions.getPitchFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double rollBack    = EulerConversions.getRollFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta, phi);

        assertEquals(yaw,   headingBack, ANGLE_TOLERANCE_DEG, "mismatched heading after round-trip (south)");
        assertEquals(pitch, pitchBack,   ANGLE_TOLERANCE_DEG, "mismatched pitch after round-trip (south)");
        assertEquals(roll,  rollBack,    ANGLE_TOLERANCE_DEG, "mismatched roll after round-trip (south)");
    }

    /**
     * Test round-trip: heading west (-90 degrees)
     */
    @Test
    public void testRoundTripWestHeading()
    {
        if (verbose)
            System.out.println("*** EulerConversionsTest testRoundTripWestHeading()");

        double yaw = -90.0;
        double pitch = 0.0;
        double roll = 0.0;

        double psi   = EulerConversions.getPsiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double theta = EulerConversions.getThetaFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double phi   = EulerConversions.getPhiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch, roll);

        double headingBack = EulerConversions.getOrientationFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double pitchBack   = EulerConversions.getPitchFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double rollBack    = EulerConversions.getRollFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta, phi);

        assertEquals(yaw,   headingBack, ANGLE_TOLERANCE_DEG, "mismatched heading after round-trip (west)");
        assertEquals(pitch, pitchBack,   ANGLE_TOLERANCE_DEG, "mismatched pitch after round-trip (west)");
        assertEquals(roll,  rollBack,    ANGLE_TOLERANCE_DEG, "mismatched roll after round-trip (west)");
    }

    /**
     * Test round-trip: pitch up (30 degrees nose up), heading north
     */
    @Test
    public void testRoundTripPitchUp()
    {
        if (verbose)
            System.out.println("*** EulerConversionsTest testRoundTripPitchUp()");

        double yaw = 0.0;
        double pitch = 30.0; // nose up
        double roll = 0.0;

        double psi   = EulerConversions.getPsiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double theta = EulerConversions.getThetaFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double phi   = EulerConversions.getPhiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch, roll);

        double headingBack = EulerConversions.getOrientationFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double pitchBack   = EulerConversions.getPitchFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double rollBack    = EulerConversions.getRollFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta, phi);

        assertEquals(yaw,   headingBack, ANGLE_TOLERANCE_DEG, "mismatched heading after round-trip (pitch up)");
        assertEquals(pitch, pitchBack,   ANGLE_TOLERANCE_DEG, "mismatched pitch after round-trip (pitch up)");
        assertEquals(roll,  rollBack,    ANGLE_TOLERANCE_DEG, "mismatched roll after round-trip (pitch up)");
    }

    /**
     * Test round-trip: pitch down (-15 degrees nose down), heading east
     */
    @Test
    public void testRoundTripPitchDown()
    {
        if (verbose)
            System.out.println("*** EulerConversionsTest testRoundTripPitchDown()");

        double yaw = 90.0;
        double pitch = -15.0; // nose down
        double roll = 0.0;

        double psi   = EulerConversions.getPsiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double theta = EulerConversions.getThetaFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double phi   = EulerConversions.getPhiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch, roll);

        double headingBack = EulerConversions.getOrientationFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double pitchBack   = EulerConversions.getPitchFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double rollBack    = EulerConversions.getRollFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta, phi);

        assertEquals(yaw,   headingBack, ANGLE_TOLERANCE_DEG, "mismatched heading after round-trip (pitch down)");
        assertEquals(pitch, pitchBack,   ANGLE_TOLERANCE_DEG, "mismatched pitch after round-trip (pitch down)");
        assertEquals(roll,  rollBack,    ANGLE_TOLERANCE_DEG, "mismatched roll after round-trip (pitch down)");
    }

    /**
     * Test round-trip: banked turn (heading 45, roll 30)
     */
    @Test
    public void testRoundTripBankedTurn()
    {
        if (verbose)
            System.out.println("*** EulerConversionsTest testRoundTripBankedTurn()");

        double yaw = 45.0;
        double pitch = 0.0;
        double roll = 30.0; // banked right

        double psi   = EulerConversions.getPsiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double theta = EulerConversions.getThetaFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double phi   = EulerConversions.getPhiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch, roll);

        double headingBack = EulerConversions.getOrientationFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double pitchBack   = EulerConversions.getPitchFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double rollBack    = EulerConversions.getRollFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta, phi);

        assertEquals(yaw,   headingBack, ANGLE_TOLERANCE_DEG, "mismatched heading after round-trip (banked turn)");
        assertEquals(pitch, pitchBack,   ANGLE_TOLERANCE_DEG, "mismatched pitch after round-trip (banked turn)");
        assertEquals(roll,  rollBack,    ANGLE_TOLERANCE_DEG, "mismatched roll after round-trip (banked turn)");
    }

    /**
     * Test round-trip: combined heading, pitch, and roll
     * Heading 225 (southwest), pitch 10 up, roll -20 (left bank)
     */
    @Test
    public void testRoundTripCombinedAngles()
    {
        if (verbose)
            System.out.println("*** EulerConversionsTest testRoundTripCombinedAngles()");

        double yaw = -135.0; // southwest (equivalent to 225 from north, but atan2 returns -135)
        double pitch = 10.0;
        double roll = -20.0;

        double psi   = EulerConversions.getPsiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double theta = EulerConversions.getThetaFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch);
        double phi   = EulerConversions.getPhiFromTaitBryanAngles(NPS_LAT_RAD, NPS_LON_RAD, yaw, pitch, roll);

        double headingBack = EulerConversions.getOrientationFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double pitchBack   = EulerConversions.getPitchFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta);
        double rollBack    = EulerConversions.getRollFromEuler(NPS_LAT_RAD, NPS_LON_RAD, psi, theta, phi);

        assertEquals(yaw,   headingBack, ANGLE_TOLERANCE_DEG, "mismatched heading after round-trip (combined)");
        assertEquals(pitch, pitchBack,   ANGLE_TOLERANCE_DEG, "mismatched pitch after round-trip (combined)");
        assertEquals(roll,  rollBack,    ANGLE_TOLERANCE_DEG, "mismatched roll after round-trip (combined)");
    }

    /**
     * Test at equator/prime meridian (lat=0, lon=0) to verify different position
     */
    @Test
    public void testRoundTripEquator()
    {
        if (verbose)
            System.out.println("*** EulerConversionsTest testRoundTripEquator()");

        double lat = 0.0;
        double lon = 0.0;
        double yaw = 45.0;
        double pitch = 10.0;
        double roll = 5.0;

        double psi   = EulerConversions.getPsiFromTaitBryanAngles(lat, lon, yaw, pitch);
        double theta = EulerConversions.getThetaFromTaitBryanAngles(lat, lon, yaw, pitch);
        double phi   = EulerConversions.getPhiFromTaitBryanAngles(lat, lon, yaw, pitch, roll);

        double headingBack = EulerConversions.getOrientationFromEuler(lat, lon, psi, theta);
        double pitchBack   = EulerConversions.getPitchFromEuler(lat, lon, psi, theta);
        double rollBack    = EulerConversions.getRollFromEuler(lat, lon, psi, theta, phi);

        assertEquals(yaw,   headingBack, ANGLE_TOLERANCE_DEG, "mismatched heading at equator");
        assertEquals(pitch, pitchBack,   ANGLE_TOLERANCE_DEG, "mismatched pitch at equator");
        assertEquals(roll,  rollBack,    ANGLE_TOLERANCE_DEG, "mismatched roll at equator");
    }

    /**
     * Test at southern hemisphere position: Cape Town (-33.9, 18.4)
     */
    @Test
    public void testRoundTripSouthernHemisphere()
    {
        if (verbose)
            System.out.println("*** EulerConversionsTest testRoundTripSouthernHemisphere()");

        double lat = -33.9 * CoordinateConversions.DEGREES_TO_RADIANS;
        double lon = 18.4 * CoordinateConversions.DEGREES_TO_RADIANS;
        double yaw = 60.0;
        double pitch = 5.0;
        double roll = -10.0;

        double psi   = EulerConversions.getPsiFromTaitBryanAngles(lat, lon, yaw, pitch);
        double theta = EulerConversions.getThetaFromTaitBryanAngles(lat, lon, yaw, pitch);
        double phi   = EulerConversions.getPhiFromTaitBryanAngles(lat, lon, yaw, pitch, roll);

        double headingBack = EulerConversions.getOrientationFromEuler(lat, lon, psi, theta);
        double pitchBack   = EulerConversions.getPitchFromEuler(lat, lon, psi, theta);
        double rollBack    = EulerConversions.getRollFromEuler(lat, lon, psi, theta, phi);

        assertEquals(yaw,   headingBack, ANGLE_TOLERANCE_DEG, "mismatched heading at southern hemisphere");
        assertEquals(pitch, pitchBack,   ANGLE_TOLERANCE_DEG, "mismatched pitch at southern hemisphere");
        assertEquals(roll,  rollBack,    ANGLE_TOLERANCE_DEG, "mismatched roll at southern hemisphere");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("EulerConversionsTest start");
        EulerConversionsTest test = new EulerConversionsTest();

        setUpClass();
        test.testRoundTripNorthLevel();
        test.testRoundTripEastHeading();
        test.testRoundTripSouthHeading();
        test.testRoundTripWestHeading();
        test.testRoundTripPitchUp();
        test.testRoundTripPitchDown();
        test.testRoundTripBankedTurn();
        test.testRoundTripCombinedAngles();
        test.testRoundTripEquator();
        test.testRoundTripSouthernHemisphere();
        tearDownClass();

        System.out.println("EulerConversionsTest complete");
    }
}
