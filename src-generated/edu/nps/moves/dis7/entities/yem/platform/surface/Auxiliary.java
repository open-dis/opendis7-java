package edu.nps.moves.dis7.entities.yem.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@756b2d90
 * Country: Yemen (YEM)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18745
 */
public class Auxiliary extends EntityType
{
    public Auxiliary()
    {
        setCountry(Country.YEMEN_YEM);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 18745, Auxiliary
    }
}
