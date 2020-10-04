package edu.nps.moves.dis7.entities.isr.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4bd1f8dd
 * Country: Israel (ISR)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 23877
 */
public class IsraelAircraftIndustries1125Astra extends EntityType
{
    public IsraelAircraftIndustries1125Astra()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)86); // uid 23875, Civilian Fixed Wing Aircraft, Medium (up to 41,000 lbs / 18,597 kg)
        setSubCategory((byte)32); // uid 23876, Twin Jet
        setSpecific((byte)1); // uid 23877, Israel Aircraft Industries 1125 Astra
    }
}
