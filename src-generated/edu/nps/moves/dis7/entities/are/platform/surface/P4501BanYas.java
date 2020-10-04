package edu.nps.moves.dis7.entities.are.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@31dfc6f5
 * Country: United Arab Emirates (ARE)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18701
 */
public class P4501BanYas extends EntityType
{
    public P4501BanYas()
    {
        setCountry(Country.UNITED_ARAB_EMIRATES_ARE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 18692, Light/Patrol Craft
        setSubCategory((byte)3); // uid 18700, Ban Yas (Lurssen TNC 45) Class (fast attack craft-missile)
        setSpecific((byte)1); // uid 18701, P4501 Ban Yas
    }
}
