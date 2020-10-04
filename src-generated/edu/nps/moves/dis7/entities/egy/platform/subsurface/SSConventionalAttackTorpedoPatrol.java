package edu.nps.moves.dis7.entities.egy.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@e4487af
 * Country: Egypt (EGY)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 18814
 */
public class SSConventionalAttackTorpedoPatrol extends EntityType
{
    public SSConventionalAttackTorpedoPatrol()
    {
        setCountry(Country.EGYPT_EGY);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 18814, SS (Conventional Attack-Torpedo Patrol)
    }
}
