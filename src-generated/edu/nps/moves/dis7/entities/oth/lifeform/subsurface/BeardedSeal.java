package edu.nps.moves.dis7.entities.oth.lifeform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@148ab138
 * Country: Other
 * Entity kind: Life form
 * Domain: SUBSURFACE
 *
 * Entity type uid: 32275
 */
public class BeardedSeal extends EntityType
{
    public BeardedSeal()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)201); // uid 32270, Mammal
        setSubCategory((byte)121); // uid 32275, Bearded Seal
    }
}
