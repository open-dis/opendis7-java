package edu.nps.moves.dis7.entities.swe.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@48528634
 * Country: Sweden (SWE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24357
 */
public class Saab2000 extends EntityType
{
    public Saab2000()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)87); // uid 24355, Civilian Fixed Wing Aircraft, Large (up to 255,000 lbs / 115,666 kg)
        setSubCategory((byte)22); // uid 24356, Twin Engine Turboprop
        setSpecific((byte)1); // uid 24357, Saab 2000
    }
}
