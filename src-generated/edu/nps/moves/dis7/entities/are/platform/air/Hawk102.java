package edu.nps.moves.dis7.entities.are.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1f9f381d;
 * Country: United Arab Emirates (ARE);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 28585
 */
public class Hawk102 extends EntityType
{
    /** Default constructor */
    public Hawk102()
    {
        setCountry(Country.UNITED_ARAB_EMIRATES_ARE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 28579, Trainer
        setSubCategory((byte)1); // uid 28580, BAE Systems Hawk
        setSpecific((byte)3); // uid 28585, Hawk 102
    }
}
