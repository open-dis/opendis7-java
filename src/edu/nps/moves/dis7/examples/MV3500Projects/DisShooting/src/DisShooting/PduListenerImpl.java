package DisShooting;

import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.Pdu;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** PDU listener for this simulation run
 *
 * @author &lt;a href="mailto:tdnorbra@nps.edu?subject=mv4503.PduListenerImpl"&gt;Terry Norbraten, NPS MOVES&lt;/a&gt;
 */
public class PduListenerImpl implements PduListener
{
    /** Default constructor */
    public PduListenerImpl()
    {
        // default constructor
    }
    
    /** All ENTITIES in the world we have heard from */
    static final Map<EntityID, EntityStatePdu> ENTITIES = Collections.synchronizedMap(new HashMap<>());
    static Collection<EntityStatePdu> allEntities = ENTITIES.values();
    static Set<EntityID> allIds = ENTITIES.keySet();

    /** 
     * We are notified by NetworkComms singleton that a PDU has arrived. Do 
     * something with it.
     * 
     * @param aPdu a protocol data unit to process
     */
    @Override
     public void pduReceived(Pdu aPdu)
     {
         switch(aPdu.getPduType())
         {
            case ENTITY_STATE: // targetEspdu
                
                EntityStatePdu espdu = (EntityStatePdu) aPdu;
                EntityID id = espdu.getEntityID();
                
                if(espdu.getEntityType().getEntityKind() == EntityKind.MUNITION) // A munition
                    break;
                
                ENTITIES.put(id, espdu);
                print(id);
                
                break;

            case FIRE:
            case DETONATION:
                System.out.println("Got " + aPdu);
                break;

            default:
                System.out.println("Received PDU " + aPdu.getClass().getName() + " of type " + aPdu.getPduType());
                System.err.println("Not handled");
        }
     }
     
     private void print(EntityID id) {
         System.out.println("Adding entity (SiteID, AppID, ID): " + id.getSiteID() + ", " + id.getApplicationID() + ", " + id.getEntityID());
     }

} // end class file PduListenerImpl.java
