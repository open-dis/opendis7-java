package edu.nps.moves.dis7.entities.sgp.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@459b187a
 * Country: Singapore (SGP)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 25356
 */
public class Steadfast70 extends EntityType
{
    public Steadfast70()
    {
        setCountry(Country.SINGAPORE_SGP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 25352, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 25353, Formidable Class
        setSpecific((byte)3); // uid 25356, Steadfast 70
    }
}
