package edu.nps.moves.dis7.entities.usa.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@7c69e1e1
 * Country: United States of America (USA)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 22991
 */
public class DT562GSQAcousticSeismic extends EntityType
{
    public DT562GSQAcousticSeismic()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 22987, Multi-spectral
        setSubCategory((byte)24); // uid 22988, Battlefield Surveillance
        setSpecific((byte)2); // uid 22990, AN/GSQ-187 Improved REMBASS
        setExtra((byte)1); // uid 22991, DT-562/GSQ - Acoustic/Seismic
    }
}
