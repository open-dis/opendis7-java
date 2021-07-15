package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@c689973;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 24957
 */
public class ATV4X4PolarisSportsmanMV extends EntityType
{
    /** Default constructor */
    public ATV4X4PolarisSportsmanMV()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)90); // uid 24955, Recreational
        setSubCategory((byte)2); // uid 24956, ATV, 4X4
        setSpecific((byte)1); // uid 24957, ATV 4X4, Polaris Sportsman MV
    }
}
