package edu.nps.moves.dis7.entities.hrv.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4c371370
 * Country: Croatia (HRV)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19333
 */
public class KoncarTypeR02ClassFastAttackCraftMissilePCFG extends EntityType
{
    public KoncarTypeR02ClassFastAttackCraftMissilePCFG()
    {
        setCountry(Country.CROATIA_HRV);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 19332, Light/Patrol Craft
        setSubCategory((byte)1); // uid 19333, Koncar (Type R-02) Class (Fast Attack Craft-Missile) (PCFG)
    }
}
