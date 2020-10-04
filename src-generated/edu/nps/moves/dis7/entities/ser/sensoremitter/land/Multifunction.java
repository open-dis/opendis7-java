package edu.nps.moves.dis7.entities.ser.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@71d99732
 * Country: Serbia and Montenegro
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 22588
 */
public class Multifunction extends EntityType
{
    public Multifunction()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22587, RF Active
        setSubCategory((byte)1); // uid 22588, Multi-function
    }
}
