package edu.nps.moves.dis7.entities.ind.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5b1ebf56
 * Country: India (IND)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 30219
 */
public class A50EI extends EntityType
{
    public A50EI()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 30217, Surveillance/C2 (Airborne Early Warning)
        setSubCategory((byte)1); // uid 30218, Beriev A-50 Mainstay
        setSpecific((byte)1); // uid 30219, A-50E/I
    }
}
