package DisShooting;

import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.enumerations.ForceID;
import edu.nps.moves.dis7.enumerations.PlatformDomain;
import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.spatial.*;

/** Setup for friendly entity
 *
 * @author DMcG
 */
public class Sniper implements Runnable
{
    private static Sniper sniper = null;
    Vector3Double disCoordinates;
    EntityID eId;
    
    /** provide reference to this object
      * @return reference to this object */
    public static Sniper getInstance() {
        if (sniper == null) {
            sniper = new Sniper();
        }
        return sniper;    
    }
    
    private Sniper()
    {
        this.eId = new EntityID();
        eId.setSiteID(17);
        eId.setApplicationID(42);
        eId.setEntityID(104);
    }
    
    @Override
    public void run()
    {
        System.out.println("Announcing " + this.eId);
        EntityStatePdu espdu;
        RangeCoordinates rangeCoordinates;
        
        while(true)
        {
            // Create a new coordinate system at the give latitude, longitude, and altitude
            rangeCoordinates = new RangeCoordinates(31.441, 45.227, 17.0);

            espdu = new EntityStatePdu();
        
            // Convert from the coodinate system with the rangeCoordinates above to DIS coordinates
            disCoordinates = rangeCoordinates.DISCoordFromLocalFlat(0, 0, 0);
            espdu.setEntityLocation(disCoordinates);

            // Set various fields--entityID, entity type, etc.
            espdu.setExerciseID((byte)1);
            espdu.setEntityID(eId);

            espdu.getEntityType().setEntityKind(EntityKind.PLATFORM);
            espdu.getEntityType().setDomain(Domain.inst(PlatformDomain.LAND));
            espdu.getEntityType().setCategory((short)2);
            espdu.getEntityType().setSubCategory((short)1);
            espdu.getEntityType().setSpecific((short)1);
            espdu.getEntityType().setCountry(Country.UNITED_STATES_OF_AMERICA_USA);

            espdu.getMarking().setCharacters("KaPOW".getBytes());

            espdu.setForceId(ForceID.FRIENDLY);

            NetworkComms.getInstance().sendPdu(espdu);

            SimulationRunner.sleep(2000);
        }
    }
}
