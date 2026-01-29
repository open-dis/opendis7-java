/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.DeadReckoningParameters;
import edu.nps.moves.dis7.pdus.Vector3Float;
import edu.nps.moves.dis7.enumerations.DeadReckoningAlgorithm;
import java.io.*;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for DeadReckoningParameters data structure.
 * Validates construction, field access, marshal/unmarshal round-trip, and algorithm types.
 */
@DisplayName("DeadReckoningParametersTest")
public class DeadReckoningParametersTest
{
    private static final float TOLERANCE = 1.0e-5f;
    private static boolean verbose = true;

    /** default constructor */
    public DeadReckoningParametersTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** DeadReckoningParametersTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** DeadReckoningParametersTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** DeadReckoningParametersTest testDefaultConstructor()");

        DeadReckoningParameters drp = new DeadReckoningParameters();
        assertNotNull(drp.getEntityLinearAcceleration(), "entityLinearAcceleration should not be null");
        assertNotNull(drp.getEntityAngularVelocity(), "entityAngularVelocity should not be null");
        assertNotNull(drp.getParameters(), "parameters array should not be null");
        assertEquals(15, drp.getParameters().length, "parameters array should be 15 bytes");
    }

    @Test
    public void testSetAlgorithm()
    {
        if (verbose)
            System.out.println("*** DeadReckoningParametersTest testSetAlgorithm()");

        DeadReckoningParameters drp = new DeadReckoningParameters();
        drp.setDeadReckoningAlgorithm(DeadReckoningAlgorithm.DRM_FPW_CONSTANT_VELOCITY_LOW_ACCELERATION_LINEAR_MOTION_ENTITY);
        assertEquals(DeadReckoningAlgorithm.DRM_FPW_CONSTANT_VELOCITY_LOW_ACCELERATION_LINEAR_MOTION_ENTITY,
            drp.getDeadReckoningAlgorithm(), "mismatched algorithm");
    }

    @Test
    public void testSetAccelerationAndVelocity()
    {
        if (verbose)
            System.out.println("*** DeadReckoningParametersTest testSetAccelerationAndVelocity()");

        DeadReckoningParameters drp = new DeadReckoningParameters();
        Vector3Float accel = new Vector3Float();
        accel.setX(1.0f);
        accel.setY(2.0f);
        accel.setZ(3.0f);
        drp.setEntityLinearAcceleration(accel);

        Vector3Float angVel = new Vector3Float();
        angVel.setX(0.1f);
        angVel.setY(0.2f);
        angVel.setZ(0.3f);
        drp.setEntityAngularVelocity(angVel);

        assertEquals(1.0f, drp.getEntityLinearAcceleration().getX(), TOLERANCE, "mismatched accel x");
        assertEquals(2.0f, drp.getEntityLinearAcceleration().getY(), TOLERANCE, "mismatched accel y");
        assertEquals(3.0f, drp.getEntityLinearAcceleration().getZ(), TOLERANCE, "mismatched accel z");
        assertEquals(0.1f, drp.getEntityAngularVelocity().getX(), TOLERANCE, "mismatched angVel x");
        assertEquals(0.2f, drp.getEntityAngularVelocity().getY(), TOLERANCE, "mismatched angVel y");
        assertEquals(0.3f, drp.getEntityAngularVelocity().getZ(), TOLERANCE, "mismatched angVel z");
    }

    @Test
    public void testMarshalUnmarshalDataStream() throws Exception
    {
        if (verbose)
            System.out.println("*** DeadReckoningParametersTest testMarshalUnmarshalDataStream()");

        DeadReckoningParameters original = new DeadReckoningParameters();
        original.setDeadReckoningAlgorithm(DeadReckoningAlgorithm.DRM_FPW_CONSTANT_VELOCITY_LOW_ACCELERATION_LINEAR_MOTION_ENTITY);
        original.getEntityLinearAcceleration().setX(5.0f);
        original.getEntityLinearAcceleration().setY(10.0f);
        original.getEntityLinearAcceleration().setZ(15.0f);
        original.getEntityAngularVelocity().setX(0.5f);
        original.getEntityAngularVelocity().setY(1.0f);
        original.getEntityAngularVelocity().setZ(1.5f);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        original.marshal(dos);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        DeadReckoningParameters restored = new DeadReckoningParameters();
        restored.unmarshal(dis);

        assertEquals(original.getDeadReckoningAlgorithm(), restored.getDeadReckoningAlgorithm(), "mismatched algorithm after unmarshal");
        assertEquals(original.getEntityLinearAcceleration().getX(), restored.getEntityLinearAcceleration().getX(), TOLERANCE, "mismatched accel x after unmarshal");
        assertEquals(original.getEntityLinearAcceleration().getY(), restored.getEntityLinearAcceleration().getY(), TOLERANCE, "mismatched accel y after unmarshal");
        assertEquals(original.getEntityLinearAcceleration().getZ(), restored.getEntityLinearAcceleration().getZ(), TOLERANCE, "mismatched accel z after unmarshal");
        assertEquals(original.getEntityAngularVelocity().getX(), restored.getEntityAngularVelocity().getX(), TOLERANCE, "mismatched angVel x after unmarshal");
        assertEquals(original.getEntityAngularVelocity().getY(), restored.getEntityAngularVelocity().getY(), TOLERANCE, "mismatched angVel y after unmarshal");
        assertEquals(original.getEntityAngularVelocity().getZ(), restored.getEntityAngularVelocity().getZ(), TOLERANCE, "mismatched angVel z after unmarshal");
    }

    @Test
    public void testMarshalUnmarshalByteBuffer() throws Exception
    {
        if (verbose)
            System.out.println("*** DeadReckoningParametersTest testMarshalUnmarshalByteBuffer()");

        DeadReckoningParameters original = new DeadReckoningParameters();
        original.setDeadReckoningAlgorithm(DeadReckoningAlgorithm.DRM_RVW_HIGH_SPEED_OR_MANEUVERING_ENTITY_WITH_EXTRAPOLATION_OF_ORIENTATION);
        original.getEntityLinearAcceleration().setX(-1.0f);
        original.getEntityAngularVelocity().setZ(0.99f);

        ByteBuffer buffer = ByteBuffer.allocate(original.getMarshalledSize());
        original.marshal(buffer);
        buffer.flip();

        DeadReckoningParameters restored = new DeadReckoningParameters();
        restored.unmarshal(buffer);

        assertEquals(original.getDeadReckoningAlgorithm(), restored.getDeadReckoningAlgorithm(), "mismatched algorithm after ByteBuffer unmarshal");
        assertEquals(original.getEntityLinearAcceleration().getX(), restored.getEntityLinearAcceleration().getX(), TOLERANCE, "mismatched accel x after ByteBuffer unmarshal");
        assertEquals(original.getEntityAngularVelocity().getZ(), restored.getEntityAngularVelocity().getZ(), TOLERANCE, "mismatched angVel z after ByteBuffer unmarshal");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("DeadReckoningParametersTest start");
        DeadReckoningParametersTest test = new DeadReckoningParametersTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testSetAlgorithm();
        test.testSetAccelerationAndVelocity();
        test.testMarshalUnmarshalDataStream();
        test.testMarshalUnmarshalByteBuffer();
        tearDownClass();
        System.out.println("DeadReckoningParametersTest complete");
    }
}
