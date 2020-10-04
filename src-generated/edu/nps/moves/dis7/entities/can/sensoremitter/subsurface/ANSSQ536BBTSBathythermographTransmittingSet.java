package edu.nps.moves.dis7.entities.can.sensoremitter.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@25464154
 * Country: Canada (CAN)
 * Entity kind: Sensor/Emitter
 * Domain: SUBSURFACE
 *
 * Entity type uid: 22598
 */
public class ANSSQ536BBTSBathythermographTransmittingSet extends EntityType
{
    public ANSSQ536BBTSBathythermographTransmittingSet()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)9); // uid 22596, Thermal (temperature sensing)
        setSubCategory((byte)78); // uid 22597, Bathythermal Sensor
        setSpecific((byte)1); // uid 22598, AN/SSQ-536B BTS (Bathythermograph Transmitting Set)
    }
}
