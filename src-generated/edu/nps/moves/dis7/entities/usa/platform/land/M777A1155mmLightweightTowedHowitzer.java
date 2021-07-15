package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@abbe000;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 26230
 */
public class M777A1155mmLightweightTowedHowitzer extends EntityType
{
    /** Default constructor */
    public M777A1155mmLightweightTowedHowitzer()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 10312, Towed artillery
        setSubCategory((byte)6); // uid 10320, M777 155-mm Lightweight Towed Howitzer
        setSpecific((byte)1); // uid 26230, M777A1 155-mm Lightweight Towed Howitzer
    }
}
