package edu.nps.moves.dis7.entities.srb.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@61c42416;
 * Country: Serbia (SRB);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 30168
 */
public class SelfPropelledVSHORADGunMissileSystem extends EntityType
{
    /** Default constructor */
    public SelfPropelledVSHORADGunMissileSystem()
    {
        setCountry(Country.SERBIA_SRB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 30166, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)2); // uid 30168, Self -Propelled VSHORAD Gun / Missile System
    }
}
