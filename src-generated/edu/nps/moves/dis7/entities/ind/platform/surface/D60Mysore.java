package edu.nps.moves.dis7.entities.ind.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4748a0f9
 * Country: India (IND)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23157
 */
public class D60Mysore extends EntityType
{
    public D60Mysore()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)4); // uid 18824, Guided Missile Destroyer (DDG)
        setSubCategory((byte)1); // uid 18825, Delhi Class
        setSpecific((byte)1); // uid 23157, D60 Mysore
    }
}
