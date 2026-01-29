/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.enumerations.DisPduType;
import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.utilities.DisTime.TimestampStyle;
import edu.nps.moves.dis7.utilities.PduFactory;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Extended unit tests for PduFactory utility class.
 * Validates factory configuration, PDU creation with custom parameters,
 * timestamp assignment, header consistency, and deserialization.
 * Supplements existing PduFactoryTest with deeper coverage.
 */
@DisplayName("PduFactoryExtendedTest")
public class PduFactoryExtendedTest
{
    private static boolean verbose = true;

    /** default constructor */
    public PduFactoryExtendedTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest tearDownClass()");
    }

    @Test
    public void testDefaultFactory()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest testDefaultFactory()");

        PduFactory factory = new PduFactory();
        assertNotNull(factory, "factory should not be null");
        assertEquals(TimestampStyle.IEEE_ABSOLUTE, factory.getTimestampStyle(), "mismatched default timestamp style");
    }

    @Test
    public void testCustomTimestampStyle()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest testCustomTimestampStyle()");

        PduFactory factory = new PduFactory(TimestampStyle.IEEE_RELATIVE);
        assertEquals(TimestampStyle.IEEE_RELATIVE, factory.getTimestampStyle(), "mismatched custom timestamp style");

        factory.setTimestampStyle(TimestampStyle.UNIX);
        assertEquals(TimestampStyle.UNIX, factory.getTimestampStyle(), "mismatched timestamp style after set");
    }

    @Test
    public void testFullConstructor()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest testFullConstructor()");

        PduFactory factory = new PduFactory(Country.UNITED_STATES_OF_AMERICA_USA,
            (byte) 5, (short) 10, (short) 20, TimestampStyle.IEEE_ABSOLUTE);
        assertNotNull(factory, "factory should not be null");

        EntityStatePdu espdu = factory.makeEntityStatePdu();
        assertNotNull(espdu, "ESPDU should not be null");
        assertEquals(5, espdu.getExerciseID(), "mismatched exerciseID");
    }

    @Test
    public void testMakeEntityStatePdu()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest testMakeEntityStatePdu()");

        PduFactory factory = new PduFactory();
        EntityStatePdu espdu = factory.makeEntityStatePdu();
        assertNotNull(espdu, "ESPDU should not be null");
        assertEquals(DisPduType.ENTITY_STATE, espdu.getPduType(), "mismatched PDU type");
        assertTrue(espdu.getTimestamp() != 0, "timestamp should be set");
    }

    @Test
    public void testMakeFirePdu()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest testMakeFirePdu()");

        PduFactory factory = new PduFactory();
        FirePdu firePdu = factory.makeFirePdu();
        assertNotNull(firePdu, "FirePdu should not be null");
        assertEquals(DisPduType.FIRE, firePdu.getPduType(), "mismatched PDU type");
    }

    @Test
    public void testMakeDetonationPdu()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest testMakeDetonationPdu()");

        PduFactory factory = new PduFactory();
        DetonationPdu detPdu = factory.makeDetonationPdu();
        assertNotNull(detPdu, "DetonationPdu should not be null");
        assertEquals(DisPduType.DETONATION, detPdu.getPduType(), "mismatched PDU type");
    }

    @Test
    public void testMakeCommentPduWithStrings()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest testMakeCommentPduWithStrings()");

        PduFactory factory = new PduFactory();
        CommentPdu commentPdu = factory.makeCommentPdu("test message one", "test message two");
        assertNotNull(commentPdu, "CommentPdu should not be null");
        assertEquals(DisPduType.COMMENT, commentPdu.getPduType(), "mismatched PDU type");
        assertEquals(2, commentPdu.getVariableDatumRecords().size(), "mismatched variable datum count");
    }

    @Test
    public void testHeaderConsistencyAcrossPduTypes()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest testHeaderConsistencyAcrossPduTypes()");

        PduFactory factory = new PduFactory(Country.UNITED_STATES_OF_AMERICA_USA,
            (byte) 7, (short) 100, (short) 200, TimestampStyle.IEEE_ABSOLUTE);

        EntityStatePdu espdu = factory.makeEntityStatePdu();
        FirePdu firePdu = factory.makeFirePdu();
        DetonationPdu detPdu = factory.makeDetonationPdu();

        // exercise ID should be consistent across all PDUs from same factory
        assertEquals(espdu.getExerciseID(), firePdu.getExerciseID(), "mismatched exerciseID between ESPDU and FirePdu");
        assertEquals(espdu.getExerciseID(), detPdu.getExerciseID(), "mismatched exerciseID between ESPDU and DetonationPdu");
        assertEquals(7, espdu.getExerciseID(), "mismatched exerciseID value");
    }

    @Test
    public void testMarshalUnmarshalRoundTrip() throws Exception
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest testMarshalUnmarshalRoundTrip()");

        PduFactory factory = new PduFactory();
        EntityStatePdu original = factory.makeEntityStatePdu();
        original.getEntityID().setSiteID(10).setApplicationID(20).setEntityID(30);

        ByteBuffer buffer = original.marshal();
        assertNotNull(buffer, "marshal result should not be null");
        assertTrue(buffer.limit() > 0, "marshalled buffer should not be empty");

        Pdu restored = factory.createPdu(buffer);
        assertNotNull(restored, "deserialized PDU should not be null");
        assertEquals(DisPduType.ENTITY_STATE, restored.getPduType(), "mismatched PDU type after round-trip");
    }

    @Test
    public void testCreatePduByType()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest testCreatePduByType()");

        PduFactory factory = new PduFactory();
        Pdu firePdu = factory.createPdu(DisPduType.FIRE);
        assertNotNull(firePdu, "PDU created by type should not be null");
        assertEquals(DisPduType.FIRE, firePdu.getPduType(), "mismatched PDU type");

        Pdu espdu = factory.createPdu(DisPduType.ENTITY_STATE);
        assertNotNull(espdu, "PDU created by type should not be null");
        assertEquals(DisPduType.ENTITY_STATE, espdu.getPduType(), "mismatched PDU type");
    }

    @Test
    public void testMakeCollisionPdu()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest testMakeCollisionPdu()");

        PduFactory factory = new PduFactory();
        CollisionPdu collisionPdu = factory.makeCollisionPdu();
        assertNotNull(collisionPdu, "CollisionPdu should not be null");
        assertEquals(DisPduType.COLLISION, collisionPdu.getPduType(), "mismatched PDU type");
    }

    @Test
    public void testMakeCreateEntityPdu()
    {
        if (verbose)
            System.out.println("*** PduFactoryExtendedTest testMakeCreateEntityPdu()");

        PduFactory factory = new PduFactory();
        CreateEntityPdu createPdu = factory.makeCreateEntityPdu();
        assertNotNull(createPdu, "CreateEntityPdu should not be null");
        assertEquals(DisPduType.CREATE_ENTITY, createPdu.getPduType(), "mismatched PDU type");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println("PduFactoryExtendedTest start");
        PduFactoryExtendedTest test = new PduFactoryExtendedTest();
        setUpClass();
        test.testDefaultFactory();
        test.testCustomTimestampStyle();
        test.testFullConstructor();
        test.testMakeEntityStatePdu();
        test.testMakeFirePdu();
        test.testMakeDetonationPdu();
        test.testMakeCommentPduWithStrings();
        test.testHeaderConsistencyAcrossPduTypes();
        test.testMarshalUnmarshalRoundTrip();
        test.testCreatePduByType();
        test.testMakeCollisionPdu();
        test.testMakeCreateEntityPdu();
        tearDownClass();
        System.out.println("PduFactoryExtendedTest complete");
    }
}
