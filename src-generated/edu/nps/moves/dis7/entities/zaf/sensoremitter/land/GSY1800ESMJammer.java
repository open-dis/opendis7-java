package edu.nps.moves.dis7.entities.zaf.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@42a05533
 * Country: South Africa (ZAF)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 23705
 */
public class GSY1800ESMJammer extends EntityType
{
    public GSY1800ESMJammer()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 23703, RF Active
        setSubCategory((byte)1); // uid 23704, Multi-function
        setSpecific((byte)1); // uid 23705, GSY 1800 ESM/Jammer
    }
}
