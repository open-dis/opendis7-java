package edu.nps.moves.dis7.entities.oth.culturalfeature.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@702f4124
 * Country: Other
 * Entity kind: Cultural feature
 * Domain: SUBSURFACE
 *
 * Entity type uid: 29788
 */
public class UnderwaterTidalSteamPowerStation extends EntityType
{
    public UnderwaterTidalSteamPowerStation()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 29783, Electrical Power Installation
        setSubCategory((byte)3); // uid 29787, Tidal Power Station
        setSpecific((byte)1); // uid 29788, Underwater Tidal Steam Power Station
    }
}
