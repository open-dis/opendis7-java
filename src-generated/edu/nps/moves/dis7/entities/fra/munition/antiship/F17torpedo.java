package edu.nps.moves.dis7.entities.fra.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@571a663c
 * Country: France (FRA)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 21105
 */
public class F17torpedo extends EntityType
{
    public F17torpedo()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 21088, Guided
        setSubCategory((byte)11); // uid 21105, F-17 torpedo
    }
}
