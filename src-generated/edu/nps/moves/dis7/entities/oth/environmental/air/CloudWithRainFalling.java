package edu.nps.moves.dis7.entities.oth.environmental.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@7e2c6fd6
 * Country: Other
 * Entity kind: Environmental
 * Domain: AIR
 *
 * Entity type uid: 21916
 */
public class CloudWithRainFalling extends EntityType
{
    public CloudWithRainFalling()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.ENVIRONMENTAL);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 21916, Cloud With Rain Falling
    }
}
