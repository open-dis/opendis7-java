package edu.nps.moves.dis7.entities.usa.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@36776c32
 * Country: United States of America (USA)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 26428
 */
public class UH72ALakotaMEDEVACRedCross extends EntityType
{
    public UH72ALakotaMEDEVACRedCross()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)21); // uid 11088, Utility helicopter
        setSubCategory((byte)7); // uid 23566, American Eurocopter UH-72 Lakota (LUH)
        setSpecific((byte)3); // uid 26428, UH-72A Lakota, MEDEVAC (Red Cross)
    }
}
