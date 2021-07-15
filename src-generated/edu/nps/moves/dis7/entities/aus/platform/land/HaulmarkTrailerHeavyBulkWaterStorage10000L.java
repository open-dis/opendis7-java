package edu.nps.moves.dis7.entities.aus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@299a06ac;
 * Country: Australia (AUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 29407
 */
public class HaulmarkTrailerHeavyBulkWaterStorage10000L extends EntityType
{
    /** Default constructor */
    public HaulmarkTrailerHeavyBulkWaterStorage10000L()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)17); // uid 29403, Water Trailer
        setSubCategory((byte)2); // uid 29405, 1001- 5000 Gallons
        setSpecific((byte)2); // uid 29407, Haulmark - Trailer, Heavy, Bulk Water Storage, 10000L
    }
}
