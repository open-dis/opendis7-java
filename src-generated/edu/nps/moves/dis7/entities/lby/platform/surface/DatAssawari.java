package edu.nps.moves.dis7.entities.lby.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@b5cc23a
 * Country: Libya (LBY)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18917
 */
public class DatAssawari extends EntityType
{
    public DatAssawari()
    {
        setCountry(Country.LIBYA_LBY);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 18916, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 18917, Dat Assawari
    }
}
