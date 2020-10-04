package edu.nps.moves.dis7.entities.rus.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5c60b0a0
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 30415
 */
public class _998YunarmeetsKamchatkiP417 extends EntityType
{
    public _998YunarmeetsKamchatkiP417()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 13805, Auxiliary
        setSubCategory((byte)118); // uid 30405, Grachonok Class (Project 21980) Anti-Saboteur Ship
        setSpecific((byte)10); // uid 30415, 998 Yunarmeets Kamchatki (P-417)
    }
}
