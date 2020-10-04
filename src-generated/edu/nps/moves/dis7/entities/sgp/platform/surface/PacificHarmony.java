package edu.nps.moves.dis7.entities.sgp.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@73fb1d7f
 * Country: Singapore (SGP)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24570
 */
public class PacificHarmony extends EntityType
{
    public PacificHarmony()
    {
        setCountry(Country.SINGAPORE_SGP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24550, Tanker (Group 3 Merchant)
        setSubCategory((byte)1); // uid 24551, Liquid Petroleum Gas (LPG)Tanker
        setSpecific((byte)2); // uid 24570, Pacific Harmony
    }
}
