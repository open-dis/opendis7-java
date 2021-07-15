package edu.nps.moves.dis7.entities.prt.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@790132f7;
 * Country: Portugal (PRT);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 29611
 */
public class ASWPatrolObservation extends EntityType
{
    /** Default constructor */
    public ASWPatrolObservation()
    {
        setCountry(Country.PORTUGAL_PRT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)5); // uid 29611, ASW/Patrol/Observation
    }
}
