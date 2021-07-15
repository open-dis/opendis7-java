package edu.nps.moves.dis7.entities.lka.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@339a3670;
 * Country: Sri Lanka (LKA);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26423
 */
public class ColomboClassUltraFastAttackCraft extends EntityType
{
    /** Default constructor */
    public ColomboClassUltraFastAttackCraft()
    {
        setCountry(Country.SRI_LANKA_LKA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26422, Light/Patrol Craft
        setSubCategory((byte)1); // uid 26423, Colombo Class Ultra Fast Attack Craft
    }
}
