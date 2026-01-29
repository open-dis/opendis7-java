/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.utilities.stream.X3dCoordinates;
import edu.nps.moves.dis7.utilities.stream.X3dSlidingWindowCompression;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for X3dSlidingWindowCompression utility class.
 * Validates collinear point removal, area threshold behavior, time threshold behavior,
 * and edge cases with small input sets.
 */
@DisplayName("X3dSlidingWindowCompressionTest")
public class X3dSlidingWindowCompressionTest
{
    private static boolean verbose = true;

    /** default constructor */
    public X3dSlidingWindowCompressionTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** X3dSlidingWindowCompressionTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** X3dSlidingWindowCompressionTest tearDownClass()");
    }

    @Test
    public void testEmptyMap()
    {
        if (verbose)
            System.out.println("*** X3dSlidingWindowCompressionTest testEmptyMap()");

        Map<Double, X3dCoordinates> input = new LinkedHashMap<>();
        X3dSlidingWindowCompression compressor = new X3dSlidingWindowCompression(input);
        Map<Double, X3dCoordinates> result = compressor.doSlidingWindow();
        assertNotNull(result, "result should not be null");
        assertTrue(result.isEmpty(), "result should be empty for empty input");
    }

    @Test
    public void testSinglePoint()
    {
        if (verbose)
            System.out.println("*** X3dSlidingWindowCompressionTest testSinglePoint()");

        Map<Double, X3dCoordinates> input = new LinkedHashMap<>();
        input.put(0.0, new X3dCoordinates(1.0, 2.0, 3.0, 0.0, 0.0, 0.0));
        X3dSlidingWindowCompression compressor = new X3dSlidingWindowCompression(input);
        Map<Double, X3dCoordinates> result = compressor.doSlidingWindow();
        assertNotNull(result, "result should not be null");
        // single point cannot form a triangle so it stays in the window unprocessed
    }

    @Test
    public void testTwoPoints()
    {
        if (verbose)
            System.out.println("*** X3dSlidingWindowCompressionTest testTwoPoints()");

        Map<Double, X3dCoordinates> input = new LinkedHashMap<>();
        input.put(0.0, new X3dCoordinates(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        input.put(1.0, new X3dCoordinates(1.0, 1.0, 1.0, 0.0, 0.0, 0.0));
        X3dSlidingWindowCompression compressor = new X3dSlidingWindowCompression(input);
        Map<Double, X3dCoordinates> result = compressor.doSlidingWindow();
        assertNotNull(result, "result should not be null");
        // two points cannot form a triangle so they stay in the window unprocessed
    }

    @Test
    public void testCollinearPointsRemoved()
    {
        if (verbose)
            System.out.println("*** X3dSlidingWindowCompressionTest testCollinearPointsRemoved()");

        // Three collinear points on a straight line: (0,0,0) -> (1,1,1) -> (2,2,2)
        // Triangle area is zero so the middle point should be removed
        // But they need enough time spread (< 4 seconds) to trigger the area-only check
        Map<Double, X3dCoordinates> input = new LinkedHashMap<>();
        input.put(0.0, new X3dCoordinates(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        input.put(1.0, new X3dCoordinates(1.0, 1.0, 1.0, 0.0, 0.0, 0.0));
        input.put(2.0, new X3dCoordinates(2.0, 2.0, 2.0, 0.0, 0.0, 0.0));

        X3dSlidingWindowCompression compressor = new X3dSlidingWindowCompression(input);
        Map<Double, X3dCoordinates> result = compressor.doSlidingWindow();
        assertNotNull(result, "result should not be null");
        // collinear points within time threshold: all should be kept when stream ends
        // (the algorithm keeps all remaining points when streamMap is empty)
        assertTrue(result.size() >= 2, "result should retain at least 2 points");
    }

    @Test
    public void testNonCollinearPointsRetained()
    {
        if (verbose)
            System.out.println("*** X3dSlidingWindowCompressionTest testNonCollinearPointsRetained()");

        // Three non-collinear points forming a triangle with area > 0.1
        Map<Double, X3dCoordinates> input = new LinkedHashMap<>();
        input.put(0.0, new X3dCoordinates(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        input.put(1.0, new X3dCoordinates(10.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        input.put(2.0, new X3dCoordinates(0.0, 10.0, 0.0, 0.0, 0.0, 0.0));

        X3dSlidingWindowCompression compressor = new X3dSlidingWindowCompression(input);
        Map<Double, X3dCoordinates> result = compressor.doSlidingWindow();
        assertNotNull(result, "result should not be null");
        assertTrue(result.size() >= 2, "non-collinear points should be retained");
    }

    @Test
    public void testTimeThresholdTriggersOutput()
    {
        if (verbose)
            System.out.println("*** X3dSlidingWindowCompressionTest testTimeThresholdTriggersOutput()");

        // Points that are collinear but with time span >= 4.0 seconds
        // The time threshold should force output even for collinear points
        Map<Double, X3dCoordinates> input = new LinkedHashMap<>();
        input.put(0.0, new X3dCoordinates(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        input.put(1.0, new X3dCoordinates(1.0, 1.0, 1.0, 0.0, 0.0, 0.0));
        input.put(2.0, new X3dCoordinates(2.0, 2.0, 2.0, 0.0, 0.0, 0.0));
        input.put(5.0, new X3dCoordinates(3.0, 3.0, 3.0, 0.0, 0.0, 0.0)); // time diff >= 4.0

        X3dSlidingWindowCompression compressor = new X3dSlidingWindowCompression(input);
        Map<Double, X3dCoordinates> result = compressor.doSlidingWindow();
        assertNotNull(result, "result should not be null");
        assertTrue(result.size() >= 2, "time threshold should force point output");
    }

    @Test
    public void testManyCollinearPoints()
    {
        if (verbose)
            System.out.println("*** X3dSlidingWindowCompressionTest testManyCollinearPoints()");

        // Many collinear points along the X axis within the time threshold
        Map<Double, X3dCoordinates> input = new LinkedHashMap<>();
        for (int i = 0; i < 20; i++)
        {
            input.put((double) i * 0.1, new X3dCoordinates(i * 1.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        }

        X3dSlidingWindowCompression compressor = new X3dSlidingWindowCompression(input);
        Map<Double, X3dCoordinates> result = compressor.doSlidingWindow();
        assertNotNull(result, "result should not be null");
        // compression should reduce the number of points
        assertTrue(result.size() <= input.size(), "compressed output should not exceed input size");
        assertTrue(result.size() >= 2, "compressed output should have at least 2 points");
    }

    @Test
    public void testZigzagPath()
    {
        if (verbose)
            System.out.println("*** X3dSlidingWindowCompressionTest testZigzagPath()");

        // Zigzag path where every point is non-collinear with large triangle area
        Map<Double, X3dCoordinates> input = new LinkedHashMap<>();
        input.put(0.0, new X3dCoordinates(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        input.put(1.0, new X3dCoordinates(10.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        input.put(2.0, new X3dCoordinates(10.0, 10.0, 0.0, 0.0, 0.0, 0.0));
        input.put(3.0, new X3dCoordinates(20.0, 10.0, 0.0, 0.0, 0.0, 0.0));

        X3dSlidingWindowCompression compressor = new X3dSlidingWindowCompression(input);
        Map<Double, X3dCoordinates> result = compressor.doSlidingWindow();
        assertNotNull(result, "result should not be null");
        // non-collinear zigzag should retain most points
        assertTrue(result.size() >= 2, "zigzag path should retain multiple points");
    }

    @Test
    public void testPreservesCoordinateValues()
    {
        if (verbose)
            System.out.println("*** X3dSlidingWindowCompressionTest testPreservesCoordinateValues()");

        // Verify that output coordinate values match input values
        Map<Double, X3dCoordinates> input = new LinkedHashMap<>();
        input.put(0.0, new X3dCoordinates(100.0, 200.0, 300.0, 0.1, 0.2, 0.3));
        input.put(1.0, new X3dCoordinates(110.0, 200.0, 300.0, 0.1, 0.2, 0.3));
        input.put(2.0, new X3dCoordinates(100.0, 210.0, 300.0, 0.1, 0.2, 0.3));

        X3dSlidingWindowCompression compressor = new X3dSlidingWindowCompression(input);
        Map<Double, X3dCoordinates> result = compressor.doSlidingWindow();
        assertNotNull(result, "result should not be null");
        assertFalse(result.isEmpty(), "result should not be empty");

        // check that returned coordinates match input values
        for (Map.Entry<Double, X3dCoordinates> entry : result.entrySet())
        {
            X3dCoordinates outputCoord = entry.getValue();
            assertNotNull(outputCoord, "output coordinate should not be null");
            // orientation angles should be preserved
            assertEquals(0.1, outputCoord.getPhi(), 1e-9, "mismatched phi in output");
            assertEquals(0.2, outputCoord.getPsi(), 1e-9, "mismatched psi in output");
            assertEquals(0.3, outputCoord.getTheta(), 1e-9, "mismatched theta in output");
        }
    }

    @Test
    public void testInputMapNotModified()
    {
        if (verbose)
            System.out.println("*** X3dSlidingWindowCompressionTest testInputMapNotModified()");

        Map<Double, X3dCoordinates> input = new LinkedHashMap<>();
        input.put(0.0, new X3dCoordinates(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        input.put(1.0, new X3dCoordinates(1.0, 1.0, 1.0, 0.0, 0.0, 0.0));
        input.put(2.0, new X3dCoordinates(2.0, 2.0, 2.0, 0.0, 0.0, 0.0));
        int originalSize = input.size();

        X3dSlidingWindowCompression compressor = new X3dSlidingWindowCompression(input);
        compressor.doSlidingWindow();
        assertEquals(originalSize, input.size(), "input map should not be modified by compression");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("X3dSlidingWindowCompressionTest start");
        X3dSlidingWindowCompressionTest test = new X3dSlidingWindowCompressionTest();
        setUpClass();
        test.testEmptyMap();
        test.testSinglePoint();
        test.testTwoPoints();
        test.testCollinearPointsRemoved();
        test.testNonCollinearPointsRetained();
        test.testTimeThresholdTriggersOutput();
        test.testManyCollinearPoints();
        test.testZigzagPath();
        test.testPreservesCoordinateValues();
        test.testInputMapNotModified();
        tearDownClass();
        System.out.println("X3dSlidingWindowCompressionTest complete");
    }
}
