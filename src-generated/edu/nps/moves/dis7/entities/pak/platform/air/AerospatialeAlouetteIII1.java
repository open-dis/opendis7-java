package edu.nps.moves.dis7.entities.pak.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@c827db
 * Country: Pakistan (PAK)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 30457
 */
public class AerospatialeAlouetteIII1 extends EntityType
{
    public AerospatialeAlouetteIII1()
    {
        setCountry(Country.PAKISTAN_PAK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)22); // uid 30456, Anti-Submarine Warfare/Patrol Helicopter
        setSubCategory((byte)1); // uid 30457, Aerospatiale Alouette III
    }
}
