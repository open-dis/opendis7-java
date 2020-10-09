package edu.nps.moves.dis7.entities.ury.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3c7279a5
 * Country: Uruguay (URY)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27531
 */
public class WangeroogeClassType722Type754 extends EntityType
{
    public WangeroogeClassType722Type754()
    {
        setCountry(Country.URUGUAY_URY);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 27490, Auxiliary
        setSubCategory((byte)2); // uid 27531, Wangerooge Class (Type 722, Type 754)
    }
}
