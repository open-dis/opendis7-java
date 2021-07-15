package edu.nps.moves.dis7.entities.mhl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@27e0f2f5;
 * Country: Marshall Islands (MHL);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26707
 */
public class LightPatrolCraft extends EntityType
{
    /** Default constructor */
    public LightPatrolCraft()
    {
        setCountry(Country.MARSHALL_ISLANDS_MHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26707, Light/Patrol Craft
    }
}
