package edu.nps.moves.dis7.entities.irn.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7911cc15
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32480
 */
public class Shahab2SeparatedWarhead extends EntityType
{
    public Shahab2SeparatedWarhead()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 32473, Guided
        setSubCategory((byte)9); // uid 32479, Shahab 2
        setSpecific((byte)1); // uid 32480, Shahab 2 Separated Warhead
    }
}
