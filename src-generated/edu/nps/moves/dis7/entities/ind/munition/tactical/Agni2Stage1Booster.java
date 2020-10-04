package edu.nps.moves.dis7.entities.ind.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@447521e
 * Country: India (IND)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32537
 */
public class Agni2Stage1Booster extends EntityType
{
    public Agni2Stage1Booster()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 32533, Guided
        setSubCategory((byte)1); // uid 32534, Agni 2
        setSpecific((byte)3); // uid 32537, Agni 2 Stage 1 Booster
    }
}
