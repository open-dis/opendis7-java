package edu.nps.moves.dis7.entities.nld.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2f3c6ac4
 * Country: Netherlands (NLD)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 27936
 */
public class DAFYAC23006x6 extends EntityType
{
    public DAFYAC23006x6()
    {
        setCountry(Country.NETHERLANDS_NLD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 27930, Large Wheeled Utility Vehicle
        setSubCategory((byte)6); // uid 27936, DAF YAC-2300 6x6
    }
}
