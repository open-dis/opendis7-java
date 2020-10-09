package edu.nps.moves.dis7.entities.che.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@2f6e92ca
 * Country: Switzerland (CHE)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 28729
 */
public class SkyguardIII extends EntityType
{
    public SkyguardIII()
    {
        setCountry(Country.SWITZERLAND_CHE);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22494, RF Active
        setSubCategory((byte)4); // uid 22495, Fire Control Radar
        setSpecific((byte)1); // uid 22496, Skyguard
        setExtra((byte)1); // uid 28729, Skyguard III
    }
}
