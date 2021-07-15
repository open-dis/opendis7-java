package edu.nps.moves.dis7.entities.prk.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@8549c5f;
 * Country: Korea (Democratic Peoples Republic of) (PRK);
 * Entity kind: Sensor/Emitter;
 * Domain: LAND;
 *
 * Entity type uid: 22535
 */
public class DrumTiltB extends EntityType
{
    /** Default constructor */
    public DrumTiltB()
    {
        setCountry(Country.KOREA_DEMOCRATIC_PEOPLES_REPUBLIC_OF_PRK);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22530, RF Active
        setSubCategory((byte)4); // uid 22534, Fire Control Radar
        setSpecific((byte)1); // uid 22535, Drum Tilt B
    }
}
