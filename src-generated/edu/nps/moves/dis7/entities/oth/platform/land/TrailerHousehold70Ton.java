package edu.nps.moves.dis7.entities.oth.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2b50150
 * Country: Other
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 31633
 */
public class TrailerHousehold70Ton extends EntityType
{
    public TrailerHousehold70Ton()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)89); // uid 25929, Trailer
        setSubCategory((byte)24); // uid 31625, Trailer, Household
        setSpecific((byte)8); // uid 31633, Trailer, Household, 7.0 Ton
    }
}
