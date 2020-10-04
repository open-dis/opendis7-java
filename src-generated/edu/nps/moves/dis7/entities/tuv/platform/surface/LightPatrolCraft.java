package edu.nps.moves.dis7.entities.tuv.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@79a04e5f
 * Country: Tuvalu (TUV)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 26723
 */
public class LightPatrolCraft extends EntityType
{
    public LightPatrolCraft()
    {
        setCountry(Country.TUVALU_TUV);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26723, Light/Patrol Craft
    }
}
