package edu.nps.moves.dis7.entities.isr.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@56a05324
 * Country: Israel (ISR)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32532
 */
public class ExtendedRangeArtilleryEXTRA extends EntityType
{
    public ExtendedRangeArtilleryEXTRA()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 29011, Guided
        setSubCategory((byte)12); // uid 32532, Extended Range Artillery (EXTRA)
    }
}
