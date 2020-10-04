package edu.nps.moves.dis7.entities.ser.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@a0db585
 * Country: Serbia and Montenegro
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19080
 */
public class DamenClass extends EntityType
{
    public DamenClass()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 19072, Light/Patrol Craft
        setSubCategory((byte)3); // uid 19080, Damen Class
    }
}
