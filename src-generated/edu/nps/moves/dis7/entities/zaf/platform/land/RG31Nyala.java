package edu.nps.moves.dis7.entities.zaf.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@38792286;
 * Country: South Africa (ZAF);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 27272
 */
public class RG31Nyala extends EntityType
{
    /** Default constructor */
    public RG31Nyala()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 27271, Large Wheeled Utility Vehicle
        setSubCategory((byte)1); // uid 27272, RG-31 Nyala
    }
}
