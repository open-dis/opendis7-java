package edu.nps.moves.dis7.entities.blz.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@153f5a29;
 * Country: Belize (BLZ);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 19256
 */
public class NonCombatantShip extends EntityType
{
    /** Default constructor */
    public NonCombatantShip()
    {
        setCountry(Country.BELIZE_BLZ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)61); // uid 19256, Non-Combatant Ship
    }
}
