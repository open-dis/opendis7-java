package edu.nps.moves.dis7.entities.ind.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@403f0a22
 * Country: India (IND)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 31714
 */
public class DornierDo228 extends EntityType
{
    public DornierDo228()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 31713, Cargo/Tanker
        setSubCategory((byte)1); // uid 31714, Dornier Do 228
    }
}
