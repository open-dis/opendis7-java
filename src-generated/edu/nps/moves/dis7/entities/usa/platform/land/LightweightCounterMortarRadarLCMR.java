package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@467233e4;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31245
 */
public class LightweightCounterMortarRadarLCMR extends EntityType
{
    /** Default constructor */
    public LightweightCounterMortarRadarLCMR()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 10679, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)10); // uid 31245, Lightweight Counter Mortar Radar (LCMR)
    }
}