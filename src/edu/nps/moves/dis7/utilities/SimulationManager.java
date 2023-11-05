/**
 * Copyright (c) 2008-2022, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD-style open-source license, see project
 * <a href="https://savage.nps.edu/opendis7-java/license.html" target="_blank">license.html</a> and <a href="https://savage.nps.edu/opendis7-java/license.txt" target="_blank">license.txt</a>
 */

package edu.nps.moves.dis7.utilities;

import edu.nps.moves.dis7.pdus.CreateEntityPdu;
import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.RemoveEntityPdu;

import java.util.ArrayList;
import java.util.List;

/**
 * Manage overall Simulation Management (SIMAN) choreography for a participating application in a DIS channel.
 * <ul>
 * <li> IEEE 1278.1 DIS Application Protocols, 4.6.3.a.5 Timestamp, General Requirements, page 43</li>
 * <li> IEEE 1278.1 DIS Application Protocols, 4.6.3.c.1 Timestamp, Relative Timestamps, page 44</li>
 * <li> IEEE 1278.1 DIS Application Protocols, 5.6 Simulation management, page 89</li>
 * </ul>
 * @see <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/specifications/README.md">MV3500 Distributed Simulation Fundamentals, Specification Documents, IEEE and SISO</a>
 * @see <a href="https://ieeexplore.ieee.org/document/6387564">1278.1-2012. IEEE Standard for Distributed Interactive Simulation (DIS) - Application Protocols</a> 5.6.3 The simulation management computer
 * @see <a href="https://ieeexplore.ieee.org/document/587529">1278.3-1996. IEEE Recommended Practice for Distributed Interactive Simulation - Exercise Management and Feedback</a>
 * @author brutzman
 */
public class SimulationManager 
{
    private        DisThreadedNetworkInterface disThreadedNetworkInterface;
    private static List<RecordType>      entityRecordList = new ArrayList<>();
    private static List<RecordType>        hostRecordList = new ArrayList<>();
    private static List<RecordType> applicationRecordList = new ArrayList<>();
    private        String                           descriptor;
    private static int                                  hostID = 0;
    /** Factory object used to create new PDU instances */
    private PduFactory pduFactory;
    
    private String TRACE_PREFIX = "[" + (SimulationManager.class.getSimpleName()) + "] ";
    
    /**
     * Object constructor with descriptor
     * @param newDescriptor simple descriptor name for this class
     */
    public SimulationManager (String newDescriptor)
    {
        if  (newDescriptor != null)
             descriptor = newDescriptor.trim();
        else descriptor = "";
    }
    /**
     * Object constructor
     */
    public SimulationManager ()
    {
        this("");
    }
    
    /**
     * Start the simulation according to specifications
     */
    public void simulationStart()
    {
        // TODO
    }
    /**
     * Pause the simulation according to specifications
     */
    public void simulationPause()
    {
        // TODO
    }
    /**
     * Resume the simulation according to specifications
     */
    public void simulationResume()
    {
        // TODO
    }
    /**
     * Stop the simulation according to specifications
     */
    public void simulationStop()
    {
        // TODO
    }
    /**
     * An entity can Join the simulation according to specifications
     */
    public void simulationJoin()
    {
        CreateEntityPdu createEntityPdu;
//        createEntityPdu.setExerciseID(123); // TODO
//      createEntityPdu.setPduStatus(); // TODO
        
        if (hasDisThreadedNetworkInterface())
        {
            for (RecordType entity : entityRecordList)
            {
                // TODO set record parameters
                createEntityPdu = pduFactory.makeCreateEntityPdu();
                createEntityPdu.setExerciseID(entity.getId());
                createEntityPdu.setTimestamp(DisTime.getCurrentDisTimestamp());
                disThreadedNetworkInterface.send(createEntityPdu);
            }
        }
        else
        {
            System.err.println(TRACE_PREFIX + "addEntity() unable to send CreateEntityPdu since no disThreadedNetworkInterface found");
            //  TODO consider queue for unsent entities
        }
    }
    /**
     * An entity can Leave the simulation according to specifications
     */
    public void simulationLeave()
    {
        // TODO
    }
    
