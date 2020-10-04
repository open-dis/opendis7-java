package edu.nps.moves.dis7.entities.rus.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@537ca28e
 * Country: Russia (RUS)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32406
 */
public class SS26Stone9K720Iskander extends EntityType
{
    public SS26Stone9K720Iskander()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 27168, Guided
        setSubCategory((byte)7); // uid 32406, SS-26 Stone (9K720 Iskander)
    }
}
