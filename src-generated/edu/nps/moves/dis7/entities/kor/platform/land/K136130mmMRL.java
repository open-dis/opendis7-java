package edu.nps.moves.dis7.entities.kor.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3624da92;
 * Country: Korea (Republic of) (KOR);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 23761
 */
public class K136130mmMRL extends EntityType
{
    /** Default constructor */
    public K136130mmMRL()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 23759, Self-Propelled Artillery
        setSubCategory((byte)2); // uid 23761, K-136 130mm MRL
    }
}
