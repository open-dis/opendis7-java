package edu.nps.moves.dis7.entities.can.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6806468e
 * Country: Canada (CAN)
 * Entity kind: Munition
 * Domain: BATTLEFIELD_SUPPORT
 *
 * Entity type uid: 21767
 */
public class CRV7RA70HEISAPHighExplosiveIncendiarySemiArmorPiercing extends EntityType
{
    public CRV7RA70HEISAPHighExplosiveIncendiarySemiArmorPiercing()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)2); // uid 21760, Ballistic
        setSubCategory((byte)1); // uid 21761, 70 mm(2.75in)
        setSpecific((byte)6); // uid 21767, CRV7 RA-70 HEISAP: High Explosive Incendiary Semi-Armor Piercing
    }
}
