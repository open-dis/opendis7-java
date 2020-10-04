package edu.nps.moves.dis7.entities.swe.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1907874b
 * Country: Sweden (SWE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 25602
 */
public class JAS39A extends EntityType
{
    public JAS39A()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 17492, Fighter/Air Defense
        setSubCategory((byte)3); // uid 17495, SAAB JAS 39 Gripen
        setSpecific((byte)1); // uid 25602, JAS 39A
    }
}
