package edu.nps.moves.dis7.entities.oth.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7d2a6eac
 * Country: Other
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 24837
 */
public class GenericToyATVChildwLaserDesignator extends EntityType
{
    public GenericToyATVChildwLaserDesignator()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)90); // uid 24835, Recreational
        setSubCategory((byte)7); // uid 24836, Generic Toy, ATV
        setSpecific((byte)1); // uid 24837, Generic Toy ATV, Child w/ Laser Designator
    }
}
