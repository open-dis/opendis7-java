package edu.nps.moves.dis7.entities.kor.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1601e47
 * Country: Korea (Republic of) (KOR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 17699
 */
public class USMSC268Classminesweepercoastal extends EntityType
{
    public USMSC268Classminesweepercoastal()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 17691, Mine Countermeasure Ship/Craft
        setSubCategory((byte)2); // uid 17699, US MSC 268 Class (minesweeper-coastal)
    }
}
