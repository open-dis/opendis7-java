package edu.nps.moves.dis7.entities.idn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@63f8276e
 * Country: Indonesia (IDN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 31436
 */
public class Boeing7372x9Surveiller extends EntityType
{
    public Boeing7372x9Surveiller()
    {
        setCountry(Country.INDONESIA_IDN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)5); // uid 31435, ASW/Patrol/Observation
        setSubCategory((byte)1); // uid 31436, Boeing 737-2x9 Surveiller
    }
}
