package edu.nps.moves.dis7.entities.grc.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7e4204e2
 * Country: Greece (GRC)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23372
 */
public class P18Armatolos extends EntityType
{
    public P18Armatolos()
    {
        setCountry(Country.GREECE_GRC);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 23370, Light/Patrol Craft
        setSubCategory((byte)1); // uid 23371, Armatolos (Osprey 55) class
        setSpecific((byte)1); // uid 23372, P18 Armatolos
    }
}
