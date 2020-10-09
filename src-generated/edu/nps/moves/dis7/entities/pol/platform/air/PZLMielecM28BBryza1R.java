package edu.nps.moves.dis7.entities.pol.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7fae4d4a
 * Country: Poland (POL)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 23087
 */
public class PZLMielecM28BBryza1R extends EntityType
{
    public PZLMielecM28BBryza1R()
    {
        setCountry(Country.POLAND_POL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)5); // uid 23086, ASW/Patrol/Observation
        setSubCategory((byte)1); // uid 23087, PZL-Mielec M28B Bryza 1R
    }
}
