package edu.nps.moves.dis7.entities.can.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@47ef968d
 * Country: Canada (CAN)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 31198
 */
public class MTVFFitterRepairVehicle extends EntityType
{
    public MTVFFitterRepairVehicle()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)3); // uid 31189, Armored Utility Vehicle
        setSubCategory((byte)2); // uid 31197, M113A3 / Mobile Tactical Vehicle Light (MTVL) Utility Vehicles
        setSpecific((byte)1); // uid 31198, MTVF Fitter (Repair) Vehicle
    }
}
