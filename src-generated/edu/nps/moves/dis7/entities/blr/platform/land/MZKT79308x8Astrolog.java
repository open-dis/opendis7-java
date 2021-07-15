package edu.nps.moves.dis7.entities.blr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@531be3c5;
 * Country: Belarus (BLR);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 30051
 */
public class MZKT79308x8Astrolog extends EntityType
{
    /** Default constructor */
    public MZKT79308x8Astrolog()
    {
        setCountry(Country.BELARUS_BLR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 30050, Large Wheeled Utility Vehicle
        setSubCategory((byte)1); // uid 30051, MZKT-7930 8x8 Astrolog
    }
}
