package edu.nps.moves.dis7.entities.chn.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@704d6e83;
 * Country: China, Peoples Republic of (CHN);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31981
 */
public class AR3300mm8x8MultipleLaunchRocketSystemMLRS extends EntityType
{
    /** Default constructor */
    public AR3300mm8x8MultipleLaunchRocketSystemMLRS()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 16884, Self-Propelled Artillery
        setSubCategory((byte)38); // uid 31980, AR3 370mm 8x8 Multiple Launch Rocket System (MLRS)
        setSpecific((byte)1); // uid 31981, AR3 300mm 8x8 Multiple Launch Rocket System (MLRS)
    }
}
