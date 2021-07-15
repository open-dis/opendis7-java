package edu.nps.moves.dis7.entities.oth.supply.class2clothingindividualequipmenttoolsadminsupplies;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@100807ca;
 * Country: Other;
 * Entity kind: Supply;
 * Domain: CLASS_2_CLOTHING_INDIVIDUAL_EQUIPMENT_TOOLS_ADMIN_SUPPLIES;
 *
 * Entity type uid: 31919
 */
public class Rope extends EntityType
{
    /** Default constructor */
    public Rope()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_2_CLOTHING_INDIVIDUAL_EQUIPMENT_TOOLS_ADMIN_SUPPLIES));

        setCategory((byte)3); // uid 30659, B - Ground Support Materiel
        setSubCategory((byte)4); // uid 31919, Rope
    }
}