package edu.nps.moves.dis7.entities.idn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7e3181aa;
 * Country: Indonesia (IDN);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 28545
 */
public class Hawk109 extends EntityType
{
    /** Default constructor */
    public Hawk109()
    {
        setCountry(Country.INDONESIA_IDN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 28542, Trainer
        setSubCategory((byte)1); // uid 28543, BAE Systems Hawk
        setSpecific((byte)2); // uid 28545, Hawk 109
    }
}
