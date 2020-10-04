package edu.nps.moves.dis7.entities.blr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@58651fd0
 * Country: Belarus (BLR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 30050
 */
public class LargeWheeledUtilityVehicle extends EntityType
{
    public LargeWheeledUtilityVehicle()
    {
        setCountry(Country.BELARUS_BLR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 30050, Large Wheeled Utility Vehicle
    }
}
