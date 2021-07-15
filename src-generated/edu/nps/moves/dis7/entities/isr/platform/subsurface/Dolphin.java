package edu.nps.moves.dis7.entities.isr.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@32c8e539;
 * Country: Israel (ISR);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 18256
 */
public class Dolphin extends EntityType
{
    /** Default constructor */
    public Dolphin()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 18254, SS (Conventional Attack-Torpedo, Patrol)
        setSubCategory((byte)1); // uid 18255, Dolphin Type 800
        setSpecific((byte)1); // uid 18256, Dolphin
    }
}
