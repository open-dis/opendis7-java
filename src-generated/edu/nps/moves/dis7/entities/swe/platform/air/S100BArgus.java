package edu.nps.moves.dis7.entities.swe.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@fab35b1
 * Country: Sweden (SWE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 25601
 */
public class S100BArgus extends EntityType
{
    public S100BArgus()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 25599, Surveillance/C2 (Airborne Early Warning)
        setSubCategory((byte)1); // uid 25600, Saab 340 AEW&C
        setSpecific((byte)1); // uid 25601, S 100B Argus
    }
}
