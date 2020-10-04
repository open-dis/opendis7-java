package edu.nps.moves.dis7.entities.jpn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6722db6e
 * Country: Japan (JPN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24787
 */
public class KawasakiC2 extends EntityType
{
    public KawasakiC2()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 24785, Cargo/Tanker
        setSubCategory((byte)2); // uid 24787, Kawasaki C-2
    }
}
