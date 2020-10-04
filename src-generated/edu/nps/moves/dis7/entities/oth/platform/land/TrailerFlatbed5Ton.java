package edu.nps.moves.dis7.entities.oth.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3b0f7d9d
 * Country: Other
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 31634
 */
public class TrailerFlatbed5Ton extends EntityType
{
    public TrailerFlatbed5Ton()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)89); // uid 25929, Trailer
        setSubCategory((byte)1); // uid 25930, Generic Trailer, Flatbed
        setSpecific((byte)1); // uid 31634, Trailer, Flatbed 5 Ton
    }
}
