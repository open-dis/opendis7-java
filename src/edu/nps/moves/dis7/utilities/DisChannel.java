/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD-style open-source license, see project
 * <a href="https://savage.nps.edu/opendis7-java/license.html" target="_blank">license.html</a> and <a href="https://savage.nps.edu/opendis7-java/license.txt" target="_blank">license.txt</a>
 */
package edu.nps.moves.dis7.utilities;

import edu.nps.moves.dis7.enumerations.VariableRecordType;
import edu.nps.moves.dis7.pdus.CommentPdu;
import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.utilities.SimulationManager.RecordType;
import edu.nps.moves.dis7.utilities.stream.PduRecorder;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DisChannel integrates multiple utility capabilities to handle most  networking and entity-management tasks.
 * Provides a simplified interface wrapping DisThreadedNetworkInterface, PduRecorder, and SimulationManager
 * for programs connecting to OpenDis7 communications.  This lets library users avoid handling of network threads.
 * <br>
 * TODO future work will confirm that multiple different DisChannel connections can be used simultaneously by a parent program.
 * @see <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/specifications/README.md">MV3500 Distributed Simulation Fundamentals, Specification Documents, IEEE and SISO</a>
 * @see <a href="https://ieeexplore.ieee.org/document/6387564">1278.1-2012. IEEE Standard for Distributed Interactive Simulation (DIS) - Application Protocols</a>
 * @author brutzman
 */
public class DisChannel
{
    /**
     * Output prefix to help with logging by identifying this class.
     */
    protected String        descriptor = this.getClass().getSimpleName();
    // might have different DisChannel objects created on different channels, so TRACE_PREFIX is non-static
    private              String TRACE_PREFIX            = "[" + descriptor + "] ";
    private static       String thisHostName            = "localhost";
    private static final String NETWORK_ADDRESS_DEFAULT = "239.1.2.3";
    private static final int       NETWORK_PORT_DEFAULT = 3000;
    /** default directory for PDULOG files */
    protected static final String  DEFAULT_PDULOG_OUTPUT_DIRECTORY = "./pduLog";

    /** whether or not verbose comments are provided */
    private boolean verboseComments = true;
    String networkAddress = NETWORK_ADDRESS_DEFAULT;
    int       networkPort = NETWORK_PORT_DEFAULT;
    static DisTime.TimestampStyle timestampStyle = DisTime.TimestampStyle.IEEE_ABSOLUTE;

    /** Creates DIS Protocol Data Unit (PDU) classes for simulation entities */
    private static PduFactory                       pduFactory;

    // class variables
    /** Common thread-safe interface for low-level networking */
    protected DisThreadedNetworkInterface             disNetworkInterface;
    /** Common thread-safe interface for listening */
              DisThreadedNetworkInterface.PduListener pduListener;
    /** our latest received PDU, of whatever pduType */
    Pdu                                               receivedPdu;
    /** utility class for recording PDUs */
    protected PduRecorder                             pduRecorder;
    private boolean                                 verboseDisNetworkInterface = true;
    private boolean                                 verbosePduRecorder         = true;

    /** CommentPdu type providing a description, used for consistent reporting and logging. */
    public final static VariableRecordType COMMENTPDU_DESCRIPTION            = VariableRecordType.DESCRIPTION;

    /** CommentPdu type providing an event report, used for consistent reporting and logging. */
    public final static VariableRecordType COMMENTPDU_NARRATIVE              = VariableRecordType.COMPLETE_EVENT_REPORT;

    /** CommentPdu type providing simulation program status, used for consistent reporting and logging. */
    public final static VariableRecordType COMMENTPDU_APPLICATION_STATUS      = VariableRecordType.APPLICATION_STATUS;

    /** CommentPdu type documenting current elapsed time, used for consistent reporting and logging. */
    public final static VariableRecordType COMMENTPDU_ELAPSED_TIME            = VariableRecordType.ELAPSED_TIME;

    /** CommentPdu type documenting simulation program timestep, used for consistent reporting and logging. */
    public final static VariableRecordType COMMENTPDU_SIMULATION_TIMESTEP     = VariableRecordType.APPLICATION_TIMESTEP;

    /** CommentPdu type documenting simulation program time, used for consistent reporting and logging. */
    public final static VariableRecordType COMMENTPDU_TIME     = VariableRecordType.TIME;

