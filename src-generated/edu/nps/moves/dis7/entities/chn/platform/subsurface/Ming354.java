package edu.nps.moves.dis7.entities.chn.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5c33f1a9
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 17458
 */
public class Ming354 extends EntityType
{
    public Ming354()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 17451, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)1); // uid 17452, Ming Class (Type 035)
        setSpecific((byte)6); // uid 17458, Ming 354
    }
}
