package edu.nps.moves.dis7.entities.ser.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@2328ec73
 * Country: Serbia and Montenegro
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 22587
 */
public class RFActive extends EntityType
{
    public RFActive()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22587, RF Active
    }
}
