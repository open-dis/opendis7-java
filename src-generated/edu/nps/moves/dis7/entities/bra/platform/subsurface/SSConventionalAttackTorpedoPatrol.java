package edu.nps.moves.dis7.entities.bra.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@39c0f4a;
 * Country: Brazil (BRA);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 32643
 */
public class SSConventionalAttackTorpedoPatrol extends EntityType
{
    /** Default constructor */
    public SSConventionalAttackTorpedoPatrol()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 32643, SS (Conventional Attack - Torpedo, Patrol)
    }
}
