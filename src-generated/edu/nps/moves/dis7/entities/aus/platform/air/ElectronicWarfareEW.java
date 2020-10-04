package edu.nps.moves.dis7.entities.aus.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@17ed40e0
 * Country: Australia (AUS)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29319
 */
public class ElectronicWarfareEW extends EntityType
{
    public ElectronicWarfareEW()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)6); // uid 29319, Electronic Warfare (EW)
    }
}
