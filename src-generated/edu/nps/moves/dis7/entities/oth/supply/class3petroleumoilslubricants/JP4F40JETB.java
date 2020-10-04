package edu.nps.moves.dis7.entities.oth.supply.class3petroleumoilslubricants;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@59f3426f
 * Country: Other
 * Entity kind: Supply
 * Domain: CLASS_3_PETROLEUM_OILS_LUBRICANTS
 *
 * Entity type uid: 30675
 */
public class JP4F40JETB extends EntityType
{
    public JP4F40JETB()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_3_PETROLEUM_OILS_LUBRICANTS));

        setCategory((byte)2); // uid 30674, A - POL for Air Vehicles
        setSubCategory((byte)1); // uid 30675, JP-4 (F-40/JET B)
    }
}
