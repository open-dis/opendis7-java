package edu.nps.moves.dis7.entities.aus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7e774085;
 * Country: Australia (AUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31767
 */
public class BushmasterProtectedMobilityVehicleEW extends EntityType
{
    /** Default constructor */
    public BushmasterProtectedMobilityVehicleEW()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)3); // uid 26906, Armored Utility Vehicle
        setSubCategory((byte)2); // uid 26912, Bushmaster Protected Mobility Vehicle
        setSpecific((byte)7); // uid 31767, Bushmaster Protected Mobility Vehicle - EW
    }
}
