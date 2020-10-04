package edu.nps.moves.dis7.entities.irn.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@67c2e933
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 18033
 */
public class _320mmOGHABMultipleRocketLauncher extends EntityType
{
    public _320mmOGHABMultipleRocketLauncher()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 18032, Self-Propelled Artillery
        setSubCategory((byte)1); // uid 18033, 320 mm OGHAB Multiple Rocket Launcher
    }
}
