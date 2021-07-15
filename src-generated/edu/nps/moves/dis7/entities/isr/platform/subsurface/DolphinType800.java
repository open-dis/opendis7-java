package edu.nps.moves.dis7.entities.isr.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@73dce0e6;
 * Country: Israel (ISR);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 18255
 */
public class DolphinType800 extends EntityType
{
    /** Default constructor */
    public DolphinType800()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 18254, SS (Conventional Attack-Torpedo, Patrol)
        setSubCategory((byte)1); // uid 18255, Dolphin Type 800
    }
}
