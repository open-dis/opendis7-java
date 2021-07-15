package edu.nps.moves.dis7.entities.ind.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@21274afe;
 * Country: India (IND);
 * Entity kind: Munition;
 * Domain: STRATEGIC;
 *
 * Entity type uid: 21737
 */
public class Agni extends EntityType
{
    /** Default constructor */
    public Agni()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 21736, Guided
        setSubCategory((byte)1); // uid 21737, Agni
    }
}
