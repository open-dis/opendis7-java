package edu.nps.moves.dis7.entities.isr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3c989952
 * Country: Israel (ISR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18211
 */
public class _501Eilat extends EntityType
{
    public _501Eilat()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 18209, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 18210, Eilat (Saar 5) Class (Corvette)
        setSpecific((byte)1); // uid 18211, 501 Eilat
    }
}
