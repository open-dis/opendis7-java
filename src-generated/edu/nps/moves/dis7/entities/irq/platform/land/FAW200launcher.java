package edu.nps.moves.dis7.entities.irq.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5e8ac0e1
 * Country: Iraq (IRQ)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 17996
 */
public class FAW200launcher extends EntityType
{
    public FAW200launcher()
    {
        setCountry(Country.IRAQ_IRQ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 17990, Self-Propelled Artillery
        setSubCategory((byte)6); // uid 17996, FAW 200 launcher
    }
}
