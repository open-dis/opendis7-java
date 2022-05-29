/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.nps.moves.dis7.utilities;

import edu.nps.moves.dis7.enumerations.VariableRecordType;
import edu.nps.moves.dis7.pdus.CommentPdu;
import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.utilities.stream.PduRecorder;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * DisChannel integrates multiple utility capabilities to handle most  networking and entity-management tasks.
 * Provides a simplified interface wrapping DisThreadedNetworkInterface, PduRecorder and SimulationManager
 * for programs connecting to OpenDis7 communications.
 * TODO future work will confirm that multiple different DisChannel connections can be used simultaneously by a parent program.
 * @author brutzman
 */
public class DisChannel 
{
    private String        descriptor = this.getClass().getSimpleName();
    /**
     * Output prefix to help with logging by identifying this class.
     */
    // might have different DisChannel objects created on different channels, so TRACE_PREFIX is non-static
    private              String TRACE_PREFIX            = "[" + descriptor + "] "; 
    private static       String thisHostName            = "localhost";
    private static final String NETWORK_ADDRESS_DEFAULT = "239.1.2.3";
    private static final int       NETWORK_PORT_DEFAULT = 3000;
    private static final String  DEFAULT_PDULOG_OUTPUT_DIRECTORY = "./pduLog";
    
    protected boolean verboseComments = true;
    String networkAddress = NETWORK_ADDRESS_DEFAULT;
    int       networkPort = NETWORK_PORT_DEFAULT;
    static DisTime.TimestampStyle timestampStyle = DisTime.TimestampStyle.IEEE_ABSOLUTE;
    
    /** Creates DIS Protocol Data Unit (PDU) classes for simulation entities */
    private static PduFactory                       pduFactory;
    
    // class variables
    private DisThreadedNetworkInterface             disNetworkInterface;
            DisThreadedNetworkInterface.PduListener pduListener;
            Pdu                                     receivedPdu;
    private PduRecorder                             pduRecorder;
          
    /* VariableRecordType enumerations have potential use with CommentPdu logs */
    /* TODO contrast to EntityType */
    public final VariableRecordType     descriptionCommentType = VariableRecordType.DESCRIPTION;
    public final VariableRecordType       narrativeCommentType = VariableRecordType.COMPLETE_EVENT_REPORT;
    public final VariableRecordType          statusCommentType = VariableRecordType.APPLICATION_STATUS;
    public final VariableRecordType currentTimeStepCommentType = VariableRecordType.APPLICATION_TIMESTEP;
    
    /** SimulationManager class handles DIS joining, announcing and leaving tasks.
     * It is instantiated here as an object */
    SimulationManager        simulationManager = new SimulationManager();

