package edu.nps.moves.dis7.entities.fra.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@78b9155e
 * Country: France (FRA)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 22486
 */
public class VolexIIIIV extends EntityType
{
    public VolexIIIIV()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 22477, RF Active
        setSubCategory((byte)2); // uid 22481, Early Warning/Surveillance Radar
        setSpecific((byte)5); // uid 22486, Volex III/IV
    }
}
