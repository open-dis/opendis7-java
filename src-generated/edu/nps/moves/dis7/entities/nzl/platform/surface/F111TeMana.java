package edu.nps.moves.dis7.entities.nzl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7957dc72;
 * Country: New Zealand (NZL);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31744
 */
public class F111TeMana extends EntityType
{
    /** Default constructor */
    public F111TeMana()
    {
        setCountry(Country.NEW_ZEALAND_NZL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 31741, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 31742, ANZAC Class (Meko 200)
        setSpecific((byte)2); // uid 31744, F111 Te Mana
    }
}
