package edu.nps.moves.dis7.entities.are.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7412ed6b
 * Country: United Arab Emirates (ARE)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18694
 */
public class P561Kawkab extends EntityType
{
    public P561Kawkab()
    {
        setCountry(Country.UNITED_ARAB_EMIRATES_ARE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 18692, Light/Patrol Craft
        setSubCategory((byte)1); // uid 18693, Kawkab Class (coastal patrol craft)
        setSpecific((byte)1); // uid 18694, P561 Kawkab
    }
}
