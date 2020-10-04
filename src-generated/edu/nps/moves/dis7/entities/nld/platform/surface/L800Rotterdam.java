package edu.nps.moves.dis7.entities.nld.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@52eacb4b
 * Country: Netherlands (NLD)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23302
 */
public class L800Rotterdam extends EntityType
{
    public L800Rotterdam()
    {
        setCountry(Country.NETHERLANDS_NLD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)56); // uid 23300, Amphibious Transport Dock
        setSubCategory((byte)1); // uid 23301, Rotterdam Class
        setSpecific((byte)1); // uid 23302, L800 Rotterdam
    }
}
