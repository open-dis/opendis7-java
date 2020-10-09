package edu.nps.moves.dis7.entities.arg.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@123a439b
 * Country: Argentina (ARG)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18755
 */
public class GuidedMissileDestroyer extends EntityType
{
    public GuidedMissileDestroyer()
    {
        setCountry(Country.ARGENTINA_ARG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)4); // uid 18755, Guided Missile Destroyer
    }
}
