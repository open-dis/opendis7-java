package edu.nps.moves.dis7.entities.deu.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4fedf908
 * Country: Germany (DEU)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 28113
 */
public class RPR117 extends EntityType
{
    public RPR117()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22489, RF Active
        setSubCategory((byte)2); // uid 28112, Early Warning/Surveillance
        setSpecific((byte)1); // uid 28113, RPR-117
    }
}
