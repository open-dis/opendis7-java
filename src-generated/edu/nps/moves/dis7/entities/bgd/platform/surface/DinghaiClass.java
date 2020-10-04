package edu.nps.moves.dis7.entities.bgd.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1810399e
 * Country: Bangladesh (BGD)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 32618
 */
public class DinghaiClass extends EntityType
{
    public DinghaiClass()
    {
        setCountry(Country.BANGLADESH_BGD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 32617, Auxiliary
        setSubCategory((byte)1); // uid 32618, Dinghai Class
    }
}