    /** CommentPdu type documenting current waypoint number, used for consistent reporting and logging. */
    public final static VariableRecordType COMMENTPDU_CURRENT_WAYPOINT_NUMBER = VariableRecordType.CURRENT_WAYPOINT_NUMBER;

    // TODO additional pecial Simkit COMMENTPDU types

    /** SimulationManager class handles DIS joining, announcing and leaving tasks.
     * It is instantiated here as an object */
    private SimulationManager simulationManager;

    /** Base constructor */
    public DisChannel()
    {
        // base constructor is not invoked automatically by other constructors
        // https://stackoverflow.com/questions/581873/best-way-to-handle-multiple-constructors-in-java
        initialize();
    }

    /** Constructor with new descriptor
     * @param initialDescriptor descriptor for this instance */
    public DisChannel(String initialDescriptor)
    {
        this();
        descriptor = initialDescriptor;
    }

    /** Constructor with new verboseness
     * @param verbosenessDisNetworkInterface  whether channel is initially verbose
     * @param verbosenessPduRecorder      whether PduRecorder is initially verbose */
    public DisChannel(boolean verbosenessDisNetworkInterface, boolean verbosenessPduRecorder)
    {
        this();
        verboseDisNetworkInterface = verbosenessDisNetworkInterface;
        verbosePduRecorder         = verbosenessPduRecorder;
    }

    /** Constructor with new descriptor, verboseness
     * @param initialDescriptor descriptor for this instance
     * @param verbosenessDisNetworkInterface  whether channel is initially verbose
     * @param verbosenessPduRecorder whether PduRecorder is initially verbose  */
    public DisChannel(String initialDescriptor, boolean verbosenessDisNetworkInterface, boolean verbosenessPduRecorder)
    {
        this(initialDescriptor);
        verboseDisNetworkInterface = verbosenessDisNetworkInterface;
        verbosePduRecorder         = verbosenessPduRecorder;
    }

    /** Initialize this class. Will only be called once per object instantiation */
    private void initialize()
    {
        DisTime.setTimestampStyle(timestampStyle); // DISTime is a singleton shared class
        pduFactory        = DisTime.getPduFactory();
        simulationManager = new SimulationManager();
        simulationManager.setPduFactory(pduFactory);

        try
        {
            thisHostName = InetAddress.getLocalHost().getHostName();
            printlnTRACE("thisHostName=" + thisHostName);
        }
        catch (UnknownHostException uhe)
        {
            printlnTRACE(thisHostName + " is not connected to network: " + uhe.getMessage());
        }
    }

    /** Add entity using SimulationManager
     * @param newEntity new entity to add with announcement by SimulationManager */
    public synchronized void addEntity(EntityID newEntity)
    {
        // TODO send simulation management PDUs
        simulationManager.addEntity(newEntity);
    }
    
    /** Remove entity using SimulationManager
     * @param entity entity to remove with announcement by SimulationManager */
    public synchronized void removeEntity(EntityID entity)
    {   
        RecordType rt = simulationManager.getEntityRecordByID(entity.getEntityID());
        
        // TODO send simulation management PDUs
        simulationManager.removeEntity(rt);
    }

    /** Join DIS channel using SimulationManager */
    public synchronized void join()
    {
        // TODO simulation management PDUs for startup, planning to design special class support
        simulationManager.setDescriptor(descriptor);
        simulationManager.addHost(getThisHostName());
        simulationManager.setDisThreadedNetworkInterface(disNetworkInterface);

        simulationManager.simulationJoin();
        simulationManager.simulationStart();
        // TODO consider boolean response indicating if join was successful
    }

    /** Leave DIS channel using SimulationManager */
    public synchronized void leave()
    {
        // TODO send simulation management PDUs
        simulationManager.simulationStop();
        simulationManager.simulationLeave();
        // TODO consider boolean response indicating if leave was successful
    }

    /**
     * get current networkAddress as a string
     * @return the networkAddress
     */
    public String getNetworkAddress() {
        return networkAddress;
    }

    /**
     * set current networkAddress using a string
     * @param newNetworkAddress the networkAddress to set
     */
    public final void setNetworkAddress(String newNetworkAddress) {
        this.networkAddress = newNetworkAddress;
    }

    /**
     * get current networkPort
     * @return the networkPort
     */
    public int getNetworkPort() {
        return networkPort;
    }

