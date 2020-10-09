package edu.nps.moves.dis7.entities.dnk.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@557caf28
 * Country: Denmark (DNK)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24136
 */
public class UtilityHelicopter extends EntityType
{
    public UtilityHelicopter()
    {
        setCountry(Country.DENMARK_DNK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)21); // uid 24136, Utility Helicopter
    }
}
