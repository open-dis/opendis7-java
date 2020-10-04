package edu.nps.moves.dis7.entities.oth.supply.class2clothingindividualequipmenttoolsadminsupplies;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@77d0dbba
 * Country: Other
 * Entity kind: Supply
 * Domain: CLASS_2_CLOTHING_INDIVIDUAL_EQUIPMENT_TOOLS_ADMIN_SUPPLIES
 *
 * Entity type uid: 30670
 */
public class CombatIdentificationPanelCIP extends EntityType
{
    public CombatIdentificationPanelCIP()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_2_CLOTHING_INDIVIDUAL_EQUIPMENT_TOOLS_ADMIN_SUPPLIES));

        setCategory((byte)3); // uid 30659, B - Ground Support Materiel
        setSubCategory((byte)3); // uid 30670, Combat Identification Panel (CIP)
    }
}
