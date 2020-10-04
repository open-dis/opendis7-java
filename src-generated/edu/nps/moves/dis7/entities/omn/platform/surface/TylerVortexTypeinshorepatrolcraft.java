package edu.nps.moves.dis7.entities.omn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@79f227a9
 * Country: Oman (OMN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 17960
 */
public class TylerVortexTypeinshorepatrolcraft extends EntityType
{
    public TylerVortexTypeinshorepatrolcraft()
    {
        setCountry(Country.OMAN_OMN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 17942, Light/Patrol Craft
        setSubCategory((byte)5); // uid 17960, Tyler-Vortex Type (inshore patrol craft)
    }
}
