package edu.nps.moves.dis7.entities.ser.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@859ea42;
 * Country: Serbia and Montenegro;
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 19071
 */
public class SplitKotor extends EntityType
{
    /** Default constructor */
    public SplitKotor()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 19070, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 19071, Split/Kotor
    }
}
