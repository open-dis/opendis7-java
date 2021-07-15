package edu.nps.moves.dis7.entities.sgp.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@53830483;
 * Country: Singapore (SGP);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 25550
 */
public class BroncoAllTerrainTrackedCarrierATTC extends EntityType
{
    /** Default constructor */
    public BroncoAllTerrainTrackedCarrierATTC()
    {
        setCountry(Country.SINGAPORE_SGP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 25549, Armored Fighting Vehicle
        setSubCategory((byte)1); // uid 25550, Bronco All Terrain Tracked Carrier (ATTC)
    }
}
