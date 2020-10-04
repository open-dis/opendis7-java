package edu.nps.moves.dis7.entities.ken.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3e2943ab
 * Country: Kenya (KEN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28548
 */
public class BAESystemsHawk extends EntityType
{
    public BAESystemsHawk()
    {
        setCountry(Country.KENYA_KEN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 28547, Trainer
        setSubCategory((byte)1); // uid 28548, BAE Systems Hawk
    }
}
