package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1b01a0d
 * Country: United States of America (USA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 27265
 */
public class ANTSC154SecureMobileAntiJamReliableTacticalTerminalSMARTT extends EntityType
{
    public ANTSC154SecureMobileAntiJamReliableTacticalTerminalSMARTT()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)35); // uid 10748, C4I Facility
        setSubCategory((byte)7); // uid 27265, AN/TSC-154 Secure Mobile Anti-Jam Reliable Tactical Terminal (SMART-T)
    }
}
