package edu.nps.moves.dis7.entities.nor.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6e685e6c
 * Country: Norway (NOR)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 29050
 */
public class KongsbergNavalStrikeMissile extends EntityType
{
    public KongsbergNavalStrikeMissile()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 21775, Guided
        setSubCategory((byte)2); // uid 29050, Kongsberg Naval Strike Missile
    }
}
