package edu.nps.moves.dis7.entities.srb.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7569ea63;
 * Country: Serbia (SRB);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 30176
 */
public class Lasta95P2 extends EntityType
{
    /** Default constructor */
    public Lasta95P2()
    {
        setCountry(Country.SERBIA_SRB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 30172, Trainer
        setSubCategory((byte)1); // uid 30173, Lasta 95
        setSpecific((byte)3); // uid 30176, Lasta 95P-2
    }
}
