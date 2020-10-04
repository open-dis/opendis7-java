package edu.nps.moves.dis7.entities.oth.culturalfeature.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@61993d18
 * Country: Other
 * Entity kind: Cultural feature
 * Domain: SURFACE
 *
 * Entity type uid: 32580
 */
public class DyeMarker extends EntityType
{
    public DyeMarker()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)4); // uid 22139, Marker
        setSubCategory((byte)5); // uid 32579, SAR Marker
        setSpecific((byte)1); // uid 32580, Dye Marker
    }
}
