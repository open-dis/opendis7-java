package edu.nps.moves.dis7.entities.yem.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1c98b4eb
 * Country: Yemen (YEM)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18748
 */
public class _140tankeroil extends EntityType
{
    public _140tankeroil()
    {
        setCountry(Country.YEMEN_YEM);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 18745, Auxiliary
        setSubCategory((byte)1); // uid 18746, Toplivo Class
        setSpecific((byte)2); // uid 18748, 140 (tanker-oil)
    }
}
