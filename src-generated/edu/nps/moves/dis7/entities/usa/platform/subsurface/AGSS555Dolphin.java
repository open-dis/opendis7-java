package edu.nps.moves.dis7.entities.usa.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@691541bc
 * Country: United States of America (USA)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 12412
 */
public class AGSS555Dolphin extends EntityType
{
    public AGSS555Dolphin()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)7); // uid 12410, SSA(Conventional Auxiliary)
        setSubCategory((byte)1); // uid 12411, Dolphin Class
        setSpecific((byte)1); // uid 12412, AGSS 555 Dolphin
    }
}
