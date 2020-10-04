package edu.nps.moves.dis7.entities.rus.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@78e043e4
 * Country: Russia (RUS)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 22439
 */
public class SnowDrift9S18M1 extends EntityType
{
    public SnowDrift9S18M1()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22411, RF Active
        setSubCategory((byte)5); // uid 22437, Target Acquisition Radar
        setSpecific((byte)2); // uid 22439, Snow Drift (9S18M1)
    }
}
