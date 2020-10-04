package edu.nps.moves.dis7.entities.rou.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@d0ec63
 * Country: Romania (ROU)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27816
 */
public class _190Lastunul extends EntityType
{
    public _190Lastunul()
    {
        setCountry(Country.ROMANIA_ROU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 27812, Frigate (including Corvette)
        setSubCategory((byte)1); // uid 27813, Zborul (Tarantul I) Class
        setSpecific((byte)3); // uid 27816, 190 Lastunul
    }
}
