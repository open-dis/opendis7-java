package edu.nps.moves.dis7.entities.csk.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@2d3379b4
 * Country: Czechoslovakia (CSK)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 19126
 */
public class CargoTanker extends EntityType
{
    public CargoTanker()
    {
        setCountry(Country.CZECHOSLOVAKIA_CSK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 19126, Cargo / Tanker
    }
}
