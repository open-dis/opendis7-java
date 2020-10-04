package edu.nps.moves.dis7.entities.oth.supply.class7majoritems;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3d132bb6
 * Country: Other
 * Entity kind: Supply
 * Domain: CLASS_7_MAJOR_ITEMS
 *
 * Entity type uid: 30754
 */
public class C130JFuelTank extends EntityType
{
    public C130JFuelTank()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_7_MAJOR_ITEMS));

        setCategory((byte)20); // uid 30749, Drop Tank
        setSubCategory((byte)5); // uid 30754, C-130J Fuel Tank
    }
}
