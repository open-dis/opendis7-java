package edu.nps.moves.dis7.entities.usa.munition.directedenergydeweapon;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3ef0e576;
 * Country: United States of America (USA);
 * Entity kind: Munition;
 * Domain: DIRECTED_ENERGY_DE_WEAPON;
 *
 * Entity type uid: 20299
 */
public class HighPowerMicrowaveHPMWeapon extends EntityType
{
    /** Default constructor */
    public HighPowerMicrowaveHPMWeapon()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.DIRECTED_ENERGY_DE_WEAPON));

        setCategory((byte)2); // uid 20298, Area Effect DE Weapon
        setSubCategory((byte)1); // uid 20299, High Power Microwave (HPM) Weapon
    }
}
