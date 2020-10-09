package edu.nps.moves.dis7.entities.nor.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1804f60d
 * Country: Norway (NOR)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29605
 */
public class P3Orion extends EntityType
{
    public P3Orion()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)5); // uid 29604, ASW/Patrol/Observation
        setSubCategory((byte)1); // uid 29605, P-3 Orion
    }
}