    /**
     * set current networkPort
     * @param newNetworkPort the networkPort to set
     */
    public final void setNetworkPort(int newNetworkPort) {
        this.networkPort = newNetworkPort;
    }

    /**
     * Get timestampStyle used by PduFactory
     * @return current timestampStyle
     */
    public DisTime.TimestampStyle getTimestampStyle() {
        return timestampStyle;
    }

    /**
     * Set timestampStyle used by PduFactory
     * @param newTimestampStyle the timestampStyle to set
     */
    public synchronized void setTimestampStyle(DisTime.TimestampStyle newTimestampStyle) {
        timestampStyle = newTimestampStyle;
        DisTime.setTimestampStyle(newTimestampStyle);
    }

    /**
     * Initialize network interface, choosing best available network interface.  Singleton pattern.
     */
    public synchronized void setUpNetworkInterface()
    {
        if (disNetworkInterface != null)
        {
            printlnTRACE("*** Warning: setUpNetworkInterface() has already created disNetworkInterface, second invocation ignored");
            return;
        }
        
        String pduLogOutputDirectory = DEFAULT_PDULOG_OUTPUT_DIRECTORY;
        printlnTRACE("Beginning pdu save to directory " + pduLogOutputDirectory);
        pduRecorder = new PduRecorder(pduLogOutputDirectory, getNetworkAddress(), getNetworkPort()); // assumes save
        pduRecorder.setEncodingPduLog(PduRecorder.ENCODING_PLAINTEXT);
        pduRecorder.setDescriptor(descriptor); // also sets for the DisThreadedNetworkInterface
        pduRecorder.setVerbose(isVerboseDisNetworkInterface()); // either sending, receiving or both. Also sets for the DisThreadedNetworkInterface
        pduRecorder.start(); // begin running which also starts a DisThreadedNetworkInterface instance with the given network address and port
        
        disNetworkInterface = pduRecorder.getDisThreadedNetworkInterface();
        if (isVerbosePduRecorder())
            printlnTRACE("Network confirmation:" + " address=" + getDisNetworkInterface().getAddress() + //  disNetworkInterface.getMulticastGroup() +
                                                      " port=" + getDisNetworkInterface().getPort());    // + disNetworkInterface.getDisPort());
        
        /* Callback handler for listener (Not used) */
        pduListener = (Pdu newPdu) -> {
            receivedPdu = newPdu;
        };
        getDisNetworkInterface().addListener(pduListener);
    }

    /** All done, release network resources */
    public synchronized void tearDownNetworkInterface()
    {
        if (pduListener != null)
            getDisNetworkInterface().removeListener(pduListener);

        getPduRecorder().stop();     // handles disNetworkInterface.close(), tears down threads and sockets
    }

    /**
     * Send a single Protocol Data Unit (PDU) of any type, using timestamp value already provided in PDU
     * @param pdu the pdu to send
     */
    public synchronized void sendSinglePdu(Pdu pdu)
    {
        if (getDisNetworkInterface() == null)
            setUpNetworkInterface(); // ensure connected
        try
        {
            getDisNetworkInterface().sendPDU(pdu);
            // https://stackoverflow.com/questions/10663920/calling-thread-sleep-from-synchronized-context-in-java
            // https://stackoverflow.com/questions/1036754/difference-between-wait-vs-sleep-in-java
            wait(100); // TODO consider wait() instead of sleep()
            // TODO consider refactoring the wait logic and moving externally// TODO consider wait() instead of sleep()
        }
        catch (InterruptedException ex)
        {
            System.err.println(this.getClass().getSimpleName() + " Error sending PDU: " + ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    /**
     * Send a single Protocol Data Unit (PDU) of any type, after setting the PDU with given timestamp in seconds
     * @param timestampSeconds timestamp to set for this PDU, seconds since epoch
     * @param pdu the pdu to send
     */
    public synchronized void sendSinglePdu(double timestampSeconds, Pdu pdu)
    {
        pdu.setTimestampSeconds(timestampSeconds);
        sendSinglePdu(pdu);
    }
    
    /**
     * Send a single Protocol Data Unit (PDU) of any type following a real-time delay
     * @param pdu the pdu to send
     * @param delayTimeMilliseconds delay before sending
     */
    public synchronized void sendSinglePduDelayed(Pdu pdu, long delayTimeMilliseconds)
    {
        // https://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java
        Timer timer = new Timer();

        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                sendSinglePdu(pdu);
            }
        }, delayTimeMilliseconds);
    }

