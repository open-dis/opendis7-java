package edu.nps.moves.dis7.entities.che.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@192f5f39;
 * Country: Switzerland (CHE);
 * Entity kind: Sensor/Emitter;
 * Domain: LAND;
 *
 * Entity type uid: 22497
 */
public class SuperFledermaus extends EntityType
{
    /** Default constructor */
    public SuperFledermaus()
    {
        setCountry(Country.SWITZERLAND_CHE);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22494, RF Active
        setSubCategory((byte)4); // uid 22495, Fire Control Radar
        setSpecific((byte)2); // uid 22497, Super Fledermaus
    }
}
