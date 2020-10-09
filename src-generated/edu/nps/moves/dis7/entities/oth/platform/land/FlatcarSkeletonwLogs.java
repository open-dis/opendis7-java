package edu.nps.moves.dis7.entities.oth.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@7af707e0
 * Country: Other
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 29669
 */
public class FlatcarSkeletonwLogs extends EntityType
{
    public FlatcarSkeletonwLogs()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)92); // uid 25990, Trains
        setSubCategory((byte)4); // uid 25994, Generic Flatcar
        setSpecific((byte)2); // uid 29668, Flatcar, Skeleton (Logging)
        setExtra((byte)1); // uid 29669, Flatcar, Skeleton w/ Logs
    }
}
