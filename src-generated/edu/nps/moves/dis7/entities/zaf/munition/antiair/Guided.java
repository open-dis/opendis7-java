package edu.nps.moves.dis7.entities.zaf.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@7be38eba
 * Country: South Africa (ZAF)
 * Entity kind: Munition
 * Domain: ANTI_AIR
 *
 * Entity type uid: 28982
 */
public class Guided extends EntityType
{
    public Guided()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 28982, Guided
    }
}
