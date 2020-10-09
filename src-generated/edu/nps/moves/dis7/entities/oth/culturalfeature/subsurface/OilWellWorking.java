package edu.nps.moves.dis7.entities.oth.culturalfeature.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@667a467f
 * Country: Other
 * Entity kind: Cultural feature
 * Domain: SUBSURFACE
 *
 * Entity type uid: 23416
 */
public class OilWellWorking extends EntityType
{
    public OilWellWorking()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)1); // uid 22161, Oil Well
        setSubCategory((byte)1); // uid 23416, Oil Well, Working
    }
}
