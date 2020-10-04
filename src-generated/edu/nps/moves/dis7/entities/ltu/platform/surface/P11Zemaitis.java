package edu.nps.moves.dis7.entities.ltu.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@59a67c3a
 * Country: Lithuania (LTU)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27779
 */
public class P11Zemaitis extends EntityType
{
    public P11Zemaitis()
    {
        setCountry(Country.LITHUANIA_LTU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 27777, Light/Patrol Craft
        setSubCategory((byte)1); // uid 27778, Flyvefisken Class
        setSpecific((byte)1); // uid 27779, P11 Zemaitis
    }
}
