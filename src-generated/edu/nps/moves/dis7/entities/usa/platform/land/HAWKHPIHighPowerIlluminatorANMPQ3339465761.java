package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@36f7d7b
 * Country: United States of America (USA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 10686
 */
public class HAWKHPIHighPowerIlluminatorANMPQ3339465761 extends EntityType
{
    public HAWKHPIHighPowerIlluminatorANMPQ3339465761()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 10679, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)1); // uid 10680, MIM-23 Raytheon HAWK Low-to-Medium Altitude SAM System
        setSpecific((byte)2); // uid 10683, Battery
        setExtra((byte)3); // uid 10686, HAWK HPI (High-Power Illuminator) AN/MPQ-33/39/46/57/61 -
    }
}
