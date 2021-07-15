package edu.nps.moves.dis7.entities.oth.lifeform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@10b67f54;
 * Country: Other;
 * Entity kind: Life form;
 * Domain: AIR;
 *
 * Entity type uid: 32261
 */
public class Eagle extends EntityType
{
    /** Default constructor */
    public Eagle()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)200); // uid 32257, Bird
        setSubCategory((byte)50); // uid 32261, Eagle
    }
}
