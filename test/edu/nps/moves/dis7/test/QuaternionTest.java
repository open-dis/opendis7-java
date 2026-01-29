/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.legacy.math.Quaternion;
import edu.nps.moves.legacy.math.Vec3f;
import edu.nps.moves.legacy.math.Matrix3f;
import edu.nps.moves.legacy.math.Matrix4f;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Quaternion legacy math class.
 * Validates identity, axis-angle, Euler, matrix conversion, normalize,
 * conjugate, invert, multiply, xform, slerp, and makeFromVecs.
 */
@DisplayName("QuaternionTest")
public class QuaternionTest
{
    private static final float TOLERANCE = 1.0e-4f;
    private static boolean verbose = true;

    /** default constructor */
    public QuaternionTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** QuaternionTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** QuaternionTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructorIsIdentity()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testDefaultConstructorIsIdentity()");

        Quaternion q = new Quaternion();
        assertEquals(0.0f, q.getQuatValue(0), TOLERANCE, "identity q[0]");
        assertEquals(0.0f, q.getQuatValue(1), TOLERANCE, "identity q[1]");
        assertEquals(0.0f, q.getQuatValue(2), TOLERANCE, "identity q[2]");
        assertEquals(1.0f, q.getQuatValue(3), TOLERANCE, "identity q[3]");
    }

    @Test
    public void testIdentityLength()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testIdentityLength()");

        Quaternion q = new Quaternion();
        assertEquals(1.0f, q.length(), TOLERANCE, "identity quaternion should have unit length");
    }

    @Test
    public void testCopyConstructor()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testCopyConstructor()");

        float[] axis = {0.0f, 0.0f, 1.0f};
        Quaternion original = new Quaternion(axis, (float)(Math.PI / 4.0));
        Quaternion copy = new Quaternion(original);
        assertEquals(original.getQuatValue(0), copy.getQuatValue(0), TOLERANCE, "copy q[0]");
        assertEquals(original.getQuatValue(1), copy.getQuatValue(1), TOLERANCE, "copy q[1]");
        assertEquals(original.getQuatValue(2), copy.getQuatValue(2), TOLERANCE, "copy q[2]");
        assertEquals(original.getQuatValue(3), copy.getQuatValue(3), TOLERANCE, "copy q[3]");
    }

    @Test
    public void testAxisAngleRoundTrip()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testAxisAngleRoundTrip()");

        float angle = (float)(Math.PI / 3.0); // 60 degrees
        float[] axisIn = {0.0f, 1.0f, 0.0f};
        Quaternion q = new Quaternion(axisIn, angle);

        float[] axisOut = new float[3];
        float[] angleOut = new float[1];
        q.getAxisAngle(axisOut, angleOut);

        assertEquals(0.0f, axisOut[0], TOLERANCE, "axis x");
        assertEquals(1.0f, axisOut[1], TOLERANCE, "axis y");
        assertEquals(0.0f, axisOut[2], TOLERANCE, "axis z");
        assertEquals(angle, angleOut[0], TOLERANCE, "angle");
    }

    @Test
    public void testEulersRoundTrip()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testEulersRoundTrip()");

        float heading = 0.5f;
        float pitch = 0.3f;
        float roll = 0.1f;

        Quaternion q = new Quaternion();
        q.setEulers(heading, pitch, roll);

        float[] hpr = new float[3];
        q.getEulers(hpr);

        assertEquals(heading, hpr[0], TOLERANCE, "heading round-trip");
        assertEquals(pitch, hpr[1], TOLERANCE, "pitch round-trip");
        assertEquals(roll, hpr[2], TOLERANCE, "roll round-trip");
    }

    @Test
    public void testZeroEulersGiveIdentity()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testZeroEulersGiveIdentity()");

        Quaternion q = new Quaternion();
        q.setEulers(0.0f, 0.0f, 0.0f);
        assertEquals(0.0f, q.getQuatValue(0), TOLERANCE, "zero euler q[0]");
        assertEquals(0.0f, q.getQuatValue(1), TOLERANCE, "zero euler q[1]");
        assertEquals(0.0f, q.getQuatValue(2), TOLERANCE, "zero euler q[2]");
        assertEquals(1.0f, q.getQuatValue(3), TOLERANCE, "zero euler q[3]");
    }

    @Test
    public void testMatrix3fRoundTrip()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testMatrix3fRoundTrip()");

        Matrix3f mIn = new Matrix3f(0.5f, 0.3f, 0.1f);
        Quaternion q = new Quaternion(mIn);
        Matrix3f mOut = new Matrix3f();
        q.getMat3(mOut);

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                assertEquals(mIn.getMatValue(r, c), mOut.getMatValue(r, c), TOLERANCE,
                    "matrix3f round-trip [" + r + "][" + c + "]");
    }

    @Test
    public void testMatrix4fRoundTrip()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testMatrix4fRoundTrip()");

        Matrix4f mIn = new Matrix4f(0.4f, 0.2f, 0.6f);
        Quaternion q = new Quaternion(mIn);
        Matrix4f mOut = new Matrix4f();
        q.getMat4(mOut);

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                assertEquals(mIn.getMatValue(r, c), mOut.getMatValue(r, c), TOLERANCE,
                    "matrix4f round-trip [" + r + "][" + c + "]");
        // bottom row and right column
        assertEquals(0.0f, mOut.getMatValue(0, 3), TOLERANCE, "m[0][3]");
        assertEquals(0.0f, mOut.getMatValue(1, 3), TOLERANCE, "m[1][3]");
        assertEquals(0.0f, mOut.getMatValue(2, 3), TOLERANCE, "m[2][3]");
        assertEquals(0.0f, mOut.getMatValue(3, 0), TOLERANCE, "m[3][0]");
        assertEquals(0.0f, mOut.getMatValue(3, 1), TOLERANCE, "m[3][1]");
        assertEquals(0.0f, mOut.getMatValue(3, 2), TOLERANCE, "m[3][2]");
        assertEquals(1.0f, mOut.getMatValue(3, 3), TOLERANCE, "m[3][3]");
    }

    @Test
    public void testNormalize()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testNormalize()");

        Quaternion q = new Quaternion();
        q.setQuat(1.0f, 2.0f, 3.0f, 4.0f);
        q.normalize();
        assertEquals(1.0f, q.length(), TOLERANCE, "normalized quaternion should have unit length");
    }

    @Test
    public void testConjugate()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testConjugate()");

        Quaternion q = new Quaternion();
        q.setQuat(1.0f, 2.0f, 3.0f, 4.0f);
        q.conjugate();
        assertEquals(-1.0f, q.getQuatValue(0), TOLERANCE, "conjugate q[0]");
        assertEquals(-2.0f, q.getQuatValue(1), TOLERANCE, "conjugate q[1]");
        assertEquals(-3.0f, q.getQuatValue(2), TOLERANCE, "conjugate q[2]");
        assertEquals(4.0f, q.getQuatValue(3), TOLERANCE, "conjugate q[3]");
    }

    @Test
    public void testInvertUnitQuaternion()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testInvertUnitQuaternion()");

        // for unit quaternion, inverse equals conjugate
        float[] axis = {0.0f, 0.0f, 1.0f};
        Quaternion q = new Quaternion(axis, (float)(Math.PI / 4.0));
        Quaternion inv = new Quaternion(q);
        inv.invert();

        // q * q^-1 should give identity
        Quaternion result = new Quaternion();
        result.mult(q, inv);
        assertEquals(0.0f, result.getQuatValue(0), TOLERANCE, "q*q^-1 q[0]");
        assertEquals(0.0f, result.getQuatValue(1), TOLERANCE, "q*q^-1 q[1]");
        assertEquals(0.0f, result.getQuatValue(2), TOLERANCE, "q*q^-1 q[2]");
        assertEquals(1.0f, result.getQuatValue(3), TOLERANCE, "q*q^-1 q[3]");
    }

    @Test
    public void testMultiplyIdentity()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testMultiplyIdentity()");

        Quaternion identity = new Quaternion();
        float[] axis = {1.0f, 0.0f, 0.0f};
        Quaternion q = new Quaternion(axis, (float)(Math.PI / 6.0));

        Quaternion result = new Quaternion();
        result.mult(q, identity);

        assertEquals(q.getQuatValue(0), result.getQuatValue(0), TOLERANCE, "q*I q[0]");
        assertEquals(q.getQuatValue(1), result.getQuatValue(1), TOLERANCE, "q*I q[1]");
        assertEquals(q.getQuatValue(2), result.getQuatValue(2), TOLERANCE, "q*I q[2]");
        assertEquals(q.getQuatValue(3), result.getQuatValue(3), TOLERANCE, "q*I q[3]");
    }

    @Test
    public void testXformIdentity()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testXformIdentity()");

        Quaternion identity = new Quaternion();
        Vec3f v = new Vec3f(1.0f, 2.0f, 3.0f);
        identity.xform(v);
        assertEquals(1.0f, v.get(0), TOLERANCE, "identity xform v[0]");
        assertEquals(2.0f, v.get(1), TOLERANCE, "identity xform v[1]");
        assertEquals(3.0f, v.get(2), TOLERANCE, "identity xform v[2]");
    }

    @Test
    public void testXform90DegreesAboutZ()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testXform90DegreesAboutZ()");

        float[] axis = {0.0f, 0.0f, 1.0f};
        Quaternion q = new Quaternion(axis, (float)(Math.PI / 2.0));
        Vec3f v = new Vec3f(1.0f, 0.0f, 0.0f);
        q.xform(v);
        // rotating x-axis 90 degrees about z gives y-axis
        assertEquals(0.0f, v.get(0), TOLERANCE, "rotated v[0]");
        assertEquals(1.0f, v.get(1), TOLERANCE, "rotated v[1]");
        assertEquals(0.0f, v.get(2), TOLERANCE, "rotated v[2]");
    }

    @Test
    public void testXformArrayForm()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testXformArrayForm()");

        float[] axis = {0.0f, 0.0f, 1.0f};
        Quaternion q = new Quaternion(axis, (float)(Math.PI / 2.0));
        float[] v = {1.0f, 0.0f, 0.0f};
        q.xform(v);
        assertEquals(0.0f, v[0], TOLERANCE, "rotated v[0]");
        assertEquals(1.0f, v[1], TOLERANCE, "rotated v[1]");
        assertEquals(0.0f, v[2], TOLERANCE, "rotated v[2]");
    }

    @Test
    public void testSlerpEndpoints()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testSlerpEndpoints()");

        float[] axis = {0.0f, 1.0f, 0.0f};
        Quaternion q1 = new Quaternion();
        Quaternion q2 = new Quaternion(axis, (float)(Math.PI / 2.0));

        // slerp at alpha=0 should give q1
        Quaternion result0 = new Quaternion();
        result0.slerp(q1, q2, 0.0f, 0);
        assertEquals(q1.getQuatValue(0), result0.getQuatValue(0), TOLERANCE, "slerp(0) q[0]");
        assertEquals(q1.getQuatValue(1), result0.getQuatValue(1), TOLERANCE, "slerp(0) q[1]");
        assertEquals(q1.getQuatValue(2), result0.getQuatValue(2), TOLERANCE, "slerp(0) q[2]");
        assertEquals(q1.getQuatValue(3), result0.getQuatValue(3), TOLERANCE, "slerp(0) q[3]");

        // slerp at alpha=1 should give q2
        Quaternion result1 = new Quaternion();
        result1.slerp(q1, q2, 1.0f, 0);
        assertEquals(q2.getQuatValue(0), result1.getQuatValue(0), TOLERANCE, "slerp(1) q[0]");
        assertEquals(q2.getQuatValue(1), result1.getQuatValue(1), TOLERANCE, "slerp(1) q[1]");
        assertEquals(q2.getQuatValue(2), result1.getQuatValue(2), TOLERANCE, "slerp(1) q[2]");
        assertEquals(q2.getQuatValue(3), result1.getQuatValue(3), TOLERANCE, "slerp(1) q[3]");
    }

    @Test
    public void testSlerpMidpoint()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testSlerpMidpoint()");

        Quaternion q1 = new Quaternion();
        float[] axis = {0.0f, 1.0f, 0.0f};
        Quaternion q2 = new Quaternion(axis, (float)(Math.PI / 2.0));

        Quaternion mid = new Quaternion();
        mid.slerp(q1, q2, 0.5f, 0);
        // midpoint should have unit length
        assertEquals(1.0f, mid.length(), TOLERANCE, "slerp midpoint should have unit length");
    }

    @Test
    public void testMakeFromVecsParallel()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testMakeFromVecsParallel()");

        Vec3f v1 = new Vec3f(1.0f, 0.0f, 0.0f);
        Vec3f v2 = new Vec3f(1.0f, 0.0f, 0.0f);
        Quaternion q = new Quaternion(v1, v2);
        // parallel vectors should give identity quaternion
        assertEquals(0.0f, q.getQuatValue(0), TOLERANCE, "parallel q[0]");
        assertEquals(0.0f, q.getQuatValue(1), TOLERANCE, "parallel q[1]");
        assertEquals(0.0f, q.getQuatValue(2), TOLERANCE, "parallel q[2]");
        assertEquals(1.0f, q.getQuatValue(3), TOLERANCE, "parallel q[3]");
    }

    @Test
    public void testMakeFromVecsOrthogonal()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testMakeFromVecsOrthogonal()");

        Vec3f v1 = new Vec3f(1.0f, 0.0f, 0.0f);
        Vec3f v2 = new Vec3f(0.0f, 1.0f, 0.0f);
        Quaternion q = new Quaternion(v1, v2);
        // rotating v1 by q should give v2
        Vec3f test = new Vec3f(1.0f, 0.0f, 0.0f);
        q.xform(test);
        assertEquals(0.0f, test.get(0), TOLERANCE, "rotated v[0]");
        assertEquals(1.0f, test.get(1), TOLERANCE, "rotated v[1]");
        assertEquals(0.0f, test.get(2), TOLERANCE, "rotated v[2]");
    }

    @Test
    public void testSetGetQuatValue()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testSetGetQuatValue()");

        Quaternion q = new Quaternion();
        q.setQuatValue(0, 0.5f);
        q.setQuatValue(1, 0.6f);
        q.setQuatValue(2, 0.7f);
        q.setQuatValue(3, 0.8f);
        assertEquals(0.5f, q.getQuatValue(0), TOLERANCE, "get q[0]");
        assertEquals(0.6f, q.getQuatValue(1), TOLERANCE, "get q[1]");
        assertEquals(0.7f, q.getQuatValue(2), TOLERANCE, "get q[2]");
        assertEquals(0.8f, q.getQuatValue(3), TOLERANCE, "get q[3]");
    }

    @Test
    public void testBoundsCheck()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testBoundsCheck()");

        Quaternion q = new Quaternion();
        assertEquals(0.0f, q.getQuatValue(-1), TOLERANCE, "out of bounds should return 0");
        assertEquals(0.0f, q.getQuatValue(4), TOLERANCE, "out of bounds should return 0");
    }

    @Test
    public void testAddSub()
    {
        if (verbose)
            System.out.println("*** QuaternionTest testAddSub()");

        Quaternion a = new Quaternion();
        a.setQuat(1.0f, 2.0f, 3.0f, 4.0f);
        Quaternion b = new Quaternion();
        b.setQuat(5.0f, 6.0f, 7.0f, 8.0f);

        Quaternion sum = new Quaternion();
        sum.add(a, b);
        assertEquals(6.0f, sum.getQuatValue(0), TOLERANCE, "add q[0]");
        assertEquals(8.0f, sum.getQuatValue(1), TOLERANCE, "add q[1]");
        assertEquals(10.0f, sum.getQuatValue(2), TOLERANCE, "add q[2]");
        assertEquals(12.0f, sum.getQuatValue(3), TOLERANCE, "add q[3]");

        Quaternion diff = new Quaternion();
        diff.sub(b, a);
        assertEquals(4.0f, diff.getQuatValue(0), TOLERANCE, "sub q[0]");
        assertEquals(4.0f, diff.getQuatValue(1), TOLERANCE, "sub q[1]");
        assertEquals(4.0f, diff.getQuatValue(2), TOLERANCE, "sub q[2]");
        assertEquals(4.0f, diff.getQuatValue(3), TOLERANCE, "sub q[3]");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("QuaternionTest start");
        QuaternionTest test = new QuaternionTest();
        setUpClass();
        test.testDefaultConstructorIsIdentity();
        test.testIdentityLength();
        test.testCopyConstructor();
        test.testAxisAngleRoundTrip();
        test.testEulersRoundTrip();
        test.testZeroEulersGiveIdentity();
        test.testMatrix3fRoundTrip();
        test.testMatrix4fRoundTrip();
        test.testNormalize();
        test.testConjugate();
        test.testInvertUnitQuaternion();
        test.testMultiplyIdentity();
        test.testXformIdentity();
        test.testXform90DegreesAboutZ();
        test.testXformArrayForm();
        test.testSlerpEndpoints();
        test.testSlerpMidpoint();
        test.testMakeFromVecsParallel();
        test.testMakeFromVecsOrthogonal();
        test.testSetGetQuatValue();
        test.testBoundsCheck();
        test.testAddSub();
        tearDownClass();
        System.out.println("QuaternionTest complete");
    }
}
