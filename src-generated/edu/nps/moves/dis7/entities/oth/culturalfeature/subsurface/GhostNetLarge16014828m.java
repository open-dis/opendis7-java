package edu.nps.moves.dis7.entities.oth.culturalfeature.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5a90fcaa
 * Country: Other
 * Entity kind: Cultural feature
 * Domain: SUBSURFACE
 *
 * Entity type uid: 25213
 */
public class GhostNetLarge16014828m extends EntityType
{
    public GhostNetLarge16014828m()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)4); // uid 25210, Ghost Net
        setSubCategory((byte)3); // uid 25213, Ghost Net, Large (1601-4828m)
    }
}
