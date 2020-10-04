package edu.nps.moves.dis7.entities.rus.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5e69cf07
 * Country: Russia (RUS)
 * Entity kind: Munition
 * Domain: STRATEGIC
 *
 * Entity type uid: 20944
 */
public class SS20Saber extends EntityType
{
    public SS20Saber()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 20919, Guided
        setSubCategory((byte)20); // uid 20944, SS-20 Saber
    }
}
