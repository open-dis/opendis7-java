package edu.nps.moves.dis7.entities.kir.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@423e4cbb;
 * Country: Kiribati (KIR);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26704
 */
public class LightPatrolCraft extends EntityType
{
    /** Default constructor */
    public LightPatrolCraft()
    {
        setCountry(Country.KIRIBATI_KIR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26704, Light/Patrol Craft
    }
}
