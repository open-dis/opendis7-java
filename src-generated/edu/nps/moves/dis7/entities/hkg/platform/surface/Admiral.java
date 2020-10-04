package edu.nps.moves.dis7.entities.hkg.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6f3c660a
 * Country: Hong Kong (HKG)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24596
 */
public class Admiral extends EntityType
{
    public Admiral()
    {
        setCountry(Country.HONG_KONG_HKG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24589, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)2); // uid 24590, Dry Bulk Cargo Ship
        setSpecific((byte)2); // uid 24596, Admiral
    }
}
