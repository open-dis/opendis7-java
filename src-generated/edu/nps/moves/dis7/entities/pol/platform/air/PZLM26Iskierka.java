package edu.nps.moves.dis7.entities.pol.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1d2644e3
 * Country: Poland (POL)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29193
 */
public class PZLM26Iskierka extends EntityType
{
    public PZLM26Iskierka()
    {
        setCountry(Country.POLAND_POL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 29192, Trainer
        setSubCategory((byte)1); // uid 29193, PZL M26 Iskierka
    }
}
