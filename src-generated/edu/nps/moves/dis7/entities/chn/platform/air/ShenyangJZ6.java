package edu.nps.moves.dis7.entities.chn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@525b461a
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24379
 */
public class ShenyangJZ6 extends EntityType
{
    public ShenyangJZ6()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)7); // uid 24378, Reconnaissance
        setSubCategory((byte)1); // uid 24379, Shenyang JZ-6
    }
}
