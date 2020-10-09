package edu.nps.moves.dis7.entities.usa.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@e5c5e6
 * Country: United States of America (USA)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 32302
 */
public class ANPEQ18InfraredZoomLaserIlluminatorDesignatorIZLID1000P extends EntityType
{
    public ANPEQ18InfraredZoomLaserIlluminatorDesignatorIZLID1000P()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 23721, Electro-Optical
        setSubCategory((byte)7); // uid 32300, Guidance/Illumination
        setSpecific((byte)2); // uid 32302, AN/PEQ-18 Infrared Zoom Laser Illuminator Designator (IZLID) 1000P
    }
}
