package edu.nps.moves.dis7.entities.prk.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5f2606b
 * Country: Korea (Democratic Peoples Republic of) (PRK)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 17766
 */
public class SohoClass extends EntityType
{
    public SohoClass()
    {
        setCountry(Country.KOREA_DEMOCRATIC_PEOPLES_REPUBLIC_OF_PRK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 17765, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 17766, Soho Class
    }
}
