package edu.nps.moves.dis7.entities.per.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@36074e47
 * Country: Peru (PER)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 28252
 */
public class Auxiliary extends EntityType
{
    public Auxiliary()
    {
        setCountry(Country.PERU_PER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 28252, Auxiliary
    }
}
