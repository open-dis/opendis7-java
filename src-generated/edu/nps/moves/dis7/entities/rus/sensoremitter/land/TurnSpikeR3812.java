package edu.nps.moves.dis7.entities.rus.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@cf08c97
 * Country: Russia (RUS)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 22836
 */
public class TurnSpikeR3812 extends EntityType
{
    public TurnSpikeR3812()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)3); // uid 22833, RF Passive (intercept and DF)
        setSubCategory((byte)16); // uid 22834, Identification/Classification (including IFF)
        setSpecific((byte)2); // uid 22836, Turn Spike R-381-2
    }
}
