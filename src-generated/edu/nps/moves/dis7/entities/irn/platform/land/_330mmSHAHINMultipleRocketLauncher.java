package edu.nps.moves.dis7.entities.irn.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@41dd05a
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 18034
 */
public class _330mmSHAHINMultipleRocketLauncher extends EntityType
{
    public _330mmSHAHINMultipleRocketLauncher()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 18032, Self-Propelled Artillery
        setSubCategory((byte)2); // uid 18034, 330 mm SHAHIN Multiple Rocket Launcher
    }
}
