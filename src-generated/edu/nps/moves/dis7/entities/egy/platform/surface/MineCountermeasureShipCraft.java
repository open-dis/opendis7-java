package edu.nps.moves.dis7.entities.egy.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@f79e
 * Country: Egypt (EGY)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 26761
 */
public class MineCountermeasureShipCraft extends EntityType
{
    public MineCountermeasureShipCraft()
    {
        setCountry(Country.EGYPT_EGY);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 26761, Mine Countermeasure Ship/Craft
    }
}
