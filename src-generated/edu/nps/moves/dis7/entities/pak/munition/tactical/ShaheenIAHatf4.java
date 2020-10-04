package edu.nps.moves.dis7.entities.pak.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@782fd504
 * Country: Pakistan (PAK)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 31394
 */
public class ShaheenIAHatf4 extends EntityType
{
    public ShaheenIAHatf4()
    {
        setCountry(Country.PAKISTAN_PAK);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 31392, Guided
        setSubCategory((byte)2); // uid 31394, Shaheen IA (Hatf-4)
    }
}
