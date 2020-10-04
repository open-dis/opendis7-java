package edu.nps.moves.dis7.entities.kor.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@61078690
 * Country: Korea (Republic of) (KOR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 23756
 */
public class K200KoreanInfantryFightingVehicleKIFV extends EntityType
{
    public K200KoreanInfantryFightingVehicleKIFV()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 17623, Armored Fighting Vehicle
        setSubCategory((byte)2); // uid 23756, K-200 Korean Infantry Fighting Vehicle (KIFV)
    }
}
