package edu.nps.moves.dis7.entities.sau.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2e51d054
 * Country: Saudi Arabia (SAU)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 17847
 */
public class PC9 extends EntityType
{
    public PC9()
    {
        setCountry(Country.SAUDI_ARABIA_SAU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 17845, Trainer
        setSubCategory((byte)1); // uid 17846, Pilatus Flugzeugwerke SA PC-9
        setSpecific((byte)1); // uid 17847, PC-9
    }
}
