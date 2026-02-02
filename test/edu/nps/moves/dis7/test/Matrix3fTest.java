/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.legacy.math.Matrix3f;
import edu.nps.moves.legacy.math.Vec3f;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Matrix3f legacy math class.
 * Validates construction, identity, Euler angles, and vector transforms.
 */
@DisplayName("Matrix3fTest")
public class Matrix3fTest
{
    private static final float TOLERANCE = 1.0e-4f;
    private static boolean verbose = true;

    /** default constructor */
    public Matrix3fTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** Matrix3fTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** Matrix3fTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** Matrix3fTest testDefaultConstructor()");

        Matrix3f m = new Matrix3f();
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                assertEquals(0.0f, m.getMatValue(r, c), TOLERANCE, "mismatched null matrix [" + r + "][" + c + "]");
    }

    @Test
    public void testIdentity()
    {
        if (verbose)
            System.out.println("*** Matrix3fTest testIdentity()");

        Matrix3f m = new Matrix3f();
        m.makeIdent();
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
            {
                float expected = (r == c) ? 1.0f : 0.0f;
                assertEquals(expected, m.getMatValue(r, c), TOLERANCE, "mismatched identity [" + r + "][" + c + "]");
            }
    }

    @Test
    public void testCopyConstructor()
    {
        if (verbose)
            System.out.println("*** Matrix3fTest testCopyConstructor()");

        Matrix3f original = new Matrix3f();
        original.makeIdent();
        original.setMatValue(0, 1, 5.0f);
        Matrix3f copy = new Matrix3f(original);
        assertEquals(5.0f, copy.getMatValue(0, 1), TOLERANCE, "mismatched copy [0][1]");
        assertEquals(1.0f, copy.getMatValue(0, 0), TOLERANCE, "mismatched copy [0][0]");
    }

    @Test
    public void testIdentityXformVec3f()
    {
        if (verbose)
            System.out.println("*** Matrix3fTest testIdentityXformVec3f()");

        Matrix3f identity = new Matrix3f();
        identity.makeIdent();
        Vec3f v = new Vec3f(1.0f, 2.0f, 3.0f);
        identity.xform(v);
        assertEquals(1.0f, v.get(0), TOLERANCE, "identity xform should not change v[0]");
        assertEquals(2.0f, v.get(1), TOLERANCE, "identity xform should not change v[1]");
        assertEquals(3.0f, v.get(2), TOLERANCE, "identity xform should not change v[2]");
    }

    @Test
    public void testIdentityXformArray()
    {
        if (verbose)
            System.out.println("*** Matrix3fTest testIdentityXformArray()");

        Matrix3f identity = new Matrix3f();
        identity.makeIdent();
        float[] v = {1.0f, 2.0f, 3.0f};
        identity.xform(v);
        assertEquals(1.0f, v[0], TOLERANCE, "identity xform should not change v[0]");
        assertEquals(2.0f, v[1], TOLERANCE, "identity xform should not change v[1]");
        assertEquals(3.0f, v[2], TOLERANCE, "identity xform should not change v[2]");
    }

    @Test
    public void testSetGetEulersRoundTrip()
    {
        if (verbose)
            System.out.println("*** Matrix3fTest testSetGetEulersRoundTrip()");

        float heading = 0.5f; // radians
        float pitch = 0.3f;
        float roll = 0.1f;

        Matrix3f m = new Matrix3f(heading, pitch, roll);
        float[] hpr = new float[3];
        m.getEulers(hpr);

        assertEquals(heading, hpr[0], TOLERANCE, "mismatched heading after Euler round-trip");
        assertEquals(pitch, hpr[1], TOLERANCE, "mismatched pitch after Euler round-trip");
        assertEquals(roll, hpr[2], TOLERANCE, "mismatched roll after Euler round-trip");
    }

    @Test
    public void testSetEulersZero()
    {
        if (verbose)
            System.out.println("*** Matrix3fTest testSetEulersZero()");

        Matrix3f m = new Matrix3f(0.0f, 0.0f, 0.0f);
        // with zero Eulers, matrix should be identity
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
            {
                float expected = (r == c) ? 1.0f : 0.0f;
                assertEquals(expected, m.getMatValue(r, c), TOLERANCE, "zero Euler should give identity [" + r + "][" + c + "]");
            }
    }

    @Test
    public void testArrayConstructor()
    {
        if (verbose)
            System.out.println("*** Matrix3fTest testArrayConstructor()");

        float[][] mat = {
            {1.0f, 2.0f, 3.0f},
            {4.0f, 5.0f, 6.0f},
            {7.0f, 8.0f, 9.0f}
        };
        Matrix3f m = new Matrix3f(mat);
        assertEquals(1.0f, m.getMatValue(0, 0), TOLERANCE, "mismatched [0][0]");
        assertEquals(5.0f, m.getMatValue(1, 1), TOLERANCE, "mismatched [1][1]");
        assertEquals(9.0f, m.getMatValue(2, 2), TOLERANCE, "mismatched [2][2]");
        assertEquals(6.0f, m.getMatValue(1, 2), TOLERANCE, "mismatched [1][2]");
    }

    @Test
    public void testSetMatValue()
    {
        if (verbose)
            System.out.println("*** Matrix3fTest testSetMatValue()");

        Matrix3f m = new Matrix3f();
        m.setMatValue(1, 2, 42.0f);
        assertEquals(42.0f, m.getMatValue(1, 2), TOLERANCE, "mismatched setMatValue");
        assertEquals(0.0f, m.getMatValue(0, 0), TOLERANCE, "other values should remain zero");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("Matrix3fTest start");
        Matrix3fTest test = new Matrix3fTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testIdentity();
        test.testCopyConstructor();
        test.testIdentityXformVec3f();
        test.testIdentityXformArray();
        test.testSetGetEulersRoundTrip();
        test.testSetEulersZero();
        test.testArrayConstructor();
        test.testSetMatValue();
        tearDownClass();
        System.out.println("Matrix3fTest complete");
    }
}
