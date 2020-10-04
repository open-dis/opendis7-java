package edu.nps.moves.dis7.entities.ita.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@64df9a61
 * Country: Italy (ITA)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 18660
 */
public class TotiClass1075class extends EntityType
{
    public TotiClass1075class()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 18649, SS (Conventional Attack-Torpedo, Patrol)
        setSubCategory((byte)3); // uid 18660, Toti Class (1075 class)
    }
}
