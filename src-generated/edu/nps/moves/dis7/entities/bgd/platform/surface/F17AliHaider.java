package edu.nps.moves.dis7.entities.bgd.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@77b52d12;
 * Country: Bangladesh (BGD);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 32607
 */
public class F17AliHaider extends EntityType
{
    /** Default constructor */
    public F17AliHaider()
    {
        setCountry(Country.BANGLADESH_BGD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 26771, Guided Missile Frigate (FFG)
        setSubCategory((byte)2); // uid 32605, Jianghu-III Class (Type 053H2)
        setSpecific((byte)2); // uid 32607, F17 Ali Haider
    }
}
