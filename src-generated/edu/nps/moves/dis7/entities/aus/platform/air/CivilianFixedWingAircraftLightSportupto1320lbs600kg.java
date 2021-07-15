package edu.nps.moves.dis7.entities.aus.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@60215eee;
 * Country: Australia (AUS);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 29569
 */
public class CivilianFixedWingAircraftLightSportupto1320lbs600kg extends EntityType
{
    /** Default constructor */
    public CivilianFixedWingAircraftLightSportupto1320lbs600kg()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)84); // uid 29569, Civilian Fixed Wing Aircraft, Light Sport (up to 1320 lbs / 600 kg)
    }
}
