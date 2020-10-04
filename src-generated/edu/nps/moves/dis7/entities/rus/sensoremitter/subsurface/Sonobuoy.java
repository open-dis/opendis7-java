package edu.nps.moves.dis7.entities.rus.sensoremitter.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@24b3f778
 * Country: Russia (RUS)
 * Entity kind: Sensor/Emitter
 * Domain: SUBSURFACE
 *
 * Entity type uid: 26683
 */
public class Sonobuoy extends EntityType
{
    public Sonobuoy()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)10); // uid 22458, Acoustic, active
        setSubCategory((byte)77); // uid 26683, Sonobuoy
    }
}
