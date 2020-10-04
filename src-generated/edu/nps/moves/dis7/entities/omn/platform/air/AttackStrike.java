package edu.nps.moves.dis7.entities.omn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@12f3afb5
 * Country: Oman (OMN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28562
 */
public class AttackStrike extends EntityType
{
    public AttackStrike()
    {
        setCountry(Country.OMAN_OMN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)2); // uid 28562, Attack/Strike
    }
}
