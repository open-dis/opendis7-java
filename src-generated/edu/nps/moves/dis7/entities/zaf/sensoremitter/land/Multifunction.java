package edu.nps.moves.dis7.entities.zaf.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@17053b5
 * Country: South Africa (ZAF)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 23704
 */
public class Multifunction extends EntityType
{
    public Multifunction()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 23703, RF Active
        setSubCategory((byte)1); // uid 23704, Multi-function
    }
}
