package edu.nps.moves.dis7.entities.rou.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@757194dc
 * Country: Romania (ROU)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 27818
 */
public class SSConventionalAttackTorpedoPatrol extends EntityType
{
    public SSConventionalAttackTorpedoPatrol()
    {
        setCountry(Country.ROMANIA_ROU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 27818, SS (Conventional Attack - Torpedo, Patrol)
    }
}
