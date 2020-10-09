package edu.nps.moves.dis7.entities.tuv.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7c8c70d6
 * Country: Tuvalu (TUV)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 26724
 */
public class PacificClassPatrolBoat extends EntityType
{
    public PacificClassPatrolBoat()
    {
        setCountry(Country.TUVALU_TUV);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26723, Light/Patrol Craft
        setSubCategory((byte)1); // uid 26724, Pacific Class Patrol Boat
    }
}
