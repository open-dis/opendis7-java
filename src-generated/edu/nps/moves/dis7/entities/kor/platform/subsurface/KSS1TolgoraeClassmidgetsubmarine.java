package edu.nps.moves.dis7.entities.kor.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@54709809
 * Country: Korea (Republic of) (KOR)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 17743
 */
public class KSS1TolgoraeClassmidgetsubmarine extends EntityType
{
    public KSS1TolgoraeClassmidgetsubmarine()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)7); // uid 17742, SSA (Conventional Auxiliary)
        setSubCategory((byte)1); // uid 17743, KSS-1 Tolgorae Class (midget submarine)
    }
}
