package edu.nps.moves.dis7.entities.deu.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@38234a38
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 16796
 */
public class S182U32 extends EntityType
{
    public S182U32()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 16757, SS (Conventional attack-torpedo patrol)
        setSubCategory((byte)6); // uid 16794, Type 212A
        setSpecific((byte)2); // uid 16796, S 182 U 32
    }
}
