package edu.nps.moves.dis7.entities.che.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@59072e9d
 * Country: Switzerland (CHE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 19049
 */
public class PilatusPC7 extends EntityType
{
    public PilatusPC7()
    {
        setCountry(Country.SWITZERLAND_CHE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 19048, Trainer
        setSubCategory((byte)1); // uid 19049, Pilatus PC-7
    }
}
