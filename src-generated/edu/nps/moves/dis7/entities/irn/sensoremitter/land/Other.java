package edu.nps.moves.dis7.entities.irn.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@5402612e
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 22574
 */
public class Other extends EntityType
{
    public Other()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)0); // uid 22574, Other
    }
}
