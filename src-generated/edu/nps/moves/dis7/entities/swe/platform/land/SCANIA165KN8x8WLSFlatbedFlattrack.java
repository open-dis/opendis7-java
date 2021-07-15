package edu.nps.moves.dis7.entities.swe.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1bc49bc5;
 * Country: Sweden (SWE);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 27970
 */
public class SCANIA165KN8x8WLSFlatbedFlattrack extends EntityType
{
    /** Default constructor */
    public SCANIA165KN8x8WLSFlatbedFlattrack()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 26342, Large Wheeled Utility Vehicle
        setSubCategory((byte)2); // uid 27970, SCANIA 165 KN 8x8 WLS Flatbed/Flattrack
    }
}
