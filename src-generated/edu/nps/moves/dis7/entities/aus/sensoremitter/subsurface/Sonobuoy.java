package edu.nps.moves.dis7.entities.aus.sensoremitter.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@56881196
 * Country: Australia (AUS)
 * Entity kind: Sensor/Emitter
 * Domain: SUBSURFACE
 *
 * Entity type uid: 22557
 */
public class Sonobuoy extends EntityType
{
    public Sonobuoy()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)11); // uid 22556, Acoustic, passive
        setSubCategory((byte)77); // uid 22557, Sonobuoy
    }
}
