package edu.nps.moves.dis7.entities.usa.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6785c9fa
 * Country: United States of America (USA)
 * Entity kind: Munition
 * Domain: STRATEGIC
 *
 * Entity type uid: 20283
 */
public class AGM86BALCM extends EntityType
{
    public AGM86BALCM()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 20282, Guided
        setSubCategory((byte)1); // uid 20283, AGM-86B ALCM
    }
}
