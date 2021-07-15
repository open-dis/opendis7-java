package edu.nps.moves.dis7.entities.rou.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5f212d84;
 * Country: Romania (ROU);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 29196
 */
public class IAR99Soim extends EntityType
{
    /** Default constructor */
    public IAR99Soim()
    {
        setCountry(Country.ROMANIA_ROU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 29195, Trainer
        setSubCategory((byte)1); // uid 29196, IAR 99 Soim
    }
}
