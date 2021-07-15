package edu.nps.moves.dis7.entities.yem.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@4a864d4d;
 * Country: Yemen (YEM);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 18749
 */
public class NoncombatantShip extends EntityType
{
    /** Default constructor */
    public NoncombatantShip()
    {
        setCountry(Country.YEMEN_YEM);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)61); // uid 18749, Non-combatant Ship
    }
}
