package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@32ec9c90
 * Country: United States of America (USA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 22920
 */
public class SemitrailerVan6tonM146 extends EntityType
{
    public SemitrailerVan6tonM146()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)20); // uid 10646, Maintenance equipment trailer
        setSubCategory((byte)3); // uid 10649, Tools/parts trailer
        setSpecific((byte)2); // uid 22920, Semi-trailer, Van, 6-ton, M146
    }
}
