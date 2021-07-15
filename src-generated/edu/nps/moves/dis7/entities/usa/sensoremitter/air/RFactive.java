package edu.nps.moves.dis7.entities.usa.sensoremitter.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@4e85dcb2;
 * Country: United States of America (USA);
 * Entity kind: Sensor/Emitter;
 * Domain: AIR;
 *
 * Entity type uid: 22368
 */
public class RFactive extends EntityType
{
    /** Default constructor */
    public RFactive()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)2); // uid 22368, RF active
    }
}
