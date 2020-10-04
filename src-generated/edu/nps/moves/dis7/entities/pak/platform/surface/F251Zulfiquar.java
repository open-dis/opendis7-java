package edu.nps.moves.dis7.entities.pak.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1761de10
 * Country: Pakistan (PAK)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 28406
 */
public class F251Zulfiquar extends EntityType
{
    public F251Zulfiquar()
    {
        setCountry(Country.PAKISTAN_PAK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 28404, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 28405, F-22P Zulfiquar Class
        setSpecific((byte)1); // uid 28406, F-251 Zulfiquar
    }
}
