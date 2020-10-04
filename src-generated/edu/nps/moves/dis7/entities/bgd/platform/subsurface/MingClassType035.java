package edu.nps.moves.dis7.entities.bgd.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@9629756
 * Country: Bangladesh (BGD)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 32632
 */
public class MingClassType035 extends EntityType
{
    public MingClassType035()
    {
        setCountry(Country.BANGLADESH_BGD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 32631, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)1); // uid 32632, Ming Class (Type 035)
    }
}
