/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html or license.txt
 * @author brutzman@nps.edu
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.entities.swe.platform.surface._001Poseidon;
import edu.nps.moves.dis7.entities.swe.platform.surface._002Triton;
import edu.nps.moves.dis7.enumerations.*;
import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.utilities.DisChannel;
import edu.nps.moves.dis7.utilities.PduFactory;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/** The purpose of this inheritable class is to provide an easily modifiable 
 *  example simulation program that includes DIS-capable entities performing 
 *  tasks of interest, and then reporting activity via PDUs to the network.
 *  Default program initialization includes PDU recording turned on by default.
 *  @see <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/examples/src/OpenDis7Examples/ExampleSimulationProgramLog.txt" target="_blank">ExampleSimulationProgramLog.txt</a>
 *  @see <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/examples/src/OpenDis7Examples/ExampleSimulationProgramPduCaptureLog.dislog" target="_blank">ExampleSimulationProgramPduCaptureLog.dislog</a>
 *  @see <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/examples/src/OpenDis7Examples/ExampleSimulationProgramFlowDiagram.pdf" target="_blank">ExampleSimulationProgramFlowDiagram.pdf</a>
 *  @see <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/examples/src/OpenDis7Examples/ExampleSimulationProgramWireshark.png" target="_blank">ExampleSimulationProgramWireshark.png</a>
 *  @see <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/examples/src/OpenDis7Examples/ExampleSimulationProgramSequenceDiagram.png" target="_blank">ExampleSimulationProgramSequenceDiagram.png</a>
 */
public class ExampleSimulationProgram
{
    /* **************************** infrastructure code, modification is seldom needed ************************* */
                 
    private   String     descriptor = this.getClass().getSimpleName();
    /** DIS channel defined by network address/port combination includes multiple utility capabilities */
    protected DisChannel disChannel;
    /** Factory object used to create new PDU instances */
    protected PduFactory pduFactory;
    
    /** seconds per loop for real-time or simulation execution */
    private double  simulationTimeStepDuration  =  1.0; // seconds TODO encapsulate
    /** initial simulation time in seconds */
    double  simulationTimeInitial = 0.0;
    /** current simulation time in seconds */
    double  simulationTimeSeconds = simulationTimeInitial;
    /** Maximum number of simulation loops */
    int MAX_LOOP_COUNT = 4;
    
    String narrativeMessage1 = new String();
    String narrativeMessage2 = new String();
    String narrativeMessage3 = new String();
    
    /** EntityID settings for entity 1 */
    protected EntityID           entityID_1          = new EntityID();
    /** EntityID settings for entity 2 */
    protected EntityID           entityID_2          = new EntityID();
    /** EntityID settings for entity 3, a potential third-party observer and after-action reporter */
    protected EntityID           entityID_3          = new EntityID();
    
    /** ESPDU for entity 1 */
    protected EntityStatePdu     entityStatePdu_1;
    /** ESPDU for entity 2 */
    protected EntityStatePdu     entityStatePdu_2;
    /** FirePdu for entity 1 first  weapon (if any) */
    protected FirePdu            firePdu_1a;
    /** FirePdu for entity 1 second weapon (if any) */
    protected FirePdu            firePdu_1b;
    /** MunitionDescriptor for these weapons */
    protected MunitionDescriptor munitionDescriptor1;
    
    /** TODO DetonationPdu for entity 1 second weapon (if any) */
    protected DetonationPdu            detonationPdu_1a;
    /** TODO DetonationPdu for entity 1 second weapon (if any) */
    protected DetonationPdu            detonationPdu_1b;
    
    // hey programmer, what other state do you want?  this is a good place to declare it...
    
