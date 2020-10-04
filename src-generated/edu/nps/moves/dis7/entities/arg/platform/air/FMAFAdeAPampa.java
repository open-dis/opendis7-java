package edu.nps.moves.dis7.entities.arg.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@626b2d4a
 * Country: Argentina (ARG)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24775
 */
public class FMAFAdeAPampa extends EntityType
{
    public FMAFAdeAPampa()
    {
        setCountry(Country.ARGENTINA_ARG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 24774, Trainer
        setSubCategory((byte)1); // uid 24775, FMA/FAdeA Pampa
    }
}
