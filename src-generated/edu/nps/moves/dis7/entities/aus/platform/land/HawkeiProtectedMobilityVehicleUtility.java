package edu.nps.moves.dis7.entities.aus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@515f550a;
 * Country: Australia (AUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 29418
 */
public class HawkeiProtectedMobilityVehicleUtility extends EntityType
{
    /** Default constructor */
    public HawkeiProtectedMobilityVehicleUtility()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)6); // uid 28910, Small Wheeled Utility Vehicle
        setSubCategory((byte)3); // uid 29414, Hawkei Protected Mobility Vehicle - Light 4x4
        setSpecific((byte)4); // uid 29418, Hawkei Protected Mobility Vehicle - Utility
    }
}
