package edu.nps.moves.dis7.entities.oth.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@73386d72
 * Country: Other
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 29675
 */
public class FlatcarCenterbeam extends EntityType
{
    public FlatcarCenterbeam()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)92); // uid 25990, Trains
        setSubCategory((byte)4); // uid 25994, Generic Flatcar
        setSpecific((byte)6); // uid 29675, Flatcar, Centerbeam
    }
}
