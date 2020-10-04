package edu.nps.moves.dis7.entities.bra.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@66a3ffec
 * Country: Brazil (BRA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 24388
 */
public class LargeWheeledUtilityVehiclegreaterthan125tons extends EntityType
{
    public LargeWheeledUtilityVehiclegreaterthan125tons()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 24388, Large Wheeled Utility Vehicle - (greater than 1.25 tons)
    }
}
