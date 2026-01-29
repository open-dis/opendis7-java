/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.legacy.math.Vec4f;
import edu.nps.moves.legacy.math.Matrix4f;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Vec4f legacy math class.
 * Validates vector construction, arithmetic, dot product, normalization, and transforms.
 */
@DisplayName("Vec4fTest")
public class Vec4fTest
{
    private static final float TOLERANCE = 1.0e-5f;
    private static boolean verbose = true;

    /** default constructor */
    public Vec4fTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** Vec4fTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** Vec4fTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testDefaultConstructor()");

        Vec4f v = new Vec4f();
        assertEquals(0.0f, v.get(0), TOLERANCE, "mismatched v[0]");
        assertEquals(0.0f, v.get(1), TOLERANCE, "mismatched v[1]");
        assertEquals(0.0f, v.get(2), TOLERANCE, "mismatched v[2]");
        assertEquals(0.0f, v.get(3), TOLERANCE, "mismatched v[3]");
    }

    @Test
    public void testComponentConstructor()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testComponentConstructor()");

        Vec4f v = new Vec4f(1.0f, 2.0f, 3.0f, 4.0f);
        assertEquals(1.0f, v.get(0), TOLERANCE, "mismatched v[0]");
        assertEquals(2.0f, v.get(1), TOLERANCE, "mismatched v[1]");
        assertEquals(3.0f, v.get(2), TOLERANCE, "mismatched v[2]");
        assertEquals(4.0f, v.get(3), TOLERANCE, "mismatched v[3]");
    }

    @Test
    public void testCopyConstructor()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testCopyConstructor()");

        Vec4f original = new Vec4f(5.0f, 6.0f, 7.0f, 8.0f);
        Vec4f copy = new Vec4f(original);
        assertEquals(original.get(0), copy.get(0), TOLERANCE, "mismatched copy v[0]");
        assertEquals(original.get(1), copy.get(1), TOLERANCE, "mismatched copy v[1]");
        assertEquals(original.get(2), copy.get(2), TOLERANCE, "mismatched copy v[2]");
        assertEquals(original.get(3), copy.get(3), TOLERANCE, "mismatched copy v[3]");
    }

    @Test
    public void testAdd()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testAdd()");

        Vec4f a = new Vec4f(1.0f, 2.0f, 3.0f, 4.0f);
        Vec4f b = new Vec4f(5.0f, 6.0f, 7.0f, 8.0f);
        a.add(b);
        assertEquals(6.0f, a.get(0), TOLERANCE, "mismatched add v[0]");
        assertEquals(8.0f, a.get(1), TOLERANCE, "mismatched add v[1]");
        assertEquals(10.0f, a.get(2), TOLERANCE, "mismatched add v[2]");
        assertEquals(12.0f, a.get(3), TOLERANCE, "mismatched add v[3]");
    }

    @Test
    public void testSub()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testSub()");

        Vec4f a = new Vec4f(6.0f, 8.0f, 10.0f, 12.0f);
        Vec4f b = new Vec4f(1.0f, 2.0f, 3.0f, 4.0f);
        a.sub(b);
        assertEquals(5.0f, a.get(0), TOLERANCE, "mismatched sub v[0]");
        assertEquals(6.0f, a.get(1), TOLERANCE, "mismatched sub v[1]");
        assertEquals(7.0f, a.get(2), TOLERANCE, "mismatched sub v[2]");
        assertEquals(8.0f, a.get(3), TOLERANCE, "mismatched sub v[3]");
    }

    @Test
    public void testScale()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testScale()");

        Vec4f v = new Vec4f(1.0f, 2.0f, 3.0f, 4.0f);
        v.scale(3.0f);
        assertEquals(3.0f, v.get(0), TOLERANCE, "mismatched scale v[0]");
        assertEquals(6.0f, v.get(1), TOLERANCE, "mismatched scale v[1]");
        assertEquals(9.0f, v.get(2), TOLERANCE, "mismatched scale v[2]");
        assertEquals(12.0f, v.get(3), TOLERANCE, "mismatched scale v[3]");
    }

    @Test
    public void testNegate()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testNegate()");

        Vec4f v = new Vec4f(1.0f, -2.0f, 3.0f, -4.0f);
        v.negate();
        assertEquals(-1.0f, v.get(0), TOLERANCE, "mismatched negate v[0]");
        assertEquals(2.0f, v.get(1), TOLERANCE, "mismatched negate v[1]");
        assertEquals(-3.0f, v.get(2), TOLERANCE, "mismatched negate v[2]");
        assertEquals(4.0f, v.get(3), TOLERANCE, "mismatched negate v[3]");
    }

    @Test
    public void testLength()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testLength()");

        Vec4f v = new Vec4f(1.0f, 2.0f, 3.0f, 4.0f);
        float expected = (float) Math.sqrt(1 + 4 + 9 + 16); // sqrt(30)
        assertEquals(expected, v.length(), TOLERANCE, "mismatched length");

        Vec4f zero = new Vec4f();
        assertEquals(0.0f, zero.length(), TOLERANCE, "mismatched length for zero vector");
    }

    @Test
    public void testNormalize()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testNormalize()");

        Vec4f v = new Vec4f(2.0f, 0.0f, 0.0f, 0.0f);
        v.normalize();
        assertEquals(1.0f, v.length(), TOLERANCE, "normalized vector should have unit length");
        assertEquals(1.0f, v.get(0), TOLERANCE, "mismatched normalized v[0]");
        assertEquals(0.0f, v.get(1), TOLERANCE, "mismatched normalized v[1]");
        assertEquals(0.0f, v.get(2), TOLERANCE, "mismatched normalized v[2]");
        assertEquals(0.0f, v.get(3), TOLERANCE, "mismatched normalized v[3]");
    }

    @Test
    public void testNormalizeZeroVector()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testNormalizeZeroVector()");

        Vec4f v = new Vec4f();
        v.normalize(); // should not throw
        assertEquals(0.0f, v.get(0), TOLERANCE, "zero vector normalize v[0]");
        assertEquals(0.0f, v.get(1), TOLERANCE, "zero vector normalize v[1]");
        assertEquals(0.0f, v.get(2), TOLERANCE, "zero vector normalize v[2]");
        assertEquals(0.0f, v.get(3), TOLERANCE, "zero vector normalize v[3]");
    }

    @Test
    public void testDotProduct()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testDotProduct()");

        Vec4f a = new Vec4f(1.0f, 2.0f, 3.0f, 4.0f);
        Vec4f b = new Vec4f(5.0f, 6.0f, 7.0f, 8.0f);
        // 1*5 + 2*6 + 3*7 + 4*8 = 5 + 12 + 21 + 32 = 70
        assertEquals(70.0f, a.dot(b), TOLERANCE, "mismatched dot product");
        assertEquals(70.0f, Vec4f.dot(a, b), TOLERANCE, "mismatched static dot product");
    }

    @Test
    public void testOrthogonalDot()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testOrthogonalDot()");

        Vec4f a = new Vec4f(1.0f, 0.0f, 0.0f, 0.0f);
        Vec4f b = new Vec4f(0.0f, 1.0f, 0.0f, 0.0f);
        assertEquals(0.0f, a.dot(b), TOLERANCE, "orthogonal vectors dot product should be 0");
    }

    @Test
    public void testBoundsCheck()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testBoundsCheck()");

        Vec4f v = new Vec4f(1.0f, 2.0f, 3.0f, 4.0f);
        assertEquals(0.0f, v.get(-1), TOLERANCE, "out of bounds get should return 0");
        assertEquals(0.0f, v.get(4), TOLERANCE, "out of bounds get should return 0");
    }

    @Test
    public void testXformIdentity()
    {
        if (verbose)
            System.out.println("*** Vec4fTest testXformIdentity()");

        Vec4f v = new Vec4f(1.0f, 2.0f, 3.0f, 4.0f);
        Matrix4f identity = new Matrix4f();
        identity.makeIdent();
        v.xform(identity);
        assertEquals(1.0f, v.get(0), TOLERANCE, "identity xform should not change v[0]");
        assertEquals(2.0f, v.get(1), TOLERANCE, "identity xform should not change v[1]");
        assertEquals(3.0f, v.get(2), TOLERANCE, "identity xform should not change v[2]");
        assertEquals(4.0f, v.get(3), TOLERANCE, "identity xform should not change v[3]");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("Vec4fTest start");
        Vec4fTest test = new Vec4fTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testComponentConstructor();
        test.testCopyConstructor();
        test.testAdd();
        test.testSub();
        test.testScale();
        test.testNegate();
        test.testLength();
        test.testNormalize();
        test.testNormalizeZeroVector();
        test.testDotProduct();
        test.testOrthogonalDot();
        test.testBoundsCheck();
        test.testXformIdentity();
        tearDownClass();
        System.out.println("Vec4fTest complete");
    }
}
