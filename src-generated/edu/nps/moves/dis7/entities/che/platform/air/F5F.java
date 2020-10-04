package edu.nps.moves.dis7.entities.che.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@25ad4f71
 * Country: Switzerland (CHE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 31132
 */
public class F5F extends EntityType
{
    public F5F()
    {
        setCountry(Country.SWITZERLAND_CHE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 31129, Fighter/Air Defense
        setSubCategory((byte)1); // uid 31130, F-5 Freedom Fighter/Tiger II
        setSpecific((byte)2); // uid 31132, F-5 F
    }
}
