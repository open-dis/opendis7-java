package edu.nps.moves.dis7.entities.ind.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6bca7e0d;
 * Country: India (IND);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 31439
 */
public class P8INeptune extends EntityType
{
    /** Default constructor */
    public P8INeptune()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)5); // uid 31437, ASW/Patrol/Observation
        setSubCategory((byte)1); // uid 31438, Boeing P-8 Multi-Mission Maritime Aircraft (MMA)
        setSpecific((byte)1); // uid 31439, P-8I Neptune
    }
}
