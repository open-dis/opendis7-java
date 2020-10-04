package edu.nps.moves.dis7.entities.ukr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@b9a77c8
 * Country: Ukraine (UKR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 28801
 */
public class ZubrClass extends EntityType
{
    public ZubrClass()
    {
        setCountry(Country.UKRAINE_UKR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)15); // uid 28800, Air Cushion/Surface Effect
        setSubCategory((byte)1); // uid 28801, Zubr Class
    }
}
