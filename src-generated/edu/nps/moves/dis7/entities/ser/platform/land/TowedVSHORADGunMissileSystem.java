package edu.nps.moves.dis7.entities.ser.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@e042c99
 * Country: Serbia and Montenegro
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 23674
 */
public class TowedVSHORADGunMissileSystem extends EntityType
{
    public TowedVSHORADGunMissileSystem()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 23670, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)2); // uid 23674, Towed VSHORAD Gun / Missile System
    }
}
