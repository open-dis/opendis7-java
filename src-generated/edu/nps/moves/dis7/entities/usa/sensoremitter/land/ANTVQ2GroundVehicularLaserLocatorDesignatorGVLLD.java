package edu.nps.moves.dis7.entities.usa.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7a730479;
 * Country: United States of America (USA);
 * Entity kind: Sensor/Emitter;
 * Domain: LAND;
 *
 * Entity type uid: 23723
 */
public class ANTVQ2GroundVehicularLaserLocatorDesignatorGVLLD extends EntityType
{
    /** Default constructor */
    public ANTVQ2GroundVehicularLaserLocatorDesignatorGVLLD()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 23721, Electro-Optical
        setSubCategory((byte)60); // uid 23722, Missile Guidance
        setSpecific((byte)1); // uid 23723, AN/TVQ-2 Ground/Vehicular Laser Locator Designator (G/VLLD)
    }
}
