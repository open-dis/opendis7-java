package edu.nps.moves.dis7.entities.usa.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@6ec3a4c2
 * Country: United States of America (USA)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 23653
 */
public class ACADAwTelemetryLink extends EntityType
{
    public ACADAwTelemetryLink()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 22359, Chemical, point detector
        setSubCategory((byte)2); // uid 22362, Early Warning/Surveillance
        setSpecific((byte)2); // uid 23652, ACADA
        setExtra((byte)1); // uid 23653, ACADA w/Telemetry Link
    }
}
