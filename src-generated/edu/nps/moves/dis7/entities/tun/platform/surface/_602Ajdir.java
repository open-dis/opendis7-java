package edu.nps.moves.dis7.entities.tun.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7640a5b1;
 * Country: Tunisia (TUN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 27579
 */
public class _602Ajdir extends EntityType
{
    /** Default constructor */
    public _602Ajdir()
    {
        setCountry(Country.TUNISIA_TUN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27576, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 27577, Kondor I Class
        setSpecific((byte)2); // uid 27579, 602 Ajdir
    }
}
