package edu.nps.moves.dis7.entities.dza.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@73a8dfcc
 * Country: Algeria (DZA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27752
 */
public class _937Soummam extends EntityType
{
    public _937Soummam()
    {
        setCountry(Country.ALGERIA_DZA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 27750, Auxiliary
        setSubCategory((byte)1); // uid 27751, Daxin Class
        setSpecific((byte)1); // uid 27752, 937 Soummam
    }
}
