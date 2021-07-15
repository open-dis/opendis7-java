package edu.nps.moves.dis7.entities.usa.munition.antisatellite;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@7e2bd5e6;
 * Country: United States of America (USA);
 * Entity kind: Munition;
 * Domain: ANTI_SATELLITE;
 *
 * Entity type uid: 19686
 */
public class Guided extends EntityType
{
    /** Default constructor */
    public Guided()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SATELLITE));

        setCategory((byte)1); // uid 19686, Guided
    }
}
