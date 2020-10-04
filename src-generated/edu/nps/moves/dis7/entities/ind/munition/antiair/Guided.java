package edu.nps.moves.dis7.entities.ind.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@6cc48a17
 * Country: India (IND)
 * Entity kind: Munition
 * Domain: ANTI_AIR
 *
 * Entity type uid: 21742
 */
public class Guided extends EntityType
{
    public Guided()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 21742, Guided
    }
}
