package edu.nps.moves.dis7.entities.tun.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@16727bf0
 * Country: Tunisia (TUN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27580
 */
public class _603ElEdrak extends EntityType
{
    public _603ElEdrak()
    {
        setCountry(Country.TUNISIA_TUN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27576, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 27577, Kondor I Class
        setSpecific((byte)3); // uid 27580, 603 El Edrak
    }
}
