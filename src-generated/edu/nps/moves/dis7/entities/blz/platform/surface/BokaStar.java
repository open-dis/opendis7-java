package edu.nps.moves.dis7.entities.blz.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@482f8f11
 * Country: Belize (BLZ)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24497
 */
public class BokaStar extends EntityType
{
    public BokaStar()
    {
        setCountry(Country.BELIZE_BLZ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24495, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)5); // uid 24496, Ro-Ro Ship (Roll-on/Roll-off Ship)
        setSpecific((byte)1); // uid 24497, Boka Star
    }
}
