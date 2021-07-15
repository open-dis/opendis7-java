package edu.nps.moves.dis7.entities.irq.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@11c581a0;
 * Country: Iraq (IRQ);
 * Entity kind: Munition;
 * Domain: TACTICAL;
 *
 * Entity type uid: 21272
 */
public class AlAbbas extends EntityType
{
    /** Default constructor */
    public AlAbbas()
    {
        setCountry(Country.IRAQ_IRQ);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)2); // uid 21271, Ballistic
        setSubCategory((byte)1); // uid 21272, Al Abbas
    }
}
