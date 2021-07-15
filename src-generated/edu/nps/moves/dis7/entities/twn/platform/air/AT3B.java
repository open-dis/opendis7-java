package edu.nps.moves.dis7.entities.twn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6dfa915a;
 * Country: Taiwan, Province of China (TWN);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 29226
 */
public class AT3B extends EntityType
{
    /** Default constructor */
    public AT3B()
    {
        setCountry(Country.TAIWAN_PROVINCE_OF_CHINA_TWN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 29223, Trainer
        setSubCategory((byte)1); // uid 29224, AIDC AT-3 Tzu Chung
        setSpecific((byte)2); // uid 29226, AT-3B
    }
}
