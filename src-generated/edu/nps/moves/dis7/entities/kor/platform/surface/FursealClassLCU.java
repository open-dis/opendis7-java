package edu.nps.moves.dis7.entities.kor.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@f9b7332;
 * Country: Korea (Republic of) (KOR);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 17715
 */
public class FursealClassLCU extends EntityType
{
    /** Default constructor */
    public FursealClassLCU()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 17711, Auxiliary
        setSubCategory((byte)2); // uid 17715, Furseal Class (LCU)
    }
}