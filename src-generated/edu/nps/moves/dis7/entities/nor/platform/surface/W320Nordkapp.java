package edu.nps.moves.dis7.entities.nor.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@47d93e0d
 * Country: Norway (NOR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27600
 */
public class W320Nordkapp extends EntityType
{
    public W320Nordkapp()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)63); // uid 27598, Coast Guard Boats
        setSubCategory((byte)1); // uid 27599, Nordkapp class
        setSpecific((byte)1); // uid 27600, W320 Nordkapp
    }
}
