package edu.nps.moves.dis7.entities.esp.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@36cc9385
 * Country: Spain (ESP)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29905
 */
public class SH60BSeahawk extends EntityType
{
    public SH60BSeahawk()
    {
        setCountry(Country.SPAIN_ESP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)22); // uid 29903, Anti-Submarine Warfare/Patrol Helicopter
        setSubCategory((byte)1); // uid 29904, Sikorsky S-70B
        setSpecific((byte)1); // uid 29905, SH-60B Seahawk
    }
}
