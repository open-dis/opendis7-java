package edu.nps.moves.dis7.entities.vut.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@77524ca7;
 * Country: Vanuatu (VUT);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26701
 */
public class PacificClassPatrolBoat extends EntityType
{
    /** Default constructor */
    public PacificClassPatrolBoat()
    {
        setCountry(Country.VANUATU_VUT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26700, Light/Patrol Craft
        setSubCategory((byte)1); // uid 26701, Pacific Class Patrol Boat
    }
}
