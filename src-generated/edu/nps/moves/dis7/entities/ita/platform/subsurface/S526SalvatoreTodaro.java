package edu.nps.moves.dis7.entities.ita.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@77602954
 * Country: Italy (ITA)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 18664
 */
public class S526SalvatoreTodaro extends EntityType
{
    public S526SalvatoreTodaro()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 18649, SS (Conventional Attack-Torpedo, Patrol)
        setSubCategory((byte)4); // uid 18663, Todaro Class (Type 212A)
        setSpecific((byte)1); // uid 18664, S526 Salvatore Todaro
    }
}
