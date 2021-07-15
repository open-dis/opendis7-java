package edu.nps.moves.dis7.entities.fra.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@66982506;
 * Country: France (FRA);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 28167
 */
public class CMACGMMedea extends EntityType
{
    /** Default constructor */
    public CMACGMMedea()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 28165, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)3); // uid 28166, Container Ship
        setSpecific((byte)1); // uid 28167, CMA CGM Medea
    }
}
