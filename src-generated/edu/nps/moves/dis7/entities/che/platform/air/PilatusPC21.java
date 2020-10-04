package edu.nps.moves.dis7.entities.che.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@337bbfdf
 * Country: Switzerland (CHE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24800
 */
public class PilatusPC21 extends EntityType
{
    public PilatusPC21()
    {
        setCountry(Country.SWITZERLAND_CHE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 19048, Trainer
        setSubCategory((byte)3); // uid 24800, Pilatus PC-21
    }
}
