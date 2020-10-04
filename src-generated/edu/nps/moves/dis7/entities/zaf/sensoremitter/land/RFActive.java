package edu.nps.moves.dis7.entities.zaf.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@3cad24ae
 * Country: South Africa (ZAF)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 23703
 */
public class RFActive extends EntityType
{
    public RFActive()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 23703, RF Active
    }
}
