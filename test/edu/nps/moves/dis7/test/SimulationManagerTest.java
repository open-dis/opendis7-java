/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.utilities.SimulationManager;
import edu.nps.moves.dis7.utilities.SimulationManager.RecordType;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for SimulationManager utility class.
 * Tests record management, entity/host tracking, and configuration
 * without requiring network access.
 */
@DisplayName("SimulationManagerTest")
public class SimulationManagerTest
{
    private static boolean verbose = true;

    /** helper instance for creating inner RecordType objects */
    private SimulationManager smHelper = new SimulationManager();

    /** default constructor */
    public SimulationManagerTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest testDefaultConstructor()");

        SimulationManager sm = new SimulationManager();
        assertNotNull(sm, "SimulationManager should not be null");
    }

    @Test
    public void testDescriptorConstructor()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest testDescriptorConstructor()");

        SimulationManager sm = new SimulationManager("test sim");
        assertEquals("test sim", sm.getDescriptor(), "mismatched descriptor");
    }

    @Test
    public void testSetDescriptor()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest testSetDescriptor()");

        SimulationManager sm = new SimulationManager();
        sm.setDescriptor("new descriptor");
        assertEquals("new descriptor", sm.getDescriptor(), "mismatched descriptor after set");
    }

    @Test
    public void testClearDescriptor()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest testClearDescriptor()");

        SimulationManager sm = new SimulationManager("something");
        sm.clearDescriptor();
        assertTrue(sm.getDescriptor().isEmpty(), "descriptor should be empty after clear");
    }

    @Test
    public void testRecordType()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest testRecordType()");

        RecordType record = smHelper.new RecordType(1, "Entity1", "A test entity", "ref-001");
        assertEquals(1, record.getId(), "mismatched record ID");
        assertEquals("Entity1", record.getName(), "mismatched record name");
        assertEquals("A test entity", record.getDescription(), "mismatched record description");
        assertEquals("ref-001", record.getReference(), "mismatched record reference");
    }

    @Test
    public void testRecordTypeSetters()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest testRecordTypeSetters()");

        RecordType record = smHelper.new RecordType(1, "Entity1");
        record.setId(2);
        record.setName("Entity2");
        record.setDescription("updated description");
        record.setReference("ref-002");
        record.setAlias("alias1");

        assertEquals(2, record.getId(), "mismatched record ID after set");
        assertEquals("Entity2", record.getName(), "mismatched record name after set");
        assertEquals("updated description", record.getDescription(), "mismatched description after set");
        assertEquals("ref-002", record.getReference(), "mismatched reference after set");
        assertEquals("alias1", record.getAlias(), "mismatched alias after set");
    }

    @Test
    public void testEntityListManagement()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest testEntityListManagement()");

        SimulationManager sm = new SimulationManager();
        assertNotNull(sm.getEntityRecordList(), "entity list should not be null");
        assertTrue(sm.getEntityRecordList().isEmpty(), "entity list should be empty initially");

        RecordType entity = smHelper.new RecordType(1, "Tank1");
        sm.addEntity(entity);
        assertEquals(1, sm.getEntityRecordList().size(), "entity list should have 1 entry");

        RecordType retrieved = sm.getEntityRecordByIndex(0);
        assertNotNull(retrieved, "retrieved entity should not be null");
        assertEquals("Tank1", retrieved.getName(), "mismatched entity name");
    }

    @Test
    public void testHostListManagement()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest testHostListManagement()");

        SimulationManager sm = new SimulationManager();
        assertNotNull(sm.getHostRecordList(), "host list should not be null");
        assertTrue(sm.getHostRecordList().isEmpty(), "host list should be empty initially");

        sm.addHost("localhost");
        assertEquals(1, sm.getHostRecordList().size(), "host list should have 1 entry");
    }

    @Test
    public void testClearAll()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest testClearAll()");

        SimulationManager sm = new SimulationManager("test");
        sm.addEntity(smHelper.new RecordType(1, "Entity1"));
        sm.addHost("host1");
        sm.clearAll();

        assertTrue(sm.getEntityRecordList().isEmpty(), "entity list should be empty after clearAll");
        assertTrue(sm.getHostRecordList().isEmpty(), "host list should be empty after clearAll");
    }

    @Test
    public void testGetPduFactory()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest testGetPduFactory()");

        SimulationManager sm = new SimulationManager();
        assertNotNull(sm.getPduFactory(), "PduFactory should not be null");
    }

    @Test
    public void testAddEntityById()
    {
        if (verbose)
            System.out.println("*** SimulationManagerTest testAddEntityById()");

        SimulationManager sm = new SimulationManager();
        EntityID entityId = new EntityID().setSiteID(1).setApplicationID(2).setEntityID(3);
        sm.addEntity(entityId);
        assertEquals(1, sm.getEntityRecordList().size(), "entity list should have 1 entry after addEntity(EntityID)");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("SimulationManagerTest start");
        SimulationManagerTest test = new SimulationManagerTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testDescriptorConstructor();
        test.testSetDescriptor();
        test.testClearDescriptor();
        test.testRecordType();
        test.testRecordTypeSetters();
        test.testEntityListManagement();
        test.testHostListManagement();
        test.testClearAll();
        test.testGetPduFactory();
        test.testAddEntityById();
        tearDownClass();
        System.out.println("SimulationManagerTest complete");
    }
}
