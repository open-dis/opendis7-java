package edu.nps.moves.dis7.entities.rou.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7a26928a
 * Country: Romania (ROU)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27809
 */
public class Type22FrigateBoxerClass extends EntityType
{
    public Type22FrigateBoxerClass()
    {
        setCountry(Country.ROMANIA_ROU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 27808, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 27809, Type 22 Frigate / Boxer Class
    }
}
