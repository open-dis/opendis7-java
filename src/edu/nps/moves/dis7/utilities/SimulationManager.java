/*
Copyright (c) 1995-2022 held by the author(s).  All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer
      in the documentation and/or other materials provided with the
      distribution.
    * Neither the names of the Naval Postgraduate School (NPS)
      Modeling Virtual Environments and Simulation (MOVES) Institute
      https://www.nps.edu and https://www.nps.edu/web/moves
      nor the names of its contributors may be used to endorse or
      promote products derived from this software without specific
      prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
*/
// TODO move into opendis7 distribution tree

package edu.nps.moves.dis7.utilities;

import edu.nps.moves.dis7.pdus.CreateEntityPdu;
import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.RemoveEntityPdu;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.DisTime;
import java.util.ArrayList;

/**
 * Manage overall Simulation Management (SIMAN) choreography for a DIS channel participant.
 * TODO once operation is working satisfactorily, this class will be moved into the opendis7-java distribution utilities.
 * @see <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/specifications/README.md" target="_blank">Networked Graphics MV3500, Specification Documents, IEEE and SISO</a>
 * @see <a href="https://ieeexplore.ieee.org/document/6387564" target="_blank">1278.1-2012. IEEE Standard for Distributed Interactive Simulation (DIS) - Application Protocols</a> 5.6.3 The simulation management computer
 * @see <a href="https://ieeexplore.ieee.org/document/587529" target="_blank">1278.3-1996. IEEE Recommended Practice for Distributed Interactive Simulation - Exercise Management and Feedback</a>
 * @see IEEE 1278.1 DIS Application Protocols, 4.6.3.a.5 Timestamp, General Requirements, page 43
 * @see IEEE 1278.1 DIS Application Protocols, 4.6.3.c.1 Timestamp, Relative Timestamps, page 44
 * @see IEEE 1278.1 DIS Application Protocols, 5.6 Simulation management, page 89
 * @author brutzman
 */
public class SimulationManager 
{
    private        DisThreadedNetworkInterface disThreadedNetworkInterface;
    private static ArrayList<RecordType>      entityRecordList = new ArrayList<>();
    private static ArrayList<RecordType>        hostRecordList = new ArrayList<>();
    private static ArrayList<RecordType> applicationRecordList = new ArrayList<>();
    private        String                           descriptor = new String();
    private static int                                  hostID = 0;
    
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
        CreateEntityPdu createEntityPdu = new CreateEntityPdu();
        createEntityPdu.setExerciseID(123); // TODO
//      createEntityPdu.setPduStatus(); // TODO
        
        if (hasDisThreadedNetworkInterface())
        {
            for (RecordType entity : entityRecordList)
            {
                // TODO set record parameters
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
        private String name        = new String();
        private String alias       = new String();
        private String description = new String();
        private String reference   = new String();
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
    public ArrayList<RecordType> getEntityRecordList() {
        return entityRecordList;
    }

    /**
     * Provide entire hostRecordList
     * @return the hostRecordList
     */
    public ArrayList<RecordType> getHostRecordList() {
        return hostRecordList;
    }

    /**
     * Provide entire applicationRecordList
     * @return the applicationRecordList
     */
    public ArrayList<RecordType> getApplicationRecordList() {
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
        this.disThreadedNetworkInterface = new DisThreadedNetworkInterface(descriptor);
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
        this.disThreadedNetworkInterface = new DisThreadedNetworkInterface(address, port, descriptor);
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
                CreateEntityPdu createEntityPdu = new CreateEntityPdu();
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
                RemoveEntityPdu removeEntityPdu = new RemoveEntityPdu();
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
}
