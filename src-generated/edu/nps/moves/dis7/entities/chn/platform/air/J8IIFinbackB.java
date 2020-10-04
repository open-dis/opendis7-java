package edu.nps.moves.dis7.entities.chn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@23bb8443
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 16975
 */
public class J8IIFinbackB extends EntityType
{
    public J8IIFinbackB()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 16966, Fighter/Air Defense
        setSubCategory((byte)3); // uid 16973, Shenyang J-8 (Finback)
        setSpecific((byte)2); // uid 16975, J-8 II Finback B
    }
}
