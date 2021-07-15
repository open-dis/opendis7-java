package edu.nps.moves.dis7.entities.nld.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@4f541e67;
 * Country: Netherlands (NLD);
 * Entity kind: Sensor/Emitter;
 * Domain: LAND;
 *
 * Entity type uid: 22570
 */
public class RFActive extends EntityType
{
    /** Default constructor */
    public RFActive()
    {
        setCountry(Country.NETHERLANDS_NLD);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22570, RF Active
    }
}
