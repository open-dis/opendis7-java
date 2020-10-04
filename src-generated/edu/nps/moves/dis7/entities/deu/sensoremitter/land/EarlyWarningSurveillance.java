package edu.nps.moves.dis7.entities.deu.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3006bfb
 * Country: Germany (DEU)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 28112
 */
public class EarlyWarningSurveillance extends EntityType
{
    public EarlyWarningSurveillance()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22489, RF Active
        setSubCategory((byte)2); // uid 28112, Early Warning/Surveillance
    }
}
