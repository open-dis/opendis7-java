package edu.nps.moves.dis7.entities.are.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@37468787
 * Country: United Arab Emirates (ARE)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24599
 */
public class AlDhabiyyah extends EntityType
{
    public AlDhabiyyah()
    {
        setCountry(Country.UNITED_ARAB_EMIRATES_ARE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24597, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)2); // uid 24598, Dry Bulk Cargo Ship
        setSpecific((byte)1); // uid 24599, Al Dhabiyyah
    }
}
