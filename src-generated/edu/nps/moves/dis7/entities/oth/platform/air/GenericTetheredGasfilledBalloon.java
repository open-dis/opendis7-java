package edu.nps.moves.dis7.entities.oth.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7af707e0;
 * Country: Other;
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 24736
 */
public class GenericTetheredGasfilledBalloon extends EntityType
{
    /** Default constructor */
    public GenericTetheredGasfilledBalloon()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)100); // uid 24734, Civilian Lighter than Air, Balloon
        setSubCategory((byte)2); // uid 24736, Generic Tethered Gas-filled Balloon
    }
}
