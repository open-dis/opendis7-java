package edu.nps.moves.dis7.entities.zaf.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@9aa2002;
 * Country: South Africa (ZAF);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 23108
 */
public class F147Spioenkop extends EntityType
{
    /** Default constructor */
    public F147Spioenkop()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 23104, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 23105, Valour class
        setSpecific((byte)3); // uid 23108, F147 Spioenkop
    }
}
