package edu.nps.moves.dis7.entities.rus.munition.antiradar;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7b3cbe6e
 * Country: Russia (RUS)
 * Entity kind: Munition
 * Domain: ANTI_RADAR
 *
 * Entity type uid: 20512
 */
public class AS12Kegler extends EntityType
{
    public AS12Kegler()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_RADAR));

        setCategory((byte)1); // uid 20509, Guided
        setSubCategory((byte)3); // uid 20512, AS-12 Kegler
    }
}
