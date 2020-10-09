package edu.nps.moves.dis7.entities.prt.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@77bb0ab5
 * Country: Portugal (PRT)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29613
 */
public class P3C extends EntityType
{
    public P3C()
    {
        setCountry(Country.PORTUGAL_PRT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)5); // uid 29611, ASW/Patrol/Observation
        setSubCategory((byte)1); // uid 29612, P-3 Orion
        setSpecific((byte)1); // uid 29613, P-3C
    }
}
