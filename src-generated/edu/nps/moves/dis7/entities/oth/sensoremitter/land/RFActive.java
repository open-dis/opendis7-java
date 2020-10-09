package edu.nps.moves.dis7.entities.oth.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@4152bd0f
 * Country: Other
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 22561
 */
public class RFActive extends EntityType
{
    public RFActive()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22561, RF Active
    }
}
