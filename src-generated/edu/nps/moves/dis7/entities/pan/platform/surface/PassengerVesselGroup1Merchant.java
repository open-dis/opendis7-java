package edu.nps.moves.dis7.entities.pan.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@df1cff6
 * Country: Panama (PAN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 31884
 */
public class PassengerVesselGroup1Merchant extends EntityType
{
    public PassengerVesselGroup1Merchant()
    {
        setCountry(Country.PANAMA_PAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)80); // uid 31884, Passenger Vessel (Group 1 Merchant)
    }
}
