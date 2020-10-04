package edu.nps.moves.dis7.entities.oth.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@f4f843f
 * Country: Other
 * Entity kind: Life form
 * Domain: LAND
 *
 * Entity type uid: 32728
 */
public class TerroristCombatantwPSM extends EntityType
{
    public TerroristCombatantwPSM()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)101); // uid 32719, Terrorist Combatant
        setSubCategory((byte)80); // uid 32727, Hand Guns
        setSpecific((byte)1); // uid 32728, Terrorist Combatant w/ PSM
    }
}
