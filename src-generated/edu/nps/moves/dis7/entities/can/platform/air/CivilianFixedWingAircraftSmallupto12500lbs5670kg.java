package edu.nps.moves.dis7.entities.can.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@131276c2
 * Country: Canada (CAN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29153
 */
public class CivilianFixedWingAircraftSmallupto12500lbs5670kg extends EntityType
{
    public CivilianFixedWingAircraftSmallupto12500lbs5670kg()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)85); // uid 29153, Civilian Fixed Wing Aircraft, Small (up to 12,500 lbs / 5,670 kg)
    }
}
