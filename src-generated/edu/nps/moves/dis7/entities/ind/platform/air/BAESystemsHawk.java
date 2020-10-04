package edu.nps.moves.dis7.entities.ind.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@74bada02
 * Country: India (IND)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28536
 */
public class BAESystemsHawk extends EntityType
{
    public BAESystemsHawk()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 28535, Trainer
        setSubCategory((byte)1); // uid 28536, BAE Systems Hawk
    }
}
