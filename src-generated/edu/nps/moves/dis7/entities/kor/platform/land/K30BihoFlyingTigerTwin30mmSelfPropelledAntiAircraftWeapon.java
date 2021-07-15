package edu.nps.moves.dis7.entities.kor.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@60b71e8f;
 * Country: Korea (Republic of) (KOR);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31329
 */
public class K30BihoFlyingTigerTwin30mmSelfPropelledAntiAircraftWeapon extends EntityType
{
    /** Default constructor */
    public K30BihoFlyingTigerTwin30mmSelfPropelledAntiAircraftWeapon()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 31327, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)2); // uid 31329, K30 Biho (Flying Tiger) Twin 30 mm Self-Propelled Anti-Aircraft Weapon
    }
}
