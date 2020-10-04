package edu.nps.moves.dis7.entities.chn.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5111de7c
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Munition
 * Domain: STRATEGIC
 *
 * Entity type uid: 32791
 */
public class DF26BStage1Booster extends EntityType
{
    public DF26BStage1Booster()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 21556, Guided
        setSubCategory((byte)38); // uid 32788, DF-26B
        setSpecific((byte)4); // uid 32791, DF-26B Stage 1 Booster
    }
}