    /**
     * Constructor to create an instance of this class.
     * Design goal: additional built-in initialization conveniences can go here
     * to keep your efforts focused on the runSimulation() method.
     */
    // base constructor is not invoked automatically by other constructors
    // https://stackoverflow.com/questions/581873/best-way-to-handle-multiple-constructors-in-java
    public ExampleSimulationProgram()
    {
        initialize();
    }
    /**
     * Constructor to create an instance of this class.
     * @param newDescriptor describes this program, useful for logging and debugging
     */
    public ExampleSimulationProgram(String newDescriptor)
    {
        descriptor = newDescriptor;
        initialize();
    }
    /**
     * Utility Constructor that allows your example simulation program to override default network address and port
     * @param address network address to use
     * @param port corresponding network port to use
     */
    public ExampleSimulationProgram(String address, int port)
    {
        disChannel.setNetworkAddress            (address);
        disChannel.setNetworkPort               (port);
        disChannel.setVerboseComments           (true);       // TODO rename library method to disambiguate CommentPDU
                                                                            // TODO still seems really chatty... add silent mode?
        disChannel.setVerboseDisNetworkInterface(true);  // Default false
        disChannel.setVerbosePduRecorder        (true);       // default false
        initialize();
    }
    
    /** Initialize channel setup for OpenDis7 and report a test PDU
     * @see initializeDisChannel
     * @see initializeSimulationEntities */
    private void initialize()
    {
        initializeDisChannel(); // must come first, uses PduFactory
        
        initializeSimulationEntities(); // set unchanging parameters
        
        disChannel.join(); // TODO further functionality expected
        
        String timeStepMessage = "Simulation timestep duration " + getSimulationTimeStepDuration() + " seconds";
        disChannel.sendCommentPdu(simulationTimeSeconds, DisChannel.COMMENTPDU_SIMULATION_TIMESTEP, timeStepMessage);
        // additional constructor initialization can go here
    }
    
    /** Initialize channel setup for OpenDis7 and report a test PDU */
    private void initializeDisChannel()
    {
        if (disChannel == null)
            disChannel = new DisChannel();
        else
        {
            disChannel.printlnTRACE ("*** warning, duplicate invocation of initializeDisChannel() ignored");
            return;
        }
        pduFactory     = disChannel.getPduFactory();
        disChannel.setDescriptor(this.getClass().getSimpleName()); // ExampleSimulationProgram might be a superclass
        disChannel.setUpNetworkInterface();
        disChannel.printlnTRACE ("just checking: disChannel.getNetworkAddress()=" + disChannel.getNetworkAddress() +
                                                         ", getNetworkPort()="    + disChannel.getNetworkPort());
        disChannel.getDisNetworkInterface().setVerbose(true); // sending and receipt
        disChannel.printlnTRACE ("just checking: hasVerboseSending()=" + disChannel.getDisNetworkInterface().hasVerboseSending() +
                                              ", hasVerboseReceipt()=" + disChannel.getDisNetworkInterface().hasVerboseReceipt());
        disChannel.getPduRecorder().setVerbose(true);

        // TODO confirm whether recorder is explicitly started by programmer (or not)
        
//      disChannel.sendCommentPdu(VariableRecordType.OTHER, "DisThreadedNetworkInterface.initializeDisChannel() complete"); // hello channel, debug
    }
    
