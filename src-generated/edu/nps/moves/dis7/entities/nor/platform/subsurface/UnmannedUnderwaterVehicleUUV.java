package edu.nps.moves.dis7.entities.nor.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@6f0628de
 * Country: Norway (NOR)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 29289
 */
public class UnmannedUnderwaterVehicleUUV extends EntityType
{
    public UnmannedUnderwaterVehicleUUV()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)8); // uid 29289, Unmanned Underwater Vehicle (UUV)
    }
}
