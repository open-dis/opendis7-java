package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4c9e38
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 30586
 */
public class KamAZ4350wRB636AM2SvetKUELINTEWSystem extends EntityType
{
    public KamAZ4350wRB636AM2SvetKUELINTEWSystem()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 12867, Large Wheeled Utility Vehicle
        setSubCategory((byte)42); // uid 30585, KamAZ-4350
        setSpecific((byte)1); // uid 30586, KamAZ-4350 w/ RB-636AM2 Svet-KU ELINT EW System
    }
}
