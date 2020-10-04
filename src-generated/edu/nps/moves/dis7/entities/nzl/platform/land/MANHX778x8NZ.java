package edu.nps.moves.dis7.entities.nzl.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@60d84f61
 * Country: New Zealand (NZL)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 31942
 */
public class MANHX778x8NZ extends EntityType
{
    public MANHX778x8NZ()
    {
        setCountry(Country.NEW_ZEALAND_NZL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 31941, Large Wheeled Utility Vehicle
        setSubCategory((byte)1); // uid 31942, MAN HX77 - 8x8 (NZ)
    }
}
