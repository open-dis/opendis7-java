package edu.nps.moves.dis7.entities.zaf.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@59ed3e6c
 * Country: South Africa (ZAF)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 19112
 */
public class AttackHelicopter extends EntityType
{
    public AttackHelicopter()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)20); // uid 19112, Attack Helicopter
    }
}
