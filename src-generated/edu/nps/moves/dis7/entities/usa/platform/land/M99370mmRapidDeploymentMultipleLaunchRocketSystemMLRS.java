package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@668625f5;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 10342
 */
public class M99370mmRapidDeploymentMultipleLaunchRocketSystemMLRS extends EntityType
{
    /** Default constructor */
    public M99370mmRapidDeploymentMultipleLaunchRocketSystemMLRS()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 10312, Towed artillery
        setSubCategory((byte)15); // uid 10342, M993 70-mm Rapid Deployment Multiple Launch Rocket System (MLRS)
    }
}
