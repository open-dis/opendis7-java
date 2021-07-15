package edu.nps.moves.dis7.entities.usa.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@34be065a;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 10931
 */
public class BoeingRockwellYAL1AirborneLaserABL extends EntityType
{
    /** Default constructor */
    public BoeingRockwellYAL1AirborneLaserABL()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 10867, Cargo/Tanker
        setSubCategory((byte)10); // uid 10928, Boeing 747
        setSpecific((byte)3); // uid 10931, Boeing/Rockwell YAL-1 Airborne Laser (ABL)
    }
}
