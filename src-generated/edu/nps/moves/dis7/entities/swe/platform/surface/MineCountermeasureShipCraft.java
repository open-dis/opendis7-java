package edu.nps.moves.dis7.entities.swe.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@1a4d1ab7;
 * Country: Sweden (SWE);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26832
 */
public class MineCountermeasureShipCraft extends EntityType
{
    /** Default constructor */
    public MineCountermeasureShipCraft()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 26832, Mine Countermeasure Ship/Craft
    }
}