package edu.nps.moves.dis7.entities.deu.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@34c76167
 * Country: Germany (DEU)
 * Entity kind: Munition
 * Domain: ANTI_AIR
 *
 * Entity type uid: 21201
 */
public class Guided extends EntityType
{
    public Guided()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 21201, Guided
    }
}
