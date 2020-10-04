package edu.nps.moves.dis7.entities.sau.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@126f1ba8
 * Country: Saudi Arabia (SAU)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 17894
 */
public class _220Dheba extends EntityType
{
    public _220Dheba()
    {
        setCountry(Country.SAUDI_ARABIA_SAU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 17889, Auxiliary
        setSubCategory((byte)2); // uid 17893, LCM 6 Class
        setSpecific((byte)1); // uid 17894, 220 Dheba
    }
}
