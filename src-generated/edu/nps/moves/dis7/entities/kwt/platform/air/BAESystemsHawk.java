package edu.nps.moves.dis7.entities.kwt.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1a69561c
 * Country: Kuwait (KWT)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28552
 */
public class BAESystemsHawk extends EntityType
{
    public BAESystemsHawk()
    {
        setCountry(Country.KUWAIT_KWT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 17906, Trainer
        setSubCategory((byte)3); // uid 28552, BAE Systems Hawk
    }
}
