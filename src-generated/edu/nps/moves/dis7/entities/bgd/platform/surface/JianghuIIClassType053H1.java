package edu.nps.moves.dis7.entities.bgd.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@402f32ff
 * Country: Bangladesh (BGD)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 26772
 */
public class JianghuIIClassType053H1 extends EntityType
{
    public JianghuIIClassType053H1()
    {
        setCountry(Country.BANGLADESH_BGD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 26771, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 26772, Jianghu-II Class (Type 053H1)
    }
}