    /** Get ready, get set... initialize simulation entities.  Who's who in the zoo?
     */
    public void initializeSimulationEntities()
    {        
        if (pduFactory == null)
            pduFactory      = disChannel.getPduFactory();
        entityStatePdu_1    = pduFactory.makeEntityStatePdu();
        entityStatePdu_2    = pduFactory.makeEntityStatePdu();
        firePdu_1a          = pduFactory.makeFirePdu();
        firePdu_1b          = pduFactory.makeFirePdu();
        munitionDescriptor1 = new MunitionDescriptor();
        
        // can a third party report their independent (non-entity) status of a detonation? yes...
        // if this is a third-party report, then that third party will need an independent EntityID
        detonationPdu_1a    = pduFactory.makeDetonationPdu();
        detonationPdu_1a.setSourceEntityID(entityID_3);
        
        // Your model setup: define participants.  who's who in this zoo?
        // Assuming you keep track of entity objects...  here is some support for for Entity 1.
        
        // PDU objects are already declared and instances created, so now set their values.
        // who is who in our big zoo, sufficient for global participation if we need it
        entityID_1.setSiteID(1).setApplicationID(2).setEntityID(3); // made-up example ID;
        disChannel.addEntity(entityID_1);
        
        entityID_2.setSiteID(1).setApplicationID(2).setEntityID(4); // made-up example ID; 
        disChannel.addEntity(entityID_2);
        // TODO someday, use enumerations for sites as part of a SimulationManager object; e.g. is there a unique site triplet for MOVES Institute?

        entityStatePdu_1.setEntityID(entityID_1);
        entityStatePdu_1.setForceId(ForceID.FRIENDLY);
        entityStatePdu_1.setEntityType(new _001Poseidon());       // note import statement above
//      entityStatePdu_1.setMarking("Entity #1");
        entityStatePdu_1.setEntityType(new edu.nps.moves.dis7.entities.usa.platform.air.MV22B()); // note import statement at top
        entityStatePdu_1.setMarking("Entity #53");
        entityStatePdu_1.getMarkingString(); // use Netbeans Debug breakpoint here to check left justified...

        entityStatePdu_2.setEntityID(entityID_2);
        entityStatePdu_2.setForceId(ForceID.OPPOSING);
        entityStatePdu_2.setEntityType(new _002Triton()); // note import statement above
        entityStatePdu_2.setMarking("Entity #2");

        // TODO how should we customize this munition?  what are key parameters for your simulation? 
        // more is needed here by scenario authors...
        munitionDescriptor1.setQuantity(1);
        firePdu_1a.setDescriptor(munitionDescriptor1).setRange(1000.0f); // TODO if not setting target entity, how to set direction?
    }
                 
