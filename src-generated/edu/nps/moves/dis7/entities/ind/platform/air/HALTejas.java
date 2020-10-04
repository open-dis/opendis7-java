package edu.nps.moves.dis7.entities.ind.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@79517588
 * Country: India (IND)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24784
 */
public class HALTejas extends EntityType
{
    public HALTejas()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 24783, Fighter/Air Defense
        setSubCategory((byte)1); // uid 24784, HAL Tejas
    }
}
