package edu.nps.moves.dis7.entities.zaf.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5e69cf07;
 * Country: South Africa (ZAF);
 * Entity kind: Munition;
 * Domain: ANTI_AIR;
 *
 * Entity type uid: 29556
 */
public class Umkhonto extends EntityType
{
    /** Default constructor */
    public Umkhonto()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 28982, Guided
        setSubCategory((byte)2); // uid 29556, Umkhonto
    }
}
