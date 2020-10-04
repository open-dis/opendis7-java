package edu.nps.moves.dis7.entities.egy.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@33c911a1
 * Country: Egypt (EGY)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18799
 */
public class GuidedMissileFrigates extends EntityType
{
    public GuidedMissileFrigates()
    {
        setCountry(Country.EGYPT_EGY);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 18799, Guided Missile Frigates
    }
}
