package edu.nps.moves.dis7.entities.rus.expendable.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1b444b5
 * Country: Russia (RUS)
 * Entity kind: Expendable
 * Domain: SUBSURFACE
 *
 * Entity type uid: 22310
 */
public class UC2Countermeasure extends EntityType
{
    public UC2Countermeasure()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)4); // uid 22307, Active Emitter
        setSubCategory((byte)3); // uid 22310, UC-2 Countermeasure
    }
}
