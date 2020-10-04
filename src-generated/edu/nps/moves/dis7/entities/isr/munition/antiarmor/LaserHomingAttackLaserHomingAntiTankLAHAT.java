package edu.nps.moves.dis7.entities.isr.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7761e342
 * Country: Israel (ISR)
 * Entity kind: Munition
 * Domain: ANTI_ARMOR
 *
 * Entity type uid: 29010
 */
public class LaserHomingAttackLaserHomingAntiTankLAHAT extends EntityType
{
    public LaserHomingAttackLaserHomingAntiTankLAHAT()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)1); // uid 21287, Guided
        setSubCategory((byte)4); // uid 29010, Laser Homing Attack / Laser Homing Anti-Tank (LAHAT)
    }
}
