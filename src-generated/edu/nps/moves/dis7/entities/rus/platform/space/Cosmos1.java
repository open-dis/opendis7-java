package edu.nps.moves.dis7.entities.rus.platform.space;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@12c60152
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: SPACE
 *
 * Entity type uid: 14857
 */
public class Cosmos1 extends EntityType
{
    public Cosmos1()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SPACE));

        setCategory((byte)2); // uid 14850, Unmanned
        setSubCategory((byte)3); // uid 14856, Early Warning satellite
        setSpecific((byte)1); // uid 14857, Cosmos
    }
}
