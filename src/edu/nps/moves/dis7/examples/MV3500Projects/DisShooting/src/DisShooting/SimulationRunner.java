package DisShooting;

import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.enumerations.DetonationResult;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.enumerations.MunitionDescriptorFuse;
import edu.nps.moves.dis7.enumerations.MunitionDescriptorWarhead;
import edu.nps.moves.dis7.enumerations.PlatformDomain;
import edu.nps.moves.dis7.pdus.*;

/**
 * Shoots at stuff it sees.
 * 
 * @author DMcG
 * @author &lt;a href="mailto:tdnorbra@nps.edu?subject=mv4503.SimulationRunner"&gt;Terry Norbraten, NPS MOVES&lt;/a&gt;
 */
public class SimulationRunner
{
    /** three strikes you're out! */
    public final static int FIRING_ATTEMPTS = 3;
    
    private static NetworkComms networkComms = null;
    private static PduListenerImpl pDuL;
    
    private Sniper sniper;
    private Target target;

    /**
     * Program invocation, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("DisShooting.SimulationRunner started...");
        SimulationRunner runner = new SimulationRunner();
        // Creates socket, starts listening thread for network traffic (if
        // not already listening)
        networkComms = NetworkComms.getInstance(); 
        
        // Will work for both sniper and target PDUs
        // Listen for PDUs and build up a list of all the ENTITIES in the world
        networkComms.addListener(pDuL = new PduListenerImpl());
        
        for(int idx = 0; idx < FIRING_ATTEMPTS; idx++)
        {
            System.out.println("Going to sleep for 10 seconds to build a list of entities in the world");
            sleep(10000);
            System.out.println("Number of entities in the world: " + PduListenerImpl.ENTITIES.size());

            // Now we should have a list of ENTITIES in the world we can shoot at.
            // Fire away.
            runner.shoot();
        }
        
        networkComms.removeListener(pDuL);
    }
    
    /** 
     * Constructor starts a list of ENTITIES in the world that is populated by
     * the NetworkComms object notifying us of new ESPDUs.
     */
    public SimulationRunner()
    {   
        
        // Sends ESPDUs from our shooter
        sniper = Sniper.getInstance();
        Thread sniperThread = new Thread(sniper);
        sniperThread.setDaemon(true);
        sniperThread.start(); 
        
        // Sends ESPDUs from our target
        target = Target.getInstance();
        Thread targetThread = new Thread(target);
        targetThread.setDaemon(true);
        targetThread.start();
    }
   