    /**
     * Simple simulation record type
     */
    public class RecordType
    {
        private int    id          = -1;
        private String name;
        private String alias;
        private String description;
        private String reference;
        private boolean isHostType  = false;
    
        /**
         * Constructor for new record
         * @param id   identifying number
         * @param name common name
         * @param description longer description
         * @param reference   formal reference for this record, if any
         */
        public RecordType (int id, String name, String description, String reference)
        {
            this.id          = id;
            this.name        = name;
            this.description = description;
            this.reference   = reference;
            // TODO create alias: if IP address then check for hostname, and vice versa
        }
        /**
         * Utility constructor for new record, description and reference remain blank
         * @param id   identifying number
         * @param name common name
         */
        public RecordType (int id, String name)
        {
            this.id          = id;
            this.name        = name;
            this.description = "";
            this.reference   = "";
            // TODO create alias: if IP address then check for hostname, and vice versa
        }
        /**
         * Utility constructor for new record, description and reference remain blank
         * @param id   identifying number
         * @param name common name
         * @param isHostType whether or not this record is for a host
         */
        public RecordType (int id, String name, boolean isHostType)
        {
            this.id          = id;
            this.name        = name;
            this.description = "";
            this.reference   = "";
            this.isHostType  = isHostType;
            // TODO create alias: if IP address then check for hostname, and vice versa
        }
        
        /**
         * Simple representation of record
         * @return id,name,"description"
         */
        @Override
        public String toString()
        {
            return "id" + "," + name + ",\"" + description + "\"";
        }

        /**
         * get record id
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * set record id
         * @param newID the id to set
         * @return same object to permit progressive setters
         */
        public RecordType setId(int newID) {
            this.id = newID;
            return this;
        }

        /**
         * get record name
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * set record name
         * @param newName the name to set
         * @return same object to permit progressive setters
         */
        public RecordType setName(String newName) {
            this.name = newName;
            return this;
        }

        /**
         * get record description
         * @return the description
         */
        public String getDescription() {
            return description;
        }

        /**
         * set record description
         * @param newDescription the description to set
         * @return same object to permit progressive setters
         */
        public RecordType setDescription(String newDescription) {
            this.description = newDescription;
            return this;
        }

        /**
         * get record reference
         * @return the reference
         */
        public String getReference() {
            return reference;
        }

        /**
         * set record reference
         * @param newReference the reference to set
         * @return same object to permit progressive setters
         */
        public RecordType setReference(String newReference) {
            this.reference = newReference;
            return this;
        }

        /**
         * get record alias name
         * @return the alias
         */
        public String getAlias() {
            return alias;
        }

        /**
         * set record alias name
         * @param alias the alias to set
         * @return same object to permit progressive setters
         */
        public RecordType setAlias(String alias) {
            this.alias = alias;
            return this;
        }

        /**
         * Does record represent a network address
         * @return whether record is a network address
         */
        public boolean isNetworkAddress() {
            return isHostType;
        }

        /**
         * Set whether record represents a network address
         * @param isAddress the isAddress to set
         */
        public void setNetworkAddress(boolean isAddress) {
            this.isHostType = isAddress;
        }
    }

    /**
     * Get a single entityRecord from list
     * @param index which record to retrieve
     * @return the record matching this index
     */
    public RecordType getEntityRecordByIndex(int index) 
    {
        if (entityRecordList.isEmpty())
        {
            System.err.println ("*** getEntityRecordByIndex list is empty, unable to get index=" + index);
            return null;
        }
        else if (entityRecordList.size() <= index)
        {
            System.err.println ("*** getEntityRecordByIndex list has size=" + entityRecordList.size() + ", unable to get index=" + index);
            return null;
        }
        else if (index < 0)
        {
            System.err.println ("*** getEntityRecordByIndex cannot retrieve illegal index=" + index);
            return null;
        }
        else return entityRecordList.get(index);
    }

