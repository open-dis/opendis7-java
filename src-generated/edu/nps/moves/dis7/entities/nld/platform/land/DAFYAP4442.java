package edu.nps.moves.dis7.entities.nld.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4a9419d7
 * Country: Netherlands (NLD)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 27935
 */
public class DAFYAP4442 extends EntityType
{
    public DAFYAP4442()
    {
        setCountry(Country.NETHERLANDS_NLD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 27930, Large Wheeled Utility Vehicle
        setSubCategory((byte)5); // uid 27935, DAF YAP-4442
    }
}
