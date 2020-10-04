package edu.nps.moves.dis7.entities.oth.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@74cd798f
 * Country: Other
 * Entity kind: Life form
 * Domain: LAND
 *
 * Entity type uid: 32251
 */
public class AustralianBrownSnake extends EntityType
{
    public AustralianBrownSnake()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)201); // uid 32241, Reptile
        setSubCategory((byte)67); // uid 32251, Australian Brown Snake
    }
}
