/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.legacy.math.Matrix4f;
import edu.nps.moves.legacy.math.Vec4f;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Matrix4f legacy math class.
 * Validates construction, identity, Euler angles, and vector transforms.
 */
@DisplayName("Matrix4fTest")
public class Matrix4fTest
{
    private static final float TOLERANCE = 1.0e-4f;
    private static boolean verbose = true;

    /** default constructor */
    public Matrix4fTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** Matrix4fTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** Matrix4fTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** Matrix4fTest testDefaultConstructor()");

        Matrix4f m = new Matrix4f();
        for (int r = 0; r < 4; r++)
            for (int c = 0; c < 4; c++)
                assertEquals(0.0f, m.getMatValue(r, c), TOLERANCE, "mismatched null matrix [" + r + "][" + c + "]");
    }

    @Test
    public void testIdentity()
    {
        if (verbose)
            System.out.println("*** Matrix4fTest testIdentity()");

        Matrix4f m = new Matrix4f();
        m.makeIdent();
        for (int r = 0; r < 4; r++)
            for (int c = 0; c < 4; c++)
            {
                float expected = (r == c) ? 1.0f : 0.0f;
                assertEquals(expected, m.getMatValue(r, c), TOLERANCE, "mismatched identity [" + r + "][" + c + "]");
            }
    }

    @Test
    public void testCopyConstructor()
    {
        if (verbose)
            System.out.println("*** Matrix4fTest testCopyConstructor()");

        Matrix4f original = new Matrix4f();
        original.makeIdent();
        original.setMatValue(0, 3, 7.0f);
        Matrix4f copy = new Matrix4f(original);
        assertEquals(7.0f, copy.getMatValue(0, 3), TOLERANCE, "mismatched copy [0][3]");
        assertEquals(1.0f, copy.getMatValue(0, 0), TOLERANCE, "mismatched copy [0][0]");
    }

    @Test
    public void testIdentityXformVec4f()
    {
        if (verbose)
            System.out.println("*** Matrix4fTest testIdentityXformVec4f()");

        Matrix4f identity = new Matrix4f();
        identity.makeIdent();
        Vec4f v = new Vec4f(1.0f, 2.0f, 3.0f, 4.0f);
        identity.xform(v);
        assertEquals(1.0f, v.get(0), TOLERANCE, "identity xform should not change v[0]");
        assertEquals(2.0f, v.get(1), TOLERANCE, "identity xform should not change v[1]");
        assertEquals(3.0f, v.get(2), TOLERANCE, "identity xform should not change v[2]");
        assertEquals(4.0f, v.get(3), TOLERANCE, "identity xform should not change v[3]");
    }

    @Test
    public void testSetEulersZero()
    {
        if (verbose)
            System.out.println("*** Matrix4fTest testSetEulersZero()");

        Matrix4f m = new Matrix4f(0.0f, 0.0f, 0.0f);
        // zero Eulers should give identity
        for (int r = 0; r < 4; r++)
            for (int c = 0; c < 4; c++)
            {
                float expected = (r == c) ? 1.0f : 0.0f;
                assertEquals(expected, m.getMatValue(r, c), TOLERANCE, "zero Euler should give identity [" + r + "][" + c + "]");
            }
    }

    @Test
    public void testSetEulersBottomRow()
    {
        if (verbose)
            System.out.println("*** Matrix4fTest testSetEulersBottomRow()");

        Matrix4f m = new Matrix4f(0.5f, 0.3f, 0.1f);
        // bottom row and right column should be [0,0,0,1] pattern for rotation matrix
        assertEquals(0.0f, m.getMatValue(3, 0), TOLERANCE, "mismatched [3][0]");
        assertEquals(0.0f, m.getMatValue(3, 1), TOLERANCE, "mismatched [3][1]");
        assertEquals(0.0f, m.getMatValue(3, 2), TOLERANCE, "mismatched [3][2]");
        assertEquals(1.0f, m.getMatValue(3, 3), TOLERANCE, "mismatched [3][3]");
        assertEquals(0.0f, m.getMatValue(0, 3), TOLERANCE, "mismatched [0][3]");
        assertEquals(0.0f, m.getMatValue(1, 3), TOLERANCE, "mismatched [1][3]");
        assertEquals(0.0f, m.getMatValue(2, 3), TOLERANCE, "mismatched [2][3]");
    }

    @Test
    public void testArrayConstructor()
    {
        if (verbose)
            System.out.println("*** Matrix4fTest testArrayConstructor()");

        float[][] mat = {
            {1.0f, 2.0f, 3.0f, 4.0f},
            {5.0f, 6.0f, 7.0f, 8.0f},
            {9.0f, 10.0f, 11.0f, 12.0f},
            {13.0f, 14.0f, 15.0f, 16.0f}
        };
        Matrix4f m = new Matrix4f(mat);
        assertEquals(1.0f, m.getMatValue(0, 0), TOLERANCE, "mismatched [0][0]");
        assertEquals(6.0f, m.getMatValue(1, 1), TOLERANCE, "mismatched [1][1]");
        assertEquals(11.0f, m.getMatValue(2, 2), TOLERANCE, "mismatched [2][2]");
        assertEquals(16.0f, m.getMatValue(3, 3), TOLERANCE, "mismatched [3][3]");
    }

    @Test
    public void testSetMatValue()
    {
        if (verbose)
            System.out.println("*** Matrix4fTest testSetMatValue()");

        Matrix4f m = new Matrix4f();
        m.setMatValue(2, 3, 99.0f);
        assertEquals(99.0f, m.getMatValue(2, 3), TOLERANCE, "mismatched setMatValue");
        assertEquals(0.0f, m.getMatValue(0, 0), TOLERANCE, "other values should remain zero");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("Matrix4fTest start");
        Matrix4fTest test = new Matrix4fTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testIdentity();
        test.testCopyConstructor();
        test.testIdentityXformVec4f();
        test.testSetEulersZero();
        test.testSetEulersBottomRow();
        test.testArrayConstructor();
        test.testSetMatValue();
        tearDownClass();
        System.out.println("Matrix4fTest complete");
    }
}
