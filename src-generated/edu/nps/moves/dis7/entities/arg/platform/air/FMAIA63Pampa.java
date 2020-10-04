package edu.nps.moves.dis7.entities.arg.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6504e3b2
 * Country: Argentina (ARG)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24776
 */
public class FMAIA63Pampa extends EntityType
{
    public FMAIA63Pampa()
    {
        setCountry(Country.ARGENTINA_ARG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 24774, Trainer
        setSubCategory((byte)1); // uid 24775, FMA/FAdeA Pampa
        setSpecific((byte)1); // uid 24776, FMA IA 63 Pampa
    }
}
