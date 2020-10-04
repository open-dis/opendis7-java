package edu.nps.moves.dis7.entities.prt.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@1efdcd5
 * Country: Portugal (PRT)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19357
 */
public class PRTNonCombatantShip extends EntityType
{
    public PRTNonCombatantShip()
    {
        setCountry(Country.PORTUGAL_PRT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)61); // uid 19357, PRT Non-Combatant Ship
    }
}
