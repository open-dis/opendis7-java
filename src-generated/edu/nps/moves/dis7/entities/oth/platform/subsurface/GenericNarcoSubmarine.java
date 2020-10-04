package edu.nps.moves.dis7.entities.oth.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1fd386c3
 * Country: Other
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 29696
 */
public class GenericNarcoSubmarine extends EntityType
{
    public GenericNarcoSubmarine()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)82); // uid 29695, Semi-Submersible Boats
        setSubCategory((byte)1); // uid 29696, Generic Narco-Submarine
    }
}
