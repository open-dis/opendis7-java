package edu.nps.moves.dis7.entities.irn.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@9408857
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Munition
 * Domain: STRATEGIC
 *
 * Entity type uid: 32490
 */
public class Ashura extends EntityType
{
    public Ashura()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 21715, Guided
        setSubCategory((byte)20); // uid 32490, Ashura
    }
}
