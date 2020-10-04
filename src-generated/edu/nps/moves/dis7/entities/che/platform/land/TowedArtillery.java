package edu.nps.moves.dis7.entities.che.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@68d7a2df
 * Country: Switzerland (CHE)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 19037
 */
public class TowedArtillery extends EntityType
{
    public TowedArtillery()
    {
        setCountry(Country.SWITZERLAND_CHE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 19037, Towed Artillery
    }
}
