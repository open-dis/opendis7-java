package edu.nps.moves.dis7.entities.rus.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@42107318
 * Country: Russia (RUS)
 * Entity kind: Munition
 * Domain: STRATEGIC
 *
 * Entity type uid: 32394
 */
public class SS25Stage1Booster extends EntityType
{
    public SS25Stage1Booster()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 20919, Guided
        setSubCategory((byte)22); // uid 20946, SS-25 Sickle
        setSpecific((byte)5); // uid 32394, SS-25 Stage 1 Booster
    }
}
