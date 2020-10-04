package edu.nps.moves.dis7.entities.nor.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3704122f
 * Country: Norway (NOR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 29678
 */
public class CondensateStorageTanker extends EntityType
{
    public CondensateStorageTanker()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24609, Tanker (Group 3 Merchant)
        setSubCategory((byte)9); // uid 29678, Condensate Storage Tanker
    }
}
