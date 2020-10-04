package edu.nps.moves.dis7.entities.rus.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@238bfd6c
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 27187
 */
public class K506Zelenograd extends EntityType
{
    public K506Zelenograd()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)1); // uid 14759, SSBN (Nuclear Ballistic Missile)
        setSubCategory((byte)3); // uid 14762, Delta III Class
        setSpecific((byte)3); // uid 27187, K-506 Zelenograd
    }
}
