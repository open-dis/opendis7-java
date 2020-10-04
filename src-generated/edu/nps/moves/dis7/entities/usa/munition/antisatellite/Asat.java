package edu.nps.moves.dis7.entities.usa.munition.antisatellite;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@49190ed6
 * Country: United States of America (USA)
 * Entity kind: Munition
 * Domain: ANTI_SATELLITE
 *
 * Entity type uid: 19687
 */
public class Asat extends EntityType
{
    public Asat()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SATELLITE));

        setCategory((byte)1); // uid 19686, Guided
        setSubCategory((byte)1); // uid 19687, Asat
    }
}
