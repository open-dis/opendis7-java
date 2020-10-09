package edu.nps.moves.dis7.entities.rus.sensoremitter.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@50785f86
 * Country: Russia (RUS)
 * Entity kind: Sensor/Emitter
 * Domain: SURFACE
 *
 * Entity type uid: 28230
 */
public class RMB81 extends EntityType
{
    public RMB81()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)15); // uid 28228, Magnetic
        setSubCategory((byte)77); // uid 28229, Sonobuoy
        setSpecific((byte)1); // uid 28230, RMB-81
    }
}
