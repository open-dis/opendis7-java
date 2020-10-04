package edu.nps.moves.dis7.entities.chn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@6591f517
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24382
 */
public class SurveillanceC2AirborneEarlyWarning extends EntityType
{
    public SurveillanceC2AirborneEarlyWarning()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 24382, Surveillance/C2 (Airborne Early Warning)
    }
}
