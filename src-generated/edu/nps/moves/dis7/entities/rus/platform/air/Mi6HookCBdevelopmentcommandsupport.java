package edu.nps.moves.dis7.entities.rus.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@127f9161;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 13457
 */
public class Mi6HookCBdevelopmentcommandsupport extends EntityType
{
    /** Default constructor */
    public Mi6HookCBdevelopmentcommandsupport()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)21); // uid 13431, Utility helicopter
        setSubCategory((byte)4); // uid 13454, Mi-6 Hook
        setSpecific((byte)3); // uid 13457, Mi-6 Hook C (B development, command support)
    }
}