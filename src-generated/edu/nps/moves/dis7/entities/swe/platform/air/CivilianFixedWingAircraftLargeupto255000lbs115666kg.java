package edu.nps.moves.dis7.entities.swe.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@4047d2d9
 * Country: Sweden (SWE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24355
 */
public class CivilianFixedWingAircraftLargeupto255000lbs115666kg extends EntityType
{
    public CivilianFixedWingAircraftLargeupto255000lbs115666kg()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)87); // uid 24355, Civilian Fixed Wing Aircraft, Large (up to 255,000 lbs / 115,666 kg)
    }
}
