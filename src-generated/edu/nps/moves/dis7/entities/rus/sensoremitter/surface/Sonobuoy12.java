package edu.nps.moves.dis7.entities.rus.sensoremitter.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7c3c3d67
 * Country: Russia (RUS)
 * Entity kind: Sensor/Emitter
 * Domain: SURFACE
 *
 * Entity type uid: 28229
 */
public class Sonobuoy12 extends EntityType
{
    public Sonobuoy12()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)15); // uid 28228, Magnetic
        setSubCategory((byte)77); // uid 28229, Sonobuoy
    }
}
