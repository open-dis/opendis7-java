package edu.nps.moves.dis7.entities.irq.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6cd7f381;
 * Country: Iraq (IRQ);
 * Entity kind: Sensor/Emitter;
 * Domain: LAND;
 *
 * Entity type uid: 22584
 */
public class Mobile extends EntityType
{
    /** Default constructor */
    public Mobile()
    {
        setCountry(Country.IRAQ_IRQ);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22581, RF Active
        setSubCategory((byte)1); // uid 22582, Multi-function
        setSpecific((byte)2); // uid 22584, Mobile
    }
}
