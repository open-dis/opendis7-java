package edu.nps.moves.dis7.entities.chn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5606c0b;
 * Country: China, Peoples Republic of (CHN);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 17015
 */
public class ChangduAircraftIndustrialCorpJJ7FT7 extends EntityType
{
    /** Default constructor */
    public ChangduAircraftIndustrialCorpJJ7FT7()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 17013, Trainer
        setSubCategory((byte)2); // uid 17015, Changdu Aircraft Industrial Corp. JJ-7/FT-7
    }
}
