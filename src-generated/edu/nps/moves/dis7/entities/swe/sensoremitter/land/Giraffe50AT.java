package edu.nps.moves.dis7.entities.swe.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@1b25d695
 * Country: Sweden (SWE)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 22551
 */
public class Giraffe50AT extends EntityType
{
    public Giraffe50AT()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22547, RF Active
        setSubCategory((byte)5); // uid 22548, Target Acquisition Radar
        setSpecific((byte)1); // uid 22549, Giraffe
        setExtra((byte)2); // uid 22551, Giraffe-50 AT
    }
}
