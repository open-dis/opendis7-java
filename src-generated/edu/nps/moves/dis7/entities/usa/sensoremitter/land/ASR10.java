package edu.nps.moves.dis7.entities.usa.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@eb91027
 * Country: United States of America (USA)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 22338
 */
public class ASR10 extends EntityType
{
    public ASR10()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22317, RF Active
        setSubCategory((byte)2); // uid 22321, Early Warning / Surveillance Radar
        setSpecific((byte)15); // uid 22338, ASR-10
    }
}
