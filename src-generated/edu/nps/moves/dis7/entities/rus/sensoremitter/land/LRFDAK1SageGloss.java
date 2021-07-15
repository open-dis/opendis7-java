package edu.nps.moves.dis7.entities.rus.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@67e11bda;
 * Country: Russia (RUS);
 * Entity kind: Sensor/Emitter;
 * Domain: LAND;
 *
 * Entity type uid: 23717
 */
public class LRFDAK1SageGloss extends EntityType
{
    /** Default constructor */
    public LRFDAK1SageGloss()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 23715, Electro-Optical
        setSubCategory((byte)9); // uid 23716, Ranging
        setSpecific((byte)1); // uid 23717, LRF DAK-1 (Sage Gloss)
    }
}
