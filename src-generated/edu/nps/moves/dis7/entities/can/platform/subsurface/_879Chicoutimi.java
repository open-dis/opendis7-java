package edu.nps.moves.dis7.entities.can.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@11758f2a
 * Country: Canada (CAN)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 23128
 */
public class _879Chicoutimi extends EntityType
{
    public _879Chicoutimi()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 23123, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)1); // uid 23124, Victoria (Upholder) class
        setSpecific((byte)4); // uid 23128, 879 Chicoutimi
    }
}
