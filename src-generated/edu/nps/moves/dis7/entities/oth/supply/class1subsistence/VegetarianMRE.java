package edu.nps.moves.dis7.entities.oth.supply.class1subsistence;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@22ff1372
 * Country: Other
 * Entity kind: Supply
 * Domain: CLASS_1_SUBSISTENCE
 *
 * Entity type uid: 30648
 */
public class VegetarianMRE extends EntityType
{
    public VegetarianMRE()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_1_SUBSISTENCE));

        setCategory((byte)3); // uid 30645, C - Combat Rations
        setSubCategory((byte)1); // uid 30646, Meal Ready to Eat (MRE) - USA
        setSpecific((byte)2); // uid 30648, Vegetarian MRE
    }
}
