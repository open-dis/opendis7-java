package edu.nps.moves.dis7.entities.fra.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5b48f0f4
 * Country: France (FRA)
 * Entity kind: Munition
 * Domain: ANTI_AIR
 *
 * Entity type uid: 21049
 */
public class _20mm extends EntityType
{
    public _20mm()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)2); // uid 21048, Ballistic
        setSubCategory((byte)1); // uid 21049, 20 mm
    }
}
