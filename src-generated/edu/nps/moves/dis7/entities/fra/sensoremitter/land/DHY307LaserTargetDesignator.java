package edu.nps.moves.dis7.entities.fra.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2e3900dc
 * Country: France (FRA)
 * Entity kind: Sensor/Emitter
 * Domain: LAND
 *
 * Entity type uid: 23699
 */
public class DHY307LaserTargetDesignator extends EntityType
{
    public DHY307LaserTargetDesignator()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 23697, Electro-Optical
        setSubCategory((byte)60); // uid 23698, Missile Guidance
        setSpecific((byte)1); // uid 23699, DHY-307 Laser Target Designator
    }
}
