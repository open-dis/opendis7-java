package edu.nps.moves.dis7.entities.phl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6c8a68c1
 * Country: Philippines (PHL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 31153
 */
public class _290AgtaexL126Balikpapan extends EntityType
{
    public _290AgtaexL126Balikpapan()
    {
        setCountry(Country.PHILIPPINES_PHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)11); // uid 31149, Landing Craft
        setSubCategory((byte)1); // uid 31150, Ivatan Class (ex Balikpapan Class)
        setSpecific((byte)3); // uid 31153, 290 Agta (ex L 126 Balikpapan)
    }
}
