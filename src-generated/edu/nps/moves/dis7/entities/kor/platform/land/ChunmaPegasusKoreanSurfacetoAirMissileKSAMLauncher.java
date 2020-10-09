package edu.nps.moves.dis7.entities.kor.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7859e786
 * Country: Korea (Republic of) (KOR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 31328
 */
public class ChunmaPegasusKoreanSurfacetoAirMissileKSAMLauncher extends EntityType
{
    public ChunmaPegasusKoreanSurfacetoAirMissileKSAMLauncher()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 31327, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)1); // uid 31328, Chunma (Pegasus) Korean Surface-to-Air Missile (K-SAM) Launcher
    }
}
