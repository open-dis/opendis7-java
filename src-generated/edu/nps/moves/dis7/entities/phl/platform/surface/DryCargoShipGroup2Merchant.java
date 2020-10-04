package edu.nps.moves.dis7.entities.phl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@111610e6
 * Country: Philippines (PHL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24559
 */
public class DryCargoShipGroup2Merchant extends EntityType
{
    public DryCargoShipGroup2Merchant()
    {
        setCountry(Country.PHILIPPINES_PHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24559, Dry Cargo Ship (Group 2 Merchant)
    }
}
