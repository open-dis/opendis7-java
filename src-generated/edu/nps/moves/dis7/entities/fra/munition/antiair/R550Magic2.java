package edu.nps.moves.dis7.entities.fra.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1df9186f
 * Country: France (FRA)
 * Entity kind: Munition
 * Domain: ANTI_AIR
 *
 * Entity type uid: 21043
 */
public class R550Magic2 extends EntityType
{
    public R550Magic2()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 21028, Guided
        setSubCategory((byte)9); // uid 21041, R-550 Magic
        setSpecific((byte)2); // uid 21043, R-550 Magic 2
    }
}
