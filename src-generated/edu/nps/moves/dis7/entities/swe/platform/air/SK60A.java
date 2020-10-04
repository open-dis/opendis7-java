package edu.nps.moves.dis7.entities.swe.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1dba4e06
 * Country: Sweden (SWE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 25596
 */
public class SK60A extends EntityType
{
    public SK60A()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 25594, Trainer
        setSubCategory((byte)1); // uid 25595, Saab 105
        setSpecific((byte)1); // uid 25596, SK 60A
    }
}
