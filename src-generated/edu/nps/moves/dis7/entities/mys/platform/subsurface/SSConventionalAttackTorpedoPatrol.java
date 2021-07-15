package edu.nps.moves.dis7.entities.mys.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@7e094740;
 * Country: Malaysia (MYS);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 26250
 */
public class SSConventionalAttackTorpedoPatrol extends EntityType
{
    /** Default constructor */
    public SSConventionalAttackTorpedoPatrol()
    {
        setCountry(Country.MALAYSIA_MYS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 26250, SS (Conventional Attack - Torpedo, Patrol)
    }
}
