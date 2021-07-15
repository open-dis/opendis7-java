package edu.nps.moves.dis7.entities.rus.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3cead673;
 * Country: Russia (RUS);
 * Entity kind: Sensor/Emitter;
 * Domain: LAND;
 *
 * Entity type uid: 23720
 */
public class _1D22LaserTargetDesignator extends EntityType
{
    /** Default constructor */
    public _1D22LaserTargetDesignator()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 23715, Electro-Optical
        setSubCategory((byte)60); // uid 23718, Missile Guidance
        setSpecific((byte)2); // uid 23720, 1D22 Laser Target Designator
    }
}
