package edu.nps.moves.dis7.entities.rus.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@72a7aa4f
 * Country: Russia (RUS)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32408
 */
public class SS26Stage1Booster extends EntityType
{
    public SS26Stage1Booster()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 27168, Guided
        setSubCategory((byte)7); // uid 32406, SS-26 Stone (9K720 Iskander)
        setSpecific((byte)2); // uid 32408, SS-26 Stage 1 Booster
    }
}
