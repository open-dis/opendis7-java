package edu.nps.moves.dis7.entities.sgp.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@10fda3d0
 * Country: Singapore (SGP)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27897
 */
public class FrigateincludingCorvette extends EntityType
{
    public FrigateincludingCorvette()
    {
        setCountry(Country.SINGAPORE_SGP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 27897, Frigate (including Corvette)
    }
}
