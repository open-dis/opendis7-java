package edu.nps.moves.dis7.entities.deu.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@748741cb
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 16356
 */
public class PAH1A1 extends EntityType
{
    public PAH1A1()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)20); // uid 16353, Attack Helicopter
        setSubCategory((byte)1); // uid 16354, Eurocopter BO 105/PAH-1/VBH/BSH-1
        setSpecific((byte)2); // uid 16356, PAH-1A1
    }
}
