package edu.nps.moves.dis7.entities.ltu.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@7eb01b12;
 * Country: Lithuania (LTU);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 27782
 */
public class MineCountermeasureShipCraft extends EntityType
{
    /** Default constructor */
    public MineCountermeasureShipCraft()
    {
        setCountry(Country.LITHUANIA_LTU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27782, Mine Countermeasure Ship/Craft
    }
}
