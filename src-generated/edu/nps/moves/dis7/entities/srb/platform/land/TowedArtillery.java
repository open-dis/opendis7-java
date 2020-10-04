package edu.nps.moves.dis7.entities.srb.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@687e4c93
 * Country: Serbia (SRB)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 30160
 */
public class TowedArtillery extends EntityType
{
    public TowedArtillery()
    {
        setCountry(Country.SERBIA_SRB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 30160, Towed Artillery
    }
}
