package edu.nps.moves.dis7.entities.irn.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7d50f2a8
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 33077
 */
public class Qiam1SpentBooster extends EntityType
{
    public Qiam1SpentBooster()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 32473, Guided
        setSubCategory((byte)104); // uid 33075, Qiam 1
        setSpecific((byte)2); // uid 33077, Qiam 1 Spent Booster
    }
}
