package edu.nps.moves.dis7.entities.rou.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5e76a2bb
 * Country: Romania (ROU)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 27819
 */
public class KiloClass extends EntityType
{
    public KiloClass()
    {
        setCountry(Country.ROMANIA_ROU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 27818, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)1); // uid 27819, Kilo Class
    }
}
