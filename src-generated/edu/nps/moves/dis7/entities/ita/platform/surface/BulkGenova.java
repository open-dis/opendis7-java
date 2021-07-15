package edu.nps.moves.dis7.entities.ita.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@305f7627;
 * Country: Italy (ITA);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 24457
 */
public class BulkGenova extends EntityType
{
    /** Default constructor */
    public BulkGenova()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24454, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)3); // uid 24455, Container Ship
        setSpecific((byte)2); // uid 24457, Bulk Genova
    }
}
