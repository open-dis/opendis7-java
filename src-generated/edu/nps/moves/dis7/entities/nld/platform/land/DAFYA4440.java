package edu.nps.moves.dis7.entities.nld.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5a021cb9
 * Country: Netherlands (NLD)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 27931
 */
public class DAFYA4440 extends EntityType
{
    public DAFYA4440()
    {
        setCountry(Country.NETHERLANDS_NLD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 27930, Large Wheeled Utility Vehicle
        setSubCategory((byte)1); // uid 27931, DAF YA-4440
    }
}
