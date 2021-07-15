package edu.nps.moves.dis7.entities.csk.sensoremitter.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1f6c4ae;
 * Country: Czechoslovakia (CSK);
 * Entity kind: Sensor/Emitter;
 * Domain: LAND;
 *
 * Entity type uid: 22503
 */
public class TamaraTrashDrum extends EntityType
{
    /** Default constructor */
    public TamaraTrashDrum()
    {
        setCountry(Country.ACTION_REQUEST_RELIABLE);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)3); // uid 22500, RF Passive (intercept and DF)
        setSubCategory((byte)16); // uid 22501, Identification/Classification Radar
        setSpecific((byte)2); // uid 22503, Tamara (Trash Drum)
    }
}
