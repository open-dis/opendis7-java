package edu.nps.moves.dis7.entities.swe.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@61cd1c71
 * Country: Sweden (SWE)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 17487
 */
public class L60AAGun extends EntityType
{
    public L60AAGun()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 17483, Air Defense/Missile Defense Unit Equipment
        setSubCategory((byte)1); // uid 17484, Towed VSHORAD Gun/Missile System
        setSpecific((byte)1); // uid 17485, 40mm Bofors
        setExtra((byte)2); // uid 17487, L/60 AA Gun
    }
}
