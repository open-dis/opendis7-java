package edu.nps.moves.dis7.entities.srb.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@26221bad
 * Country: Serbia (SRB)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 30174
 */
public class Lasta95N extends EntityType
{
    public Lasta95N()
    {
        setCountry(Country.SERBIA_SRB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 30172, Trainer
        setSubCategory((byte)1); // uid 30173, Lasta 95
        setSpecific((byte)1); // uid 30174, Lasta 95N
    }
}
