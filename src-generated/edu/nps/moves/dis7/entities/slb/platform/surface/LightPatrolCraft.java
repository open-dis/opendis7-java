package edu.nps.moves.dis7.entities.slb.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@6884f0d9;
 * Country: Solomon Islands (SLB);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26746
 */
public class LightPatrolCraft extends EntityType
{
    /** Default constructor */
    public LightPatrolCraft()
    {
        setCountry(Country.SOLOMON_ISLANDS_SLB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26746, Light/Patrol Craft
    }
}
