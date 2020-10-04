package edu.nps.moves.dis7.entities.fin.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@6e509ffa
 * Country: Finland (FIN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28531
 */
public class Trainer extends EntityType
{
    public Trainer()
    {
        setCountry(Country.FINLAND_FIN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 28531, Trainer
    }
}
