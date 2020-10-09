package edu.nps.moves.dis7.entities.irn.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@16e1219f
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Munition
 * Domain: STRATEGIC
 *
 * Entity type uid: 32495
 */
public class Shahab4SeparatedWarhead extends EntityType
{
    public Shahab4SeparatedWarhead()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 21715, Guided
        setSubCategory((byte)22); // uid 32492, Shahab 4
        setSpecific((byte)3); // uid 32495, Shahab 4 Separated Warhead
    }
}
