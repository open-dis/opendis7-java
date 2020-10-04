package edu.nps.moves.dis7.entities.fra.munition.antiradar;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@29bbc63c
 * Country: France (FRA)
 * Entity kind: Munition
 * Domain: ANTI_RADAR
 *
 * Entity type uid: 21084
 */
public class Guided extends EntityType
{
    public Guided()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_RADAR));

        setCategory((byte)1); // uid 21084, Guided
    }
}
