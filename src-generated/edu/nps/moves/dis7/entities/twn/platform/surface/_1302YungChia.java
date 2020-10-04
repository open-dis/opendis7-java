package edu.nps.moves.dis7.entities.twn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4052c8c2
 * Country: Taiwan, Province of China (TWN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19222
 */
public class _1302YungChia extends EntityType
{
    public _1302YungChia()
    {
        setCountry(Country.TAIWAN_PROVINCE_OF_CHINA_TWN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 19219, Mine Coutermeasures Ship/Craft
        setSubCategory((byte)1); // uid 19220, Yun Feng Class
        setSpecific((byte)2); // uid 19222, 1302 Yung Chia
    }
}
