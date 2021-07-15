package edu.nps.moves.dis7.entities.esp.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@496a31da;
 * Country: Spain (ESP);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 29595
 */
public class McDonnellDouglasEF18Hornet extends EntityType
{
    /** Default constructor */
    public McDonnellDouglasEF18Hornet()
    {
        setCountry(Country.SPAIN_ESP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 29594, Fighter/Air Defense
        setSubCategory((byte)1); // uid 29595, McDonnell Douglas EF-18 Hornet
    }
}
