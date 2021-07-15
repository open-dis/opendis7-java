package edu.nps.moves.dis7.entities.isr.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@7ce97ee5;
 * Country: Israel (ISR);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 18249
 */
public class SSGConventionalGuidedMissile extends EntityType
{
    /** Default constructor */
    public SSGConventionalGuidedMissile()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)4); // uid 18249, SSG (Conventional Guided Missile)
    }
}
