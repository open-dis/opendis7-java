package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2e463f4
 * Country: United States of America (USA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 10650
 */
public class M129A2CSemiTrailerVanMaint12ton extends EntityType
{
    public M129A2CSemiTrailerVanMaint12ton()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)20); // uid 10646, Maintenance equipment trailer
        setSubCategory((byte)3); // uid 10649, Tools/parts trailer
        setSpecific((byte)1); // uid 10650, M129A2C Semi-Trailer, Van, Maint, 12-ton
    }
}
