package edu.nps.moves.dis7.entities.mys.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@1b822fcc
 * Country: Malaysia (MYS)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28558
 */
public class Trainer extends EntityType
{
    public Trainer()
    {
        setCountry(Country.MALAYSIA_MYS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 28558, Trainer
    }
}
