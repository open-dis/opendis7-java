package edu.nps.moves.dis7.entities.twn.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@3b770d07
 * Country: Taiwan, Province of China (TWN)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 21757
 */
public class Guided extends EntityType
{
    public Guided()
    {
        setCountry(Country.TAIWAN_PROVINCE_OF_CHINA_TWN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 21757, Guided
    }
}
