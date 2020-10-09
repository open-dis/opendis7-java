package edu.nps.moves.dis7.entities.are.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@29a98d9f
 * Country: United Arab Emirates (ARE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28584
 */
public class Hawk63C extends EntityType
{
    public Hawk63C()
    {
        setCountry(Country.UNITED_ARAB_EMIRATES_ARE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 28579, Trainer
        setSubCategory((byte)1); // uid 28580, BAE Systems Hawk
        setSpecific((byte)2); // uid 28582, Hawk 63
        setExtra((byte)2); // uid 28584, Hawk 63C
    }
}
