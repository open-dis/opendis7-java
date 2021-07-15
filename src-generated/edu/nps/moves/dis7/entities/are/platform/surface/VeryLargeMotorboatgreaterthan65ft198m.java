package edu.nps.moves.dis7.entities.are.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@55d58825;
 * Country: United Arab Emirates (ARE);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 28236
 */
public class VeryLargeMotorboatgreaterthan65ft198m extends EntityType
{
    /** Default constructor */
    public VeryLargeMotorboatgreaterthan65ft198m()
    {
        setCountry(Country.UNITED_ARAB_EMIRATES_ARE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)84); // uid 28235, Private Motorboat
        setSubCategory((byte)4); // uid 28236, Very Large Motorboat (greater than 65ft/19.8m)
    }
}
