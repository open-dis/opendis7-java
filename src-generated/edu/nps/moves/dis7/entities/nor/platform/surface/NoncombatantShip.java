package edu.nps.moves.dis7.entities.nor.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@88d6f9b
 * Country: Norway (NOR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18978
 */
public class NoncombatantShip extends EntityType
{
    public NoncombatantShip()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)61); // uid 18978, Non-combatant Ship
    }
}
