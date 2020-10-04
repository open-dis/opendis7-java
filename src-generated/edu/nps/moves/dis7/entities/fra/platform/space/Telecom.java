package edu.nps.moves.dis7.entities.fra.platform.space;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5c86a017
 * Country: France (FRA)
 * Entity kind: Platform
 * Domain: SPACE
 *
 * Entity type uid: 16213
 */
public class Telecom extends EntityType
{
    public Telecom()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SPACE));

        setCategory((byte)2); // uid 16211, Unmanned
        setSubCategory((byte)1); // uid 16212, Communication satellite
        setSpecific((byte)1); // uid 16213, Telecom
    }
}
