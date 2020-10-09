package edu.nps.moves.dis7.entities.esp.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@2a331b46
 * Country: Spain (ESP)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 24128
 */
public class SmallWheeledUtilityVehicle0125tons extends EntityType
{
    public SmallWheeledUtilityVehicle0125tons()
    {
        setCountry(Country.SPAIN_ESP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)6); // uid 24128, Small Wheeled Utility Vehicle - (0-1.25 tons)
    }
}
