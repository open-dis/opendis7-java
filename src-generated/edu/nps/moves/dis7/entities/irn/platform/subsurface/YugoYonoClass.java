package edu.nps.moves.dis7.entities.irn.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@56aaaecd
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 30890
 */
public class YugoYonoClass extends EntityType
{
    public YugoYonoClass()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)12); // uid 30889, SSM (Midget Submarine, under 150 tons)
        setSubCategory((byte)1); // uid 30890, Yugo (Yono) Class
    }
}
