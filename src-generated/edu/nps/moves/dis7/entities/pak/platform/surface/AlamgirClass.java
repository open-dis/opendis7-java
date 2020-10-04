package edu.nps.moves.dis7.entities.pak.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@19f21b6b
 * Country: Pakistan (PAK)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 30449
 */
public class AlamgirClass extends EntityType
{
    public AlamgirClass()
    {
        setCountry(Country.PAKISTAN_PAK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 28404, Guided Missile Frigate (FFG)
        setSubCategory((byte)2); // uid 30449, Alamgir Class
    }
}
