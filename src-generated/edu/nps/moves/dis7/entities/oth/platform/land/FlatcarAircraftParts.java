package edu.nps.moves.dis7.entities.oth.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7ba63fe5
 * Country: Other
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 29674
 */
public class FlatcarAircraftParts extends EntityType
{
    public FlatcarAircraftParts()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)92); // uid 25990, Trains
        setSubCategory((byte)4); // uid 25994, Generic Flatcar
        setSpecific((byte)5); // uid 29674, Flatcar, Aircraft Parts
    }
}