    /**
     * Called after a list of entities has been build up by receiving ESPDUs. 
     * Generates Fire and Detonation PDUs for each of the entities heard from, 
     * and fires at all the entities, except the sniper (us).
     */
    public void shoot()
    {
        FirePdu firePdu ; // this is actually somewhat optional
        DetonationPdu detonationPdu;
        EntityStatePdu munitionEspdu;
        EntityID targetEntityID, munitionEntityID;
        Vector3Double targetLocation;
        Vector3Float localCoordinates;
        EventIdentifier event;
        MunitionDescriptor burst, burst1;
        short eventNumber = 1;
        
        // We do a synchronize() here on the ENTITIES variable because another 
        // thread may be modifying it at the same time.
        synchronized (PduListenerImpl.ENTITIES) {

            // Loop through all ENTITIES, sending a detonation PDU to
            // each at their location. 
            for (EntityStatePdu targetEspdu : PduListenerImpl.allEntities) {
                
                targetEntityID = targetEspdu.getEntityID();
                System.out.println("Target entity (ID, AppID, SiteID): " + targetEntityID.getSiteID() + ", " + targetEntityID.getApplicationID() + ", " + targetEntityID.getEntityID());
                targetLocation = targetEspdu.getEntityLocation();
                System.out.println("Target location (x, y, z): " + targetLocation.getX() + ", " + targetLocation.getY() + ", " + targetLocation.getZ());

                if (targetEntityID.equals(sniper.eId)) {
                    System.out.println("don't shoot, it's me!");
                    continue;
                }

                // create and announce an entity for the munition fired
                munitionEspdu = new EntityStatePdu();
                munitionEspdu.setExerciseID((byte)1);
                munitionEntityID = new EntityID();
                munitionEntityID.setSiteID(sniper.eId.getSiteID());
                munitionEntityID.setApplicationID(sniper.eId.getApplicationID());
                munitionEntityID.setEntityID((int) ((Math.random() * 32000)));
                munitionEspdu.setEntityID(munitionEntityID);

                // This is some kind of grenade
                munitionEspdu.getEntityType().setEntityKind(EntityKind.MUNITION);
                munitionEspdu.getEntityType().setDomain(Domain.inst(PlatformDomain.LAND));
                munitionEspdu.getEntityType().setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
                munitionEspdu.getEntityType().setCategory((short) 2); // ballistic
                munitionEspdu.getEntityType().setSubCategory((short) 44);
                munitionEspdu.getEntityType().setSpecific((short) 0);
                munitionEspdu.getEntityType().setExtra((short) 0);

                // Blow up the target entity
                munitionEspdu.getEntityLocation().setX(targetLocation.getX());
                munitionEspdu.getEntityLocation().setY(targetLocation.getY());
                munitionEspdu.getEntityLocation().setZ(targetLocation.getZ());

                // Typically the shooter models the flight of the munition.
                //Vector3Float vel = munitionEspdu.getEntityLinearVelocity();
                //vel.setX(10.0f);
                //vel.setY(20.0f);
                //vel.setZ(40.0f);
                
                // Send the munition pdu
                networkComms.sendPdu(munitionEspdu);
//                sleep(1000);

                // Fire PDU
                firePdu = new FirePdu();
                firePdu.setExerciseID((byte)1);

                // Shooter
                event = new EventIdentifier();
                SimulationAddress addr = new SimulationAddress();
                addr.setApplication(sniper.eId.getApplicationID());
                addr.setSite(sniper.eId.getSiteID());
                event.setSimulationAddress(addr);
                event.setEventNumber(eventNumber);
                eventNumber++;
                firePdu.setEventID(event);

                firePdu.getLocationInWorldCoordinates().setX(sniper.disCoordinates.getX());
                firePdu.getLocationInWorldCoordinates().setY(sniper.disCoordinates.getY());
                firePdu.getLocationInWorldCoordinates().setZ(sniper.disCoordinates.getZ());

                firePdu.setRange(0.0f);
                firePdu.setMunitionExpendibleID(munitionEntityID);
                firePdu.setTargetEntityID(targetEntityID);
                firePdu.setFiringEntityID(sniper.eId);

                networkComms.sendPdu(firePdu);
//                sleep(1000);

                // Create an explosion that ties together the shooter, target, and munition 
                detonationPdu = new DetonationPdu();
                detonationPdu.setExerciseID((byte)1);

                // Who's shooting: us
                detonationPdu.setSourceEntityID(sniper.eId);

                // Who we're shooting at; one of the ESPDUS (other than us) we received
                detonationPdu.setTargetEntityID(targetEntityID);

                // The thing blowing up (the munition)
                detonationPdu.setExplodingEntityID(munitionEntityID);

                // An event ID; this is used to tie fire and detonation events together
                detonationPdu.setEventID(event);

                // location of detonation
                detonationPdu.setLocationInWorldCoordinates(targetLocation);

                // Result of detonation
                detonationPdu.setDetonationResult(DetonationResult.GROUND_IMPACT); // ground impact

                // Location of explosion in local entity coordinates
                localCoordinates = new Vector3Float();
                localCoordinates.setX(0.0f);
                localCoordinates.setY(0.0f);
                localCoordinates.setZ(0.0f);
                detonationPdu.setLocationOfEntityCoordinates(localCoordinates);

                // Descriptors
                // Grenade (swiped from VBS2 wireshark capture)
                burst = firePdu.getDescriptor();
                burst.setMunitionType(munitionEspdu.getEntityType());
                burst.setQuantity(1);
                burst.setRate(1);
                burst.setFuse(MunitionDescriptorFuse.CONTACT_DELAYED_100_MS_DELAY);
                burst.setWarhead(MunitionDescriptorWarhead.HE_SHAPED_CHARGE); // HE

                detonationPdu.setDescriptor(burst);
                //networkComms.sendPdu(detonationPdu);
//                sleep(1000);
                
//                burst1 = new MunitionDescriptor();
//                burst1.setMunitionType(munitionEspdu.getEntityType());
//                burst1.setQuantity(1);
//                burst1.setRate(1);
//                burst1.setFuse(MunitionDescriptorFuse._250_MS_DELAY);
//                burst1.setWarhead(MunitionDescriptorWarhead.KINETIC); // kinetic

//                detonationPdu.setDescriptor(burst1);
//                networkComms.sendPdu(detonationPdu);
//                sleep(1000);
            }
            
            // Wipe out all the ENTITIES for the next time through the loop
            PduListenerImpl.ENTITIES.clear();
        }
    }
     /** wait before next activity
     * @param ms duration in milliseconds */
     public static void sleep(long ms) {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException e)
        {
            System.err.println("Bad sleep");
        }
     }
}
