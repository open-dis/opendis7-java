package edu.nps.moves.dis7.entities.fin.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@d21a74c
 * Country: Finland (FIN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28532
 */
public class BAESystemsHawk extends EntityType
{
    public BAESystemsHawk()
    {
        setCountry(Country.FINLAND_FIN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 28531, Trainer
        setSubCategory((byte)1); // uid 28532, BAE Systems Hawk
    }
}
