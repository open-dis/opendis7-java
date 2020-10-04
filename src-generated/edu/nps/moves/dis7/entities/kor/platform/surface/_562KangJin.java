package edu.nps.moves.dis7.entities.kor.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@cdc3aae
 * Country: Korea (Republic of) (KOR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 17694
 */
public class _562KangJin extends EntityType
{
    public _562KangJin()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 17691, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 17692, Swallow Class (minehunter)
        setSpecific((byte)2); // uid 17694, 562 Kang Jin
    }
}
