package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4e224df5
 * Country: United States of America (USA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 10744
 */
public class JLENSPTIRProcessingStation extends EntityType
{
    public JLENSPTIRProcessingStation()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)32); // uid 10742, Surveillance Facility
        setSubCategory((byte)1); // uid 10743, JLENS Processing Stations (General)
        setSpecific((byte)1); // uid 10744, JLENS PTIR Processing Station
    }
}
