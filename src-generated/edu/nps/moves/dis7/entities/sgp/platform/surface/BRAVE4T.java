package edu.nps.moves.dis7.entities.sgp.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@fb713e7;
 * Country: Singapore (SGP);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 25557
 */
public class BRAVE4T extends EntityType
{
    /** Default constructor */
    public BRAVE4T()
    {
        setCountry(Country.SINGAPORE_SGP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)11); // uid 25555, Landing Craft
        setSubCategory((byte)1); // uid 25556, BRAVE Fast Landing Craft for Equipment and Personnel (FCEP)
        setSpecific((byte)1); // uid 25557, BRAVE -4T
    }
}
