package edu.nps.moves.dis7.entities.chn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6166e06f
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24677
 */
public class ShenyangJ31 extends EntityType
{
    public ShenyangJ31()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 16966, Fighter/Air Defense
        setSubCategory((byte)8); // uid 24677, Shenyang J-31
    }
}
