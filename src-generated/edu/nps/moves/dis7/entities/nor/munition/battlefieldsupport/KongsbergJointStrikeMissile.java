package edu.nps.moves.dis7.entities.nor.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@333398f
 * Country: Norway (NOR)
 * Entity kind: Munition
 * Domain: BATTLEFIELD_SUPPORT
 *
 * Entity type uid: 29053
 */
public class KongsbergJointStrikeMissile extends EntityType
{
    public KongsbergJointStrikeMissile()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)1); // uid 29052, Guided
        setSubCategory((byte)1); // uid 29053, Kongsberg Joint Strike Missile
    }
}
