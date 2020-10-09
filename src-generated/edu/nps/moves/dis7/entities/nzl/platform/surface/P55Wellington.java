package edu.nps.moves.dis7.entities.nzl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@37d3d232
 * Country: New Zealand (NZL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 30216
 */
public class P55Wellington extends EntityType
{
    public P55Wellington()
    {
        setCountry(Country.NEW_ZEALAND_NZL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 30213, Light/Patrol Craft
        setSubCategory((byte)1); // uid 30214, Protector/Otago Class (Offshore Patrol Vessels)
        setSpecific((byte)2); // uid 30216, P55 Wellington
    }
}
