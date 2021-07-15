package edu.nps.moves.dis7.entities.oth.lifeform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4cc26df;
 * Country: Other;
 * Entity kind: Life form;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 32276
 */
public class HarborSeal extends EntityType
{
    /** Default constructor */
    public HarborSeal()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)201); // uid 32270, Mammal
        setSubCategory((byte)122); // uid 32276, Harbor Seal
    }
}
