package edu.nps.moves.dis7.entities.kor.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4a8a60bc
 * Country: Korea (Republic of) (KOR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 23763
 */
public class KH178105mmtowedhowitzer extends EntityType
{
    public KH178105mmtowedhowitzer()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 23762, Towed Artillery - (Anti-Tank guns, guns and howitzers)
        setSubCategory((byte)1); // uid 23763, KH-178 105mm towed howitzer
    }
}
