package edu.nps.moves.dis7.entities.usa.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@77cca767;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 29662
 */
public class Mk39Mod0EMATT extends EntityType
{
    /** Default constructor */
    public Mk39Mod0EMATT()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)8); // uid 28694, Unmanned Underwater Vehicle (UUV)
        setSubCategory((byte)1); // uid 29661, Autonomous Underwater Vehicle (AUV)
        setSpecific((byte)1); // uid 29662, Mk39 Mod 0 EMATT
    }
}
