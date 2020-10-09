package edu.nps.moves.dis7.entities.bgd.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@51081592
 * Country: Bangladesh (BGD)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 32633
 */
public class S161Nabajatra extends EntityType
{
    public S161Nabajatra()
    {
        setCountry(Country.BANGLADESH_BGD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 32631, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)1); // uid 32632, Ming Class (Type 035)
        setSpecific((byte)1); // uid 32633, S161 Nabajatra
    }
}