    /**
     * Get a single hostRecord from list
     * @param index which record to retrieve
     * @return the record matching this index
     */
    public RecordType getHostRecordByIndex(int index) 
    {
        if (hostRecordList.isEmpty())
        {
            System.err.println ("*** getHostRecordByIndex list is empty, unable to get index=" + index);
            return null;
        }
        else if (hostRecordList.size() <= index)
        {
            System.err.println ("*** getHostRecordByIndex list has size=" + hostRecordList.size() + ", unable to get index=" + index);
            return null;
        }
        else if (index < 0)
        {
            System.err.println ("*** getHostRecordByIndex cannot retrieve illegal index=" + index);
            return null;
        }
        else return hostRecordList.get(index);
    }

    /**
     * Get a single applicationRecord from list
     * @param index which record to retrieve
     * @return the record matching this index
     */
    public RecordType getApplicationRecordByIndex(int index) 
    {
        if (applicationRecordList.isEmpty())
        {
            System.err.println ("*** getApplicationRecordByIndex list is empty, unable to get index=" + index);
            return null;
        }
        else if (applicationRecordList.size() <= index)
        {
            System.err.println ("*** getApplicationRecordByIndex list has size=" + applicationRecordList.size() + ", unable to get index=" + index);
            return null;
        }
        else if (index < 0)
        {
            System.err.println ("*** getApplicationRecordByIndex cannot retrieve illegal index=" + index);
            return null;
        }
        else return applicationRecordList.get(index);
    }

    /**
     * Get a single entityRecord from list matching ID
     * @param valueOfInterest id for record to retrieve
     * @return the record matching this ID
     */
    public RecordType getEntityRecordByID(int valueOfInterest) 
    {
        for (RecordType entity : entityRecordList)
        {
            if (entity.getId() == valueOfInterest)
                return entity;
        }
        System.err.println ("*** getEntityRecordByID cannot find id=" + valueOfInterest);
        return null;
    }
    /**
     * Get a single hostRecord from list matching ID
     * @param valueOfInterest id for record to retrieve
     * @return the record matching this ID
     */
    public RecordType getHostRecordByID(int valueOfInterest) 
    {
        for (RecordType host : hostRecordList)
        {
            if (host.getId() == valueOfInterest)
                return host;
        }
        System.err.println ("*** getHostRecordByID cannot find id=" + valueOfInterest);
        return null;
    }
    /**
     * Get a single applicationRecord from list matching ID
     * @param valueOfInterest id for record to retrieve
     * @return the record matching this ID
     */
    public RecordType getApplicationRecordByID(int valueOfInterest) 
    {
        for (RecordType application : applicationRecordList)
        {
            if (application.getId() == valueOfInterest)
                return application;
        }
        System.err.println ("*** getApplicationRecordByID cannot find id=" + valueOfInterest);
        return null;
    }

    /**
     * Provide entire entityRecordList
     * @return the entityRecordList
     */
    public List<RecordType> getEntityRecordList() {
        return entityRecordList;
    }

    /**
     * Provide entire hostRecordList
     * @return the hostRecordList
     */
    public List<RecordType> getHostRecordList() {
        return hostRecordList;
    }

    /**
     * Provide entire applicationRecordList
     * @return the applicationRecordList
     */
    public List<RecordType> getApplicationRecordList() {
        return applicationRecordList;
    }

