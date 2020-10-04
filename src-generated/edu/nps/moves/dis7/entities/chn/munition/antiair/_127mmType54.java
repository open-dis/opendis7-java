package edu.nps.moves.dis7.entities.chn.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@72465eb2
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Munition
 * Domain: ANTI_AIR
 *
 * Entity type uid: 21336
 */
public class _127mmType54 extends EntityType
{
    public _127mmType54()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)2); // uid 21335, Ballistic
        setSubCategory((byte)1); // uid 21336, 12.7 mm Type 54
    }
}
