package edu.nps.moves.dis7.entities.pak.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@537b32ef
 * Country: Pakistan (PAK)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 27236
 */
public class S137Khalid extends EntityType
{
    public S137Khalid()
    {
        setCountry(Country.PAKISTAN_PAK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 27234, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)1); // uid 27235, Khalid / Agosta 90B Class
        setSpecific((byte)1); // uid 27236, S137 Khalid
    }
}
