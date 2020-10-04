package edu.nps.moves.dis7.entities.irn.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@374ccb9
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32489
 */
public class Shahab3SpentBooster extends EntityType
{
    public Shahab3SpentBooster()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 32473, Guided
        setSubCategory((byte)65); // uid 32487, Shahab 3
        setSpecific((byte)2); // uid 32489, Shahab 3 Spent Booster
    }
}
