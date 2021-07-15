package edu.nps.moves.dis7.entities.twn.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6fef75c6;
 * Country: Taiwan, Province of China (TWN);
 * Entity kind: Munition;
 * Domain: ANTI_AIR;
 *
 * Entity type uid: 21755
 */
public class TienChienIISkySwordII extends EntityType
{
    /** Default constructor */
    public TienChienIISkySwordII()
    {
        setCountry(Country.TAIWAN_PROVINCE_OF_CHINA_TWN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 21753, Guided
        setSubCategory((byte)2); // uid 21755, Tien Chien II / Sky Sword II
    }
}
