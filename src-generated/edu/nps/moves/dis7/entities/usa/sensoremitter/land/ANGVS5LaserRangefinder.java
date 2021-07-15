package edu.nps.moves.dis7.entities.usa.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@39b85a73;
 * Country: United States of America (USA);
 * Entity kind: Sensor/Emitter;
 * Domain: LAND;
 *
 * Entity type uid: 23725
 */
public class ANGVS5LaserRangefinder extends EntityType
{
    /** Default constructor */
    public ANGVS5LaserRangefinder()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 23721, Electro-Optical
        setSubCategory((byte)9); // uid 23724, Ranging
        setSpecific((byte)1); // uid 23725, AN/GVS-5 Laser Rangefinder
    }
}
