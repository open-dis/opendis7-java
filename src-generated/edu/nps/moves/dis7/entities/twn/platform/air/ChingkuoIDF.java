package edu.nps.moves.dis7.entities.twn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@22a6e998;
 * Country: Taiwan, Province of China (TWN);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 19138
 */
public class ChingkuoIDF extends EntityType
{
    /** Default constructor */
    public ChingkuoIDF()
    {
        setCountry(Country.TAIWAN_PROVINCE_OF_CHINA_TWN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 19137, Fighter/Air Defense
        setSubCategory((byte)1); // uid 19138, Ching-kuo (IDF)
    }
}
