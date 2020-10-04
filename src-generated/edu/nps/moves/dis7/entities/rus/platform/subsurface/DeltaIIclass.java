package edu.nps.moves.dis7.entities.rus.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7139bd31
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 14763
 */
public class DeltaIIclass extends EntityType
{
    public DeltaIIclass()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)1); // uid 14759, SSBN (Nuclear Ballistic Missile)
        setSubCategory((byte)4); // uid 14763, Delta II class
    }
}
