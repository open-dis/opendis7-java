package edu.nps.moves.dis7.entities.twn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@7fb29ca9
 * Country: Taiwan, Province of China (TWN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19219
 */
public class MineCoutermeasuresShipCraft extends EntityType
{
    public MineCoutermeasuresShipCraft()
    {
        setCountry(Country.TAIWAN_PROVINCE_OF_CHINA_TWN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 19219, Mine Coutermeasures Ship/Craft
    }
}