    /**
     * This runSimulationLoops() method is for you, a customizable programmer-modifiable
     * code block for defining and running a new simulation of interest.
     * 
     * Welcome! Other parts of this program handle bookkeeping and plumbing tasks so that
     * you can focus on your model entities and activities.
     * Expandable support includes DIS EntityStatePdu, FirePdu and CommentPdu all available for 
     * modification and sending in a simulation loop.
     * Continuous improvement efforts seek to make this program as easy and straightforward
     * as possible for DIS simulationists to use and adapt.
     * All of the other methods are setup, teardown and configuration that you may find
     * interesting, even helpful, but don't really have to worry about.
     */
    @SuppressWarnings("SleepWhileInLoop") // yes we might do that
    public void runSimulationLoops ()
    {
      try
      {
        final int     SIMULATION_MAX_LOOP_COUNT = 10; // be deliberate out there!  also avoid infinite loops.
              int     simulationLoopCount = 0;        // variable, initialized at 0
              boolean simulationComplete = false;     // sentinel variable as termination condition, are we done yet?
        
        // TODO reset Clock Time for today's date and timestamp to zero, providing consistent outputs for each simulation run
        String timeMessage = "Simulation time " + simulationTimeSeconds + " at LocalDateTime " + LocalDateTime.now();
        disChannel.sendCommentPdu(simulationTimeSeconds, DisChannel.COMMENTPDU_TIME, timeMessage);
        // TODO replace enumeration with disChannel.COMMENTPDU_TIME
        // TODO fix VariableRecordType.TIME_AMP_DATE_VALID
        
        // ===================================================================================================
        // loop the simulation while allowed, programmer can set additional conditions to break out and finish
        while (simulationLoopCount < SIMULATION_MAX_LOOP_COUNT)  // are we done yet?
        {
            simulationLoopCount++; // good practice: increment loop counter as first action in that loop
            
            // =============================================================================================
            // * your own simulation code starts here! *****************************************************
            // =============================================================================================
            
            //  are there any other variables to modify at the beginning of your loop?
            
            // are your reading any DIS PDUs from the network?  check for them here
            
            // compute a track, update an ESPDU, whatever it is that your model is doing...
            
            // Where is my entity?  Insert changes in position; this sample only changes X position.
            entityStatePdu_1.getEntityLocation().setX(entityStatePdu_1.getEntityLocation().getX() + 1.0); // 1m per timestep
            
            // decide whether to fire, and then update the firePdu.  Hmmm, you might want a target to shoot at!
            
            // etc. etc. your code goes here for your simulation of interest
                
            // something happens between my simulation entities, la de da de da...
            System.out.println ("... My simulation just did something, no really...");
            System.out.flush(); // make sure this arrives to user even if other threads somehow become deadlocked
            
            // here are two built-in Java alternatives to generating random numbers
            Random randomGenerator = new Random();
            int    randomInt       = randomGenerator.nextInt(100); // [0,   99]
            double randomDouble    = Math.random() * 100;          // [0.0, 100.0)
            
            // make your reports: narrative code for CommentPdu here (set all to empty strings to avoid sending)
            narrativeMessage1 = "MV3500 ExampleSimulationProgram";
            narrativeMessage2 = "runSimulation() loop " + simulationLoopCount;
        //  narrativeMessage3 = ""; // intentionally blank for testing
            narrativeMessage3 = "randomInt=" + randomInt + " randomDouble=" + randomDouble;

            // your loop termination condition goes here
            if (simulationLoopCount > MAX_LOOP_COUNT) // for example
            {
                simulationComplete = true;
            }      
            // =============================================================================================
            // * your own simulation code is finished here! ************************************************
            // =============================================================================================
            
            // staying synchronized with timestep: wait duration for elapsed time in this loop
            // Thread.sleep needs a (long) parameter for milliseconds, which are clumsy to use sometimes
            Thread.sleep((long)(getSimulationTimeStepDuration() * 1000)); // units of seconds * (1000 msec/sec) = milliseconds
            System.out.println ("... [Pausing for " + getSimulationTimeStepDuration() + " seconds]");
            
            // OK now send the status PDUs for this loop, and then continue
            System.out.println ("... sending PDUs of interest for simulation step " + simulationLoopCount + ", monitor loopback to confirm sent");
            System.out.flush();
            
            // TODO set timesteps in PDUs
            
            sendAllPdusForLoopTimestep(simulationTimeSeconds,
                                       entityStatePdu_1, 
                                            firePdu_1a, 
                                         DisChannel.COMMENTPDU_APPLICATION_STATUS, 
                                           narrativeMessage1, narrativeMessage2, narrativeMessage3);
            disChannel.sendSinglePdu(simulationTimeSeconds, entityStatePdu_2); // me too i.e. 2!
            
            System.out.println ("... [PDUs of interest successfully sent for this loop]");
            System.out.flush();
            
            // ===============================
            // current loop now finished, check whether to terminate if simulation complete, otherwise continue
            if (simulationComplete || (simulationLoopCount > 10000)) // for example; including fail-safe condition is good
            {
                System.out.println ("... [loop termination condition met, simulationComplete=" + simulationComplete + "]"); // ", final loopCount=" + loopCount + 
                System.out.flush();
                break;
            }
            simulationTimeSeconds += getSimulationTimeStepDuration(); // good practice: increment simulationTime as lastst action in that loop
                    
        }   // end of simulation loop, continue until done
        // ===================================================================================================// ===================================================================================================// ===================================================================================================// ===================================================================================================

        narrativeMessage2 = "runSimulation() completed successfully"; // all done, so tell everyone else on the channel
        // TODO better javadoc needs to be autogenerated for VariableRecordType enumerations
        disChannel.sendCommentPdu(DisChannel.COMMENTPDU_NARRATIVE, narrativeMessage1, narrativeMessage2, narrativeMessage3);
        System.out.println ("... [final=completion CommentPdu successfully sent for simulation]");
        
//        disChannel.getPduRecorder(). TODO record XML as well
        disChannel.leave(); // embedded SimulationManager is expected to send appropriate PDUs for entity, application shutdown
      } 
      catch (InterruptedException iex) // handle any exception that your code might choose to provoke!
      {
        Logger.getLogger(ExampleSimulationProgram.class.getSimpleName()).log(Level.SEVERE, null, iex);
      }
    }

