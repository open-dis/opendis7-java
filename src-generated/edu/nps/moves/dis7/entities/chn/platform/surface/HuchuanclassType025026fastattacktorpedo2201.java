package edu.nps.moves.dis7.entities.chn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1ffe63b9
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 17222
 */
public class HuchuanclassType025026fastattacktorpedo2201 extends EntityType
{
    public HuchuanclassType025026fastattacktorpedo2201()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)14); // uid 17216, Hydrofoil
        setSubCategory((byte)1); // uid 17217, Huchuan class Type 025/026 (fast attack-torpedo)
        setSpecific((byte)5); // uid 17222, 2201
    }
}
