package edu.nps.moves.dis7.entities.irq.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@18c5069b
 * Country: Iraq (IRQ)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18023
 */
public class _507lbnMarjid extends EntityType
{
    public _507lbnMarjid()
    {
        setCountry(Country.IRAQ_IRQ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 18021, Frigate (including Corvette)
        setSubCategory((byte)1); // uid 18022, Yugoslav Type
        setSpecific((byte)1); // uid 18023, 507 lbn Marjid
    }
}
