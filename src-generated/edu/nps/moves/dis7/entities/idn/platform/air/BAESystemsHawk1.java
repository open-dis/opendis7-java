package edu.nps.moves.dis7.entities.idn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@495fac5f
 * Country: Indonesia (IDN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28543
 */
public class BAESystemsHawk1 extends EntityType
{
    public BAESystemsHawk1()
    {
        setCountry(Country.INDONESIA_IDN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 28542, Trainer
        setSubCategory((byte)1); // uid 28543, BAE Systems Hawk
    }
}
