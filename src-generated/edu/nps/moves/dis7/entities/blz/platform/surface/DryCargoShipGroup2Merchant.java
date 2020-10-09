package edu.nps.moves.dis7.entities.blz.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@1b604f19
 * Country: Belize (BLZ)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24495
 */
public class DryCargoShipGroup2Merchant extends EntityType
{
    public DryCargoShipGroup2Merchant()
    {
        setCountry(Country.BELIZE_BLZ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24495, Dry Cargo Ship (Group 2 Merchant)
    }
}