    /**
     * Send Comment PDU using given DIS time in seconds, after setting the PDU with given timestamp in seconds
     * @param timestampSeconds timestamp to set for this PDU, seconds since epoch
     * @param commentType      enumeration value describing purpose of the narrative comment
     * @param comments         String array of narrative comments
     * @return constructed CommentPdu if sent, null otherwise
     * @see VariableRecordType for other potential CommentPdu type enumerations.
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html">Passing Information to a Method or a Constructor</a> Arbitrary Number of Arguments
     */
    public synchronized CommentPdu sendCommentPdu(double timestampSeconds,
                         VariableRecordType commentType,
                               // vararg... variable-length set of String comments can optionally follow
                                  String... comments)
    {
        if ((comments != null) && (comments.length > 0))
        {
            List<String> newCommentsList = new ArrayList<>();
            for (String comment : comments)
            {
                if ((comment != null) && !comment.isEmpty())
                {
                    newCommentsList.add(comment); // OK found something to send
                }
            }
            if (newCommentsList.isEmpty() && (commentType != null))
            {
                return null; // no CommentPdu sent
            }
            if (!newCommentsList.isEmpty())
            {
                if (getDisNetworkInterface() == null)
                    setUpNetworkInterface(); // ensure connected

                if (commentType == null)
                    commentType = VariableRecordType.OTHER; // fallback value; TODO consider pushing into pduFactory
                // now build the commentPdu from these string inputs, thus constructing a narrative entry
                @SuppressWarnings("CollectionsToArray")
                CommentPdu commentPdu = getPduFactory().makeCommentPdu(commentType, newCommentsList.toArray(new String[0])); // comments);
                commentPdu.setTimestampSeconds(timestampSeconds);

                try {
                    // Padding for the VariableDatum records can not be determined until the PDU has been marshalled.
                    // Therefore, marshalled size is not correct until after marshalling
                    commentPdu.marshal(ByteBuffer.allocate(1500));
                    commentPdu.setLength(commentPdu.getMarshalledSize());
                } catch (Exception ex) {
                    Logger.getLogger(DisChannel.class.getName()).log(Level.SEVERE, null, ex);
                }

                sendSinglePdu(commentPdu);
                if (isVerboseComments()) // narrative report
                {
                    printlnTRACE("*** [CommentPdu " + commentType.name() + "] " + newCommentsList.toString());
                    System.out.flush();
                }
                newCommentsList.clear();
                return commentPdu;
            }
        }
        return null;
    }

    /**
     * Send Comment PDU using current DIS timestamp
     * @param commentType      enumeration value describing purpose of the narrative comment
     * @param comments         String array of narrative comments
     * @return constructed CommentPdu if sent, null otherwise
     * @see VariableRecordType for other potential CommentPdu type enumerations.
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html">Passing Information to a Method or a Constructor</a> Arbitrary Number of Arguments
     */
    public synchronized CommentPdu sendCommentPdu(VariableRecordType commentType,
                                     // vararg... variable-length set of String comments can optionally follow
                                        String... comments)
    {
        return sendCommentPdu(DisTime.getCurrentDisTimestamp(), commentType, comments);
    }

