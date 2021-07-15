package edu.nps.moves.dis7.entities.deu.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1cf56a1c;
 * Country: Germany (DEU);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 24847
 */
public class AmbulanceTruckVolkswagenType2 extends EntityType
{
    /** Default constructor */
    public AmbulanceTruckVolkswagenType2()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)84); // uid 24845, Single Unit Utility/Emergency Truck
        setSubCategory((byte)1); // uid 24846, Ambulance Truck
        setSpecific((byte)1); // uid 24847, Ambulance Truck, Volkswagen Type 2
    }
}
