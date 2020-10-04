package edu.nps.moves.dis7.entities.rou.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@e93f3d5
 * Country: Romania (ROU)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27810
 */
public class F221RegeleFerdinand extends EntityType
{
    public F221RegeleFerdinand()
    {
        setCountry(Country.ROMANIA_ROU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 27808, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 27809, Type 22 Frigate / Boxer Class
        setSpecific((byte)1); // uid 27810, F-221 Regele Ferdinand
    }
}
