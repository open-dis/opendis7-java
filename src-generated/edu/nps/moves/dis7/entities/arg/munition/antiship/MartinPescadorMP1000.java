package edu.nps.moves.dis7.entities.arg.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6a1568d6
 * Country: Argentina (ARG)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 29559
 */
public class MartinPescadorMP1000 extends EntityType
{
    public MartinPescadorMP1000()
    {
        setCountry(Country.ARGENTINA_ARG);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 29558, Guided
        setSubCategory((byte)1); // uid 29559, Martin Pescador MP-1000
    }
}
