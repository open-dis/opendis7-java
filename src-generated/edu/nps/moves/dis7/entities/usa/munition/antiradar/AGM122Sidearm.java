package edu.nps.moves.dis7.entities.usa.munition.antiradar;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4276ad40
 * Country: United States of America (USA)
 * Entity kind: Munition
 * Domain: ANTI_RADAR
 *
 * Entity type uid: 19679
 */
public class AGM122Sidearm extends EntityType
{
    public AGM122Sidearm()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_RADAR));

        setCategory((byte)1); // uid 19670, Guided
        setSubCategory((byte)4); // uid 19679, AGM-122 Sidearm
    }
}
