package edu.nps.moves.dis7.entities.isr.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@54e22bdd;
 * Country: Israel (ISR);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 18190
 */
public class ARAVAIAI202 extends EntityType
{
    /** Default constructor */
    public ARAVAIAI202()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 18185, Cargo/Tanker
        setSubCategory((byte)3); // uid 18188, Israel Aircraft Industries 707
        setSpecific((byte)2); // uid 18190, ARAVA IAI-202
    }
}
