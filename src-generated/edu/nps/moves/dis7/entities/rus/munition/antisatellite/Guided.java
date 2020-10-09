package edu.nps.moves.dis7.entities.rus.munition.antisatellite;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@3f0ce0d1
 * Country: Russia (RUS)
 * Entity kind: Munition
 * Domain: ANTI_SATELLITE
 *
 * Entity type uid: 20527
 */
public class Guided extends EntityType
{
    public Guided()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SATELLITE));

        setCategory((byte)1); // uid 20527, Guided
    }
}
