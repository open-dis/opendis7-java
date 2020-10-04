package edu.nps.moves.dis7.entities.csk.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@30c15d8b
 * Country: Czechoslovakia (CSK)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 25373
 */
public class Mi171ShHipH extends EntityType
{
    public Mi171ShHipH()
    {
        setCountry(Country.CZECHOSLOVAKIA_CSK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)21); // uid 25371, Utility Helicopter
        setSubCategory((byte)1); // uid 25372, Mi-17
        setSpecific((byte)1); // uid 25373, Mi-171Sh Hip-H
    }
}
