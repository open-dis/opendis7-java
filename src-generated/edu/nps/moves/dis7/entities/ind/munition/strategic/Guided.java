package edu.nps.moves.dis7.entities.ind.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@1e56bc9b
 * Country: India (IND)
 * Entity kind: Munition
 * Domain: STRATEGIC
 *
 * Entity type uid: 21736
 */
public class Guided extends EntityType
{
    public Guided()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 21736, Guided
    }
}
