package edu.nps.moves.dis7.entities.kwt.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4e4efc1b
 * Country: Kuwait (KWT)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 17931
 */
public class S5509Qaruh extends EntityType
{
    public S5509Qaruh()
    {
        setCountry(Country.KUWAIT_KWT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 17927, Auxiliary
        setSubCategory((byte)2); // uid 17930, Support Ship (AG)
        setSpecific((byte)1); // uid 17931, S5509 Qaruh
    }
}
