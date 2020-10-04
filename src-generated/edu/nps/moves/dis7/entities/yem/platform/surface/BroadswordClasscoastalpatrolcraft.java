package edu.nps.moves.dis7.entities.yem.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@44d7e24
 * Country: Yemen (YEM)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18739
 */
public class BroadswordClasscoastalpatrolcraft extends EntityType
{
    public BroadswordClasscoastalpatrolcraft()
    {
        setCountry(Country.YEMEN_YEM);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 18738, Light/Patrol Craft
        setSubCategory((byte)1); // uid 18739, Broadsword Class (coastal patrol craft)
    }
}
