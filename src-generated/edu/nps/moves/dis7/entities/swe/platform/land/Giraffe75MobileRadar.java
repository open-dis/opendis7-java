package edu.nps.moves.dis7.entities.swe.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@546e61d5
 * Country: Sweden (SWE)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 25389
 */
public class Giraffe75MobileRadar extends EntityType
{
    public Giraffe75MobileRadar()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 17483, Air Defense/Missile Defense Unit Equipment
        setSubCategory((byte)2); // uid 25387, Self-Propelled VSHORAD Gun/Missile System
        setSpecific((byte)1); // uid 25388, Giraffe Mobile Radar
        setExtra((byte)1); // uid 25389, Giraffe 75 Mobile Radar
    }
}
