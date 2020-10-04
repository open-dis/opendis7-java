package edu.nps.moves.dis7.entities.pak.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@261d8190
 * Country: Pakistan (PAK)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19347
 */
public class A49Gwadar extends EntityType
{
    public A49Gwadar()
    {
        setCountry(Country.PAKISTAN_PAK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 19343, Auxiliary
        setSubCategory((byte)2); // uid 19346, Coastal Tankers (AOTL)
        setSpecific((byte)1); // uid 19347, A49 Gwadar
    }
}
