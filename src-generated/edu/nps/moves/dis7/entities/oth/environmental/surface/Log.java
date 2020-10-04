package edu.nps.moves.dis7.entities.oth.environmental.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@4813d0
 * Country: Other
 * Entity kind: Environmental
 * Domain: SURFACE
 *
 * Entity type uid: 25215
 */
public class Log extends EntityType
{
    public Log()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.ENVIRONMENTAL);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 25215, Log
    }
}
