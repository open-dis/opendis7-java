package edu.nps.moves.dis7.entities.kor.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@47874b25
 * Country: Korea (Republic of) (KOR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 29525
 */
public class DDH979GangGamchan extends EntityType
{
    public DDH979GangGamchan()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)4); // uid 23145, Guided Missile Destroyer (DDG)
        setSubCategory((byte)2); // uid 29520, Chungmugong Yi Sun-sin Class (KDX-II)
        setSpecific((byte)5); // uid 29525, DDH-979 Gang Gam-chan
    }
}
