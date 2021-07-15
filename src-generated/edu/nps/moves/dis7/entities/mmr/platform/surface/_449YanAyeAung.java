package edu.nps.moves.dis7.entities.mmr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5922ae77;
 * Country: Myanmar (MMR);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 32914
 */
public class _449YanAyeAung extends EntityType
{
    /** Default constructor */
    public _449YanAyeAung()
    {
        setCountry(Country.MYANMAR_MMR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 32905, Light/Patrol Craft
        setSubCategory((byte)1); // uid 32906, Hainan Class (Type 037)
        setSpecific((byte)8); // uid 32914, 449 Yan Aye Aung
    }
}
