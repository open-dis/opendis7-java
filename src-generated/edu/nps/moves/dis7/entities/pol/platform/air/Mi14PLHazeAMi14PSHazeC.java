package edu.nps.moves.dis7.entities.pol.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@29006752;
 * Country: Poland (POL);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 23089
 */
public class Mi14PLHazeAMi14PSHazeC extends EntityType
{
    /** Default constructor */
    public Mi14PLHazeAMi14PSHazeC()
    {
        setCountry(Country.POLAND_POL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)22); // uid 23088, Anti-Submarine Warfare/Patrol Helicopter
        setSubCategory((byte)1); // uid 23089, Mi-14PL Haze A/Mi-14PS Haze C
    }
}
