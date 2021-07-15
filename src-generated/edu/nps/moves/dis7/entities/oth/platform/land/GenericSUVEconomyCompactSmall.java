package edu.nps.moves.dis7.entities.oth.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5cbf9e9f;
 * Country: Other;
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 25794
 */
public class GenericSUVEconomyCompactSmall extends EntityType
{
    /** Default constructor */
    public GenericSUVEconomyCompactSmall()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)81); // uid 25754, Car
        setSubCategory((byte)112); // uid 25794, Generic SUV, Economy/Compact (Small)
    }
}