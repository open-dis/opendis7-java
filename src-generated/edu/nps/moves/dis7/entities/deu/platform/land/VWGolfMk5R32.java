package edu.nps.moves.dis7.entities.deu.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@2415fc55
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 25280
 */
public class VWGolfMk5R32 extends EntityType
{
    public VWGolfMk5R32()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)81); // uid 24838, Car
        setSubCategory((byte)52); // uid 25278, 5-Door Hatchback, Economy/Compact (Small)
        setSpecific((byte)1); // uid 25279, Volkswagen Golf
        setExtra((byte)1); // uid 25280, VW Golf Mk5 R32
    }
}
