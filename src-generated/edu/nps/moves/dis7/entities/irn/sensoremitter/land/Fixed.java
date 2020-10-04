package edu.nps.moves.dis7.entities.irn.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@43445fc6
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 22577
 */
public class Fixed extends EntityType
{
    public Fixed()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22575, RF Active
        setSubCategory((byte)1); // uid 22576, Multi-function
        setSpecific((byte)1); // uid 22577, Fixed
    }
}
