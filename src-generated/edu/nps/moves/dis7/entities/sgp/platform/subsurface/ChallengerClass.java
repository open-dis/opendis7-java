package edu.nps.moves.dis7.entities.sgp.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3d37203b;
 * Country: Singapore (SGP);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 26616
 */
public class ChallengerClass extends EntityType
{
    /** Default constructor */
    public ChallengerClass()
    {
        setCountry(Country.SINGAPORE_SGP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 26615, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)1); // uid 26616, Challenger Class
    }
}
