package edu.nps.moves.dis7.entities.jpn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2a1edad4
 * Country: Japan (JPN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23143
 */
public class DE233Chikuma extends EntityType
{
    public DE233Chikuma()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 23137, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 23138, Abukuma Class (FF)
        setSpecific((byte)5); // uid 23143, DE 233 Chikuma
    }
}
