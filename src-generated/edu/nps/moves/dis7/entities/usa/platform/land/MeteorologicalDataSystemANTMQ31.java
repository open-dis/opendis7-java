package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3a17b2e3;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 23659
 */
public class MeteorologicalDataSystemANTMQ31 extends EntityType
{
    /** Default constructor */
    public MeteorologicalDataSystemANTMQ31()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)35); // uid 10748, C4I Facility
        setSubCategory((byte)3); // uid 23659, Meteorological Data System, AN/TMQ-31
    }
}