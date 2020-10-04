package edu.nps.moves.dis7.entities.oth.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2516fc68
 * Country: Other
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24614
 */
public class GenericCruiseShip extends EntityType
{
    public GenericCruiseShip()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)80); // uid 24613, Passenger Vessel (Group 1 Merchant)
        setSubCategory((byte)1); // uid 24614, Generic Cruise Ship
    }
}
