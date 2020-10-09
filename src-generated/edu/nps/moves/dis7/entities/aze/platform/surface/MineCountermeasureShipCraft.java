package edu.nps.moves.dis7.entities.aze.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@234bef66
 * Country: Azerbaijan (AZE)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 29958
 */
public class MineCountermeasureShipCraft extends EntityType
{
    public MineCountermeasureShipCraft()
    {
        setCountry(Country.AZERBAIJAN_AZE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 29958, Mine Countermeasure Ship/Craft
    }
}
