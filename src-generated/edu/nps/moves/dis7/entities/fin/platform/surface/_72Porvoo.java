package edu.nps.moves.dis7.entities.fin.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@68267da0
 * Country: Finland (FIN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23025
 */
public class _72Porvoo extends EntityType
{
    public _72Porvoo()
    {
        setCountry(Country.FINLAND_FIN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 23021, Light/Patrol Craft
        setSubCategory((byte)1); // uid 23022, Rauma Class
        setSpecific((byte)3); // uid 23025, 72 Porvoo
    }
}
