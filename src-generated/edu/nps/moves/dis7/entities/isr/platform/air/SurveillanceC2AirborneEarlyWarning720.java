package edu.nps.moves.dis7.entities.isr.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@bf1ec20
 * Country: Israel (ISR)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 18193
 */
public class SurveillanceC2AirborneEarlyWarning720 extends EntityType
{
    public SurveillanceC2AirborneEarlyWarning720()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 18191, Surveillance/C2 (Airborne Early Warning)
        setSubCategory((byte)2); // uid 18193, 720
    }
}
