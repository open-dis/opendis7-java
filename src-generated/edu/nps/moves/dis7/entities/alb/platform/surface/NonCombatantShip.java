package edu.nps.moves.dis7.entities.alb.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@1ed6993a
 * Country: Albania (ALB)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19242
 */
public class NonCombatantShip extends EntityType
{
    public NonCombatantShip()
    {
        setCountry(Country.ALBANIA_ALB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)61); // uid 19242, Non-Combatant Ship
    }
}
