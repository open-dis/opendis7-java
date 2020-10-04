package edu.nps.moves.dis7.entities.ser.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@7fd26ad8
 * Country: Serbia and Montenegro
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19081
 */
public class MineCountermeasureShipCraft extends EntityType
{
    public MineCountermeasureShipCraft()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 19081, Mine Countermeasure Ship/Craft
    }
}
