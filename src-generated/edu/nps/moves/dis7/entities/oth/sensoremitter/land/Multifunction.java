package edu.nps.moves.dis7.entities.oth.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4345fd45
 * Country: Other
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 22562
 */
public class Multifunction extends EntityType
{
    public Multifunction()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22561, RF Active
        setSubCategory((byte)1); // uid 22562, Multi-function
    }
}
