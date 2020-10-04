package edu.nps.moves.dis7.entities.prk.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7c22d4f
 * Country: Korea (Democratic Peoples Republic of) (PRK)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 17774
 */
public class SomanClasslargepatrolcraft extends EntityType
{
    public SomanClasslargepatrolcraft()
    {
        setCountry(Country.KOREA_DEMOCRATIC_PEOPLES_REPUBLIC_OF_PRK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 17768, Light/patrol Craft
        setSubCategory((byte)5); // uid 17774, Soman Class (large patrol craft)
    }
}
