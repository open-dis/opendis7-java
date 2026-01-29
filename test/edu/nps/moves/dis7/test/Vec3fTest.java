/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.legacy.math.Vec3f;
import edu.nps.moves.legacy.math.Matrix3f;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Vec3f legacy math class.
 * Validates vector construction, arithmetic, dot/cross products, normalization, and transforms.
 */
@DisplayName("Vec3fTest")
public class Vec3fTest
{
    private static final float TOLERANCE = 1.0e-5f;
    private static boolean verbose = true;

    /** default constructor */
    public Vec3fTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** Vec3fTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** Vec3fTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testDefaultConstructor()");

        Vec3f v = new Vec3f();
        assertEquals(0.0f, v.get(0), TOLERANCE, "mismatched v[0]");
        assertEquals(0.0f, v.get(1), TOLERANCE, "mismatched v[1]");
        assertEquals(0.0f, v.get(2), TOLERANCE, "mismatched v[2]");
    }

    @Test
    public void testComponentConstructor()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testComponentConstructor()");

        Vec3f v = new Vec3f(1.0f, 2.0f, 3.0f);
        assertEquals(1.0f, v.get(0), TOLERANCE, "mismatched v[0]");
        assertEquals(2.0f, v.get(1), TOLERANCE, "mismatched v[1]");
        assertEquals(3.0f, v.get(2), TOLERANCE, "mismatched v[2]");
    }

    @Test
    public void testCopyConstructor()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testCopyConstructor()");

        Vec3f original = new Vec3f(4.0f, 5.0f, 6.0f);
        Vec3f copy = new Vec3f(original);
        assertEquals(original.get(0), copy.get(0), TOLERANCE, "mismatched copy v[0]");
        assertEquals(original.get(1), copy.get(1), TOLERANCE, "mismatched copy v[1]");
        assertEquals(original.get(2), copy.get(2), TOLERANCE, "mismatched copy v[2]");
    }

    @Test
    public void testAdd()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testAdd()");

        Vec3f a = new Vec3f(1.0f, 2.0f, 3.0f);
        Vec3f b = new Vec3f(4.0f, 5.0f, 6.0f);
        a.add(b);
        assertEquals(5.0f, a.get(0), TOLERANCE, "mismatched add v[0]");
        assertEquals(7.0f, a.get(1), TOLERANCE, "mismatched add v[1]");
        assertEquals(9.0f, a.get(2), TOLERANCE, "mismatched add v[2]");
    }

    @Test
    public void testAddTwoVectors()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testAddTwoVectors()");

        Vec3f a = new Vec3f(1.0f, 2.0f, 3.0f);
        Vec3f b = new Vec3f(4.0f, 5.0f, 6.0f);
        Vec3f result = new Vec3f();
        result.add(a, b);
        assertEquals(5.0f, result.get(0), TOLERANCE, "mismatched add v[0]");
        assertEquals(7.0f, result.get(1), TOLERANCE, "mismatched add v[1]");
        assertEquals(9.0f, result.get(2), TOLERANCE, "mismatched add v[2]");
    }

    @Test
    public void testSub()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testSub()");

        Vec3f a = new Vec3f(5.0f, 7.0f, 9.0f);
        Vec3f b = new Vec3f(1.0f, 2.0f, 3.0f);
        a.sub(b);
        assertEquals(4.0f, a.get(0), TOLERANCE, "mismatched sub v[0]");
        assertEquals(5.0f, a.get(1), TOLERANCE, "mismatched sub v[1]");
        assertEquals(6.0f, a.get(2), TOLERANCE, "mismatched sub v[2]");
    }

    @Test
    public void testScale()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testScale()");

        Vec3f v = new Vec3f(1.0f, 2.0f, 3.0f);
        v.scale(2.0f);
        assertEquals(2.0f, v.get(0), TOLERANCE, "mismatched scale v[0]");
        assertEquals(4.0f, v.get(1), TOLERANCE, "mismatched scale v[1]");
        assertEquals(6.0f, v.get(2), TOLERANCE, "mismatched scale v[2]");
    }

    @Test
    public void testNegate()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testNegate()");

        Vec3f v = new Vec3f(1.0f, -2.0f, 3.0f);
        v.negate();
        assertEquals(-1.0f, v.get(0), TOLERANCE, "mismatched negate v[0]");
        assertEquals(2.0f, v.get(1), TOLERANCE, "mismatched negate v[1]");
        assertEquals(-3.0f, v.get(2), TOLERANCE, "mismatched negate v[2]");
    }

    @Test
    public void testLength()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testLength()");

        Vec3f v = new Vec3f(3.0f, 4.0f, 0.0f);
        assertEquals(5.0f, v.length(), TOLERANCE, "mismatched length for (3,4,0)");

        Vec3f unit = new Vec3f(1.0f, 0.0f, 0.0f);
        assertEquals(1.0f, unit.length(), TOLERANCE, "mismatched length for unit vector");

        Vec3f zero = new Vec3f();
        assertEquals(0.0f, zero.length(), TOLERANCE, "mismatched length for zero vector");
    }

    @Test
    public void testNormalize()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testNormalize()");

        Vec3f v = new Vec3f(3.0f, 4.0f, 0.0f);
        v.normalize();
        assertEquals(1.0f, v.length(), TOLERANCE, "normalized vector should have unit length");
        assertEquals(0.6f, v.get(0), TOLERANCE, "mismatched normalized v[0]");
        assertEquals(0.8f, v.get(1), TOLERANCE, "mismatched normalized v[1]");
        assertEquals(0.0f, v.get(2), TOLERANCE, "mismatched normalized v[2]");
    }

    @Test
    public void testNormalizeZeroVector()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testNormalizeZeroVector()");

        Vec3f v = new Vec3f();
        v.normalize(); // should not throw, should remain zero
        assertEquals(0.0f, v.get(0), TOLERANCE, "zero vector normalize v[0]");
        assertEquals(0.0f, v.get(1), TOLERANCE, "zero vector normalize v[1]");
        assertEquals(0.0f, v.get(2), TOLERANCE, "zero vector normalize v[2]");
    }

    @Test
    public void testDotProduct()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testDotProduct()");

        Vec3f a = new Vec3f(1.0f, 0.0f, 0.0f);
        Vec3f b = new Vec3f(0.0f, 1.0f, 0.0f);
        assertEquals(0.0f, a.dot(b), TOLERANCE, "orthogonal vectors dot product should be 0");

        Vec3f c = new Vec3f(1.0f, 2.0f, 3.0f);
        Vec3f d = new Vec3f(4.0f, 5.0f, 6.0f);
        assertEquals(32.0f, c.dot(d), TOLERANCE, "mismatched dot product"); // 1*4 + 2*5 + 3*6 = 32

        assertEquals(32.0f, Vec3f.dot(c, d), TOLERANCE, "mismatched static dot product");
    }

    @Test
    public void testCrossProduct()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testCrossProduct()");

        // x cross y = z
        Vec3f x = new Vec3f(1.0f, 0.0f, 0.0f);
        Vec3f y = new Vec3f(0.0f, 1.0f, 0.0f);
        x.cross(y);
        assertEquals(0.0f, x.get(0), TOLERANCE, "mismatched cross v[0]");
        assertEquals(0.0f, x.get(1), TOLERANCE, "mismatched cross v[1]");
        assertEquals(1.0f, x.get(2), TOLERANCE, "mismatched cross v[2]");
    }

    @Test
    public void testCrossProductTwoVectors()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testCrossProductTwoVectors()");

        Vec3f a = new Vec3f(1.0f, 0.0f, 0.0f);
        Vec3f b = new Vec3f(0.0f, 1.0f, 0.0f);
        Vec3f result = new Vec3f();
        result.cross(a, b);
        assertEquals(0.0f, result.get(0), TOLERANCE, "mismatched cross v[0]");
        assertEquals(0.0f, result.get(1), TOLERANCE, "mismatched cross v[1]");
        assertEquals(1.0f, result.get(2), TOLERANCE, "mismatched cross v[2]");
    }

    @Test
    public void testMakeNull()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testMakeNull()");

        Vec3f v = new Vec3f(1.0f, 2.0f, 3.0f);
        v.makeNull();
        assertEquals(0.0f, v.get(0), TOLERANCE, "mismatched makeNull v[0]");
        assertEquals(0.0f, v.get(1), TOLERANCE, "mismatched makeNull v[1]");
        assertEquals(0.0f, v.get(2), TOLERANCE, "mismatched makeNull v[2]");
    }

    @Test
    public void testXformIdentity()
    {
        if (verbose)
            System.out.println("*** Vec3fTest testXformIdentity()");

        Vec3f v = new Vec3f(1.0f, 2.0f, 3.0f);
        Matrix3f identity = new Matrix3f();
        identity.makeIdent();
        v.xform(identity);
        assertEquals(1.0f, v.get(0), TOLERANCE, "identity xform should not change v[0]");
        assertEquals(2.0f, v.get(1), TOLERANCE, "identity xform should not change v[1]");
        assertEquals(3.0f, v.get(2), TOLERANCE, "identity xform should not change v[2]");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("Vec3fTest start");
        Vec3fTest test = new Vec3fTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testComponentConstructor();
        test.testCopyConstructor();
        test.testAdd();
        test.testAddTwoVectors();
        test.testSub();
        test.testScale();
        test.testNegate();
        test.testLength();
        test.testNormalize();
        test.testNormalizeZeroVector();
        test.testDotProduct();
        test.testCrossProduct();
        test.testCrossProductTwoVectors();
        test.testMakeNull();
        test.testXformIdentity();
        tearDownClass();
        System.out.println("Vec3fTest complete");
    }
}
