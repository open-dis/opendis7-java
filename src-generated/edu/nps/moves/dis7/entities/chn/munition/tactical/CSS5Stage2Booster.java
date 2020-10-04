package edu.nps.moves.dis7.entities.chn.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@36c07c75
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32454
 */
public class CSS5Stage2Booster extends EntityType
{
    public CSS5Stage2Booster()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 32412, Guided
        setSubCategory((byte)23); // uid 32450, CSS-5 (DF-21)
        setSpecific((byte)4); // uid 32454, CSS-5 Stage 2 Booster
    }
}
