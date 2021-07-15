package edu.nps.moves.dis7.entities.cze.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4cc4d454;
 * Country: Czech Republic (CZE);
 * Entity kind: Sensor/Emitter;
 * Domain: LAND;
 *
 * Entity type uid: 30104
 */
public class TamaraTrashDrum extends EntityType
{
    /** Default constructor */
    public TamaraTrashDrum()
    {
        setCountry(Country.CZECH_REPUBLIC_CZE);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)3); // uid 30101, RF Passive (intercept and DF)
        setSubCategory((byte)16); // uid 30102, Identification/Classification (including IFF)
        setSpecific((byte)2); // uid 30104, Tamara (Trash Drum)
    }
}
