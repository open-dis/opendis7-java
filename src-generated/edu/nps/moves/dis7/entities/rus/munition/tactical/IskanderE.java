package edu.nps.moves.dis7.entities.rus.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7f642bf;
 * Country: Russia (RUS);
 * Entity kind: Munition;
 * Domain: TACTICAL;
 *
 * Entity type uid: 32409
 */
public class IskanderE extends EntityType
{
    /** Default constructor */
    public IskanderE()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 27168, Guided
        setSubCategory((byte)4); // uid 32409, Iskander-E
    }
}
