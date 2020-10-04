package edu.nps.moves.dis7.entities.nld.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@e3cee7b
 * Country: Netherlands (NLD)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23306
 */
public class F802DeZevenProvincien extends EntityType
{
    public F802DeZevenProvincien()
    {
        setCountry(Country.NETHERLANDS_NLD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 18938, Guided Missile Frigate (FFG)
        setSubCategory((byte)4); // uid 23305, De Zeven Provincien Class
        setSpecific((byte)1); // uid 23306, F802 De Zeven Provincien
    }
}
