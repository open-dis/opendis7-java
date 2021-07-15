package edu.nps.moves.dis7.entities.oth.supply.class3petroleumoilslubricants;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6df2a206;
 * Country: Other;
 * Entity kind: Supply;
 * Domain: CLASS_3_PETROLEUM_OILS_LUBRICANTS;
 *
 * Entity type uid: 30679
 */
public class TS1RussiaRUS extends EntityType
{
    /** Default constructor */
    public TS1RussiaRUS()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_3_PETROLEUM_OILS_LUBRICANTS));

        setCategory((byte)2); // uid 30674, A - POL for Air Vehicles
        setSubCategory((byte)5); // uid 30679, TS-1 (Russia (RUS))
    }
}
