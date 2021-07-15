package edu.nps.moves.dis7.entities.oth.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@53bf7094;
 * Country: Other;
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 24712
 */
public class CivilianFixedWingAircraftHeavyabove255000lbs115666kg extends EntityType
{
    /** Default constructor */
    public CivilianFixedWingAircraftHeavyabove255000lbs115666kg()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)88); // uid 24712, Civilian Fixed Wing Aircraft, Heavy (above 255,000 lbs / 115,666 kg)
    }
}
