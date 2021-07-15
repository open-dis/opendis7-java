package edu.nps.moves.dis7.entities.ind.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@30af5b6b;
 * Country: India (IND);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 31712
 */
public class DornierDo2282011 extends EntityType
{
    /** Default constructor */
    public DornierDo2282011()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)7); // uid 31709, Reconnaissance
        setSubCategory((byte)1); // uid 31710, Dornier Do 228
        setSpecific((byte)2); // uid 31712, Dornier Do 228-201
    }
}
