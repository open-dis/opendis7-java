package edu.nps.moves.dis7.entities.nld.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3a0807b7
 * Country: Netherlands (NLD)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 27941
 */
public class DAFYBB95480Recovery extends EntityType
{
    public DAFYBB95480Recovery()
    {
        setCountry(Country.NETHERLANDS_NLD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 27930, Large Wheeled Utility Vehicle
        setSubCategory((byte)11); // uid 27941, DAF YBB-95.480 Recovery
    }
}
