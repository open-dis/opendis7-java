package edu.nps.moves.dis7.entities.aus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6504e3b2;
 * Country: Australia (AUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 29417
 */
public class HawkeiProtectedMobilityVehicleLightSpecialOperationsVehicle extends EntityType
{
    /** Default constructor */
    public HawkeiProtectedMobilityVehicleLightSpecialOperationsVehicle()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)6); // uid 28910, Small Wheeled Utility Vehicle
        setSubCategory((byte)3); // uid 29414, Hawkei Protected Mobility Vehicle - Light 4x4
        setSpecific((byte)3); // uid 29417, Hawkei Protected Mobility Vehicle - Light - Special Operations Vehicle
    }
}
