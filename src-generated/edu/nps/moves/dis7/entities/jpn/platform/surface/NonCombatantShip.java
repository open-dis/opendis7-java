package edu.nps.moves.dis7.entities.jpn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@36b0fcd5
 * Country: Japan (JPN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18906
 */
public class NonCombatantShip extends EntityType
{
    public NonCombatantShip()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)61); // uid 18906, Non-Combatant Ship
    }
}
