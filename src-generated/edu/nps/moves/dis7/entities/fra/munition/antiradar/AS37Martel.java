package edu.nps.moves.dis7.entities.fra.munition.antiradar;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@755b5f30
 * Country: France (FRA)
 * Entity kind: Munition
 * Domain: ANTI_RADAR
 *
 * Entity type uid: 21086
 */
public class AS37Martel extends EntityType
{
    public AS37Martel()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_RADAR));

        setCategory((byte)1); // uid 21084, Guided
        setSubCategory((byte)2); // uid 21086, AS 37 Martel
    }
}
