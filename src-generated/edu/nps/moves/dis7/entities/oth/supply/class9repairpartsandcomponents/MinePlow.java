package edu.nps.moves.dis7.entities.oth.supply.class9repairpartsandcomponents;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@9f2376f
 * Country: Other
 * Entity kind: Supply
 * Domain: CLASS_9_REPAIR_PARTS_AND_COMPONENTS
 *
 * Entity type uid: 30804
 */
public class MinePlow extends EntityType
{
    public MinePlow()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_9_REPAIR_PARTS_AND_COMPONENTS));

        setCategory((byte)6); // uid 30803, K - Tactical Vehicles
        setSubCategory((byte)1); // uid 30804, Mine Plow
    }
}
