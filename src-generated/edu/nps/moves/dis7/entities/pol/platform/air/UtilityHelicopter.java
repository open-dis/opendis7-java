package edu.nps.moves.dis7.entities.pol.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@4bf324f9
 * Country: Poland (POL)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24803
 */
public class UtilityHelicopter extends EntityType
{
    public UtilityHelicopter()
    {
        setCountry(Country.POLAND_POL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)21); // uid 24803, Utility Helicopter
    }
}
