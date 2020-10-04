package edu.nps.moves.dis7.entities.tur.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@74170687
 * Country: Turkey (TUR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23243
 */
public class P337Atak extends EntityType
{
    public P337Atak()
    {
        setCountry(Country.TURKEY_TUR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 19062, Light/Patrol Craft
        setSubCategory((byte)4); // uid 23235, Kilic class
        setSpecific((byte)8); // uid 23243, P337 Atak
    }
}
