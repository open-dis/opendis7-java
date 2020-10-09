package edu.nps.moves.dis7.entities.usa.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@70b6db83
 * Country: United States of America (USA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 28478
 */
public class AllWeather38ftSAFEBoat extends EntityType
{
    public AllWeather38ftSAFEBoat()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)84); // uid 26437, Private Motorboat
        setSubCategory((byte)2); // uid 28475, Medium Motorboat (up to 39ft/11.9m)
        setSpecific((byte)1); // uid 28476, U.S. Customs and Border Patrol (CBP) Interceptor Class
        setExtra((byte)2); // uid 28478, All-Weather 38ft SAFE Boat
    }
}