    /**
     * Send Comment PDU following time delay
     * @param commentType    enumeration value describing purpose of the narrative comment
     * @param delayTimeMilliseconds delay before sending
     * @param comments       String array of narrative comments
     * @see VariableRecordType for other potential CommentPdu type enumerations.
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html">Passing Information to a Method or a Constructor</a> Arbitrary Number of Arguments
     */
    public synchronized void sendCommentPduDelayed(VariableRecordType commentType,
                                      long delayTimeMilliseconds,
                                      // vararg... variable-length set of String comments can optionally follow
                                      String... comments)
    {
        // https://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java
        Timer timer = new Timer();

        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                sendCommentPdu(commentType, comments);
            }
        }, delayTimeMilliseconds);
    }

    /**
     * whether in verboseComments mode
     * @return whether verboseComments mode is enabled
     */
    public boolean isVerboseComments() {
        return verboseComments;
    }

    /**
     * set verboseComments mode
     * @param newVerboseComments whether verboseComments mode is enabled
     */
    public void setVerboseComments(boolean newVerboseComments) {
        this.verboseComments = newVerboseComments;
    }

    /**
     * Get prefix string used in trace messages
     * @return the TRACE_PREFIX
     */
    public String getTRACE_PREFIX() {
        return TRACE_PREFIX;
    }

    /**
     * Set prefix string used in trace messages
     * @param newTRACE_PREFIX the TRACE_PREFIX to set
     */
    public final void setTRACE_PREFIX(String newTRACE_PREFIX) {
        if  (newTRACE_PREFIX == null)
             newTRACE_PREFIX = "";
        if  (newTRACE_PREFIX.isBlank())
             TRACE_PREFIX = "[" + DisThreadedNetworkInterface.class.getSimpleName()                    + "] ";
        else if (newTRACE_PREFIX.contains(this.getClass().getSimpleName()))
             TRACE_PREFIX = "[" + newTRACE_PREFIX + "] ";
        else TRACE_PREFIX = "[" + this.getClass().getSimpleName() + " " + newTRACE_PREFIX + "] ";
    }

    /**
     * Print message with TRACE_PREFIX prepended
     * @param message String to print
     */
    public void printTRACE(String message) {
        System.out.print(TRACE_PREFIX + message);
    }
    
    /**
     * Print message with TRACE_PREFIX prepended
     * @param message String to print
     */
    public void printlnTRACE(String message) {
        System.out.println(TRACE_PREFIX + message);
    }

    /**
     * Get link to an already-created PduFactory
     * @return the pduFactory, simplifying program imports and configuration
     */
    public PduFactory getPduFactory()
    {
        // static singleton creation is performed in constructor, being careful here
        if (pduFactory == null)
            pduFactory = DisTime.getPduFactory();
        return pduFactory;
    }

    /**
     * Get reference to current singleton DisThreadedNetworkInterface
     * @return the disNetworkInterface
     */
    public DisThreadedNetworkInterface getDisNetworkInterface() {
        return disNetworkInterface;
    }

    /**
     * Get current host name
     * @return the thisHostName
     */
    public static String getThisHostName() {
        return thisHostName;
    }

    /**
     * Override and set current host name
     * @param aThisHostName the thisHostName to set
     */
    public static void setThisHostName(String aThisHostName) {
        thisHostName = aThisHostName;
    }

    /**
     * Get link to an already-created PduRecorder connected to current disThreadedInterface
     * @return the pduRecorder
     */
    public PduRecorder getPduRecorder() {
        return pduRecorder;
    }

    /**
     * Get simple descriptor (such as parent class name) for this network interface, used in trace statements
     * @return simple descriptor name
     */
    public String getDescriptor() {
        return descriptor;
    }

    /**
     * Set new simple descriptor (such as parent class name) for this network interface, used in trace statements
     * @param newDescriptor simple descriptor name for this interface
     */
    public void setDescriptor(String newDescriptor) {
        // might have different DisChannel objects created on different channels, so descriptor is non-static
        if (newDescriptor == null)
            newDescriptor = "";
        this.descriptor = newDescriptor;
        setTRACE_PREFIX(descriptor);
        if (disNetworkInterface != null)
            disNetworkInterface.setDescriptor(descriptor);
        if (simulationManager != null)
            simulationManager.setDescriptor(descriptor);
    }

    /**
     * Get whether DisNetworkInterface setting is verbose
     * @return the verboseDisNetworkInterface
     */
    public boolean isVerboseDisNetworkInterface() {
        return verboseDisNetworkInterface;
    }

    /**
     * Set whether DisNetworkInterface setting is verbose
     * @param verboseDisNetworkInterface the verboseDisNetworkInterface to set
     */
    public void setVerboseDisNetworkInterface(boolean verboseDisNetworkInterface) {
        this.verboseDisNetworkInterface = verboseDisNetworkInterface;
        if (disNetworkInterface != null)
            disNetworkInterface.setVerbose(verboseDisNetworkInterface);
    }

    /**
     * Get whether PduRecorder setting is verbose
     * @return the verbosePduRecorder
     */
    public boolean isVerbosePduRecorder() {
        return verbosePduRecorder;
    }

    /**
     * Set whether PduRecorder setting is verbose
     * @param verbosePduRecorder the verbosePduRecorder to set
     */
    public void setVerbosePduRecorder(boolean verbosePduRecorder) {
        this.verbosePduRecorder = verbosePduRecorder;
        if (pduRecorder != null)
            pduRecorder.setVerbose(verbosePduRecorder);
    }
}
