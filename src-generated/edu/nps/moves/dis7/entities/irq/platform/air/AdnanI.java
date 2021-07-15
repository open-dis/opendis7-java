package edu.nps.moves.dis7.entities.irq.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@681a8b4e;
 * Country: Iraq (IRQ);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 18001
 */
public class AdnanI extends EntityType
{
    /** Default constructor */
    public AdnanI()
    {
        setCountry(Country.IRAQ_IRQ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 17999, Surveillance/C2 (Airborne Early Warning)
        setSubCategory((byte)1); // uid 18000, Iraqi Air Force Adnan 1
        setSpecific((byte)1); // uid 18001, Adnan I
    }
}
