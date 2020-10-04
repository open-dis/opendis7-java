package edu.nps.moves.dis7.entities.chn.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@727dcc64
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 31720
 */
public class YLC6ATM extends EntityType
{
    public YLC6ATM()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22506, RF Active
        setSubCategory((byte)2); // uid 22510, Early Warning / Surveillance Radar
        setSpecific((byte)16); // uid 31719, YLC-6 Radar
        setExtra((byte)1); // uid 31720, YLC-6 ATM
    }
}
