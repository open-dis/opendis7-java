package edu.nps.moves.dis7.entities.usa.munition.directedenergydeweapon;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@20027c44;
 * Country: United States of America (USA);
 * Entity kind: Munition;
 * Domain: DIRECTED_ENERGY_DE_WEAPON;
 *
 * Entity type uid: 20297
 */
public class ChemicalOxygenIodineLaserCOIL extends EntityType
{
    /** Default constructor */
    public ChemicalOxygenIodineLaserCOIL()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.DIRECTED_ENERGY_DE_WEAPON));

        setCategory((byte)1); // uid 20295, Point Effect DE Weapon
        setSubCategory((byte)1); // uid 20296, Laser Weapon
        setSpecific((byte)1); // uid 20297, Chemical Oxygen Iodine Laser (COIL)
    }
}
