package edu.nps.moves.dis7.entities.isr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@784b990c
 * Country: Israel (ISR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18212
 */
public class _503Hanit extends EntityType
{
    public _503Hanit()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 18209, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 18210, Eilat (Saar 5) Class (Corvette)
        setSpecific((byte)2); // uid 18212, 503 Hanit
    }
}
