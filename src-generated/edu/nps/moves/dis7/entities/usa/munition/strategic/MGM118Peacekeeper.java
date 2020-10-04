package edu.nps.moves.dis7.entities.usa.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4dd1548e
 * Country: United States of America (USA)
 * Entity kind: Munition
 * Domain: STRATEGIC
 *
 * Entity type uid: 20291
 */
public class MGM118Peacekeeper extends EntityType
{
    public MGM118Peacekeeper()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 20282, Guided
        setSubCategory((byte)8); // uid 20291, MGM-118 Peacekeeper
    }
}
