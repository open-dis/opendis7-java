package edu.nps.moves.dis7.entities.cze.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3e694b3f
 * Country: Czech Republic (CZE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 30099
 */
public class AeroL591 extends EntityType
{
    public AeroL591()
    {
        setCountry(Country.CZECH_REPUBLIC_CZE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 30096, Trainer
        setSubCategory((byte)3); // uid 30099, Aero L-59
    }
}
