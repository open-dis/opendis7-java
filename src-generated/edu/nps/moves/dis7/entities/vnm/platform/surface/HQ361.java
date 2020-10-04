package edu.nps.moves.dis7.entities.vnm.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@251c8145
 * Country: Viet Nam (VNM)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27835
 */
public class HQ361 extends EntityType
{
    public HQ361()
    {
        setCountry(Country.VIET_NAM_VNM);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 27826, Light/Patrol Craft
        setSubCategory((byte)1); // uid 27827, Osa Class
        setSpecific((byte)8); // uid 27835, HQ-361
    }
}
