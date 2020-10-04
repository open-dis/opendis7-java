package edu.nps.moves.dis7.entities.usa.sensoremitter.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@39f4a7c4
 * Country: United States of America (USA)
 * Entity kind: Sensor/Emitter
 * Domain: SUBSURFACE
 *
 * Entity type uid: 22381
 */
public class ANSSQ36BBTSBathythermographTransmittingSet extends EntityType
{
    public ANSSQ36BBTSBathythermographTransmittingSet()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)9); // uid 22379, Thermal (temperature sensing)
        setSubCategory((byte)78); // uid 22380, Bathythermal Sensor
        setSpecific((byte)1); // uid 22381, AN/SSQ-36B BTS (Bathythermograph Transmitting Set)
    }
}
