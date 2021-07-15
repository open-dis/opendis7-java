package edu.nps.moves.dis7.entities.aus.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2db0f6b2;
 * Country: Australia (AUS);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 31677
 */
public class BoeingP8MultiMissionMaritimeAircraftMMA extends EntityType
{
    /** Default constructor */
    public BoeingP8MultiMissionMaritimeAircraftMMA()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)5); // uid 26358, ASW/Patrol/Observation
        setSubCategory((byte)2); // uid 31677, Boeing P-8 Multi-Mission Maritime Aircraft (MMA)
    }
}
