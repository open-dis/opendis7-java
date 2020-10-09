package edu.nps.moves.dis7.entities.ind.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@737a135b
 * Country: India (IND)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 27229
 */
public class S44Shishumar extends EntityType
{
    public S44Shishumar()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 23189, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)2); // uid 27228, Shishumar Class
        setSpecific((byte)1); // uid 27229, S44 Shishumar
    }
}
