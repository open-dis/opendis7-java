package edu.nps.moves.dis7.entities.usa.sensoremitter.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@75d539b9
 * Country: United States of America (USA)
 * Entity kind: Sensor/Emitter
 * Domain: SUBSURFACE
 *
 * Entity type uid: 32013
 */
public class HelrasDS100 extends EntityType
{
    public HelrasDS100()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)10); // uid 22382, Acoustic, active
        setSubCategory((byte)80); // uid 29659, Dipping Sonar
        setSpecific((byte)2); // uid 32013, Helras DS-100
    }
}
