package edu.nps.moves.dis7.entities.irn.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@b06d46d
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32474
 */
public class Shahab3Mod3A extends EntityType
{
    public Shahab3Mod3A()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 32473, Guided
        setSubCategory((byte)5); // uid 32474, Shahab 3 Mod-3A
    }
}
