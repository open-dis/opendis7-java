package edu.nps.moves.dis7.entities.rus.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@58294867
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 23823
 */
public class CivilianFixedWingAircraftLargeupto255000lbs115666kg extends EntityType
{
    public CivilianFixedWingAircraftLargeupto255000lbs115666kg()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)87); // uid 23823, Civilian Fixed Wing Aircraft, Large (up to 255,000 lbs / 115,666 kg)
    }
}
