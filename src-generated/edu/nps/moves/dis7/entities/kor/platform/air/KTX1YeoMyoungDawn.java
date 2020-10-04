package edu.nps.moves.dis7.entities.kor.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3c9168dc
 * Country: Korea (Republic of) (KOR)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 17632
 */
public class KTX1YeoMyoungDawn extends EntityType
{
    public KTX1YeoMyoungDawn()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 17631, Trainer
        setSubCategory((byte)1); // uid 17632, KTX-1 Yeo-Myoung (Dawn)
    }
}
