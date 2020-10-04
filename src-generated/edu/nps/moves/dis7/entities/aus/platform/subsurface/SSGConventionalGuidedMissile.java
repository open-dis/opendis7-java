package edu.nps.moves.dis7.entities.aus.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@617c74e5
 * Country: Australia (AUS)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 17609
 */
public class SSGConventionalGuidedMissile extends EntityType
{
    public SSGConventionalGuidedMissile()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)4); // uid 17609, SSG (Conventional Guided Missile)
    }
}
