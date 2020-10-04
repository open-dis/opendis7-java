package edu.nps.moves.dis7.entities.zaf.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@68880c21
 * Country: South Africa (ZAF)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 19117
 */
public class Vulture extends EntityType
{
    public Vulture()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)50); // uid 19114, Unmanned
        setSubCategory((byte)1); // uid 19115, RPV
        setSpecific((byte)2); // uid 19117, Vulture
    }
}
