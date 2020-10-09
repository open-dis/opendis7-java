package edu.nps.moves.dis7.entities.kwt.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@25f9407e
 * Country: Kuwait (KWT)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 17907
 */
public class ShortTucano extends EntityType
{
    public ShortTucano()
    {
        setCountry(Country.KUWAIT_KWT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 17906, Trainer
        setSubCategory((byte)1); // uid 17907, Short Tucano
    }
}
