package edu.nps.moves.dis7.entities.nzl.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@503d56b5
 * Country: New Zealand (NZL)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29188
 */
public class CargoTanker extends EntityType
{
    public CargoTanker()
    {
        setCountry(Country.NEW_ZEALAND_NZL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 29188, Cargo/Tanker
    }
}
