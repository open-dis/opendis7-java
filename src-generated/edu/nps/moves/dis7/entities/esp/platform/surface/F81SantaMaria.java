package edu.nps.moves.dis7.entities.esp.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6ed16657
 * Country: Spain (ESP)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19010
 */
public class F81SantaMaria extends EntityType
{
    public F81SantaMaria()
    {
        setCountry(Country.SPAIN_ESP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 19005, Guided Missile Frigate (FFG)
        setSubCategory((byte)3); // uid 19009, Santa Maria Class (FFG)
        setSpecific((byte)1); // uid 19010, F81 Santa Maria
    }
}
