package edu.nps.moves.dis7.entities.zaf.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2296127
 * Country: South Africa (ZAF)
 * Entity kind: Munition
 * Domain: ANTI_ARMOR
 *
 * Entity type uid: 22825
 */
public class MokopaZT6ATGM extends EntityType
{
    public MokopaZT6ATGM()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)1); // uid 22824, Guided
        setSubCategory((byte)1); // uid 22825, Mokopa ZT-6 ATGM
    }
}
