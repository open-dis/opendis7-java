package edu.nps.moves.dis7.entities.irn.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@22a4ca4a
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Munition
 * Domain: ANTI_AIR
 *
 * Entity type uid: 28966
 */
public class Sedjil extends EntityType
{
    public Sedjil()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 27268, Guided
        setSubCategory((byte)4); // uid 28966, Sedjil
    }
}
