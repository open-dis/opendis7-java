package edu.nps.moves.dis7.entities.ind.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@42039326;
 * Country: India (IND);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 31708
 */
public class DornierDo22820112 extends EntityType
{
    /** Default constructor */
    public DornierDo22820112()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 30217, Surveillance/C2 (Airborne Early Warning)
        setSubCategory((byte)2); // uid 31707, Dornier Do 228
        setSpecific((byte)1); // uid 31708, Dornier Do 228-201
    }
}
