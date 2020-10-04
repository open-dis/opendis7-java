package edu.nps.moves.dis7.entities.pak.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@377c68c6
 * Country: Pakistan (PAK)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 30456
 */
public class AntiSubmarineWarfarePatrolHelicopter extends EntityType
{
    public AntiSubmarineWarfarePatrolHelicopter()
    {
        setCountry(Country.PAKISTAN_PAK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)22); // uid 30456, Anti-Submarine Warfare/Patrol Helicopter
    }
}
