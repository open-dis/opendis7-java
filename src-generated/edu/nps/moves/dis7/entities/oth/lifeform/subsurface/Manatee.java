package edu.nps.moves.dis7.entities.oth.lifeform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7848321e;
 * Country: Other;
 * Entity kind: Life form;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 32277
 */
public class Manatee extends EntityType
{
    /** Default constructor */
    public Manatee()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)201); // uid 32270, Mammal
        setSubCategory((byte)160); // uid 32277, Manatee
    }
}
