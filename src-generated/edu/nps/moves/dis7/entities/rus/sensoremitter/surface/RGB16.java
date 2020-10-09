package edu.nps.moves.dis7.entities.rus.sensoremitter.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@681d704e
 * Country: Russia (RUS)
 * Entity kind: Sensor/Emitter
 * Domain: SURFACE
 *
 * Entity type uid: 28221
 */
public class RGB16 extends EntityType
{
    public RGB16()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)11); // uid 28216, Acoustic, Passive
        setSubCategory((byte)77); // uid 28217, Sonobuoy
        setSpecific((byte)4); // uid 28221, RGB-16
    }
}