    /** Base constructor */
    public DisChannel()
    {
        // base constructor is not invoked automatically by other constructors
        // https://stackoverflow.com/questions/581873/best-way-to-handle-multiple-constructors-in-java
        
        initialize();
    }
    /** Constructor with new descriptor
     * @param newDescriptor descriptor for this instance */
    public DisChannel(String newDescriptor)
    {
        descriptor = newDescriptor;
        initialize();
    }
    /** Initialize this class */
    private void initialize()
    {
        DisTime.setTimestampStyle(timestampStyle); // DISTime is a singleton shared class
        pduFactory          = new PduFactory(timestampStyle);
        
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
    /** add entity using SimulationManager
     * @param newEntity new entity to add for announcement by SimulationManager */
    public void addEntity(EntityID newEntity)
    {
        // TODO send simulation management PDUs
        simulationManager.addEntity(newEntity);
    }
    
    /** Join DIS channel using SimulationManager */
    public void join()
    {
        // TODO simulation management PDUs for startup, planning to design special class support 
//        simulationManager.addEntity();
        simulationManager.setDescriptor(descriptor);
        simulationManager.addHost(getThisHostName());
        simulationManager.setDisThreadedNetworkInterface(disNetworkInterface);
        
        simulationManager.simulationJoin();
        simulationManager.simulationStart();
        // TODO consider boolean response indicating if join was successful
    }
    /** Leave DIS channel using SimulationManager */
    public void leave()
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
    public void setTimestampStyle(DisTime.TimestampStyle newTimestampStyle) {
        timestampStyle = newTimestampStyle;
        DisTime.setTimestampStyle(newTimestampStyle);
    }

    /**
     * Initialize network interface, choosing best available network interface
     */
    public void setUpNetworkInterface() 
    {
        if (disNetworkInterface != null)
        {
            printlnTRACE("*** Warning: setUpNetworkInterface() has already created disNetworkInterface, second invocation ignored");
            return;
        }            
        disNetworkInterface = new DisThreadedNetworkInterface(getNetworkAddress(), getNetworkPort());
        getDisNetworkInterface().setDescriptor(descriptor);
        printlnTRACE("Network confirmation:" + " address=" + getDisNetworkInterface().getAddress() + //  disNetworkInterface.getMulticastGroup() +
                                                  " port=" + getDisNetworkInterface().getPort()); // + disNetworkInterface.getDisPort());
        pduListener = new DisThreadedNetworkInterface.PduListener() {
            /** Callback handler for listener */
            @Override
            public void incomingPdu(Pdu newPdu) {
                receivedPdu = newPdu;
            }
        };
        getDisNetworkInterface().addListener(pduListener);
        String pduLogOutputDirectory = DEFAULT_PDULOG_OUTPUT_DIRECTORY;
        printlnTRACE("Beginning pdu save to directory " + pduLogOutputDirectory);
        pduRecorder = new PduRecorder(pduLogOutputDirectory, getNetworkAddress(), getNetworkPort()); // assumes save
        pduRecorder.setEncodingPduLog(PduRecorder.ENCODING_PLAINTEXT);
        pduRecorder.setVerbose(true); // either sending, receiving or both
        pduRecorder.start(); // begin running
    }

    /** All done, release network resources */
    public void tearDownNetworkInterface() {
        getPduRecorder().stop(); // handles disNetworkInterface.close(), tears down threads and sockets
    }

    /** 
     * Send a single Protocol Data Unit (PDU) of any type
     * @param pdu the pdu to send
     */
    public void sendSinglePdu(Pdu pdu)
    {
        if (getDisNetworkInterface() == null)
            setUpNetworkInterface(); // ensure connected
        try
        {
            getDisNetworkInterface().send(pdu);
            Thread.sleep(100); // TODO consider refactoring the wait logic and moving externally
        } 
        catch (InterruptedException ex)
        {
            System.err.println(this.getClass().getSimpleName() + " Error sending PDU: " + ex.getLocalizedMessage());
            System.exit(1);
        }
    }
    /**
     * Send Comment PDU
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html">Passing Information to a Method or a Constructor</a> Arbitrary Number of Arguments
     * @param commentType    enumeration value describing purpose of the narrative comment
     * @param comments       String array of narrative comments
     */
    public void sendCommentPdu(VariableRecordType commentType,
                                     // vararg... variable-length set of String comments can optionally follow
                                        String... comments)
    {
        if ((comments != null) && (comments.length > 0))
        {
            ArrayList<String> newCommentsList = new ArrayList<>();
            for (String comment : comments)
            {
                if (!comment.isEmpty())
                {
                    newCommentsList.add(comment); // OK found something to send
                }
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
                sendSinglePdu(commentPdu);
                if (isVerboseComments())
                {
                    printlnTRACE("*** [CommentPdu narrative sent: " + commentType.name() + "] " + newCommentsList.toString());
                    System.out.flush();
                }
            }
        }
    }

    /**
     * test for verboseComments mode
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
    public PduFactory getPduFactory() {
        if (pduFactory == null)
            pduFactory = new PduFactory(timestampStyle);
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
}
