package edu.nps.moves.dis7.entities.kwt.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@19b30c92
 * Country: Kuwait (KWT)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 17919
 */
public class P3404AlSanbouk extends EntityType
{
    public P3404AlSanbouk()
    {
        setCountry(Country.KUWAIT_KWT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 17912, Light/Patrol Craft
        setSubCategory((byte)2); // uid 17918, TNC 45 Type (fast attack craft-missile)
        setSpecific((byte)1); // uid 17919, P3404 Al Sanbouk
    }
}