    /**
     * Provide access to current disThreadedNetworkInterface
     * @return the disThreadedNetworkInterface
     */
    protected DisThreadedNetworkInterface getDisThreadedNetworkInterface() {
        return disThreadedNetworkInterface;
    }
    /**
     * Set the disThreadedNetworkInterface singleton to match other classes
     * @param disThreadedNetworkInterface the disThreadedNetworkInterface to set
     * @return same object to permit progressive setters
     */
    public SimulationManager setDisThreadedNetworkInterface(DisThreadedNetworkInterface disThreadedNetworkInterface) {
        this.disThreadedNetworkInterface = disThreadedNetworkInterface;
        return this;
    }
    /**
     * Check for disThreadedNetworkInterface
     * @return whether singleton disThreadedNetworkInterface has been instantiated
     */
    protected boolean hasDisThreadedNetworkInterface() 
    {
        return (this.disThreadedNetworkInterface != null);
    }
    /**
     * Create disThreadedNetworkInterface
     */
    protected void createDisThreadedNetworkInterface() 
    {
        createDisThreadedNetworkInterface(descriptor);
    }
    /**
     * Constructor for disThreadedNetworkInterface with descriptor, 
     * using default multicast address and port
     * @param newDescriptor simple descriptor name for this interface
     */
    protected void createDisThreadedNetworkInterface(String newDescriptor) 
    {
        this.disThreadedNetworkInterface = new DisThreadedNetworkInterface(newDescriptor);
    }
    /**
     * Constructor for disThreadedNetworkInterface using specified multicast address and port 
     * @param address the multicast group or unicast address to utilize
     * @param port the multicast port to utilize
     */
    protected void createDisThreadedNetworkInterface(String address, int port) 
    {
        createDisThreadedNetworkInterface(address, port, descriptor);
    }
    /**
     * Constructor for disThreadedNetworkInterface using specified multicast address and port, plus descriptor.
     * @param address the multicast group or unicast address to utilize
     * @param port the multicast port to utilize
     * @param newDescriptor simple descriptor name for this interface
     */
    protected void createDisThreadedNetworkInterface(String address, int port, String newDescriptor) 
    {
        this.disThreadedNetworkInterface = new DisThreadedNetworkInterface(address, port, newDescriptor);
    }
    /**
     * Get simple descriptor (such as parent class name) for this SimulationManager, used in trace statements
     * @return simple descriptor name
     */
    public String getDescriptor() 
    {
        return descriptor;
    }
    /**
     * Set new simple descriptor (such as parent class name) for this SimulationManager, used in trace statements
     * @param newDescriptor simple descriptor name for this interface
     * @return same object to permit progressive setters */
    public SimulationManager setDescriptor(String newDescriptor) 
    {
        if (newDescriptor != null)
            this.descriptor = newDescriptor.trim();
        TRACE_PREFIX = "[" + DisThreadedNetworkInterface.class.getSimpleName() + " " + descriptor + "] ";
        return this;
    }
    /**
     * Reset descriptor 
     * @return same object to permit progressive setters */
    public SimulationManager clearDescriptor()
    {
        setDescriptor("");
        return this;
    }
    /**
     * clear all lists
     * @return same object to permit progressive setters */
    public SimulationManager clearAll() 
    {
        entityRecordList.clear();
        hostRecordList.clear();
        applicationRecordList.clear();
        clearDescriptor();
        return this;
    }
    /**
     * Add entity to simulation list, if this is first occurrence
     * @param newEntityID new entity to add
     * @return same object to permit progressive setters */
    public SimulationManager addEntity(EntityID newEntityID)
    {
        RecordType newEntity = new RecordType(newEntityID.getEntityID(), // short
                                              "TODOname",
                                              "TODO description",
                                              "TODO reference");
        entityRecordList.add(newEntity);
        return this;
    }
    /**
     * Add entity to simulation list and announce using CreateEntityPdu
     * @param newEntity new entity to add
     * @return same object to permit progressive setters */
    public SimulationManager addEntity(RecordType newEntity)
    {
        if (!entityRecordList.contains(newEntity))
        {
            // TODO check record type
            entityRecordList.add(newEntity);
            if (hasDisThreadedNetworkInterface())
            {
                CreateEntityPdu createEntityPdu = pduFactory.makeCreateEntityPdu();
                // TODO set record parameters
                getDisThreadedNetworkInterface().send(createEntityPdu);
            }
            else
            {
                System.err.println(TRACE_PREFIX + "addEntity() unable to send CreateEntityPdu since no disThreadedNetworkInterface found");
                //  TODO consider queue for unsent entities
            }
        }
        return this;
    }
    /**
     * Remove entity from simulation list, if found
     * @param oldEntity old entity to remove
     * @return same object to permit progressive setters */
    public SimulationManager removeEntity(RecordType oldEntity)
    {
        if (!entityRecordList.contains(oldEntity))
        {
            // TODO check record type
            entityRecordList.remove(oldEntity);
            if (hasDisThreadedNetworkInterface())
            {
                RemoveEntityPdu removeEntityPdu = pduFactory.makeRemoveEntityPdu();
                // TODO set record parameters
                getDisThreadedNetworkInterface().send(removeEntityPdu);
            }
            else
            {
                System.err.println(TRACE_PREFIX + "removeEntity() unable to send RemoveEntityPdu since no disThreadedNetworkInterface found");
                //  TODO consider queue for unsent entities
            }
        }
        return this;
    }
    /**
     * Add host to simulation list, if this is first occurrence
     * @param newHost new host to add
     * @return same object to permit progressive setters */
    public SimulationManager addHost(String newHost)
    {
        boolean  nameFound = false;
        boolean aliasFound = false;
        for (RecordType nextRecord : hostRecordList)
        {
            if ( nextRecord.name.equalsIgnoreCase(newHost.trim()))
                 nameFound = true;
            if (nextRecord.alias.equalsIgnoreCase(newHost.trim()))
                aliasFound = true;
            if ((nameFound || aliasFound) && !nextRecord.isHostType)
                 nextRecord.isHostType = true; // make sure
        }
        if (!nameFound && !aliasFound)
        {
            RecordType newRecord = new RecordType(hostID, newHost, true);
            // TODO set alias to IP number
            hostRecordList.add(newRecord);
            hostID++;
            // no PDU sent
        }
        return this;
    }
    /**
     * Remove host from simulation list, if found
     * @param oldHost old host to remove
     * @return same object to permit progressive setters */
    public SimulationManager removeHost(String oldHost)
    {
        boolean  nameFound = false;
        boolean aliasFound = false;
        for (RecordType nextRecord : hostRecordList)
        {
            if ( nextRecord.name.equalsIgnoreCase(oldHost.trim()))
                 nameFound = true;
            if (nextRecord.alias.equalsIgnoreCase(oldHost.trim()))
                aliasFound = true;
            if ((nameFound || aliasFound) && !nextRecord.isHostType)
                 nextRecord.isHostType = true; // make sure
            
            if (nameFound || aliasFound)
            {
                hostRecordList.remove(nextRecord);
                // no PDU sent
                break;
            }
        }
        return this;
    }
    
    /** Self test to check basic operation, invoked by main() */
    public void selfTest()
    {
        createDisThreadedNetworkInterface();
        
        // TODO
        
        disThreadedNetworkInterface.close(); // tears down threads and sockets
    }
    
    /**
     * Main method for testing.
     * @see <a href="https://docs.oracle.com/javase/tutorial/getStarted/application/index.html">Java Tutorials: A Closer Look at the "Hello World!" Application</a>
     * @param args [address, port, descriptor] command-line arguments are an array of optional String parameters that are passed from execution environment during invocation
     */
    public static void main(String[] args)
    {
        System.out.println("*** SimulationManager main() self test started...");
          
        SimulationManager simulationManager = new SimulationManager("main() self test");
        
        simulationManager.setDescriptor("main() self test");
        
        simulationManager.selfTest();
        
        System.out.println("*** SimulationManager main() self test complete.");
    }

    /**
     * @return the pduFactory
     */
    public PduFactory getPduFactory() {
        return pduFactory;
    }

    /**
     * @param pduFactory the pduFactory to set
     */
    public void setPduFactory(PduFactory pduFactory) {
        this.pduFactory = pduFactory;
    }
}
