package edu.nps.moves.dis7.entities.twn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1687eb01
 * Country: Taiwan, Province of China (TWN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19236
 */
public class _530WuYi extends EntityType
{
    public _530WuYi()
    {
        setCountry(Country.TAIWAN_PROVINCE_OF_CHINA_TWN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)60); // uid 19234, Fast Combat Support Ship
        setSubCategory((byte)1); // uid 19235, Wu Yi Class
        setSpecific((byte)1); // uid 19236, 530 Wu Yi
    }
}
