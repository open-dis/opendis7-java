package edu.nps.moves.dis7.entities.mmr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@c00fff0
 * Country: Myanmar (MMR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 32905
 */
public class LightPatrolCraft extends EntityType
{
    public LightPatrolCraft()
    {
        setCountry(Country.MYANMAR_MMR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 32905, Light/Patrol Craft
    }
}
