package edu.nps.moves.dis7.entities.grc.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@72437d8d
 * Country: Greece (GRC)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27520
 */
public class P73AnthypoploiarchosPezopoulos extends EntityType
{
    public P73AnthypoploiarchosPezopoulos()
    {
        setCountry(Country.GREECE_GRC);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 23370, Light/Patrol Craft
        setSubCategory((byte)2); // uid 27518, Tiger Class (Type 148)
        setSpecific((byte)2); // uid 27520, P73 Anthypoploiarchos Pezopoulos
    }
}
