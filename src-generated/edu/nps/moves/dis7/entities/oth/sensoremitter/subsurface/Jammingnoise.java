package edu.nps.moves.dis7.entities.oth.sensoremitter.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@10d905c1
 * Country: Other
 * Entity kind: Sensor/Emitter
 * Domain: SUBSURFACE
 *
 * Entity type uid: 22567
 */
public class Jammingnoise extends EntityType
{
    public Jammingnoise()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)10); // uid 22566, Acoustic, active
        setSubCategory((byte)64); // uid 22567, Jamming noise
    }
}
