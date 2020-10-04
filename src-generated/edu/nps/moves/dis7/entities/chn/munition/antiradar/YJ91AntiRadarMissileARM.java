package edu.nps.moves.dis7.entities.chn.munition.antiradar;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1fb2eec
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Munition
 * Domain: ANTI_RADAR
 *
 * Entity type uid: 30557
 */
public class YJ91AntiRadarMissileARM extends EntityType
{
    public YJ91AntiRadarMissileARM()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_RADAR));

        setCategory((byte)1); // uid 21400, Guided
        setSubCategory((byte)4); // uid 30557, YJ-91 Anti-Radar Missile (ARM)
    }
}
