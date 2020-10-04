package edu.nps.moves.dis7.entities.tun.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1cc680e
 * Country: Tunisia (TUN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23008
 */
public class P201Istiklal extends EntityType
{
    public P201Istiklal()
    {
        setCountry(Country.TUNISIA_TUN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 23006, Light/Patrol Craft
        setSubCategory((byte)1); // uid 23007, Coastal Patrol Craft class
        setSpecific((byte)1); // uid 23008, P201 Istiklal
    }
}
