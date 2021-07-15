package edu.nps.moves.dis7.entities.bhs.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@13969fbe;
 * Country: Bahamas (BHS);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 24563
 */
public class AfricanLion extends EntityType
{
    /** Default constructor */
    public AfricanLion()
    {
        setCountry(Country.BAHAMAS_BHS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24482, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)2); // uid 24562, Dry Bulk Cargo Ship
        setSpecific((byte)1); // uid 24563, African Lion
    }
}
