package edu.nps.moves.dis7.entities.isr.munition.antiradar;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@48f2054d
 * Country: Israel (ISR)
 * Entity kind: Munition
 * Domain: ANTI_RADAR
 *
 * Entity type uid: 28796
 */
public class Harpy extends EntityType
{
    public Harpy()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_RADAR));

        setCategory((byte)1); // uid 28795, Guided
        setSubCategory((byte)1); // uid 28796, Harpy
    }
}
