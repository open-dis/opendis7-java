package edu.nps.moves.dis7.entities.oth.culturalfeature.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@596afb2f
 * Country: Other
 * Entity kind: Cultural feature
 * Domain: SURFACE
 *
 * Entity type uid: 29796
 */
public class LighthouseonWaterMediumGTE20mandLT40m extends EntityType
{
    public LighthouseonWaterMediumGTE20mandLT40m()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)4); // uid 22139, Marker
        setSubCategory((byte)4); // uid 29794, Lighthouse on Water
        setSpecific((byte)2); // uid 29796, Lighthouse on Water, Medium (>=20m and <40m)
    }
}
