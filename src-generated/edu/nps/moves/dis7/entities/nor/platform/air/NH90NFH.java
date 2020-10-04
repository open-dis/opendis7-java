package edu.nps.moves.dis7.entities.nor.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@547e29a4
 * Country: Norway (NOR)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29609
 */
public class NH90NFH extends EntityType
{
    public NH90NFH()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)22); // uid 29608, Anti-Submarine Warfare/Patrol Helicopter
        setSubCategory((byte)1); // uid 29609, NH90 NFH
    }
}
