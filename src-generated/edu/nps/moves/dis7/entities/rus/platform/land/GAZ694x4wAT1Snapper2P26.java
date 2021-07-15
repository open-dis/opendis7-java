package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@72805168;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 26314
 */
public class GAZ694x4wAT1Snapper2P26 extends EntityType
{
    /** Default constructor */
    public GAZ694x4wAT1Snapper2P26()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)6); // uid 12854, Small Wheeled Utility Vehicle
        setSubCategory((byte)1); // uid 12855, GAZ-69 4x4 light vehicle
        setSpecific((byte)2); // uid 26314, GAZ-69 4x4 w/ AT-1 Snapper (2P26)
    }
}
