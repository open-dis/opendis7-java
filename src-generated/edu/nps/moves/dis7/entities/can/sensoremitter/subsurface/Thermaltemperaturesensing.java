package edu.nps.moves.dis7.entities.can.sensoremitter.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@131c0b6f
 * Country: Canada (CAN)
 * Entity kind: Sensor/Emitter
 * Domain: SUBSURFACE
 *
 * Entity type uid: 22596
 */
public class Thermaltemperaturesensing extends EntityType
{
    public Thermaltemperaturesensing()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)9); // uid 22596, Thermal (temperature sensing)
    }
}
