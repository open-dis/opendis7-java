package edu.nps.moves.dis7.entities.oth.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@894858;
 * Country: Other;
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 24735
 */
public class GenericFreeGasFilledBalloon extends EntityType
{
    /** Default constructor */
    public GenericFreeGasFilledBalloon()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)100); // uid 24734, Civilian Lighter than Air, Balloon
        setSubCategory((byte)1); // uid 24735, Generic Free Gas-Filled Balloon
    }
}
