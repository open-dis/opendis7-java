package DisShooting;

import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.enumerations.ForceID;
import edu.nps.moves.dis7.enumerations.PlatformDomain;
import edu.nps.moves.dis7.pdus.Domain;
import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.Vector3Double;
import edu.nps.moves.spatial.RangeCoordinates;

/** Our sniper's target
 *
 * @author &lt;a href="mailto:tdnorbra@nps.edu?subject=mv4503.Target"&gt;Terry Norbraten, NPS MOVES&lt;/a&gt;
 */
public class Target implements Runnable {
    
    private static Target target = null;
    private EntityID eId;
    
    /** provide reference to this object
      * @return reference to this object */
    public static Target getInstance() {
        if (target == null) {
            target = new Target();
        }
        return target;
    }
    
    private Target()
    {
        this.eId = new EntityID();
        eId.setSiteID(17);
        eId.setApplicationID(42);
        eId.setEntityID(208);
    }
    
    @Override
    public void run()
    {
        System.out.println("Announcing " + this.eId);
        EntityStatePdu espdu;
        RangeCoordinates rangeCoordinates;
        Vector3Double disCoordinates;
        
        while(true)
        {
            // Create a new coordinate system at the give latitude, longitude, and altitude
            rangeCoordinates = new RangeCoordinates(31.667, 45.421, 16.5);

            espdu = new EntityStatePdu();
        
            // Convert from the coodinate system with the rangeCoordinates above to DIS coordinates
            disCoordinates = rangeCoordinates.DISCoordFromLocalFlat(0, 1, 0);
            espdu.setEntityLocation(disCoordinates);

            // Set various fields--entityID, entity type, etc.
            espdu.setExerciseID((byte)1);
            espdu.setEntityID(eId);

            espdu.getEntityType().setEntityKind(EntityKind.PLATFORM);
            espdu.getEntityType().setDomain(Domain.inst(PlatformDomain.LAND));
            espdu.getEntityType().setCategory((short)2);
            espdu.getEntityType().setSubCategory((short)1);
            espdu.getEntityType().setSpecific((short)1);
            espdu.getEntityType().setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);

            espdu.getMarking().setCharacters("RunAndHide".getBytes());

            espdu.setForceId(ForceID.OPPOSING);

            NetworkComms.getInstance().sendPdu(espdu);

            SimulationRunner.sleep(2000);
        }
    }

} // end class file Target.java
