package edu.nps.moves.dis7.entities.swe.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@38bb9d7a
 * Country: Sweden (SWE)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 24906
 */
public class Motorcoach extends EntityType
{
    public Motorcoach()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)82); // uid 24905, Bus
        setSubCategory((byte)10); // uid 24906, Motorcoach
    }
}
