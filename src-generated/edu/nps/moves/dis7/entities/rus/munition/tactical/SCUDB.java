package edu.nps.moves.dis7.entities.rus.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2b9e69fb;
 * Country: Russia (RUS);
 * Entity kind: Munition;
 * Domain: TACTICAL;
 *
 * Entity type uid: 32411
 */
public class SCUDB extends EntityType
{
    /** Default constructor */
    public SCUDB()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 27168, Guided
        setSubCategory((byte)13); // uid 32411, SCUD-B
    }
}
