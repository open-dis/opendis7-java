package edu.nps.moves.dis7.entities.jpn.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@55795845
 * Country: Japan (JPN)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 18910
 */
public class SSConventionalAttackTorpedoPatrol extends EntityType
{
    public SSConventionalAttackTorpedoPatrol()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 18910, SS (Conventional Attack-Torpedo Patrol)
    }
}
