package edu.nps.moves.dis7.entities.swe.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@464ede1f
 * Country: Sweden (SWE)
 * Entity kind: Munition
 * Domain: ANTI_AIR
 *
 * Entity type uid: 29331
 */
public class RBS90Missile extends EntityType
{
    public RBS90Missile()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 21630, Guided
        setSubCategory((byte)4); // uid 29331, RBS-90 Missile
    }
}
