package edu.nps.moves.dis7.entities.oth.culturalfeature.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@324e8baa
 * Country: Other
 * Entity kind: Cultural feature
 * Domain: SUBSURFACE
 *
 * Entity type uid: 23417
 */
public class OilWellCapped extends EntityType
{
    public OilWellCapped()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)1); // uid 22161, Oil Well
        setSubCategory((byte)2); // uid 23417, Oil Well, Capped
    }
}
