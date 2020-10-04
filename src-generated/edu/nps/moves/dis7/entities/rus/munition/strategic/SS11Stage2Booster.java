package edu.nps.moves.dis7.entities.rus.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@591be8aa
 * Country: Russia (RUS)
 * Entity kind: Munition
 * Domain: STRATEGIC
 *
 * Entity type uid: 32378
 */
public class SS11Stage2Booster extends EntityType
{
    public SS11Stage2Booster()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 20919, Guided
        setSubCategory((byte)45); // uid 32374, SS-11 Sego
        setSpecific((byte)4); // uid 32378, SS-11 Stage 2 Booster
    }
}
