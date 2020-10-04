package edu.nps.moves.dis7.entities.can.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5c5a1b69
 * Country: Canada (CAN)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 30984
 */
public class GWagonw556mmMG extends EntityType
{
    public GWagonw556mmMG()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)6); // uid 23524, Small Wheeled Utility Vehicle
        setSubCategory((byte)2); // uid 30982, G Wagon
        setSpecific((byte)2); // uid 30984, G Wagon w/ 5.56mm MG
    }
}
