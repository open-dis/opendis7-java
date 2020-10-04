package edu.nps.moves.dis7.entities.chn.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2b999ee8
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32455
 */
public class CSSN3JL1 extends EntityType
{
    public CSSN3JL1()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 32412, Guided
        setSubCategory((byte)43); // uid 32455, CSS-N-3 (JL-1)
    }
}
