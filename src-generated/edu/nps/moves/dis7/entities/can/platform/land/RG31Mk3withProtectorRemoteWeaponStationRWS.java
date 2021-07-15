package edu.nps.moves.dis7.entities.can.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@66480dd7;
 * Country: Canada (CAN);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31205
 */
public class RG31Mk3withProtectorRemoteWeaponStationRWS extends EntityType
{
    /** Default constructor */
    public RG31Mk3withProtectorRemoteWeaponStationRWS()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 27893, Large Wheeled Utility Vehicle
        setSubCategory((byte)3); // uid 31204, RG-31 Nyala 4x4
        setSpecific((byte)1); // uid 31205, RG-31 Mk3 with Protector Remote Weapon Station (RWS)
    }
}
