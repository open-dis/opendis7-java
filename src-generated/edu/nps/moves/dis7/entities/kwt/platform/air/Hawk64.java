package edu.nps.moves.dis7.entities.kwt.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@372ea2bc;
 * Country: Kuwait (KWT);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 28553
 */
public class Hawk64 extends EntityType
{
    /** Default constructor */
    public Hawk64()
    {
        setCountry(Country.KUWAIT_KWT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 17906, Trainer
        setSubCategory((byte)3); // uid 28552, BAE Systems Hawk
        setSpecific((byte)1); // uid 28553, Hawk 64
    }
}
