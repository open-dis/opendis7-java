package edu.nps.moves.dis7.entities.mlt.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@687a762c
 * Country: Malta (MLT)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24491
 */
public class DryBulkCargoShip extends EntityType
{
    public DryBulkCargoShip()
    {
        setCountry(Country.MALTA_MLT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24490, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)2); // uid 24491, Dry Bulk Cargo Ship
    }
}
