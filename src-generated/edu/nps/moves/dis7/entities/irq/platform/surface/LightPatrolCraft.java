package edu.nps.moves.dis7.entities.irq.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@315f43d5
 * Country: Iraq (IRQ)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18007
 */
public class LightPatrolCraft extends EntityType
{
    public LightPatrolCraft()
    {
        setCountry(Country.IRAQ_IRQ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 18007, Light/Patrol Craft
    }
}
