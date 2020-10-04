package edu.nps.moves.dis7.entities.oth.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7ea4d397
 * Country: Other
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24626
 */
public class GenericHeavyLiftShip extends EntityType
{
    public GenericHeavyLiftShip()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24619, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)7); // uid 24626, Generic Heavy Lift Ship
    }
}
