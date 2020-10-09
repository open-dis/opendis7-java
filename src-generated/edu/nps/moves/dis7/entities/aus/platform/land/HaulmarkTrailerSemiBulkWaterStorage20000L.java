package edu.nps.moves.dis7.entities.aus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4ca8195f
 * Country: Australia (AUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 29409
 */
public class HaulmarkTrailerSemiBulkWaterStorage20000L extends EntityType
{
    public HaulmarkTrailerSemiBulkWaterStorage20000L()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)17); // uid 29403, Water Trailer
        setSubCategory((byte)3); // uid 29408, Greater than 5000 Gallons
        setSpecific((byte)1); // uid 29409, Haulmark - Trailer, Semi, Bulk Water Storage, 20000L
    }
}
