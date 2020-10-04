package edu.nps.moves.dis7.entities.chn.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5b02a984
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Munition
 * Domain: ANTI_ARMOR
 *
 * Entity type uid: 29114
 */
public class HJ9B extends EntityType
{
    public HJ9B()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)1); // uid 21353, Guided
        setSubCategory((byte)4); // uid 29111, Red Arrow 9 / HongJian-9 / HJ-9
        setSpecific((byte)3); // uid 29114, HJ-9B
    }
}
