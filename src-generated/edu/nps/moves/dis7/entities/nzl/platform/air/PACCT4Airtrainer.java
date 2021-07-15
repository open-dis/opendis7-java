package edu.nps.moves.dis7.entities.nzl.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1e11bc55;
 * Country: New Zealand (NZL);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 29191
 */
public class PACCT4Airtrainer extends EntityType
{
    /** Default constructor */
    public PACCT4Airtrainer()
    {
        setCountry(Country.NEW_ZEALAND_NZL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 29190, Trainer
        setSubCategory((byte)1); // uid 29191, PAC CT/4 Airtrainer
    }
}
