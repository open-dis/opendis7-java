package edu.nps.moves.dis7.entities.fra.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@aba625
 * Country: France (FRA)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 16177
 */
public class S617LeTemeraire extends EntityType
{
    public S617LeTemeraire()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)1); // uid 16174, SSBN (Nuclear Ballistic Missile)
        setSubCategory((byte)1); // uid 16175, Le Triomphant class (SNLE-NG)
        setSpecific((byte)2); // uid 16177, S 617 Le Temeraire
    }
}