    /**
     * Send EntityState, Fire, Comment PDUs that got updated for this loop, reflecting state of current simulation timestep.
     * @param simTimeSeconds simulation time in second, applied to PDU as timestamp
     * @param entityStatePdu the ESPDU to send, if any
     * @param firePdu        the FirePDU to send, if any
     * @param commentType    enumeration value describing purpose of the narrative comment PDU
     * @param comments       String array of narrative comments
     * @see DisChannel
//   * @see DisTime // TODO find renamed version
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html" target="_blank">Passing Information to a Method or a Constructor</a> Arbitrary Number of Arguments
     */
    public void sendAllPdusForLoopTimestep(double simTimeSeconds,
                                   EntityStatePdu entityStatePdu,
                                          FirePdu firePdu,
                               VariableRecordType commentType,
                                     // vararg... variable-length set of String comments can optionally follow
                                        String... comments)
    {
        if (entityStatePdu != null)
            disChannel.sendSinglePdu(simTimeSeconds, entityStatePdu);
            
        if (firePdu != null)
            disChannel.sendSinglePdu(simTimeSeconds, firePdu); // bang
        
        disChannel.sendCommentPdu(simTimeSeconds, commentType, comments); // empty comments are filtered
    }
    
    /**
     * Initial execution via main() method: handle args array of command-line initialization (CLI) arguments here
     * @param args command-line parameters: network address and port
     */
    protected void handleArguments (String[] args)
    {
        // initial execution: handle args array of initialization arguments here
        if (args.length == 2) 
        {
            if ((args[0] != null) && !args[0].isEmpty())
                thisProgram.disChannel.setNetworkAddress(args[0]);
            if ((args[1] != null) && !args[1].isEmpty())
                thisProgram.disChannel.setNetworkPort(Integer.parseInt(args[1]));
        }
        else if (args.length != 0) 
        {
            System.err.println("Usage: " + thisProgram.getClass().getSimpleName() + " [address port]");
            System.exit(-1);
        }
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
        if (newDescriptor == null)
            newDescriptor = "";
        this.descriptor = newDescriptor;
    }

    /**
     * parameter accessor method
     * @return the simulationTimeStepDuration in seconds
     */
    public double getSimulationTimeStepDuration() {
        return simulationTimeStepDuration;
    }

    /**
     * parameter accessor method
     * @param timeStepDurationSeconds the simulationTimeStepDuration in seconds to set
     */
    public void setSimulationTimeStepDuration(double timeStepDurationSeconds) {
        this.simulationTimeStepDuration = timeStepDurationSeconds;
    }
    
    /** Locally instantiable copy of program, can be subclassed. */
    protected static ExampleSimulationProgram thisProgram;
  
    /**
     * Main method is first executed when a program instance is loaded.
     * @see <a href="https://docs.oracle.com/javase/tutorial/getStarted/application/index.html" target="_blank">Java Tutorials: A Closer Look at the "Hello World!" Application</a>
     * @param args command-line parameters: network address and port.
     *    Command-line arguments are an array of optional String parameters that are passed from execution environment during invocation
     */
    public static void main(String[] args)
    {
         System.out.println("Wireshark filter for listening to these PDUs: (udp.port == 3000) &amp;&amp; dis"); // &&
        
        thisProgram = new ExampleSimulationProgram("test constructor"); // create instance of self within static main() method
        
        thisProgram.disChannel.printlnTRACE("main() started...");
        
        thisProgram.handleArguments(args); // process any command-line invocation arguments

        thisProgram.runSimulationLoops(); // ... your simulation execution code goes in there ...
        
        thisProgram.disChannel.tearDownNetworkInterface(); // make sure no processes are left lingering
        
        thisProgram.disChannel.printlnTRACE("complete."); // report successful completion
        
        System.exit(0); // ensure all threads and sockets released
    }
}
