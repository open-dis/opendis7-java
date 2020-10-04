package edu.nps.moves.dis7.entities.swe.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7af0d91b
 * Country: Sweden (SWE)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 27308
 */
public class Torpedo2000 extends EntityType
{
    public Torpedo2000()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 27301, Guided
        setSubCategory((byte)2); // uid 27308, Torpedo 2000
    }
}
