package edu.nps.moves.dis7.entities.mlt.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@452e26d0
 * Country: Malta (MLT)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27572
 */
public class KondorIClass extends EntityType
{
    public KondorIClass()
    {
        setCountry(Country.MALTA_MLT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27571, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 27572, Kondor I Class
    }
}
