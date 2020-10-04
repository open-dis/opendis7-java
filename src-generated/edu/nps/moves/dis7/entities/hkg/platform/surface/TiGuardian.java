package edu.nps.moves.dis7.entities.hkg.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@16fdec90
 * Country: Hong Kong (HKG)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24537
 */
public class TiGuardian extends EntityType
{
    public TiGuardian()
    {
        setCountry(Country.HONG_KONG_HKG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24535, Tanker (Group 3 Merchant)
        setSubCategory((byte)5); // uid 24536, Crude Oil Tanker (up to 159,999 DWT)
        setSpecific((byte)1); // uid 24537, Ti Guardian
    }
}
