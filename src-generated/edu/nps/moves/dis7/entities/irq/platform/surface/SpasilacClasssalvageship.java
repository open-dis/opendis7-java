package edu.nps.moves.dis7.entities.irq.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@64a8c844
 * Country: Iraq (IRQ)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18018
 */
public class SpasilacClasssalvageship extends EntityType
{
    public SpasilacClasssalvageship()
    {
        setCountry(Country.IRAQ_IRQ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 18013, Auxiliary
        setSubCategory((byte)2); // uid 18018, Spasilac Class (salvage ship)
    }
}
