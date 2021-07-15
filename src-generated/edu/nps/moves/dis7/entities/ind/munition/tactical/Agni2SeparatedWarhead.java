package edu.nps.moves.dis7.entities.ind.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5627cb29;
 * Country: India (IND);
 * Entity kind: Munition;
 * Domain: TACTICAL;
 *
 * Entity type uid: 32536
 */
public class Agni2SeparatedWarhead extends EntityType
{
    /** Default constructor */
    public Agni2SeparatedWarhead()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 32533, Guided
        setSubCategory((byte)1); // uid 32534, Agni 2
        setSpecific((byte)2); // uid 32536, Agni 2 Separated Warhead
    }
}
