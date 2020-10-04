package edu.nps.moves.dis7.entities.kor.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@573aeab2
 * Country: Korea (Republic of) (KOR)
 * Entity kind: Munition
 * Domain: ANTI_AIR
 *
 * Entity type uid: 29145
 */
public class Guided extends EntityType
{
    public Guided()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 29145, Guided
    }
}
