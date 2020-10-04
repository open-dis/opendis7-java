package edu.nps.moves.dis7.entities.usa.munition.other;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@8ac12e6
 * Country: United States of America (USA)
 * Entity kind: Munition
 * Domain: OTHER
 *
 * Entity type uid: 19402
 */
public class MineclearingtorpedoBangalore extends EntityType
{
    public MineclearingtorpedoBangalore()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.OTHER));

        setCategory((byte)3); // uid 19401, Fixed
        setSubCategory((byte)1); // uid 19402, Mine-clearing torpedo, Bangalore
    }
}
