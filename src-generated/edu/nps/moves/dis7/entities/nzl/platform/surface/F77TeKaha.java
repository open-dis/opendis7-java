package edu.nps.moves.dis7.entities.nzl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@329a1243
 * Country: New Zealand (NZL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 31743
 */
public class F77TeKaha extends EntityType
{
    public F77TeKaha()
    {
        setCountry(Country.NEW_ZEALAND_NZL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 31741, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 31742, ANZAC Class (Meko 200)
        setSpecific((byte)1); // uid 31743, F77 Te Kaha
    }
}
