package edu.nps.moves.dis7.entities.cub.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@2a4fb17b
 * Country: Cuba (CUB)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 29969
 */
public class MineCountermeasureShipCraft extends EntityType
{
    public MineCountermeasureShipCraft()
    {
        setCountry(Country.CUBA_CUB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 29969, Mine Countermeasure Ship/Craft
    }
}
