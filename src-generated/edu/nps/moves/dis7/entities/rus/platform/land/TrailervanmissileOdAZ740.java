package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4a29f290
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 13022
 */
public class TrailervanmissileOdAZ740 extends EntityType
{
    public TrailervanmissileOdAZ740()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)20); // uid 13018, Maintenance equipment trailer
        setSubCategory((byte)3); // uid 13021, Tools/parts trailer
        setSpecific((byte)1); // uid 13022, Trailer, van, missile, OdAZ-740
    }
}
